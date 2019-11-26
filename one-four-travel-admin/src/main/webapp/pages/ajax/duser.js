$(function () {
//点击搜索
    var uid = getParameter("uid");
    $("#btn-search").click(function () {
        var keyword = $("#searchInput").val();
        //跳转
        location.href = "duser.html?uid="+uid+"&keyword=" + keyword
    });
    var keyword = getParameter("keyword");
    if (keyword) {//对中文进行解码，防止乱码
        keyword = window.decodeURIComponent(keyword);
    }
    userInfo(uid);
    load(uid,1, keyword);
});

// session1
userInfo=function (uid) {
  $.ajax({
          url: "/favorite/userInfo.do",
          type: "GET",
          data: {"uid":uid},
          async: true,
          success: function (data) {
                var user = data.extend.user;
                $("#userN").html(user.username);
                $("#sex").html(user.sex);
                $("#collect").html(user.favCount);
              $("#status").html(user.status);
                var staImg = $('#staImg');
                staImg.removeClass();
                if (user.status==='Y'){
                    staImg.addClass("status bg-green")
                }else {
                    staImg.addClass("status bg-red")
                }
          }
  })
};

// session2
var userCurrent;//当前页

load = function (uid,currentPage, keyword) {
    userCurrent = currentPage;
    var datas = {
        uid:uid,
        currentPage: currentPage,
        keyword: keyword
    };
    $.ajax({
        url: "/favorite/routes.do",
        type: "GET",
        data: datas,
        async: true,
        success: function (data) {
            var pageInfo = data.extend.pageInfo;
            $("#totalPage").html(pageInfo.pages);
            $("#totalRows").html(pageInfo.total);
            total = pageInfo.total;
            //分页
            display(pageInfo.pageNum, pageInfo.pages, keyword,uid);
            var list = '';
            var route = pageInfo.list;
            for (var i = 0; i < route.length; i++) {
                list += '<div class="col-lg-4">\n' +
                    '                            <div class="client card">\n' +
                    '                                <div class="card-close">\n' +
                    '                                    <button class="btn btn-link delete">' +
                    '                                       <i class="fa fa-minus" style="color: darkgray"></i>' +
                    '                                        <input value="'+route[i].rid+'" hidden>'+
                    '                                    </button>\n' +
                    '                                </div>\n' +
                    '                                <div class="card-body text-center">\n' +
                    '                                    <div class="client-social">\n' +
                    '                                        <img src="static/' + route[i].rimage + '"\n' +
                    '                                             alt="..." class="img-fluid badge-rounded" style="width: 323px">\n' +
                    '                                    </div>\n' +
                    '                                    <div class="client-title">\n' +
                    '                                        <h3 class="line-limit">' + route[i].rname + '</h3><h5 class="line-limit" style="-webkit-line-clamp:2">' +
                    '                                              <span>' + route[i].routeintroduce + '</span></h5>' +
                    '                                          <a href="#?rid=' + route[i].rid + '">More</a>\n' +
                    '                                    </div>\n' +
                    '                                    <div class="client-info">\n';
                                                if(route[i].seller!==null){
                                                    list+='<a style="color: green" href="dcompany.html?sid=' + route[i].seller.sid + '">旅社:'+route[i].seller.sname+'</a>\n' ;
                                                }else {
                                                    list+='<a style="color: green" href="#">无旅社</a>\n' ;
                                                }
                                                    list+=
                    '                                        <h4 style="color: orange">' + route[i].rdate + '</h4>\n' +
                    '                                        <h3 style="color: red"><i class="fa fa-money"></i>￥' + route[i].price + '</h3>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '                        </div>';
            }
            $("#userFavorite").html(list);
            //定位到页面顶部
            // window.scrollTo(0, 0);
            document.querySelector('#page').scrollTo()
        }
    });
};

function display(curtpage, tpage, keyword,uid) {
    var options = {
        bootstrapMajorVersion: 4,//版本
        currentPage: curtpage, //当前页数
        numberOfPages: 5,//设置显示的页码数
        totalPages: tpage, //总页数
        itemTexts: function (type, page, current) {
            switch (type) {
                case "first":
                    return "首页";
                case "prev":
                    return "上一页";
                case "next":
                    return "下一页";
                case "last":
                    return "末页";
                case "page":
                    return page;
            }
        },
        onPageClicked: function (event, originalEvent, type, page) {
            load(uid,page, keyword)
        }
    };
    $("#page").bootstrapPaginator(options);
}

$(document).on("click", ".delete", function () {
    var uid = getParameter("uid");
    //1.弹出确认删除对话框
    if (confirm("确认删除此路线吗？")) {
        var id = $(this).children("input").val();
        //确认，发送ajax请求删除
        $.ajax({
            url: "/favorite/delete.do",
            type: "POST",
            data: {"rid":id,"uid":uid,_method: "DELETE"},
            dataType: "json",
            success: function (result) {
                alert("删除"+result.message);
                load(uid,userCurrent,"");
            }
        })
    }
});