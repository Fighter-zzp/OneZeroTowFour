$(function () {
    $("#save_ps").click(function () {
        var psw = $("#text_password").val();
        alert(psw);
        $.ajax({
            url: "/setPassword",
            type: "POST",
            data:{password:psw},
            dataType:"json",
            success:function (da) {
               console.log(da)
            }
        })
    })
})