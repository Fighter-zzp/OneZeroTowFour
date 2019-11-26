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

   /* $("#test").DataTable({
        // 是否开启本地分页
        "paging": true,
        // 是否开启本地排序
        "ordering": false,
        // 是否显示左下角信息
        "info": true,
        // 是否允许用户改变表格每页显示的记录数
        "lengthChange": false,
        // 是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
        "processing": true,
        // 是否允许 DataTables 开启本地搜索
        "searching": false,
        // 是否开启服务器模式
        "serverSide": true,
        // 控制 DataTables 的延迟渲染，可以提高初始化的速度
        "deferRender": true,
        // 增加或修改通过 Ajax 提交到服务端的请求数据
        "ajax": {
            "url": "/getCollect"
        },
        // 分页按钮显示选项
        "pagingType": "full_numbers",
        // 设置列的数据源
        "columns": [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "id"},
            {"data": "rname"},
            {"data": "price"},
            {"data": "routeIntroduce"},
            {"data": "rimage"},
            {
                "data": function (row, type, val, meta) {
                    return '<a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</a>&nbsp;&nbsp;&nbsp;' +
                        '<a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<a href="#" type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o"></i> 删除</a>'
                }
            }
        ],
        // 表格重绘的回调函数
        "drawCallback": function (settings) {
            App.initCheckbox();
        },
        // 国际化
        "language": {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        }
    });*/
})