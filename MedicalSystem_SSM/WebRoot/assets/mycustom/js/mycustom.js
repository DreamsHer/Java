/**
 * 目录
 * showModalNoKB                     显示Modal，禁用esc和点击背景关闭
 * setUrl                            子窗体页面跳转
 * backPage                          返回上一层页面
 * editTableToJsonString             将可编辑bsgird的值转为json 字符串 
 * editTableAddRow                   bsgird增加编辑列表 新的一编辑行
 * editTableRemoveRow                bsgird去掉当前编辑行
 * initDatetimepicker                初始化Datetimepicker
 * initDatepicker                    初始化Datepicker
 * loadDatatoForm                    jquery 根据json对象填充form表单
 * bsgridCheckOneChecked             检查bsgrid checked行的行数是否为1
 * bsgridCheckZeroChecked            检查bsgrid checked行的行数是否为0
 * bsgridGetChecked                  bsgrid返回获取checked行的index值
 * isNumericRegex                    利用正则表达式判断字符串是否是数字
 * numberorderAsc                    按照数字顺序排序的排序函数  array[] 数字排序 从大到小
 * numberorderDesc                   按照数字顺序排序的排序函数  array[] 数字排序 从大到小
 * haveValueInArray                  在传入的array数组中查询是否存在查询的值 存在返回true，否则返回false
 * 
 * */



/**
 * 显示Modal，禁用esc和点击背景关闭
 * 作者：sxj
 * @param {Object} id
 */
function showModalNoKB(id) {
	$('#'+id+" input[type=reset]").trigger("click");
	$('#' + id).modal({
		keyboard: false,
		backdrop: false
	});
	$('#' + id).modal('show');
}

/**
 * 子窗体页面跳转
 * 作者：sxj
 * @param {Object} url
 */
function setUrl(url) {
	//parent.childSetUrl(url);
	window.location = url;
}

/**
 * 返回上一层页面
 */
function backPage() {
	window.location.href=document.referrer;  
}

/**
 * 将可编辑bsgird的值转为json 字符串
 * @author en
 * @param gridObj bsgrid对象
 * @returns json字符串
 */
function editTableToJsonString(gridObj) {
	var aryObj = new Array();
	$.each(gridObj.getRowsChangedColumnsValue(), function(key,object) {
		aryObj.push(object);
	});
	return JSON.stringify(aryObj);
}

/**
 * bsgird增加编辑列表 新的一编辑行
 * @author en
 * @param gridObj bsgrid对
 */
function editTableAddRow(gridObj) {
	var chaged = gridObj.getChangedRowsIndexs();
	if (chaged == '') {//判断总行数是否为1，且未编辑
		gridObj.activeGridEditMode();
	} else {
		gridObj.addNewEditRow();
	}
}
/**
 * bsgird去掉当前编辑行
 * @author en
 * @param gridObj
 */
function editTableRemoveRow(gridObj) {
	var chagedRows = gridObj.getChangedRowsIndexs();
	//console.log(chagedRows);
	if (chagedRows.length > 1) {
		var index = gridObj.getSelectedRowIndex();
		gridObj.deleteRow(index);
	}
}



/**
 * 初始化Datetimepicker
 * @author en
 * @param dtpSelector 选择器
 */
function initDatetimepicker(dtpSelector) {
	$.datetimepicker.setLocale('ch');
	$(dtpSelector).datetimepicker({
		format: 'Y-m-d H:i',
	});
}

/**
 * 初始化Datepicker
 * @author en
 * @param dtpSelector 选择器
 */
function initDatepicker(dtpSelector) {
	$.datetimepicker.setLocale('ch');
	$(dtpSelector).datetimepicker({
		timepicker:false,//关闭时间选项 
		format: 'Y-m-d',
	});
}


/**
 * jquery 根据json对象填充form表单
 * @author en
 * @param fromId form表单id
 * @param jsonDate json对象
 */
function loadDataToForm(fromId,jsonDate){
	var obj = jsonDate;
	var key,value,tagName,type,arr;
	for(x in obj){//循环json对象
		key = x;
		value = obj[x];
		//$("[name='"+key+"'],[name='"+key+"[]']").each(function(){
		//更加form表单id 和 json对象中的key查找 表单控件
		$("#"+fromId+" [name='"+key+"'],#"+fromId+" [name='"+key+"[]']").each(function(){
			tagName = $(this)[0].tagName;
			type = $(this).attr('type');
			if(tagName=='INPUT'){
				if(type=='radio'){
					$(this).prop('checked',$(this).val()==value);
				} else if (type == 'checkbox') {
				    try {
				        //数组
				        arr = value.split(',');
				        for (var i = 0; i < arr.length; i++) {
				            if ($(this).val() == arr[i]) {
				                $(this).prop('checked', true);
				                break;
				            }
				        }
				    } catch (e) {
				        //单个
				        $(this).prop('checked', value);
				    } 
				}else{
					$(this).val(value);
				}
			} else if ( tagName == 'TEXTAREA') {
				$(this).val(value);
			} else if (tagName == 'SELECT') {
			    //console.log($(this).hasClass("select2"));
			    if ($(this).hasClass("select2")) {
			        //select2 插件的赋值方法
			        $(this).val(value).trigger("change");
			    } else {
			        $(this).val(value);
			    }
			    
			}
			
		});
	}
}

