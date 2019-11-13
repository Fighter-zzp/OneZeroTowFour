$(function () {
  /*  alert("jfjfjj")*/
    $("#dd").load("userinfo.html");
    $.ajax({
        url: "/list",
        type: "GET",
        dataType: "json",
        success: function (da) {
            console.log(da);

            let str = `
               <!-- <thead>
                <tr>   
                       <th>用户名</th>                
                </tr>
                <tr> <th>密码</th></tr>
                <tr> <th>性别</th></tr>
                <tr> <th>手机号码</th></tr>
                <tr>  <th>邮箱</th></tr>
                </thead>-->`
            da.map(item => {
                str += `
        <tbody>
               
                    <tr><th>用户名</th>
                    <td>${item.username}</td> </tr>
                    
               
                <tr><th>密码</th><td>${item.password}</td></tr>
                <tr> <th>性别</th> <td>${item.sex}</td></tr>
                <tr> <th>手机号码</th><td>${item.telephone}</td></tr>
                <tr><th>邮箱</th><td>${item.email}</td></tr>
        </tbody>`
            })
            $('#online_table').html(str)
        }
    });
})