/**
 * Created by en on 2017/5/14.
 */
(function( factory ) {
    if ( typeof define === "function" && define.amd ) {
        define( ["jquery", "./jquery.validate"], factory );
    } else if (typeof module === "object" && module.exports) {
        module.exports = factory( require( "jquery" ) );
    } else {
        factory( jQuery );
    }
}(function( $ ) {
    /*----------数字验证----------*/
    /*---Interger 整数验证-----*/
    //整数
    $.validator.addMethod('integer',function (value, element, param) {
        var regexp=/^[+-]?\d*$/;
        return this.optional(element) || (regexp.test(value));
    },'只能输入整数');
    $.validator.addMethod('integerP',function (value, element, param) {
        var regexp=/^[+]?[1-9]\d*$/;
        return this.optional(element)|| (regexp.test(value));
    },'只能输入正整数');
    $.validator.addMethod('integerN',function (value, element, param) {
        var regexp=/^-[1-9]\d*$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入负整数');
    $.validator.addMethod('integerNoZero',function (value, element, param) {
        var regexp=/^[+-]?[1-9]\d*$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入非零整数');
    /*---double 实数验证------*/
    $.validator.addMethod('double',function (value, element, param) {
        var regexp=/^[-\+]?\d+(\.\d+)?$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入实数');
    $.validator.addMethod('doubleP',function (value, element, param) {
        var regexp=/^[+]?\d+(\.\d+)?$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入正实数');

    /*-----------文本验证--------*/
    //英文
    $.validator.addMethod('english',function (value, element, param) {
        var regexp=/^[A-Za-z]*$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入英文');
    $.validator.addMethod('enNumber',function (value, element, param) {
        var regexp=/^[A-Za-z0-9]*$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入英文和数字');
    $.validator.addMethod('chinese',function (value, element, param) {
        var regexp=/^[\u0391-\uFFE5]+$/;
        return this.optional(element)||(regexp.test(value));
    },'只能输入中文');


    $.validator.addMethod('IdCard',function (value, element, param) {
        var number=value;
        var date, Ai;
        var verify = "10x98765432";
        var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
        var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
        var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[xX\d])))$/i);
        if(re == null) return false;
        if(re[1] >= area.length || area[re[1]] == "") return false;
        if(re[2].length == 12){
            Ai = number.substr(0, 17);
            date = [re[9], re[10], re[11]].join("-");
        }
        else{
            Ai = number.substr(0, 6) + "19" + number.substr(6);
            date = ["19" + re[4], re[5], re[6]].join("-");
        }
        if(!this.IsDate(date, "ymd")) return false;
        var sum = 0;
        for(var i = 0;i<=16;i++){
            sum += Ai.charAt(i) * Wi[i];
        }
        if (number.lastIndexOf("X")>-1)
            verify = "10X98765432";
        Ai +=  verify.charAt(sum%11);
        return this.optional(element)|| (number.length ==15 || number.length == 18 && number == Ai);
    },'只能输入中文');
}));