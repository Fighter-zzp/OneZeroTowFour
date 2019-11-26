$(function () {
   $.ajax({
       url: "/admin/home.do",
       type: "GET",
       data: {},
       async : true,
       success: function (data) {
           $("#companyNum").text(data.extend.count.companyNum);
           $("#userNum").text(data.extend.count.userNum);
           $("#routeNum").text(data.extend.count.routeNum);
           $("#favoriteNum").text(data.extend.count.favoriteNum);
           $("#navNum").text(data.extend.count.navNum);
           $("#statusNum").text(data.extend.count.statusNum);
       }
   })
});