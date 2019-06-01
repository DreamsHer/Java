var userId = $("#UserID").val();//获取用户ID
if (userId == "") {
    jsToLogin();
}

function jsToLogin() {
    alert("您还未登录,请先登录！！！");
    if (window.parent != undefined) {
        window.parent.location.href = "/Main/Login";
    }
    if (window.parent.parent != undefined) {
        window.parent.parent.location.href = "/Main/Login";
    } else {
        location.href = "/Main/Login";
    }
}