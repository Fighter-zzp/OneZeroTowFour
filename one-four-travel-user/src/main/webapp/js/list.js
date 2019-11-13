$(function () {
    $.ajax({
        url: "/list",
        type: "GET",
        dataType: "json",
        success: function (da) {
            console.log(da);

            let str = `
                <thead>
                <tr>
                       <th>uid</th>
                       <th>用户名</th>
                       <th>密码</th>
                       <th>名字</th>
                       <th>性别</th>
                       <th>手机号码</th>
                        <th>邮箱</th>
                                   
                </tr>
                </thead>`
            da.map(item => {
                str += `
        <tbody>
                <tr>
                    <td>${item.uid}</td>
                    <td>${item.username}</td>
                    <td>${item.password}</td>
                    <td>${item.name}</td>
                    <td>${item.sex}</td>
                    <td>${item.telephone}</td>
                    <td>${item.email}</td>
                  
                </tr>
        </tbody>`
            })
            $('#list_table').html(str)
        }
    });
})
