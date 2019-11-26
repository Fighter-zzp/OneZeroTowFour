$(function () {
    //点击搜索
    var sid = getParameter("sid");
    $("#btn-search").click(function () {
        var keyword = $("#searchInput").val();
        //跳转
        location.href = "dcompany.html?sid="+sid+"&keyword=" + keyword
    });
    var keyword = getParameter("keyword");
    if (keyword) {//对中文进行解码，防止乱码
        keyword = window.decodeURIComponent(keyword);
    }
    companyInfo(sid);
    load(sid,1, keyword);
});
//session1
function companyInfo(sid) {
    $.ajax({
        url: "/company/cInfo.do",
        type: "GET",
        data: {"sid":sid},
        async: true,
        success: function (data) {
            var cInfo = data.extend.cInfo;
            $("#companyN").html(cInfo.sname);
            $("#brief").html(cInfo.introduction);
            $("#address").html(cInfo.address);
            $("#routeNum").html(cInfo.favCount);
            $("#status").html(cInfo.status);
            var staImg = $('#staImg');
            staImg.removeClass();
            if (cInfo.status==='Y'){
                staImg.addClass("status bg-green")
            }else {
                staImg.addClass("status bg-red")
            }
        }
    })
}

var companyCurrent;//当前页

load = function (sid,currentPage, keyword) {
    companyCurrent = currentPage;
    var datas = {
        sid:sid,
        currentPage: currentPage,
        keyword: keyword
    };
    $.ajax({
        url: "/company/detailList.do",
        type: "GET",
        data: datas,
        async: true,
        success: function (data) {
            var pageInfo = data.extend.pageInfo;
            $("#totalPage").html(pageInfo.pages);
            $("#totalRows").html(pageInfo.total);
            total = pageInfo.total;
            //分页
            display(pageInfo.pageNum, pageInfo.pages, keyword, sid);
            var list = '';
            var route = pageInfo.list;
            for (var i = 0; i < route.length; i++) {
                list += '<div class="col-lg-4">\n' +
                    '                            <div class="client card" style="height: 453px">\n' +
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
                    '                                              <span>' + route[i].routeintroduce + '</span></h5>' ;
                    if (route[i].rflag==='1'){
                        list+='<button class="btn btn-danger change">禁止<input type="hidden" value="' + route[i].rid + '"></button>\n' ;
                    }else {
                        list+='<button class="btn btn-primary change">放行<input type="hidden" value="' + route[i].rid + '"></button>\n' ;
                    }
                                                                list+=

                    '                                    </div>\n' +
                    '                                    <div class="client-info">\n' +
                    '                                        <h4 style="color: orange">' + route[i].rdate + '</h4>\n' +
                    '                                        <h3 style="color: red"><i class="fa fa-money"></i>￥' + route[i].price + '</h3>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '                        </div>';
            }
            $("#companyRoutes").html(list)
        }
    });
};

function display(curtpage, tpage, keyword,sid) {
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
            load(sid,page, keyword)
        }
    };
    $("#page").bootstrapPaginator(options);
}

$(document).on("click", ".delete", function () {
    var sid = getParameter("sid");
    //1.弹出确认删除对话框
    if (confirm("确认删除此路线吗？")) {
        var id = $(this).children("input").val();
        //确认，发送ajax请求删除
        $.ajax({
            url: "/company/deleteRoute.do",
            type: "POST",
            data: {"rid":id,"sid":sid,_method: "DELETE"},
            dataType: "json",
            success: function (result) {
                alert("删除"+result.message);
                load(sid,companyCurrent,"");
            }
        })
    }
});

$(document).on("click", ".change", function () {
    var sid = getParameter("sid");
    var rid = $(this).children("input").eq(0).val();
    var status;
    if ($(this).hasClass("btn-danger")){
        status=1;
    }else {
        status=0;
    }
    //1.弹出确认删除对话框
    if (confirm("确认操作此路线吗？")) {
        //确认，发送ajax请求删除
        $.ajax({
            url: "/company/ban.do",
            type: "POST",
            data: {"rid":rid,"status":status,_method: "PUT"},
            dataType: "json",
            success: function (result) {
                alert("修改"+result.message);
                load(sid,companyCurrent,"");
            }
        })
    }
});