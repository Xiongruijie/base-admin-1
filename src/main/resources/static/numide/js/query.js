layui.use('table',function () {
    let table = layui.table;

    // "strainId": 1,
    //     "strainName": "Escherichia coli",
    //     "strainChName": "大肠埃希氏菌",
    //     "strainClass": "Escherichia"
    $.post(ctx + "/numide/test", {}, function (data) {
        let tabledata = data.data;
        alert("进入函数");
        table.render({
            elem: '#demo',
            page: false
            ,cols: [[ //表头
                {field: 'strainId', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'strainName', title: '菌名', width:80}
                ,{field: 'strainChName', title: '菌中文名', width:80}
                ,{field: 'strainClass', title: '菌族', width:80}
            ]]
            , data: tabledata
        });
    })


})
