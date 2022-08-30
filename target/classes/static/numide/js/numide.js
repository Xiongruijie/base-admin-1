
layui.use(['form','laydate'],function (){
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });
    form.on('submit(inputForm)', function (data) {

    })
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
          $.ajax({
              url: "/numide/getForm",
              contentType: "application/json;charset=UTF-8",
              type: "GET",
              dataType: "JSON",
              success:function (data) {
                  let table = $("ResultTable");
                  table.empty();
                  // for (let i = 0; i<data.data.strainName.length; i++){
                  //     let str = "<tr><td>" + data[i].Element0 + "</td><td>" + data[i].Element1 + "</td><td>" + data[i].Element2 + "</td><td>" + data[i].Element3 + "</td><td>" + data[i].Element4 + "</td><td>" + data[i].Element5 +"</td></tr>";
                  //     table.append(str);
                  // }
                  console.log(data)
              }
          });
      },
        error: function (errorMsg){
          console.log("error in ajax!")
        }
    };
    $.ajax(opt);




// let DateTime = $('#inputDateTime').val();
    // let SampleType = $('#sampleType').val();
    // let SampleNumber = $('#sampleNumber').val();
    // let SampleSource = $('#sampleSource').val();
    // let Remark = $('#remark').val();
    //
    // let Phe = $('#111').val();
    // let Xyl = $('#121').val();
    // let Raf = $('#131').val();
    // let Ind = $('#211').val();
    // let Suc = $('#221').val();
    // let Orn = $('#231').val();
    // let Lac = $('#311').val();
    // let ONPG = $('#321').val();
    // let Ure = $('#331').val();
    // let Cit = $('#411').val();
    // let Malt = $('#421').val();
    // let Lys = $('#431').val();
    // let Malo = $('#511').val();
    // let Sor = $('#521').val();
    // let Dul = $('#531').val();
    // let Ara = $('#611').val();
    // let Mel = $('#621').val();
    // let Rha = $('#631').val();
    // let Esc = $('#711').val();
    // let MR = $('#721').val();
    // let H2S = $('#731').val();
    // let Tre = $('#811').val();
    // let Cel = $('#821').val();
    // let Ox = $('#831').val();


    // let opt = {
    //     type: 'post',
    //     url: '/numide',
    //     contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
    //     dataType: 'json',
    //     data: JSON.stringify(
    //         {
    //         Phe: Phe,
    //         Xyl: Xyl,
    //         Raf: Raf,
    //         Ind: Ind,
    //         Suc: Suc,
    //         Orn: Orn,
    //         Lac: Lac,
    //         ONPG: ONPG,
    //         Ure: Ure,
    //         Cit: Cit,
    //         Malt: Malt,
    //         Lys: Lys,
    //         Malo: Malo,
    //         Sor: Sor,
    //         Dul: Dul,
    //         Ara: Ara,
    //         Mel: Mel,
    //         Rha: Rha,
    //         Esc: Esc,
    //         MR: MR,
    //         H2S: H2S,
    //         Tre: Tre,
    //         Cel: Cel,
    //         Ox: Ox,
    //     }
    //
    //
    //     ),
    //     success: alert("success"),
    //     error: function (xhr, status, error) {
    //         console.log("ajax错误！");
    //     }
    // };
    //
    // $.ajax(opt);

}

