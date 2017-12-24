function returnData(sSource, aDataSet, fnCallback) {
    $.ajax({
        "dataType" : 'json',
        "contentType": "application/json; charset=utf-8",
        "type" : "get",
        "url" : "/system-info/get-system-info",
        "data" :{
            "pageSize": function () {
                var pageSize = 10;
                $.each(aDataSet,function () {
                   if(this.name && this.name === 'length'){
                       pageSize = this.value;
                   }
                });
                return pageSize;
            },
            "pageIndex":function () {
                var pageSize,pageIndex = 1;
                $.each(aDataSet,function () {
                    if(this.name && this.name === 'length'){
                        console.log("length:"+ this.value)
                        pageSize = this.value;
                    }
                });
                $.each(aDataSet,function () {
                    if(this.name && this.name === 'start'){
                        var start = this.value;
                        if(start === 0){
                            pageIndex = 1;
                        }else {
                            if(pageSize){
                                pageIndex = start/pageSize + 1;
                            }
                        }
                    }
                });
                return pageIndex;
            }
        },
        "success" : function(resp){
            if(resp.code === '0000'){
                fnCallback({
                    "recordsTotal":resp.data.pages,
                    "recordsFiltered":resp.data.total,
                    "data":resp.data.list
                });
            }else {
                self.location = "login.html";
            }

        },
        "error":function () {
            self.location = "login.html";
        }
    });
}
$(document).ready(function () {
    var option = {
        "pagingType": "full_numbers_icon",
        "serverSide": true,
        "ordering": false,
        "fnServerData":returnData,
        "searching": false,
        "oLanguage": { //国际化配置
            "sProcessing": "正在获取数据，请稍后...",
            "sLengthMenu": "显示 _MENU_ 条",
            "sZeroRecords": "没有您要搜索的内容",
            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "记录数为0",
            "sInfoFiltered": "(总页数 _MAX_ 页)",
            "sInfoPostFix": "",
            "sSearch": "搜索",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "最后一页"
            }
        },
        "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
        "aoColumns" : [{
            "mDataProp" : "systemName",
            "sDefaultContent" : "", //此列默认值为""，以防数据中没有此值，DataTables加载数据的时候报错
            "sTitle" : "业务系统名称",
            "sClass" : "center"
        }, {
            "mDataProp" : "systemChn",
            "sTitle" : "业务系统中文名称",
            "sDefaultContent" : "",
            "sClass" : "center"
        }, {
            "mDataProp" : "systemContext",
            "sTitle" : "系统context",
            "sDefaultContent" : "",
            "sClass" : "center"
        }, {
            "mDataProp" : "systemHost",
            "sTitle" : "系统host",
            "sDefaultContent" : "",
            "sClass" : "center"
        }]
    };
    $('.table').DataTable(option);
});

