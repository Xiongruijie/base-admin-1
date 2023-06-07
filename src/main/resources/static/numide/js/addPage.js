layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });

});

function SubmitSystem() {
    console.log("SubmitSystem!!!!");
    let SystemName = $("#SystemName").value;
    let inputDateTime = $("#inputDateTime").value;
    let inputExperimentNumber = $("#inputExperimentNumber").value;
    let inputDesign = $("#inputDesign").value;
    let data = SystemName + inputDateTime + inputExperimentNumber + inputDesign;
    data = data.serializeObject();
    let opt = {
        url: "/numide/addSystem",
        contentType: "application/json;charset=UTF-8",
        type: "POST",
        data: JSON.stringify(data),
        dataType: "JSON",
        success: function (data) {
            console.log("ajax success!");
            console.log(data);
        },
        error: function (errorMsg) {
            console.log("error in ajax!");
            console.log(errorMsg)
        }
    }
    $.ajax(opt);

}

function uploadFile() {
    var file = $("#file")[0].files[0];
    var formData = new FormData();
    formData.append("file", file);
    formData.append("name", "dong");
    $.ajax({
        type: 'post',
        url: '/numide/upload',
        processData: false,
        contentType: false,
        data: formData,
        success: function (msg) {
            $("#result").html(msg + "已上传");
        }
    })
}

function GenerateInput() {
    let InputNumber = document.getElementById("inputExperimentNumber").value;

    let FormTemplate = "<form class=\"layui-form\" id=\"inputDesign\">\n" +
        "<iframe name=\"hidden\" style=\"display:none;\"></iframe>\n" +
        "<div class='layui-card'>" +
        " <div class=\"layui-row grid-demo grid-demo-bg1\">" + "<div class='layui-row'>"
    let FormEnd = "</div></div><br>\n" +
        "                    </form><button class=\"layui-btn layui-btn-primary check-button\" action='button' onclick=\"SubmitSystem()\">确认</button>"

    for (i = 1; i <= InputNumber; i++) {
        let FormElement = "<div class='layui-col-md1 input-inline'>&nbsp&nbsp" + i + "<br><input type=\"text\" id=\"Experiment" + i + "\" class=\"layui-input input-inline \" ></div>";
        FormTemplate = FormTemplate + FormElement;
    }
    document.getElementById("InterfaceDesign").innerHTML = FormTemplate + FormEnd;
}

//定义serializeObject方法，序列化表单
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
