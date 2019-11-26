$(function () {
    navList();
    updateList();
    addList();
});

navList = function () {
    $.ajax({
        url: "/nav/list.do",
        type: "GET",
        data: {},
        async: true,
        success: function (data) {
            var navs = data.extend.navList;
            var list = '';
            for (var i = 0; i < navs.length; i++) {
                list += '<div class="project">\n' +
                    '                            <div class="row bg-white has-shadow">\n' +
                    '                                <div class="left-col col-lg-6 d-flex align-items-center justify-content-between">\n' +
                    '                                    <div class="project-title d-flex align-items-center">\n' +
                    '                                        <div class="image has-shadow"><img src="static/img/tou.jpg" alt="..."\n' +
                    '                                                                           class="img-fluid"></div>\n' +
                    '                                        <div class="text">\n' +
                    '                                            <h4 class="h4">导航名</h4><span style="font-size: 16px;color: darkgrey">' + navs[i].cname + '</span>\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                    <div class="project-date">ID:<span>' + navs[i].cid + '</span></div>\n' +
                    '                                </div>\n' +
                    '                                <div class="right-col col-lg-6 d-flex align-items-center">\n' +
                    '                                    <div class="comments"><i class="fa fa-random"></i>所含路线：' + navs[i].favCount + '</div>\n' +
                    '                                    <div class="project-progress">\n' +
                    '                                        <input type="hidden" value="' + navs[i].cid + '"><input type="hidden" value="' + navs[i].cname + '">\n' +
                    '                                        <button class="btn btn-info edit_btn" data-toggle="modal" data-target="#listChangeModal">\n' +
                    '                                           修改</button>\n';
                if (navs[i].status === 1) {
                    list += '<button class="btn btn-outline-danger ban">禁用 <input type="hidden" name="' + navs[i].cid + '" value="1"></button>\n';
                } else {
                    list += '<button class="btn btn-outline-info ban">放行<input type="hidden" name="' + navs[i].cid + '" value="0"></button>\n';
                }
                list +=
                    '                                        <a class="btn btn-link" href="dnavManage.html?cid=' + navs[i].cid + '">详情</a>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>\n' +
                    '                        </div>';
            }
            $("#navList").html(list);
        }
    });
};

updateList = function () {
    $(document).on("click", ".edit_btn", function () {
        var cid = $(this).parent().children("input").eq(0).val();
        var cname = $(this).parent().children("input").eq(1).val();
        $("#c-id").val(cid);
        $("#c-name").val(cname);
        $("#save").click(function () {
            $.ajax({
                url: "/nav/update.do",
                type: "POST",
                data: $("#change-form").serialize() + '&cid='+cid+'&_method=PUT',
                async: true,
                success: function (data) {
                    $("#change-form").modal('hide');
                    alert("修改" + data.message);
                    //代码刷新页面
                    location.reload();
                }
            });
        });
    })
};

addList = function () {
    $(document).on("click", "#add", function () {
        $("#c-id").val("");
        $("#c-name").val("");
        $("#save").click(function () {
            $.ajax({
                url: "/nav/add.do",
                type: "POST",
                data: {cname: $("#c-name").val(), _method: "POST"},
                async: true,
                success: function (data) {
                    $("#change-form").modal('hide');
                    alert("添加" + data.message);
                    //代码刷新页面
                    location.reload();
                }
            });
        });
    })
};

$(document).on("click", ".ban", function () {
    var status = $(this).children("input").val();
    var cid = $(this).children("input").prop("name");
    $.ajax({
        url: "/nav/change.do",
        type: "POST",
        data: {cid: cid, status: status, _method: "PUT"},
        async: true,
        success: function (result) {
            alert("一键修改" + result.message + "！");
            //代码刷新页面
            location.reload();
        }
    })
});

