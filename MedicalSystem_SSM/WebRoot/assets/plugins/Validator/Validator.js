/*************************************************
	Validator v1.05
	code by 我佛山人
	wfsr@msn.com
	2017.05.11 qzly update
*************************************************/
String.prototype.trim = function (tvalue) {
    if (tvalue != undefined) {
        return tvalue.replace(/(^\s*)|(\s*$)/g, "");
    } else {
        return "";
    }
 };
 Validator = {
	Require : /.+/,
	Email : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
	Phone : /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/,
	/*HeXhiXiong添加支持同时验证固定电话和手机号码*/
	PhoneMobile : /(^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$)|(^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?1[3,8,5]\d{9}$)/,
	Mobile : /^((\(\d{2,3}\))|(\d{3}\-))?1[3,5]\d{9}$/,
	/*HeXhiXiong添加仅支持中国移动手机号码*/
	ChinaMobile : /^((\(\d{2,3}\))|(\d{3}\-))?1[3,8,5][4,5,6,7,8,9]\d{8}$/,
	Url : /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/,
	IdCard : "this.IsIdCard(value)",
	Currency : /^\d+(\.\d+)?$/,
	Number : /^\d+$/,
	NumberZ: /^[+]?[1-9](\d+)?$/,
	NumberF: /^-[1-9](\d+)?$/,
	NumberNo0:/^[-+]?[1-9](\d+)?$/,	
	Zip : /^[1-9]\d{5}$/,
	QQ : /^[1-9]\d{4,10}$/,
	Integer : /^[-\+]?\d+$/,
	Double : /^[-\+]?\d+(\.\d+)?$/,
	DoubleZ : /^\+?\d+(\.\d+)?$/,
	DoubleF : /^-\d+(\.\d+)?$/,
	/*HeXhiXiong添加验证正实数*/
	PDouble : /^\d+(\.\d+)?$/,
	ODouble : /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/,
	English : /^[A-Za-z]+$/,
	EnNumber : /^[A-Za-z0-9]+$/,
	Chinese :  /^[\u0391-\uFFE5]+$/,
	IncludChinese :  "this.includChinese(value,getAttribute('min'),  getAttribute('max'))",
	Username : /^[a-z]\w{3,}$/i,
	UnSafe : /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/,
	/*HeXhiXiong添加验证月份*/
	Month : /^(0?[1-9]|1[0-2])$/,	
	SafeString : "this.IsSafe(value)",
	Filter : "this.DoFilter(value, getAttribute('accept'))",
	Limit : "this.limit(value.length,getAttribute('min'),  getAttribute('max'))",
	LimitB : "this.limit(this.LenB(value), getAttribute('min'), getAttribute('max'))",
	/*HeXhiXiong修改Date验证*/
	Date : "this.IsDate(value, getAttribute('format'))",
	CompareDate : "this.ComDate(getAttribute('d1'),getAttribute('d2'),getAttribute('connection'))",//HeZhiXiong添加验证两个日期大小
	Repeat : "value == document.getElementsByName(getAttribute('to'))[0].value",
	Range : "getAttribute('min') < (value|0) && (value|0) < getAttribute('max')",
	Compare : "this.compare(value,getAttribute('operator'),getAttribute('to'))",
	Custom : "this.Exec(value, getAttribute('regexp'))",
	Group : "this.MustChecked(getAttribute('name'), getAttribute('min'), getAttribute('max'))",
	JSCode : "eval(getAttribute('JSCode'))==true",
	IsChecked: "this.CheckedTest(checked,getAttribute('require'))",
	ErrorItem : [document.forms[0]],
	ErrorMessage : ["以下原因导致提交失败：\t\t\t\t"],
	Validate : function(theForm, mode){
		var obj = theForm || event.srcElement;
		var count;
		this.ErrorMessage.length = 1;
		this.ErrorItem.length = 1;
		this.ErrorItem[0] = obj;
		
		if(typeof(obj.elements)=="undefined"){
			count = 1;
			obj.elements=new Array();
			obj.elements[0]=theForm;//||event.srcElement;
		}else{
			count = obj.elements.length;			
		}
		for(var i=0;i<count;i++){
			with(obj.elements[i]){
				var _dataType = getAttribute("dataType");
				if(typeof(_dataType) == "object" || typeof(this[_dataType]) == "undefined")  continue;
				this.ClearState(obj.elements[i]);
				if(getAttribute("require") == "false" && value == "") continue;
				if(getAttribute("disabled")==true) continue;
				switch(_dataType){
					case "IdCard" :
					case "Date" :
					case "CompareDate":
					case "Repeat" :
					case "Range" :
					case "Compare" :
					case "Custom" :
					case "Group" : 
					case "Limit" :
					case "LimitB" :
					case "SafeString" :
					case "Filter" :
					case "JSCode":
					case "IsChecked":
					case "IncludChinese":
						if(!eval(this[_dataType]))	{
							this.AddError(i, getAttribute("msg"));
						}
						break;
					default :
						if(!this[_dataType].test(String.prototype.trim(value))){
							this.AddError(i, getAttribute("msg"));
						}
						break;
				}
			}
		}
		if(this.ErrorMessage.length > 1){
			mode = mode || 1;
			var errCount = this.ErrorItem.length;
			switch(mode){
			case 2 :
				for(var i=1;i<errCount;i++)
					this.ErrorItem[i].style.color = "red";
			case 1 :
				alert(this.ErrorMessage.join("\n"));
				if (this.ErrorItem[1].visable){
					this.ErrorItem[1].focus();
				}
				break;
			case 3 :
				for(var i=1;i<errCount;i++){
				try{
					var span = document.createElement("SPAN");
					span.id = "__ErrorMessagePanel";
					span.style.color = "red";
					this.ErrorItem[i].parentNode.appendChild(span);
					span.innerHTML = "<br/>"+this.ErrorMessage[i].replace(/\d+:/,"*");
					}
					catch(e){alert(e.description);}
				}
				if (this.ErrorItem[1].visable){
					this.ErrorItem[1].focus();
				}
				alert("您输入的数据有错误！请更改红色提示对应的数据，然后再提交。");
				break;
			case 4 :
				for(var i=1;i<errCount;i++){
				try{
					var span = document.createElement("SPAN");
					span.id = "__ErrorMessagePanel";
					span.style.color = "red";
					this.ErrorItem[i].parentNode.appendChild(span);
					span.innerHTML = this.ErrorMessage[i].replace(/\d+:/,"*");
					}
					catch(e){alert(e.description);}
				}
				if (this.ErrorItem[1].visable){
					this.ErrorItem[1].focus();
				}
				break;
            case 5 :
				for(var i=1;i<errCount;i++){
				try{
					var span = document.createElement("SPAN");
					span.id = "__ErrorMessagePanel";
					span.style.color = "red";
					this.ErrorItem[i].parentNode.appendChild(span);
					span.innerHTML = this.ErrorMessage[i].replace(/\d+:/,"*");
					}
					catch(e){alert(e.description);}
				}
				if (this.ErrorItem[1].visable){
					this.ErrorItem[1].focus();
				}
				break;
			default :
				alert(this.ErrorMessage.join("\n"));
				break;
			}
			return false;
		}
		return true;
	},
	
	IsSafe : function(str){return !this.UnSafe.test(str);},
	limit : function(len,min, max){
		min = min || 0;
		max = max || Number.MAX_VALUE;
		return min <= len && len <= max;
	},
	LenB : function(str){
		return str.replace(/[^\x00-\xff]/g,"**").length;
	},
	ClearState : function(elem){
		with(elem){
			if(style.color == "red")
				style.color = "";
			var lastNode = parentNode.childNodes[parentNode.childNodes.length-1];
			if(lastNode.id == "__ErrorMessagePanel")
				parentNode.removeChild(lastNode);
		}
	},
	AddError : function(index, str){
		this.ErrorItem[this.ErrorItem.length] = this.ErrorItem[0].elements[index];
		this.ErrorMessage[this.ErrorMessage.length] = this.ErrorMessage.length + ":" + str;
	},
	Exec : function(op, reg){
		return new RegExp(reg,"g").test(op);
	},
	compare : function(op1,operator,op2){
		op1 = eval(op1);
		op2 = eval(op2);
		switch (operator) {
			case "NotEqual":
				return (op1 != op2);
			case "GreaterThan":
				return (op1 > op2);
			case "GreaterThanEqual":
				return (op1 >= op2);
			case "LessThan":
				return (op1 < op2);
			case "LessThanEqual":
				return (op1 <= op2);
			default:
				return (op1 == op2);            
		}
	},
	MustChecked : function(name, min, max){
		var groups = document.getElementsByName(name);
		var hasChecked = 0;
		min = min || 1;
		max = max || groups.length;
		for(var i=groups.length-1;i>=0;i--)
			if(groups[i].checked) hasChecked++;
		return min <= hasChecked && hasChecked <= max;
	},
	DoFilter : function(input, filter){
		return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, filter.split(/\s*,\s*/).join("|")), "gi").test(input);
	},
	IsIdCard : function(number){
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
		return (number.length ==15 || number.length == 18 && number == Ai);
	},
	IsDate : function(op, formatString){
		formatString = formatString || "ymd";
		var m, year, month, day;
		switch(formatString){
			case "ymd" :
				m = op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2})$"));
				if(m == null ) return false;
				day = m[6];
				month = m[5]*1;
				year =  (m[2].length == 4) ? m[2] : GetFullYear(parseInt(m[3], 10));
				break;
			case "dmy" :
				m = op.match(new RegExp("^(\\d{1,2})([-./])(\\d{1,2})\\2((\\d{4})|(\\d{2}))$"));
				if(m == null ) return false;
				day = m[1];
				month = m[3]*1;
				year = (m[5].length == 4) ? m[5] : GetFullYear(parseInt(m[6], 10));
				break;
				/*HeZhiXiong修改仅年份判断 格式：yyyy*/
			case "yyyy" :
				m = op.match(new RegExp("^(\\d{4})$"));
				if(m == null ) return false;
				day = 01;
				month = 01;
				year = (m[1].length == 4) ? m[1] : GetFullYear(parseInt(m[6], 10));
				break;
			/*case "ymdhms":
				m=op.match(new RegExp("^((\\d{4})|(\\d{2}))([-./])(\\d{1,2})\\4(\\d{1,2}) ([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$"));*/
			default :
				break;
		}
		if(!parseInt(month)) return false;
		month = month==0 ?12:month;
		var date = new Date(year, month-1, day);
        return (typeof(date) == "object" && year == date.getFullYear() && month == (date.getMonth()+1) && day == date.getDate());
		function GetFullYear(y){return ((y<30 ? "20" : "19") + y)|0;}
	},
	ComDate : function(d1,d2,connection){//HeZhiXiong添加验证两个日期大小
		var t_d1 = document.getElementById(d1).value;
		var t_d2 = document.getElementById(d2).value;
		if (t_d1==null || t_d1=='') 
			return true;
		else if(!this.IsDate(t_d1)) 
			return false;
		if(t_d2==null || t_d2=='')
			return true;			
		else if(!this.IsDate(t_d2))
			return false;
		
		switch (connection) {
			case "NotEqual":
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) != (Date.parse(t_d1.replace(/-/g,"\/"))));
			case "GreaterThan":
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) > (Date.parse(t_d1.replace(/-/g,"\/"))));
			case "GreaterThanEqual":
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) >= (Date.parse(t_d1.replace(/-/g,"\/"))));
			case "LessThan":
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) < (Date.parse(t_d1.replace(/-/g,"\/"))));
			case "LessThanEqual":
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) <= (Date.parse(t_d1.replace(/-/g,"\/"))));
			default:
				return ((Date.parse(t_d2.replace(/-/g,"\/"))) == (Date.parse(t_d1.replace(/-/g,"\/"))));        
		}   		
	},
	includChinese:function(vl,minLeng,maxLnegh){
		var patVl=/^[\u0391-\uFFE5]|[\u0391-\uFFE5][A-Za-z0-9,:,：, ]|[A-Za-z0-9,:,：, ][\u0391-\uFFE5]+$/;
		if(patVl.test(String.prototype.trim(vl))){
			if(!!maxLnegh&&!isNaN(maxLnegh)){
				if(vl.length>parseInt(maxLnegh)){
					return false;
				}
			}
			return true;
		}
		return false;
	},
	CheckedTest:function(checkedFlag,isRequire){
		if(isRequire == "false"){
			return true;
		}
		return checkedFlag;
	}
 }