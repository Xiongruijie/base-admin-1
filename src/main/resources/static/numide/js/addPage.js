layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });

});

function SubmitSystem(){
    let opt = {
        url: "/numide/addSystem",
        contentType: "application/json;charset=UTF-8",
        type: "POST",
        data: JSON.stringify(AddSystemForm),
        dataType: "JSON",
        success: function (data) {
            console.log("ajax success!");
            console.log(data);
        },
        error: function (errorMsg){
            console.log("error in ajax!");
        }
    }

}
function uploadFile(){
    var file = $("#file")[0].files[0];
    var formData = new FormData();
    formData.append("file",file);
    // formData.append("name","dong");
    $.ajax({
        type:'post',
        url:'/numide/upload',
        processData:false,
        contentType:false,
        data:formData,
        success:function (msg){
            $("#result").html(msg+"已上传");
        }
    })
}
