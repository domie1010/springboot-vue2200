$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/doorplate/list',
        datatype: "json",
        colModel: [
            { label: '区域名称', name: 'areaName', index: 'areaName', width: 80 },
            { label: '城市街道名称', name: 'cityName', index: 'cityName', width: 80 },
            { label: '小区名称', name: 'housingName', index: 'housingName', width: 80 },
            { label: '门牌号', name: 'ridgepoleNumber', index: 'ridgepoleNumber', width: 80 },
            { label: '申请人', name: 'applyUserName', index: 'applyUserName', width: 80 },
            { label: '申请时间', name: 'applyTime', index: 'applyTime', width: 80 },
            { label: '审批状态', name: 'auditStu', index: 'auditStu', width: 80 },
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
        doorplate: {},
    },
    methods: {
        query: function () {
            vm.reload();
        },


        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.doorplate = {};
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
            var areaName=$("#areaName option:selected").val(); //获取选中的项
            var cityName=$("#cityName option:selected").val(); //获取选中的项
            vm.doorplate.areaName=areaName;
            vm.doorplate.cityName=cityName;
            var url = vm.doorplate.id == null ? "sys/doorplate/save" : "sys/doorplate/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.doorplate),
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
                    url: baseURL + "sys/doorplate/delete",
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
            $.get(baseURL + "sys/doorplate/info/"+id, function(r){
                vm.doorplate = r.doorplate;
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