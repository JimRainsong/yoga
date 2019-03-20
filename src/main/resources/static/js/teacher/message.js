// 初始化全局变量

function closeback() {
    document.getElementById('blackback').style.display='none';
    document.getElementById('box1').style.display='none'
}







var dialog_url = "";
var is_turn_need = false;

// 视窗可见区域的宽和高
var windowHeight = document.documentElement.clientHeight;
var windowWidth = document.documentElement.clientWidth;
// 初始提示模态框的位置，居中显示
$(function () {
    // 获取属性
    var mes_window = $("#box1");
    var mes_width = mes_window.css("width");
    var mes_height = mes_window.css("height");
    // 去掉px单位
    mes_width = mes_width.substr(0, mes_width.length - 2);
    mes_height = mes_height.substr(0, mes_height.length - 2);
    // 获取左边的距离和上边的距离
    var left_distance = (windowWidth - mes_width) / 2;
    var top_distance = (windowHeight - mes_height) / 2;
    // 设置css属性
    mes_window.css("left", left_distance + "px");
    mes_window.css("top", top_distance + "px");
})
/*

function openDialog(message, url, if_turn) {
    $("#dialog_message").html(message);
    dialog_url = url;
    is_turn_need = if_turn;
    $("#block").css("display", "block");
    $("#dialog").css("display", "block");
}

function closeDialog() {
    $("#block").css("display", "none");
    $("#dialog").css("display", "none");
}

function turnTo() {
    closeDialog();
    if (is_turn_need) {
        window.location.href = "/yoga/teacher/" + dialog_url;
    }
}

<!--模态框组件-->
// <div id="block" class="modal"></div>
// <div id="dialog" class="modal">
//     <span id="message"></span>
//     <br>
//     <button onclick="closeDialog()">确认</button>
// </div>
<!-- !! -->
*/