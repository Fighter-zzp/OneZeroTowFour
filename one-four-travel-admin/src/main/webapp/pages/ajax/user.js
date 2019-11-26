$(function () {
    //点击搜索
    $("#btn-search").click(function () {
        var keyword = $("#searchInput").val();
        //跳转
        location.href = "user.html?keyword=" + keyword;
    });

    var keyword = getParameter("keyword");
    //当页码加载完成后，调用load方法，发送ajax请求加载数据
    load(1, keyword);
    //更新操作
    updateStudentInfo();
});


var current;//当前页
var total;//总页数

load = function (currentPage, keyword) {
    current = currentPage;
    var datas = {
        currentPage: currentPage,
        keyword: keyword
    };
    $.ajax({
        url: "/user/list.do",
        type: "GET",
        data: datas,
        async: true,
        success: function (result) {
            var pageInfo = result.extend.pageInfo;
            $("#totalPage").html(pageInfo.pages);
            $("#totalRows").html(pageInfo.total);
            total = pageInfo.total;
            //分页
            display(pageInfo.pageNum, pageInfo.pages, keyword);
            var list = '';
            var user = pageInfo.list;
            for (var i = 0; i < user.length; i++) {
                list += '<tr>\n' +
                    '   <th scope="row"><input class="checkbox-template ck" name="uid" value="' + user[i].uid + '" type="checkbox">\n' +
                    '   </th>\n' +
                    '   <td>' + user[i].username + '</td>\n' +
                    '   <td class="more">' + user[i].name + '</td>\n' +
                    '   <td class="more">' + user[i].birthday + '</td>\n' +
                    '   <td class="more">' + user[i].sex + '</td>\n' +
                    '   <td class="more">' + user[i].telephone + '</td>\n' +
                    '   <td>' + user[i].email + '</td>\n' +
                    '   <td>' + user[i].status + '</td>\n' +
                    '   <td>' + user[i].favCount + '</td>\n' +
                    '   <td>\n' +
                    '   <button class="btn btn-primary edit_btn" data-toggle="modal" data-target="#listUpdateModal"><i class="fa fa-edit"></i></button>' +
                    '   <button  class="btn btn-danger delete" style="pointer-events: auto;"><i class="fa fa-minus"></i></button>\n' +
                    '   <a class="btn btn-link" href="duser.html?uid='+user[i].uid+'"><i class="fa fa-desktop"></i></a>\n' +
                    // '   <a  href="/user/delete.do?uid="'+user[i].uid+' class="btn btn-danger" style="pointer-events: auto;"><i class="fa fa-minus"></i></a>\n' +
                    '   </td>\n' +
                    '   </tr>';
            }
            $("#userList").html(list);
            $(".more").hide();
            //定位到页面顶部
            // window.scrollTo(0, 0);
            document.querySelector('#page').scrollTo()
        }
    });
};

function display(curtpage, tpage, keyword) {
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
            load(page, keyword)
        }
    };
    $("#page").bootstrapPaginator(options);
}

function updateStudentInfo() {
    //为编辑按钮绑定弹出modal框事件
    //1.因为在按钮创建之前就绑定了click，所以用普通click方法绑定不上

    $(document).on("click", ".edit_btn", function () {
        //清除表单数据
        $("#listUpdateModal form")[0].reset();
        // $("#name_update_input").next("span").text("");

        var id = $(this).parent().parent().children("th").children("input").eq(0).val();
        var username = $(this).parent().parent().children("td").eq(0).text();
        var name = $(this).parent().parent().children("td").eq(1).text();
        var birthday = $(this).parent().parent().children("td").eq(2).text();
        var sex = $(this).parent().parent().children("td").eq(3).text();
        var telephone = $(this).parent().parent().children("td").eq(4).text();
        var email = $(this).parent().parent().children("td").eq(5).text();
        var status = $(this).parent().parent().children("td").eq(6).text();
        //使按钮有id属性
        $("#save").attr("edit-id", id);

        $("#user-name").val(username);
        $("#true-name").val(name);
        $("#birthday").val(birthday);
        $("#sex").val(sex);
        $("#tel").val(telephone);
        $("#email").val(email);
        $("#online").val(status);
        $("#sex input[name=sex]").val([sex]);
        $("#listUpdateModal").modal({
            backdrop: "static"
        })
    });
    //2.为模态框中的修改按钮绑定事件，更新学生信息
    $("#save").click(function () {
        //先校验表单信息
        if (!checkInput()){
            alert("输入非法！");
            return false;
        }
        $.ajax({
            url: "/user/update.do",
            type: "POST",
            data: $("#update-form").serialize() + "&_method=PUT&uid=" + $(this).attr("edit-id"),
            async: true,
            success: function (result) {
                //1.关闭modal框
                $("#listUpdateModal").modal('hide');
                //2.来到当前页，显示刚才保存的数据
                load(current,"");
            }
        });
    });
}

$("#deletes").click(function () {
    if (confirm("确认删除这些User吗？")) {
        //确认，发送ajax请求删除
        $.ajax({
            url: "/user/deletes.do",
            type: "POST",
            data: {"ids": getUIds(), _method: "DELETE"},
            async: true,
            success: function () {
                load(current,"")
            }
        });
    }
});

$(document).on("click", ".delete", function () {
    //1.弹出确认删除对话框
    var name = $(this).parents("tr").find("td:eq(0)").text();
    var id = $(this).parents("tr").find("th input:eq(0)").val();
    if (confirm("确认删除【" + name + "】吗？")) {
        //确认，发送ajax请求删除
        $.ajax({
            url: "/user/delete.do",
            type: "POST",
            data: {"uid":id,_method: "DELETE"},
            dataType: "json",
            success: function (result) {
                alert("删除"+result.message);
                load(current,"");
            }
        })
    }
});

//获取多选的uid
function getUIds() {
        var UIds = $("#userList input[name=uid]");
        var ids = [];
        UIds.each(function (i, e) {
            if ($(e).prop("checked"))
                ids.push(e.value);
        });
        return ids;
    }

checkInput=function(){
    var userName = $("#user-name").val();
    var name = $("#true-name").val();
    var birth = $("#birthday").val();
    var tel = $("#tel").val();
    var email = $("#email").val();
    var status = $("#online").val();
    var flag1 = notNull(userName)&&notNull(name)&&notNull(birth);
    var flag2 = notNull(tel) && notNull(email) && notNull(status);
    return flag1&&flag2;
};

notNull=function (name) {
    return name!=="" && name!==null;
};