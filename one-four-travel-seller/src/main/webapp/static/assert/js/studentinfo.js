//1.页面加载完成之后发送Ajax请求，要到分页数据

$(function () {
    var totalRecord,currentPage;
    //显示第一页
    to_page(1);
    //添加学生信息
    addStudentInfo();
    //修改学生信息
    updateStudentInfo();
    //单个删除学生信息
    deleteStudentInfo();
    //批量删除
    //deleteSomeStudentInfo();




    /**
     * 1.实现学生信息展示
     * @param pn
     */
   //显示学生信息
    function to_page(pageNo) {
        $.ajax({
            url: "/studentinfo",
            data: "pageNo=" + pageNo,
            type: "GET",
            success: function (result) {
                //1.解析并显示学生信息数据
                build_studentinfo_table(result);
                //2.解析并显示分页信息
                build_page_info(result);
                //3.解析并显示分页条数据
                build_page_nav(result);

            }
        })
    }
    //解析并显示员工数据表
    function build_studentinfo_table(result) {
        //清空table表格
        $("#studentinfo_table tbody").empty();
        var studentinfoList = result.extend.pageInfo.list;
        //遍历元素studentinfoList
        $.each(studentinfoList, function (index, item) {
            var checkBox=$("<td><input type='checkbox' class='check_item'/></td>");
            var id = $("<td></td>").append(item.id);
            var name = $("<td></td>").append(item.name);
            var sex = $("<td></td>").append(item.sex);
            var age = $("<td></td>").append(item.age);
            var ys = $("<td></td>").append(item.ys);
            var className = $("<td></td>").append(item.className);
            var hiredate = $("<td></td>").append(item.hiredate);
            var tel = $("<td></td>").append(item.tel);
            var jg = $("<td></td>").append(item.jg);

            var button1 = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden", true)).append("编辑");
            var button2 = $("<button></button>").addClass("tn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden", true)).append("删除");
            var td_btn = $("<td></td>").append(button1).append(" ").append(button2);
            $("<tr></tr>").append(checkBox).append(id).append(name).append(sex).append(age).append(ys)
                .append(className).append(hiredate).append(tel).append(jg).append(td_btn ).appendTo("#studentinfo_table tbody");

        })
    }

//解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总共" + result.extend.pageInfo.pages +
            "页，总共" + result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage=result.extend.pageInfo.pageNum;
    }

