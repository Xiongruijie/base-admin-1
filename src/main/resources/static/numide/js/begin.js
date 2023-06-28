window.addEventListener('DOMContentLoaded', function () {
    var stringListContainer = document.getElementById('stringListContainer');

    fetch('/numide/getAll')
        .then(function (response) {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Network response was not ok.');
        })
        .then(function (data) {
            var stringListHTML = '';
            data.forEach(function (item) {
                stringListHTML += '<div class="layui-col-md1"><input type="button" class="layui-btn layui-btn-radius layui-btn-primary" value="' + item.name + '"id="' + item.num + '" onclick="enterSystem(' +
                    item.num + ')"></div>';
            });
            stringListContainer.innerHTML = stringListHTML;
        })
        .catch(function (error) {
            console.log('Error:', error);
        });
});

function enterSystem(num) {
    window.num = num;
    // 重定向到指定接口
    $("#stringListContainer").addClass("hiddendiv");
    $("#inputbox").removeClass("hiddendiv");
    fetch('/numide/getSelect', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({num: num})
    }).then(function (response) {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to fetch string list');
        }
    }).then(function (data) {
        // 处理接收到的字符串列表
        //在inputpad中插入输入面板
        let stringListHTML = '';
        let inputPad = document.getElementById("inputPad");
        let i;
        for (i = 0; i + 2 < data.length; i = i + 3) {
            stringListHTML += "<div class=\"layui-card layui-col-md1 input-element-box\">\n" +
                "                        <div class=\"layui-card-header\">\n" +
                "                            <input type=\"text\" class=\"layui-input\" id=\"eleme" + i + "\" value=\"0\" maxlength=\"1\" \n" +
                "                                   autocomplete=\"off\" onkeyup=\"after_input(" + data[i] + "," + data[i + 1] + "," + data[i + 2] + ",eleme" + i + ")\">\n" +
                "                        </div>\n" +
                "                        <div class=\"layui-card-body\">\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width \"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click(" + data[i] + "," + data[i] + "," + data[i + 1] + "," + data[i + 2] + ",eleme" + i + ")\" id=\"" + data[i] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    1\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width left_align\"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click(" + data[i + 1] + "," + data[i] + "," + data[i + 1] + "," + data[i + 2] + ",eleme" + i + ")\" id=\"" + data[i + 1] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    &nbsp;&nbsp;2\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width left_align\"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click(" + data[i + 2] + "," + data[i] + "," + data[i + 1] + "," + data[i + 2] + ",eleme" + i + ")\" id=\"" + data[i + 2] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    &nbsp;&nbsp;4\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i] + "\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i + 1] + "\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i + 2] + "\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>";
        }
        let length = data.length;
        if (length % 3 == 1) {
            stringListHTML += "<div class=\"layui-card layui-col-md1 input-element-box\">\n" +
                "                        <div class=\"layui-card-header\">\n" +
                "                            <input type=\"text\" class=\"layui-input\" id=\"eleme" + i + "\" value=\"0\" maxlength=\"1\" \n" +
                "                                   autocomplete=\"off\" onkeyup=\"after_input_1(" + data[i] + "," + ",eleme" + i + ")\">\n" +
                "                        </div>\n" +
                "                        <div class=\"layui-card-body\">\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width \"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click_1(" + data[i] + "," + data[i] + "," + ",eleme" + i + ")\" id=\"" + data[i] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    1\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i] + "\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>";
        } else if (length % 3 == 2) {
            stringListHTML += "<div class=\"layui-card layui-col-md1 input-element-box\">\n" +
                "                        <div class=\"layui-card-header\">\n" +
                "                            <input type=\"text\" class=\"layui-input\" id=\"eleme" + i + "\" value=\"0\" maxlength=\"1\" \n" +
                "                                   autocomplete=\"off\" onkeyup=\"after_input_2(" + data[i] + "," + data[i + 1] + ",eleme" + i + ")\">\n" +
                "                        </div>\n" +
                "                        <div class=\"layui-card-body\">\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width \"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click_2(" + data[i] + "," + data[i] + "," + data[i + 1] +",eleme" + i + ")\" id=\"" + data[i] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    1\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4\">\n" +
                "                                    <input type=\"text button\" class=\"layui-btn layui-btn-xs button-width left_align\"\n" +
                "                                           tabindex=\"-1\" onclick=\"button_click_2(" + data[i + 1] + "," + data[i] + "," + data[i + 1] + ",eleme" + i + ")\" id=\"" + data[i + 1] + "\" value=\"-\">\n" +
                "                                    <br>\n" +
                "                                    &nbsp;&nbsp;2\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"layui-row layui-col-md12\">\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i] + "\n" +
                "                                </div>\n" +
                "                                <div class=\"layui-col-md4 TextExperient\">\n" +
                "                                    " + data[i + 1] + "\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>";
        }
        inputPad.innerHTML = stringListHTML;
    })
}

function submitExp() {
    fetch('/numide/getSelect', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({num: num})
    }).then(function (response) {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Failed to fetch string list');
        }
    }).then(function (data) {
        $("#strainTable").load(location.href + " #strainTable");
        $("#outputFile").removeClass("layui-btn-disabled");
        $("#printResult").removeClass("layui-btn-disabled");
        let date = document.getElementById("inputDateTime").value;
        let sampleNumber = document.getElementById("sampleNumber").value;
        let inputStr = "";
        for (let i = 0; i < data.length; i++) {
            inputStr += document.getElementById(data[i]).value;
        }
        let requestData = {
            num: window.num,
            date: date,
            sampleNumber: sampleNumber,
            inputStr: inputStr
        };
        fetch('/numide/getForm', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestData)
        }).then(function (response) {
            if (response.ok) {
                return response.text();
            }
            throw new Error('Network response was not ok.');
        }).then(function (responseData) {
            // console.log(responseData); // 打印接收到的字符串
            let dataTableDiv = document.getElementById('strainTable');
            dataTableDiv.innerHTML = responseData;
        })
            .catch(function (error) {
                console.log('Fetch error:', error);
            });
    });
}