/**
 * 检查bsgrid checked行的行数是否为1
 * @author en
 * @param bsgrid bsgrid对象
 * @param wIndex w_index名称
 * @returns {Boolean} true/false
 */
function bsgridCheckOneChecked(bsgrid,wIndex) {
	var rowIndex=bsgrid.getCheckedValues(wIndex);
	if (rowIndex.length!=0 && rowIndex!=undefined) {
		if (rowIndex.length==1) {
			return true;
		} else {
			return false;
		}
	}else{
		return false;
	}
}

/**
 * 检查bsgrid checked行的行数是否为0
 * @author en
 * @param bsgrid bsgrid对象
 * @param wIndex w_index名称
 * @returns {Boolean} true/false
 */
function bsgridCheckZeroChecked(bsgrid,wIndex) {
	var rowIndex=bsgrid.getCheckedValues(wIndex);
	if (rowIndex.length!=0 && rowIndex!=undefined) {
		return true;
	}else{
		return false;
	}
}

/**
 * bsgrid返回获取checked行的index值
 * @author en
 * @param bsgrid bsgrid对象
 * @param wIndex w_index名称
 * @returns
 */
function bsgridGetChecked(bsgrid,wIndex) {
	return bsgrid.getCheckedValues(wIndex);
}

/**
 * 设置 main.jsp 的 mainGritter方法 弹窗
 * @param title
 * @param text
 */
function setMainGritter(title,text) {
	parent.mainGritter(title,text);
}

/**
 * 利用正则表达式判断字符串是否是数字
 * @param str
 * @returns
 */
function isNumericRegex(str){
	var pattern = new RegExp('[0-9]*','i');
	return pattern.test(str);
}

/**
 * 按照数字顺序排序的排序函数 array[] 数字排序 从小到大
 * @param {} a 
 * @param {} b 
 * @returns {} 
 */
function numberorderAsc(a, b) { return a - b; }

/**
 * 按照数字顺序排序的排序函数  array[] 数字排序 从大到小
 * @param {} a 
 * @param {} b 
 * @returns {} 
 */
function numberorderDesc(a, b) { return b - a; }

/**
 * 在传入的array数组中查询是否存在查询的值 存在返回true，否则返回false
 * @param {} value 值
 * @param {} tarray  数组
 * @returns {} 
 */
function haveValueInArray(value, tarray) {
    for (var i = 0; i < tarray.length; i++) {
        if (tarray[i] == value) {
            return true;
        }
    }
    return false;
}
/**
 * 在传入的array数组中移除传入的值,返回移除后的数组
 * @param {} value 
 * @param {} tarray 
 * @returns {} 
 */
function removeValueInArray(value, tarray) {
    for (var i = 0; i < tarray.length; i++) {
        if (tarray[i] === value) {
            tarray.splice(i, 1);
        }
    }
    return tarray;
}

/**
 * 关闭fancybox弹窗
 * @returns {} 
 */
function closeFancyBox() {
    $.fancybox.close();
}

/**
 * select2 加载数据（本地数据方式）
 * @param {} select2 select2下拉框选择器 .class #id string
 * @param {} jsonUrl json地址 string
 * @returns {} 
 */
function select2LoadData(select2, jsonUrl) {
    //绑定数据前清空Select2，否则无法重新绑定
    $(select2).empty();
    //请求数据，本地数据方式绑定
    /*$.post(jsonUrl, function (data) {
        $(select2).select2({
            data: data
        });
    });*/
    $.ajax({
        type: "POST",
        url: jsonUrl,
        async: false,
        success: function (data) {
            $(select2).select2({
                data: data
            });
        }
    });
}

/**
 * 显示toastr弹窗
 * @param title 弹窗标题
 * @param msg	弹窗内容
 * @param showType 弹窗类型(如果未填默认1; 1:info,2:success,3:warning,4:error)
 * @param showTime 弹窗显示时间(单位ms; 填默认5000)
 * @param closeButton 是否显示关闭按钮(显示：true; 默认true)
 * @param progressBar 是否显示进度条(显示：true; 默认false)
 * @param position 弹窗位置(默认1; 1：右上,2:右下,3:左下,4:左上,5:顶部全宽,6:底部全宽,7:顶部居中,8:底部居中)
 */
