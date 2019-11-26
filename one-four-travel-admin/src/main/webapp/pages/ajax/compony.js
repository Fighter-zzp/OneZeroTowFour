$(function () {
//点击搜索
    $("#btn-search").click(function () {
        var keyword = $("#searchInput").val();
        //跳转
        location.href = "company.html?keyword=" + keyword;
    });

    var keyword = getParameter("keyword");
    //当页码加载完成后，调用load方法，发送ajax请求加载数据
    load(1, keyword);

    updateStudentInfo();
    change();
});
var componyCurrent; //全局当前页

load = function (currentPage, keyword) {
    componyCurrent = currentPage;
    var datas = {
        currentPage: currentPage,
        keyword: keyword
    };
    $.ajax({
        url: "/company/list.do",
        type: "GET",
        data: datas,
        async: true,
        success: function (result) {
            var pageInfo = result.extend.pageInfo;
            $("#totalPage").html(pageInfo.pages);
            $("#totalRows").html(pageInfo.total);
            // total = pageInfo.total;
            //分页
            display(pageInfo.pageNum, pageInfo.pages, keyword);
            var list = '';
            var company = pageInfo.list;
            for (var i = 0; i < company.length; i++) {
                list += '<tr>\n' +
                    '    <input type="hidden" name="sid" value="' + company[i].sid + '">\n' +
                    '    <td>' + company[i].sname + '</td>\n' +
                    '    <td>' + company[i].email + '</td>\n' +
                    '    <td>' + company[i].consphone + '</td>\n' +
                    '    <td>' + company[i].address + '</td>\n';
                    if (company[i].status==='Y'){
                        list+='    <td style="color: green">' + company[i].status + '</td>\n'+
                        '    <td>' + company[i].introduction + '</td>\n' +
                        '    <td>' + company[i].favCount + '</td>\n' +
                        '    <td>\n' +
                        '        <button class="btn btn-primary edit_btn" data-toggle="modal" data-target="#listUpdateModal"><i class="fa fa-edit"></i></button>\n' +
                        '        <button class="btn btn-info btn_change"><i class="fa fa-stop-circle-o"></i></button>\n' +
                        '        <a class="btn btn-dark" href="dcompany.html?sid='+company[i].sid+'"><i class="fa fa-modx"></i></a>\n' +
                        '    </td>\n' +
                        '</tr>';
                    }else {
                        list+='    <td style="color: red">' + company[i].status + '</td>\n'+
                            '    <td>' + company[i].introduction + '</td>\n' +
                            '    <td>' + company[i].favCount + '</td>\n' +
                            '    <td>\n' +
                            '        <button class="btn btn-primary edit_btn" data-toggle="modal" data-target="#listUpdateModal"><i class="fa fa-edit"></i></button>\n' +
                            '        <button class="btn btn-danger btn_change"><i class="fa fa-stop-circle-o"></i></button>\n' +
                            '        <a class="btn btn-dark"  href="dcompany.html?sid='+company[i].sid+'"><i class="fa fa-modx"></i></a>\n' +
                            '    </td>\n' +
                            '</tr>';
                    }
                    // '    <td style="color: orange">' + company[i].status + '</td>\n' +
            }
            $("#companyList").html(list);
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

        var sid = $(this).parent().parent().children("input").eq(0).val();
        var sname = $(this).parent().parent().children("td").eq(0).text();
        var email = $(this).parent().parent().children("td").eq(1).text();
        var consPhone = $(this).parent().parent().children("td").eq(2).text();
        var address = $(this).parent().parent().children("td").eq(3).text();
        var status = $(this).parent().parent().children("td").eq(4).text();
        var introduction = $(this).parent().parent().children("td").eq(5).text();
        //使按钮有id属性
        $("#save").attr("edit-id", sid);

        $("#s-name").val(sname);
        $("#c-email").val(email);
        $("#c-tel").val(consPhone);
        $("#address").val(address);
        $("#s-stu").val(status);
        $("#s-intr").val(introduction);
        $("#listUpdateModal").modal({
            backdrop: "static"
        })
    });
    //2.为模态框中的修改按钮绑定事件，更新学生信息
    $("#save").click(function () {
        //先校验表单信息
        if (!checkInput()) {
            alert("输入非法！");
            return false;
        }
        $.ajax({
            url: "/company/update.do",
            type: "POST",
            data: $("#update-form").serialize() + "&_method=PUT&sid=" + $(this).attr("edit-id"),
            async: true,
            success: function (result) {
                //1.关闭modal框
                $("#listUpdateModal").modal('hide');
                alert("修改成功！");
                //2.来到当前页，显示刚才保存的数据
                load(componyCurrent);
            }
        });
    });
}

checkInput = function () {
    var v1 = $("#s-name").val();
    var v2 = $("#c-email").val();
    var v3 = $("#c-tel").val();
    var v4 = $("#address").val();
    var v5 = $("#s-stu").val();
    var v6 = $("#s-intr").val();
    var flag1 = notNull(v2) && notNull(v1) && notNull(v3);
    var flag2 = notNull(v4) && notNull(v5) && notNull(v6);
    return flag1 && flag2;
};

notNull = function (name) {
    return name !== "" && name !== null;
};

//一键修改
change = function () {
    $(document).on("click", ".btn_change", function () {
        var status;
        var sid = $(this).parent().parent().children("input").eq(0).val();
        var sta = $(this).parent().parent().children("td").eq(4).text();
        if (sta==='Y'){
            status=0;
            $(this).removeClass("btn-danger").addClass("btn-info")
        }else {
            $(this).removeClass("btn-info").addClass("btn-danger");
            status=1;
        }
        $.ajax({
            url: "/company/change.do",
            type: "POST",
            data: {sid:sid,status:status,_method:"PUT"},
            async: true,
            success: function (result) {
                //1.关闭modal框
                // $("#listUpdateModal").modal('hide');
                alert("一键修改" + result.message + "！");
                //2.来到当前页，显示刚才保存的数据
                load(componyCurrent);
            }
        })
    })
};

