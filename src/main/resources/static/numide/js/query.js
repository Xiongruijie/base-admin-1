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
                    // {field: 'id', title: '查询序号', width:100, sort: true, fixed: 'left'}
                    {field: 'system_name', title: '系统类型', width:100}
                    ,{field: 'user_input', title: '编码', width:100}
                    ,{field: 'result', title: '鉴定结果', width:100}
                    ,{field: 'identity', title: '鉴定百分数', width:100}
                    ,{field: 't_value', title: 'T值', width:100}
                    ,{field: 'evaluate', title: '结果评价', width:300}
                    ,{field: 'time', title: '时间', width:200, sort: true}
                    ,{field: 'id', title: '样本编号', width:100}
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
