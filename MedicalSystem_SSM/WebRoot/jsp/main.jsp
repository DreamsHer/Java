<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap-responsive.min.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/assets/css/font-awesome.min.css" type="text/css"/>
<link rel="stylesheet" href="${ctx}/assets/css/ace.min.css" type="text/css"/> <!-- 界面样式设置 -->
<html>
<head>
    <base href="<%=basePath%>">   
    <title>金商家医院管理系统</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">	   	
		.menu-text{
			font-size: 16px;
		}	     
    </style>      
</head> 
  
<body> 
    
	<!--标题内容-->
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid HeiBackgroud" style="height:60px;">            
             <small class="brand" style="margin-top:10px;">
                 <span style="font-style:italic;color:#ffffff;font-size:26px;font-weight:bold;">欢迎使用金商家医院管理系统</span>                     
             </small>
                <ul class="breadcrumb" style="font-size:16px;float:right">                   
					<li style="color:#ffffff;margin-top:7px;">
						<span><label id="ShiJianXanShi"></label></span>
						<span>欢迎您:</span>		
						<span style="color:#CCFF33;"><lable>${name}</lable></span>								  																	
						<a href="javascript:;" onclick="loginOut()" style="color:#CCFF33;margin-left:30px;">退出</a>							
					</li>	
			 	</ul>
            </div>
        </div>
    </div>

	<!-- 模块内容显示 -->
    <div class="main-container container-fluid">
        <a class="menu-toggler" id="menu-toggler">
            <span class="menu-text"></span>
        </a>
        <div class="sidebar" id="sidebar">
        	<h3 style="margin-left:22px;margin-top:0px;height:30px;">菜 单 列 表</h3>              
            <ul class="nav nav-list" style="margin-top:10px;font-size:15px;">  
            
            	<!--药库管理  --> 
                <li>
                    <a href="#;" class="dropdown-toggle" id="Drug_Storage">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">药库药房</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="Drug_Storage1">
                                <i class="menu-icon fa fa-caret-right"></i>请购单录入
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Drug_Storage2">
                                <i class="menu-icon fa fa-caret-right"></i>入库审核
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Drug_Storage3">
                                <i class="menu-icon fa fa-caret-right"></i>出库审核
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Drug_Storage4">
                                <i class="menu-icon fa fa-caret-right"></i>综合统计
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Drug_Storage5">
                                <i class="menu-icon fa fa-caret-right"></i>盘点分析
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Pharmacy1">
                                <i class="menu-icon fa fa-caret-right"></i>药房领料
                            </a>
                            <b class="arrow"></b>
                        </li>
                         <li class="">
                            <a href="javascript:;" id="Pharmacy2">
                                <i class="menu-icon fa fa-caret-right"></i>库房退药
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
            
            	<!-- 门诊管理-->
                <li>
                	<a href="#;" class="dropdown-toggle" id="OutpatientDepartment">
                        <i class="icon-filter"></i>
                        <span class="menu-text">门诊管理</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                    	<li class="active">
                            <a href="javascript:;" id="MenZhenGuaHao">
                                <i class="menu-icon fa fa-caret-right"></i>门诊挂号
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="MenZhenShouFei">
                                <i class="menu-icon fa fa-caret-right"></i>门诊收费
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="ChongDaTuiKuan">
                                <i class="menu-icon fa fa-caret-right"></i>退药退款
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="TongJiBaoBiao">
                                <i class="menu-icon fa fa-caret-right"></i>统计报表
                            </a>
                            <b class="arrow"></b>
                        </li>             
                    </ul>                                               
                </li>
            	           			               
                <!--住院管理-->
                <li>
                    <a href="#;" class="dropdown-toggle" id="Hospitalization">
                        <i class="icon-desktop"></i>
                        <span class="menu-text">住院管理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="Hospitalization1">
                                <i class="menu-icon fa fa-caret-right"></i>住院登记
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Hospitalization2">
                                <i class="menu-icon fa fa-caret-right"></i>预交费用
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Hospitalization3">
                                <i class="menu-icon fa fa-caret-right"></i>入科转科
                            </a>
                            <b class="arrow"></b>
                        </li>
                         <li class="">
                            <a href="javascript:;" id="Hospitalization4">
                                <i class="menu-icon fa fa-caret-right"></i>中途结算
                            </a>
                            <b class="arrow"></b>
                        </li>
                         <li class="">
                            <a href="javascript:;" id="Hospitalization5">
                                <i class="menu-icon fa fa-caret-right"></i>出院处理
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>

				<!--护士护理 -->				 
                <li>
                    <a href="#;" class="dropdown-toggle" id="NursingStation">
                        <i class="icon-cut"></i>
                        <span class="menu-text">护士护理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="NursingStation1">
                                <i class="menu-icon fa fa-caret-right"></i>医嘱录入
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="NursingStation2">
                                <i class="menu-icon fa fa-caret-right"></i>项目录入
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="NursingStation3">
                                <i class="menu-icon fa fa-caret-right"></i>医嘱发送
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="NursingStation4">
                                <i class="menu-icon fa fa-caret-right"></i>单据打印
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="NursingStation5">
                                <i class="menu-icon fa fa-caret-right"></i>数据统计
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
                
                <!--化检检验-->
                <li>
                    <a href="#;" class="dropdown-toggle" id="Inspect">
                        <i class="icon-picture"></i>
                        <span class="menu-text">化检检验</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="Inspect1">
                                <i class="menu-icon fa fa-caret-right"></i>数据录入
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Inspect2">
                                <i class="menu-icon fa fa-caret-right"></i>报告审核
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Inspect3">
                                <i class="menu-icon fa fa-caret-right"></i>打印报告
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li> 
                
				<!--电子病历-->
                <li>
                    <a href="#;" class="dropdown-toggle" id="PrescriptionMedicalRecord">
                        <i class="icon-edit"></i>
                        <span class="menu-text">处方病历</span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="PrescriptionMedicalRecord1">
                                <i class="menu-icon fa fa-caret-right"></i>病历录入 
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="PrescriptionMedicalRecord2">
                                <i class="menu-icon fa fa-caret-right"></i>病历查阅
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="PrescriptionMedicalRecord3">
                                <i class="menu-icon fa fa-caret-right"></i>处方录入
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="PrescriptionMedicalRecord4">
                                <i class="menu-icon fa fa-caret-right"></i>处方统计
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>   
														
                <!--院长查询-->
                <li>
                    <a href="#;" class="dropdown-toggle" id="Dean_query">
                        <i class="icon-user"></i>
                        <span class="menu-text">院长查询 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="active">
                            <a href="javascript:;" id="Dean_query1">
                                <i class="menu-icon fa fa-caret-right"></i>病人信息
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Dean_query2">
                                <i class="menu-icon fa fa-caret-right"></i>财务信息
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Dean_query3">
                                <i class="menu-icon fa fa-caret-right"></i>医疗信息
                            </a>
                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="javascript:;" id="Dean_query4">
                                <i class="menu-icon fa fa-caret-right"></i>病种信息
                            </a>
                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li> 
                                                                                
                <!--退出系统-->               
                <li>
                	<a class="dropdown-toggle" onclick="loginOut()">
                        <i class="icon-off"></i>
                        <span class="menu-text">退出系统 </span>                       
                    </a>                      
                </li>
                
            </ul>

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left"></i>
            </div>
            
        </div>

        <div class="main-content"> 
               	
			<div class="breadcrumbs" id="breadcrumbs">
	              
	        </div>
		
			<iframe id="content" frameborder="no" border="0" style="width:100%;height:634px";"></iframe>
				       
       </div>  
       
    </div>

    <script src="${ctx}/assets/js/jquery-2.0.3.min.js"></script>   
    <script src="${ctx}/assets/js/ace-elements.min.js"></script>
    <script src="${ctx}/assets/js/ace.min.js"></script>
    <script src="${ctx}/assets/layer/layer.js"></script>
    <script src="${ctx}/assets/jquery/bsgrid.all.min.js"></script>      
                   
   	<!-- 获取系统时间及用户信息 -->        	
    <script type="text/javascript">
       
    	//加载界面时刷新时间
    	setInterval(GetShiJian, 1000);    	
        //定义时
		var Hour = 0;		
		//获取当前系统时间、星期
		function getCurDate() {
			var d = new Date();//定义时间
			var week;//定义星期
			switch (d.getDay()) {
			case 1:
				week = "星期一";
				break;
			case 2:
				week = "星期二";
				break;
			case 3:
				week = "星期三";
				break;
			case 4:
				week = "星期四";
				break;
			case 5:
				week = "星期五";
				break;
			case 6:
				week = "星期六";
				break;
			default:
				week = "星期天";
			}
			var years = d.getFullYear();
			var month = add_zero(d.getMonth() + 1);
			var days = add_zero(d.getDate());
			var hours = add_zero(d.getHours());
			var minutes = add_zero(d.getMinutes());
			var seconds = add_zero(d.getSeconds());
			//拼接年月日时分秒、星期
			var ndate = years + "年" + month + "月" + days + "日 " + hours + ":" + minutes
					+ ":" + seconds + " " + week;
			Hour = hours; //赋值时间
			return ndate; //输出结果		
		}
		//判断时间大于10时
		function add_zero(temp) {
			if (temp < 10)
				return "0" + temp;
			else
				return temp;
		}
		//获取当前时间
		function GetTime() {
			var d = new Date();
			var years = d.getFullYear();
			var month = add_zero(d.getMonth() + 1);
			var days = add_zero(d.getDate());
			return years + "-" + month + "-" + days;
		}
		//显示时间，最好使用label标签
		function GetShiJian() {
			$("#ShiJianXanShi").html(getCurDate());
		}		
		
		//注销当前用户          
        function loginOut(){          
            layer.confirm("确定要退出？", {
                icon: 3,
                btn: ['确定', '取消']
            }, function (layerIndex) {
                layer.close(layerIndex);//关闭提示框               
                window.location.href="${ctx}/userss/Outlogin.do";
            });
        };
        
        //active类
		function select(e) {
	         $('.nav-list li').removeClass('active');//移除 li标签上的active类
	         e.parents("li").addClass("active");//给选中的li标签添加active类
	    }
		                  
    </script>      
       
    <!-- 门诊管理 -->
	<script type="text/javascript">	
		
	$("#MenZhenGuaHao").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/OuGuaHaoController/GuaHao.do");
	});
	
	$("#MenZhenShouFei").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/OuShouFeiController/ShouFei.do");
	});
	
	$("#ChongDaTuiKuan").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/OuTuiKuanController/TuiKuan.do");
	});
	
	$("#TongJiBaoBiao").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/OuBaoBiaoController/BaoBiao.do");
	});
	 	    	
	</script>

	<!-- 药库管理 -->
	<script type="text/javascript">	
		
	$("#Drug_Storage1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YkLuRuController/QingGouDan.do");
	});
	
	$("#Drug_Storage2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YkRuKuController/RuKuShenHe.do");
	});
	
	$("#Drug_Storage3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YKChuKuController/ChuKuShenHe.do");
	});	
	
	$("#Drug_Storage4").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YKTongJiController/ZongHeTongJi.do");
	});
	
	$("#Drug_Storage5").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YKPanDianController/YaoPinPanDian.do");
	});	
	
	//药房管理
	$("#Pharmacy1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YKYaoFangController/LingLiaoDan.do");
	});
		
	$("#Pharmacy2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/YKYaoFangController/JieShouKuFang.do");
	});
	   	     	     	    	
	</script>

	<!-- 住院管理 -->
	<script type="text/javascript">	
	
	$("#Hospitalization1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/ZYDengJiController/ZhuYuanDengJi.do");
	});
	
	$("#Hospitalization2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/ZYJiaoFeiController/YuJiaoFeiYong.do");
	});
	
	$("#Hospitalization3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/ZYRuKeController/RuKeZhuanKe.do");
	});
	
	$("#Hospitalization4").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Hospitalization5").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/ZYChuYuanController/ChuYuanGuanLi.do");
	});	
	     	     	    	
	</script>

	<!-- 护士护理 -->
	<script type="text/javascript">	
		
	$("#NursingStation1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#NursingStation2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#NursingStation3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#NursingStation4").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#NursingStation5").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});	 
	    	     	    	
	</script>

	<!-- 化检检验 -->
	<script type="text/javascript">	
	
	$("#Inspect1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Inspect2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Inspect3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
		  	     	    	
	</script>
	
	<!-- 处方病历 -->
	<script type="text/javascript">
	
	$("#PrescriptionMedicalRecord1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#PrescriptionMedicalRecord2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#PrescriptionMedicalRecord3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#PrescriptionMedicalRecord4").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});	   
	  	     	    	
	</script>
	
	<!-- 院长查询 -->
	<script type="text/javascript">
	
	$("#Dean_query1").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Dean_query2").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Dean_query3").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});
	
	$("#Dean_query4").click(function () {
	   select($(this)); 
	   $("#content").attr("src", "${ctx}/RuKuController/RuKu.do");
	});	
	     	     	    	
	</script>

</body>
</html>
