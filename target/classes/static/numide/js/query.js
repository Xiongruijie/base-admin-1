layui.use('table',function () {
    let table = layui.table;
    let opt = {
        url: "/numide/querydata",
        contentType: "application/json;charset=UTF-8",
        type: "get",
        dataType: "JSON",
        success: function (data) {
            console.log("ajax success!");
            console.log(data)
            table.render({
                elem: '#tableQuery',
                page: false
                ,cols: [[ //表头
                    {field: 'id', title: '查询序号', width:100, sort: true, fixed: 'left'}
                    ,{field: 'inputDate', title: '更新时间', width:100, sort: true}
                    ,{field: 'userName', title: '查询用户名', width:100}
                    ,{field: 'sampleType', title: '样本类型', width:100}
                    ,{field: 'sampleNumber', title: '样本编号', width:100}
                    ,{field: 'sample_source', title: '样本来源', width:100}
                    ,{field: 'remark', title: '备注', width:100}
                    ,{field: 'result', title: '评价结果', width:500}
                    ,{field: 'phe', title: 'Phe', width:100}
                    ,{field: 'xyl', title: 'Xyl', width:100}
                    ,{field: 'raf', title: 'Raf', width:100}
                    ,{field: 'ind', title: 'Ind', width:100}
                ]]
                , data: data.data
            });
        },
        error: function (errorMsg){
            console.log("error in ajax!");
            console.log(errorMsg)
        }
    };
    $.ajax(opt);
})
