$(function () {
    $.ajax({
        url:"/getCollect",
        type:"GET",
        dataType:"json",
        success:function (da) {

            console.log(da)

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
                <tr><th>id</th><td>${item.rid}</td> </tr>             
                <tr><th>名字</th><td>${item.rname}</td> </tr>
                <tr><th>价格</th><td>${item.price}</td></tr>
                <tr> <th>routeIntroduce</th> <td>${item.routeIntroduce}</td></tr>
                <tr> <th>图片</th> <td><img src="/${item.rimage}" onclick="getId(${item.rid})"></td></tr>          
        </tbody>`
            })
            $('#test').html(str)
        }
    });
    // $(document).ready(function () {
    //     $('#test').DataTable({
    //         ajax: '/getCollect',
    //         type:"GET",
    //         columns: [
    //             { data: 'rid' },
    //             { data: 'rname' },
    //             { data: 'price' },
    //             { data: 'routeIntroduce'},
    //             { data: 'rimage' }
    //         ]
    //     });
    // });
})