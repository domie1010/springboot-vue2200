$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/expenditure/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 60 },
            { label: '参赛名称', name: 'name', index: 'name', width: 80 },
            { label: '参赛注册费', name: 'zhuche', index: 'zhuche', width: 80 },
            { label: '差率费', name: 'rate', index: 'rate', width: 80 },
            { label: '培训费', name: 'train', index: 'train', width: 80 },
            { label: '指导费', name: 'guidance', index: 'guidance', width: 80 },
            { label: '耗材费', name: 'haocai', index: 'haocai', width: 80 },
            { label: '教师奖金', name: 'bonus', index: 'bonus', width: 80 },
            { label: '其他', name: 'other', index: 'principal', width: 80 },
            { label: '合计', name: 'total', index: 'principal', width: 80 },
    ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            name: null
        },
        showList: true,
        title: null,
        dict: {},
        expenditure: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },


        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.expenditure = {};
        },
        update: function (event) {
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },

        saveOrUpdate: function (event) {
            var url = vm.expenditure.id == null ? "sys/expenditure/save" : "sys/expenditure/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.expenditure),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/expenditure/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function(id){
            $.get(baseURL + "sys/expenditure/info/"+id, function(r){
                vm.expenditure = r.expenditure;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
        }
    }
});