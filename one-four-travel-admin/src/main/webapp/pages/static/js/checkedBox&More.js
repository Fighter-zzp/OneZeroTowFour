$(function () {
    //起始隐藏一些信息
    $(".more").hide();
});

$("#more").click(function () {
    $(".more").fadeToggle("normal","swing",function () {
        $("#more").html('<i class="fa fa-minus"></i>Less')
    })
});
/**
 * 复选框处理
 */
$("#all").click(function () {
    $('.ck').each(function () {
        $(this).prop('checked', $("#all").prop("checked"));
    });
});

$(document).on("click", ".ck", function () {
    var ck = $('.ck');
    var all = $("#all");
    all.prop("checked", true);
    //if (!ck.prop("checked"))  all.prop("checked",false);
    ck.each(function () {
        if (!$(this).prop("checked")) {
            all.prop("checked", false);
            return true;
        }
    });
});


function getMoth(str){
    var oDate = new Date(str),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate();//最后拼接时间
    return getzf(oMonth) + '-' + getzf(oDay);
}
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}