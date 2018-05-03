var websocket = null;
var cahtNum = $('.chat-num').text();
if ('WebSocket' in window) {
    websocket = new WebSocket('ws://localhost:8055/webSocket');
} else {
    alert('该浏览器不支持websocket');
}
websocket.onopen = function (event) {
    console.log('websocket建立连接');
}
websocket.onclose = function (event) {
    console.log('websocket关闭连接');
}
websocket.onmessage = function (event) {
    console.log('websocket收到消息' + event.data);
    var result = $.parseJSON(event.data);
    /*接受消息*/
    if (result.type == 3) {
        var element = document.getElementById('message-template').innerHTML;
        var h = "name:" + result.sessionId + "---消息:" + result.message;
        var span = "<span style='float:right'>"+ h+"</span>"
        $('.message-container').append(element);
        $(".message-content:last").html(span);
    }
    else {
        $('.chat-num').text(result.userNum);
    }
}
websocket.onerror = function (event) {
    console.log('websocket通信发生错误');
}
window.onbeforeunload = function (event) {
    websocket.close();
}
$('.send-message').click(function () {
    var message = $('.chat-message').val();
    if (message == "") {
        mdui.alert('请输入要发送的消息');
        return;
    }
    sendmessage(message);
    $('.chat-message').val("");
})
function sendmessage(message) {
    websocket.send(message);
}