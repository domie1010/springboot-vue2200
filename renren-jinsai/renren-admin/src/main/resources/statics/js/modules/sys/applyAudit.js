$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/apply/auditList',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 60 },
            { label: '赛事名称', name: 'name', index: 'name', width: 80 },
            { label: '组赛单位', name: 'zsdw', index: 'zsdw', width: 80 },
            { label: '赛制', name: 'type', index: 'type', width: 80 },
            { label: '项目负责人', name: 'principal', index: 'principal', width: 80 },
            { label: '操作', name: 'state', index: 'state', width: 50, edittype:"button", formatter: function (value, grid, rows, state) {
                return '<a href="javascript:void(0);" style="color:#3cbd58" onclick="modify(\''+ rows.id+ '\');">同意</a>'+"&nbsp;&nbsp;"+
                    '<a href="javascript:void(1);" style="color:#f60" onclick="modify2(\''+ rows.id+ '\');">拒绝</a>';
            }}
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
        apply: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },


        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.apply = {};
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
            var type=$("#type option:selected").val(); //获取选中的项
            alert(type);
            vm.apply.type=type;
            var url = vm.apply.id == null ? "sys/apply/save" : "sys/apply/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.apply),
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
                    url: baseURL + "sys/apply/delete",
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
            $.get(baseURL + "sys/apply/info/"+id, function(r){
                vm.apply = r.apply;
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