function showToastr(title,msg,showType,showTime,closeButton,progressBar,position) {
	try{
        if(toastr!=null && toastr!=undefined){
            var positionClass='toast-top-right';
            if(position!=undefined){
                switch (position){
                    case 1:
                        positionClass='toast-top-right';
                        break;
                    case 2:
                        positionClass='toast-bottom-right';
                        break;
                    case 3:
                        positionClass='toast-bottom-left';
                        break;
                    case 4:
                        positionClass='toast-top-left';
                        break;
                    case 5:
                        positionClass='toast-top-full-width';
                        break;
                    case 6:
                        positionClass='toast-bottom-full-width';
                        break;
                    case 7:
                        positionClass='toast-top-center';
                        break;
                    case 8:
                        positionClass='toast-bottom-center';
                        break;
                    default:
                        break;
                }
            }

            if(showType!=undefined){
            	switch (showType){
					case 1:
                        showType='info';
                        break;
                    case 2:
                        showType='success';
                        break;
                    case 3:
                        showType='warning';
                        break;
                    case 4:
                        showType='error';
                        break;
                    default:
                        showType='info';
                        break;
				}
			}else{
            	showType='info';
			}

            toastr.options = {
                "closeButton": closeButton!=undefined&&typeof closeButton=='boolean'? closeButton : true,
                "debug": false,
                "progressBar": progressBar!=undefined&&typeof progressBar=='boolean' ? progressBar : false,
                "positionClass": positionClass,
                "showDuration": "400",
                "hideDuration": "1000",
                "timeOut": showTime!=undefined&&(!isNaN(showTime)) ? showTime : 5000,
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };

            toastr[showType](msg!=undefined ? msg :'', title!=undefined &&title!=''  ? title:'提示：');
        }else {
            alert("您未引入toastr！");
        }
	}catch (e){
        alert("您未引入toastr！");
	}
}

/**
 * 图片大小自适应
 * @param {} maxWidth
 * @param {} maxHeight
 * @param {} objImg
 * @returns {}
 */
function AutoResizeImage(maxWidth, maxHeight, objImg) {
    var img = new Image();
    img.src = objImg.src;
    var hRatio;
    var wRatio;
    var Ratio = 1;
    var w = img.width;
    var h = img.height;
    wRatio = maxWidth / w;
    hRatio = maxHeight / h;
    if (maxWidth == 0 && maxHeight == 0) {
        Ratio = 1;
    } else if (maxWidth == 0) {//
        if (hRatio < 1) Ratio = hRatio;
    } else if (maxHeight == 0) {
        if (wRatio < 1) Ratio = wRatio;
    } else if (wRatio < 1 || hRatio < 1) {
        Ratio = (wRatio <= hRatio ? wRatio : hRatio);
    }
    if (Ratio < 1) {
        w = w * Ratio;
        h = h * Ratio;
    }
    objImg.height = h;
    objImg.width = w;
}

/**
 * jquery 根据json对象创建Select下拉框
 * @author en
 * @param selectId form表单id
 * @param jsonData json对象
 */
function selectLoadData(selectId, jsonData) {
    $("#" + selectId).empty();//清空该元素
    for (var k in jsonData) {
        $("#" + selectId).append('<option value="' + jsonData[k].id + '">' + jsonData[k].text + '</option>');
    }
}

/**
 * jquery 根据url地址创建Select下拉框
 * @param selectId form表单id
 * @param url 请求地址
 */
function selectLoadDataByAjax( selectId,url) {
    $.post(url,function (jsonData) {
        selectLoadData(selectId,jsonData);
    })
}


function ChangeDateFormat(jsondate) {
	if (jsondate==null || jsondate=="") {
		return "";
	}
    try {
    	jsondate = jsondate.replace("/Date(", "").replace(")/", "");
	} catch (e) {
		jsondate=jsondate.time;
		jsondate=jsondate+"";
	}
    if (jsondate.indexOf("+") > 0) {
        jsondate = jsondate.substring(0, jsondate.indexOf("+"));
    }
    else if (jsondate.indexOf("-") > 0) {
        jsondate = jsondate.substring(0, jsondate.indexOf("-"));
    }

    var date = new Date(parseInt(jsondate, 10));
    var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

    return date.getFullYear()
        + "-"
        + month
        + "-"
        + currentDate
        + " "
        + date.getHours()
        + ":"
        + date.getMinutes()+":"+date.getSeconds();
}