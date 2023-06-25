layui.use(['form', 'laydate'], function () {
    let form = layui.form;
    let laydate = layui.laydate;
    laydate.render({
        trigger: 'click',
        elem: '#inputDateTime',
        format: "yyyy-MM-dd"
    });

});
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

function SubmitSystem() {
    let data = [];
    for (i = 0; i < document.getElementById("inputExperimentNumber").value; i++) {
        data.push(document.getElementById("Experiment"+(i+1)).value);
    }
    console.log(JSON.stringify(data));
    // let opt = {
    //     url:"/numide/addSystem",
    //     type: "POST",
    //     // contentType: "application/json;",
    //     data: JSON.stringify(data),
    //     dataType: "JSON",
    //     success: function (data) {
    //         console.log("ajax success!");
    //         console.log(data);
    //     },
    //     error: function (errorMsg) {
    //         console.log("error in ajax!");
    //         console.log(errorMsg)
    //     }
    // }
    // $.ajax(opt);
    // xhr 发送
    var origin = window.location.origin;
    var url = origin+"/numide/addSystem";  // 替换为实际的后端URL

    var xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // 请求成功处理逻辑
                console.log(xhr.responseText);
            } else {
                // 请求失败处理逻辑
                console.log(xhr.status + ": " + xhr.statusText);
            }
        }
    };
    xhr.send(JSON.stringify(data));
}

function uploadFile() {
    var form = document.getElementById('uploadForm');
    var systemName = document.getElementById('systemName').value;
    var file = document.getElementById('file').files[0];
    var formData = new FormData();
    formData.append('systemName', systemName);
    formData.append('file', file);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/numide/upload', true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log('文件上传成功');
            var resultDiv = document.getElementById('result');
            resultDiv.innerText = '文件上传成功，系统信息已记录并，生成该系统页面';
            let selectList = JSON.parse(xhr.responseText);
            console.log(selectList);
            //生成页面
        } else {
            console.log('文件上传失败');
            var resultDiv = document.getElementById('result');
            resultDiv.innerText = '文件上传失败';
        }
    };
    xhr.send(formData);


    // 根据模板生成html界面
    /*
    生成的是输入界面
    * */


}

function getString(){
}

function writeIntoTemplate(ExperimentList) {
    let ListLength = ExperimentList.length;
    let a = 0;
    let elementStr = "";
    for (a = 0; a+2 < ListLength; a = a+3) {
        let element0 = ListLength[a];
        let element1 = ListLength[a+1];
        let element2 = ListLength[a+2];
        let element = "                    <div class=\"layui-col-md1 numide-input-element-div\">\n" +
            "                        <div class=\"layui-card\">\n" +
            "                            <div class=\"layui-card-header\">\n" +
            "                                <input type=\"text\" id=\"{3}\" th:value=\"0\" name=\"one\" maxlength=\"1\" autocomplete=\"off\" class=\"layui-input\"\n" +
            "                                       onkeyup=\"after_input({0},{1},{2},{3})\" onpaste=\"after_input({0},{1},{2},{3})\">\n" +
            "                            </div>\n" +
            "                            <div class=\"layui-card-body\">\n" +
            "                                <div class=\"layui-card\">\n" +
            "                                    <div class=\"layui-row grid-demo grid-demo-bg1\">\n" +
            "                                        <div class=\"layui-col-md12\">\n" +
            "                                            <div class=\"layui-col-md4\">\n" +
            "                                                <input type=\"text button\" name=\"{0}\" class=\"layui-btn layui-btn-xs button-width\" id=\"{0}\" value=\"-\" onclick=\"button_click({0},{0},{1},{2},{3})\" tabindex=\"-1\">\n" +
            "                                                <br>\n" +
            "                                                1\n" +
            "                                            </div>\n" +
            "\n" +
            "                                            <div class=\"layui-col-md4\">\n" +
            "                                                <input type=\"text button\" name=\"{1}\" class=\"layui-btn layui-btn-xs button-width\" id=\"{1}\" value=\"-\" onclick=\"button_click(121,111,121,131,10)\" tabindex=\"-1\">\n" +
            "                                                <br>\n" +
            "                                                2\n" +
            "                                            </div>\n" +
            "                                            <div class=\"layui-col-md4\">\n" +
            "                                                <input type=\"text button\" name=\"{2}\" class=\"layui-btn layui-btn-xs button-width\" id=\"{2}\" value=\"-\" onclick=\"button_click(131,111,121,131,10)\" tabindex=\"-1\">\n" +
            "                                                <br>\n" +
            "                                                4\n" +
            "                                            </div>\n" +
            "                                        </div>\n" +
            "                                        <div class=\"layui-col-md12\">\n" +
            "                                            <div class=\"layui-col-md4 \">\n" +
            "                                                {0}\n" +
            "                                            </div>\n" +
            "                                            <div class=\"layui-col-md4 \">\n" +
            "                                                {1}\n" +
            "                                            </div>\n" +
            "                                            <div class=\"layui-col-md4 button-margin\">\n" +
            "                                                {2}\n" +
            "                                            </div>\n" +
            "                                        </div>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </div>\n" +
            "                        </div>\n" +
            "                    </div>\n";


    }

}
