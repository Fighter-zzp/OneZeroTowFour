$(function () {
   $("#btn").click(function () {
       $.ajax({
           url: "/admin/checkAdmin.do",
           type: "GET",
           data: $("#login-form").serialize(),
           async : true,
           success:function (data) {
               if (data.code===100){
                  location.href="index.html"
               }else{
                   alert("登录"+data.message)
               }
           }
       })
   })
});