//解析显示分页导航条
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        //如果没有前一页，前一页和首页就不能点
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //首页
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            //构建点击事件

            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.lastPage);
            })
        }
        //添加首页和前一页
        ul.append(firstPageLi).append(prePageLi);
        //遍历添加页码
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
            //如果是当前选中页面，添加active标识
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            //给每个页码添加点击就跳转
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");


    }






    /**
     * 2.实现新增功能
     * @returns {boolean}
     */
    function addStudentInfo() {

        //为新增按钮添加modal
        $("#studentinfo_add_modal_btn").click(function () {
            //清除表单数据
            $("#studentinfoAddModal form")[0].reset();
            $("#name_add_input").next("span").text("");
            $("#studentinfoAddModal").modal({
                backdrop: "static"
            })
        });



        //保存学生信息
        $("#studentinfo_save_btn").click(function () {
            //先校验表单信息
            if (!validate_form( $("#name_add_input"))) {
                return false;
            }

            //2.发送ajax请求保存学生信息
            $.ajax({
                url: "/studentinfo",
                type: "POST",
                data: $("#studentinfoAddModal form").serialize(),
                success: function (result) {
                    //学生信息保存成功(后端校验)
                    if (result.code == 100) {
                        //1.关闭modal框
                        $("#studentinfoAddModal").modal('hide');
                        //2.来到最后一页，显示刚才保存的数据
                        to_page(totalRecord);
                    } else {
                        //显示失败信息(后端校验)
                        if (result.extend.errorFields.username != undefined) {
                            show_validate_msg($("#name_add_input"), "error", result.extend.errorFields.username);
                        }


                    }

                }
            });
        });

    }

    //校验表单信息是否满足正则要求
    function validate_form(Name_ele) {
        //1.拿到要校验的数据，使用正则表达式
        //校验姓名
        var userName = Name_ele.val();
        //|(^[\u2E80-\u9FFF]{2,5})
        var regName = /^[a-zA-Z0-9\u2E80-\u9FFF]{2,16}$/;
        //如果验证失败
        if (!regName.test(userName)) {
            show_validate_msg(Name_ele, "error", "姓名2-16位中英文、数字");
            return false;
        } else {
            show_validate_msg(Name_ele, "success", "");
        }

        return true;
    }
    //显示校验提示信息
    function show_validate_msg(ele, status, msg) {
        //清除当前元素校验状态
        $(ele).parent().removeClass("has-error has-success");
        $(ele).next("span").text("");
        if (status == "error") {
            ele.parent().addClass("has-error");
            ele.next("span").text(msg);
        } else if (status == "success") {
            ele.parent().addClass("has-success");
            ele.next("span").text(msg);
        }

    }


    /**
     * 3.修改用户
     */
    function updateStudentInfo() {
        //为编辑按钮绑定弹出modal框事件
        //1.因为在按钮创建之前就绑定了click，所以用普通click方法绑定不上

        $(document).on("click",".edit_btn",function () {
            //清除表单数据
            $("#studentinfoUpdateModal form")[0].reset();
            $("#name_update_input").next("span").text("");

           //修改框中学生信息回显
           var id= $(this).parent().parent().children("td").eq(1).text();
           //将id的值传递给修改按钮的属性，方便发送Ajax请求
            $("#studentinfo_update_btn").attr("edit-id",id);
           var name=$(this).parent().parent().children("td").eq(2).text();
           var sex=$(this).parent().parent().children("td").eq(3).text();
           var age=$(this).parent().parent().children("td").eq(4).text();
           var ys=$(this).parent().parent().children("td").eq(5).text();
           var className=$(this).parent().parent().children("td").eq(6).text();
           var hiredate=$(this).parent().parent().children("td").eq(7).text();
           var tel=$(this).parent().parent().children("td").eq(8).text();
           var jg=$(this).parent().parent().children("td").eq(9).text();

            $("#name_update_input").val(name);
            $("#age_update_input").val(age);
            $("#ys_update_input").val(ys);
            $("#className_update_input").val(className);
            $("#tel_update_input").val(tel);
            $("#jg_update_input").val(jg);
            $("#studentinfoUpdateModal input[name=sex]").val([sex]);
            $("#studentinfoUpdateModal").modal({
                backdrop: "static"
            })
        });
        //2.为模态框中的修改按钮绑定事件，更新学生信息
        $("#studentinfo_update_btn").click(function () {
          //1.更新之前进行表单验证,验证没通过就直接返回
            if(!validate_form( $("#name_update_input"))){
                return false;
            }
            //2.验证通过后发送ajax请求保存更新的学生信息数据
            //如果要直接发送PUT之类的请求
            //在WEB.xml配置HttpPutFormContentFilter过滤器即可
            //这里未使用如上所述方法
            $.ajax({
                url:"/studentinfo/"+$(this).attr("edit-id"),
                type:"POST",
                data:$("#studentinfoUpdateModal form").serialize()+"&_method=PUT",
                success:function (result) {
                    //1.关闭modal框
                    $("#studentinfoUpdateModal").modal('hide');
                    //2.来到当前页，显示刚才保存的数据
                    to_page(currentPage);
                    
                }
            })

        })
    }


    /**
     * 4.删除学生信息
     */
    function deleteStudentInfo() {
        $(document).on("click",".delete_btn",function () {
            //1.弹出确认删除对话框
            var name=$(this).parents("tr").find("td:eq(2)").text();
            var id=$(this).parents("tr").find("td:eq(1)").text();
            if(confirm("确认删除【"+name+"】吗？")){
                //确认，发送ajax请求删除
                $.ajax({
                    url:"/studentinfo/"+id,
                    type:"POST",
                    data:{_method:"DELETE"},
                    dataType:"json",
                    success:function (result) {
                        alert(result.message);
                        to_page(currentPage);
                    }
                })


            }
        })
    }




});