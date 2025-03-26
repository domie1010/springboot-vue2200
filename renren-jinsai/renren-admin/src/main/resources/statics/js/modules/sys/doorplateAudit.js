$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/doorplate/auditList',
        datatype: "json",
        colModel: [
            {label: '区域名称', name: 'areaName', index: 'areaName', width: 80},
            {label: '城市街道名称', name: 'cityName', index: 'cityName', width: 80},
            {label: '小区名称', name: 'housingName', index: 'housingName', width: 80},
            {label: '门牌号', name: 'ridgepoleNumber', index: 'ridgepoleNumber', width: 80},
            {label: '申请人', name: 'applyUserName', index: 'applyUserName', width: 80},
            {label: '申请时间', name: 'applyTime', index: 'applyTime', width: 80},
            {label: '审批状态', name: 'auditStu', index: 'auditStu', width: 80},
            { label: '操作', name: 'state', index: 'state', width: 50, edittype:"button", formatter: function (value, grid, rows, state) {
                return '<a href="javascript:void(0);" style="color:#3cbd58" onclick="modify(\''+ rows.id+ '\');">同意</a>'+"&nbsp;&nbsp;"+
                    '<a href="javascript:void(1);" style="color:#f60" onclick="modify2(\''+ rows.id+ '\');">拒绝</a>';
            }}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        cmgStateFormat:"",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        },

    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
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
        getInfo: function (id) {
            $.get(baseURL + "sys/doorplate/info/" + id, function (r) {
                vm.doorplate = r.doorplate;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
        }
    }
});