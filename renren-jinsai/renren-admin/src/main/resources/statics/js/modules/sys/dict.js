$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/dict/list',
        datatype: "json",
        colModel: [
            { label: '行政区域名称', name: 'name', index: 'name', width: 80 },
            { label: '行政区域类型', name: 'type', index: 'type', width: 80 },
            { label: '行政区域编码', name: 'code', index: 'code', width: 80 },
            { label: '经纬度', name: 'remark', index: 'remark', width: 80 },
            { label: '排序', name: 'orderNum', index: 'order_num', width: 80 },
            { label: '备注', name: 'remark', index: 'remark', width: 80 }
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
        dict: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },

        test2: function () {
            var url = "sys/dict/save";
            $.ajax({
                "type" : 'get',
                url: baseURL + url,
                "dataType" : "json",
                "success" : function(data) {
                    if(r.code === 0){
                        var depart_list = data.data;
                        var opts = "";
                        for( var i = 0 ; i < depart_list.length; i++ ){
                            var depart = depart_list[i];
                            opts += "<option value='"+dict.code+"'>"+dict.name+"</option>";
                        }
                        $("#addid").append(opts);
                        $("#addid").selectpicker("refresh");
                    }

                }
            });

        },

        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.dict = {};
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
            var code= $("#test").val();
            var cshi= $("#cshi").val();
            // console.log(cshi)
            // vm.dict.code=code;
            var url = vm.dict.id == null ? "sys/dict/save" : "sys/dict/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.dict),
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
                    url: baseURL + "sys/dict/delete",
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
            $.get(baseURL + "sys/dict/info/"+id, function(r){
                vm.dict = r.dict;
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