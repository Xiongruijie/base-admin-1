layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });

});

// 添加输入按钮事件，点击按钮后对输入框响应
function button_click(opt_symbol, symbol_id_1, symbol_id_2, symbol_id_3, input_id) {
    let opt_status =opt_symbol.value;
    if (opt_status == '+') {
        opt_symbol.value = '-';
    } else if (opt_status == '-') {
        opt_symbol.value = '?';
    } else if (opt_status == '?') {
        opt_symbol.value = '+';
    }
    let sum = 0;
    if (symbol_id_1.value == "+") {
        sum += 1;
    }
    if (symbol_id_2.value == "+") {
        sum += 2;
    }
    if (symbol_id_3.value == "+") {
        sum += 4;
    }
    input_id.value = sum;
}
// 输入框输入结束按钮变化
function after_input(symbol_id_1, symbol_id_2, symbol_id_3, input_id) {
    input_id.value = input_id.value.replace(/[^0-7]/g, '');
    let sum = parseInt(input_id.value);
    if (sum >= 4) {
        symbol_id_3.value = "+";
        sum -= 4;
    } else {
        symbol_id_3.value = "-";
    }
    if (sum >= 2) {
        symbol_id_2.value = "+";
        sum -= 2;
    } else {
        symbol_id_2.value = "-";
    }
    if (sum >= 1) {
        symbol_id_1.value = "+";
        sum -= 1;
    } else {
        symbol_id_1.value = "-";
    }
}
function after_input_1(symbol_id_1, input_id) {
    input_id.value = input_id.value.replace(/[^0-7]/g, '');
    let sum = parseInt(input_id.value);
    if (sum >= 1) {
        symbol_id_1.value = "+";
        sum -= 1;
    } else {
        symbol_id_1.value = "-";
    }
}
function button_click_1(opt_symbol, symbol_id_1, input_id) {
    let opt_status =opt_symbol.value;
    if (opt_status == '+') {
        opt_symbol.value = '-';
    } else if (opt_status == '-') {
        opt_symbol.value = '?';
    } else if (opt_status == '?') {
        opt_symbol.value = '+';
    }
    let sum = 0;
    if (symbol_id_1.value == "+") {
        sum += 1;
    }
    input_id.value = sum;
}
function after_input_2(symbol_id_1, symbol_id_2, input_id) {
    input_id.value = input_id.value.replace(/[^0-7]/g, '');
    let sum = parseInt(input_id.value);
    if (sum >= 2) {
        symbol_id_2.value = "+";
        sum -= 2;
    } else {
        symbol_id_2.value = "-";
    }
    if (sum >= 1) {
        symbol_id_1.value = "+";
        sum -= 1;
    } else {
        symbol_id_1.value = "-";
    }
}
function button_click_2(opt_symbol, symbol_id_1, symbol_id_2, input_id) {
    let opt_status =opt_symbol.value;
    if (opt_status == '+') {
        opt_symbol.value = '-';
    } else if (opt_status == '-') {
        opt_symbol.value = '?';
    } else if (opt_status == '?') {
        opt_symbol.value = '+';
    }
    let sum = 0;
    if (symbol_id_1.value == "+") {
        sum += 1;
    }
    if (symbol_id_2.value == "+") {
        sum += 2;
    }
    input_id.value = sum;
}
function SubmitForm() {
    $("#strainTable").load(location.href + " #strainTable");
    $("#outputFile").removeClass("layui-btn-disabled");
    $("#printResult").removeClass("layui-btn-disabled");
    // 添加元素
    let formData = new FormData();
    formData.append();
    let InputForm = $("#inputForm").serializeObject();
    InputForm.updateTime = commonUtil.getNowTime();
    let opt = {
        url: "/numide/getForm",
        contentType: "application/json;charset=UTF-8",
        type: "POST",
        data: JSON.stringify(InputForm),
        dataType: "JSON",
        success: function (data) {
            console.log(data+"suceess!");
        },
        error: function (errorMsg) {
            console.log(errorMsg);
        }
    };
    $.ajax(opt);
}

function saveForm() {
    let filename = commonUtil.getNowTime();
    // $('table_refresh').table2excel({
    //     filename : filename+".xls", //文件名称
    //     name: "Excel Document Name.xlsx",
    //     exclude_img: false,//是否导出图片 false导出
    //     exclude_links: true,//是否导出链接 false导出
    //     exclude_inputs: true//是否导出输入框的值 true导出
    // });
    $("#table_refresh").table2excel({
        name: filename,
        filename: filename + "数据.xls", // do include extension
        preserveColors: true, // set to true if you want background colors and font colors preserved
        exclude_links: true,//是否导出链接 false导出
        exclude_inputs: true//是否导出输入框的值 true导出
    });


}

// onclick="printDiv('table_refresh')
// function printDiv(divName) {
//     var printContents = document.getElementById(divName).innerHTML;
//     var originalContents = document.body.innerHTML;
//
//     document.body.innerHTML = printContents;
//
//     window.print();
//
//     document.body.innerHTML = originalContents;
// }
