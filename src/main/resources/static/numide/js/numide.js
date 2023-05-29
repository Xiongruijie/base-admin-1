
layui.use(['form','laydate'],function (){
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });

});
// 添加输入按钮事件，点击按钮后对输入框响应
function button_click(opt_symbol,symbol_id_1,symbol_id_2,symbol_id_3,input_id) {

    let opt_status = document.getElementById(opt_symbol).value;
    if (opt_status == '+') {
        document.getElementById(opt_symbol).value = '-';
    } else if (opt_status == '-') {
        document.getElementById(opt_symbol).value = '?';
    } else if (opt_status == '?') {
        document.getElementById(opt_symbol).value = '+';
    }
    let sum = 0;
    if (document.getElementById(symbol_id_1).value === "+"){
        sum += 1;
    }
    if (document.getElementById(symbol_id_2).value === "+"){
        sum += 2;
    }
    if (document.getElementById(symbol_id_3).value === "+"){
        sum += 4;
    }
    document.getElementById(input_id).value = sum;
}

// 输入框输入结束按钮变化
function after_input(symbol_id_1,symbol_id_2,symbol_id_3,input_id){

    document.getElementById(input_id).value = document.getElementById(input_id).value.replace(/[^0-7]/g,'');

    let sum = parseInt(document.getElementById(input_id).value);
    if (sum >= 4){
        document.getElementById(symbol_id_3).value = "+";
        sum -= 4;
    }else {
        document.getElementById(symbol_id_3).value = "-";
    }
    if (sum >= 2){
        document.getElementById(symbol_id_2).value = "+";
        sum -= 2;
    }else {
        document.getElementById(symbol_id_2).value = "-";
    }
    if (sum >= 1){
        document.getElementById(symbol_id_1).value = "+";
        sum -= 1;
    }
    else {
        document.getElementById(symbol_id_1).value = "-";
    }
}


function SubmitForm() {

    $("#strainTable").load(location.href + " #strainTable");



    $("#outputFile").removeClass("layui-btn-disabled");
    $("#printResult").removeClass("layui-btn-disabled");
    let InputForm = $("#inputForm").serializeObject();
    InputForm.updateTime = commonUtil.getNowTime();
    let opt = {
      url: "/numide/getForm",
        contentType: "application/json;charset=UTF-8",
      type: "POST",
        data: JSON.stringify(InputForm),
      dataType: "JSON",
      success: function (data){
          console.log("ajax success!");
          console.log(data);

          let strainData = data.data.strainName;
          for(let i = 0; i < data.data.strainName.length; i++){
              let strainName = "<tr><td>"+((strainData[i].hasOwnProperty("Element0"))?strainData[i].Element0:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element1"))?strainData[i].Element1:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element2"))?strainData[i].Element2:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element3"))?strainData[i].Element3:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element4"))?strainData[i].Element4:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element5"))?strainData[i].Element5:"")+"</td><tr>";
              let strainProfessionalName = "<tr class='font-for-strain'><td>"+((strainData[i].hasOwnProperty("Element0"))?strainData[i].Element0:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element1"))?strainData[i].Element1:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element2"))?strainData[i].Element2:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element3"))?strainData[i].Element3:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element4"))?strainData[i].Element4:"")+"</td>"
                  +"<td>"+((strainData[i].hasOwnProperty("Element5"))?strainData[i].Element5:"")+"</td><tr>";
              if (i==0){
                  $("#strainTable").append(strainProfessionalName);
              }else {
                  $("#strainTable").append(strainName);
              }
          }

          let computeValue = data.data.computeValue;

          for(let i = 0; i < computeValue.length; i++){
              let computeValueData = "<tr><td>"+((computeValue[i].hasOwnProperty("Element0"))?computeValue[i].Element0:"")+"</td>"
                  +"<td>"+((computeValue[i].hasOwnProperty("Element1"))?computeValue[i].Element1:"")+"</td>"
                  +"<td>"+((computeValue[i].hasOwnProperty("Element2"))?computeValue[i].Element2:"")+"</td>"
                  +"<td>"+((computeValue[i].hasOwnProperty("Element3"))?computeValue[i].Element3:"")+"</td>"
                  +"<td>"+((computeValue[i].hasOwnProperty("Element4"))?computeValue[i].Element4:"")+"</td>"
                  +"<td>"+((computeValue[i].hasOwnProperty("Element5"))?computeValue[i].Element5:"")+"</td><tr>";

                  $("#strainTable").append(computeValueData);
          }
          $("#strainTable").append("<tr aria-disabled='true' class='table-data-selected'><td colspan='1'>不一致实验：</td><td></td><td></td><td></td><td></td><td></td></tr>");
          let inconsistent = data.data.inconsistent;
          for(let i = 0; i < inconsistent.length; i++){
              let inconsistentData = "<tr><td>"+((inconsistent[i].hasOwnProperty("Element0"))?inconsistent[i].Element0:"")+"</td>"
                  +"<td>"+((inconsistent[i].hasOwnProperty("Element1"))?inconsistent[i].Element1:"")+"</td>"
                  +"<td>"+((inconsistent[i].hasOwnProperty("Element2"))?inconsistent[i].Element2:"")+"</td>"
                  +"<td>"+((inconsistent[i].hasOwnProperty("Element3"))?inconsistent[i].Element3:"")+"</td>"
                  +"<td>"+((inconsistent[i].hasOwnProperty("Element4"))?inconsistent[i].Element4:"")+"</td>"
                  +"<td>"+((inconsistent[i].hasOwnProperty("Element5"))?inconsistent[i].Element5:"")+"</td><tr>";

              $("#strainTable").append(inconsistentData);
          }
          $("#strainTable").append("<tr aria-disabled='true' class='table-data-selected'><td colspan='1'>补充生化反应：</td><td></td><td></td><td></td><td></td><td></td></tr>");
          let supplement = data.data.supplement;
          for(let i = 0; i < supplement.length; i++){
              let supplementData = "<tr><td>"+((supplement[i].hasOwnProperty("Element0"))?supplement[i].Element0:"")+"</td>"
                  +"<td>"+((supplement[i].hasOwnProperty("Element1"))?supplement[i].Element1:"")+"</td>"
                  +"<td>"+((supplement[i].hasOwnProperty("Element2"))?supplement[i].Element2:"")+"</td>"
                  +"<td>"+((supplement[i].hasOwnProperty("Element3"))?supplement[i].Element3:"")+"</td>"
                  +"<td>"+((supplement[i].hasOwnProperty("Element4"))?supplement[i].Element4:"")+"</td>"
                  +"<td>"+((supplement[i].hasOwnProperty("Element5"))?supplement[i].Element5:"")+"</td><tr>";

              $("#strainTable").append(supplementData);
          }
          $("#strainTable").append("<tr aria-disabled='true' class='table-data-selected'><td colspan='3'>"+data.data.ResultEvaluation+"</td><td></td><td></td><td></td></tr>");
      },
        error: function (errorMsg){
          console.log("error in ajax!");
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
        filename: filename+"数据.xls", // do include extension
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
