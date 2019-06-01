<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>出院管理</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link href="${ctx}/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />   
    <link href="${ctx}/assets/jquery/bsgrid.all.min.css" rel="stylesheet" />  
    <link href="${ctx}/assets/jquery/grid_blue.min.css" rel="stylesheet" />    
    <style type="text/css">   
        .container-fluid {
            width: 100%;
            padding-top: 0px;
            padding-left:12px;   
            font-size: 16px;                   
        }
        .panel-body {
        	background:#f0edf1;
            padding: 0;                      
            border:0;   
            height:570px;   
        }
        
    </style>                       
  </head>  
<body>	
	<div class="container-fluid" id="GuaHaoJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
            <div class="panel-heading">
                <h1 class="panel-title">出院管理</h1>
            </div>
			<div class="panel-body">
				<form class="form-horizontal" id="formInsert" action="${ctx}/OuGuaHaoController/MenZhenGuaHao.do" method="post">					
					<div class="form-group" style="margin-top:30px;">	
						<input type="text" class="hidden" name="patientId" id="patientId" />						
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">住院编号</label>															
						<div class="col-md-2 col-sm-1">
							 <input type="text" class="form-control" name="mzregno" id="mzregnoId" readonly>	 						 	
						</div>
						<label class="col-md-1 col-sm-1 control-label">收费单号</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="regtime" id="regtime">									
						</div>							
					</div>					
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">入院时间</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="cardno" id="cardno"
								maxlength="16" onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')">
						</div>
						<label class="col-md-1 col-sm-1 control-label">出院时间</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="cardno" id="cardno">
						</div>
					</div>					
					<div class="form-group" style="margin-top:20px;">	
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">住院天数</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="age" id="age" 
								maxlength="3" onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')">
						</div>					
						<label class="col-md-1 col-sm-1 control-label">床位费用</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="socialsecurityno" id="socialsecurityno" 
								maxlength="16" onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')">
						</div>
					</div>	
						
					<div class="form-group" style="margin-top:40px;">
						<div class="col-sm-1 col-sm-offset-4">
							<button type="button" onclick="insert()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;结算</button>
						</div>
						<div class="col-sm-1">
							<button type="button" id="ZhuanKeId" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-minus"></span>&nbsp;收取</button>
						</div>												
						<div class="col-sm-1">
							<button type="button" onclick="btnTuiChu()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;预交</button>
						</div>
					</div>	
									
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">病员姓名</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="cardno" id="cardno"
								maxlength="16" onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')">
						</div>
						<label class="col-md-1 col-sm-1 control-label">病员性别</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="userId" id="userId" class="form-control">
								<option value="0">-- 选择主管医生 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">所在科室</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="userId" id="userId" class="form-control">
								<option value="0">-- 选择主管医生 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-md-1 col-sm-1 control-label">已交费用</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="registerno" id="registerno"/>								
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label">已用金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="userId" id="userId" class="form-control">
								<option value="0">-- 选择主管医生 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-md-1 col-sm-1 control-label">所剩金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="registerno" id="registerno"/>								
						</div>
					</div>
					
					<div class="form-group" style="margin-top:40px;">
						<div class="col-sm-1 col-sm-offset-5">
							<button type="button" onclick="insert()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;新增</button>
						</div>
						<div class="col-sm-1">
							<button type="button" id="ZhuanKeId" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-minus"></span>&nbsp;出院</button>
						</div>	
						<div class="col-sm-1">
							<button type="button" id="ZhuanKeId" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-minus"></span>&nbsp;打印</button>
						</div>												
						<div class="col-sm-1">
							<button type="button" onclick="btnTuiChu()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出</button>
						</div>
					</div>

				</form>

			</div>

        </div>
        
    </div>
    
    <!--住院转科窗体-->
    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" 
    	aria-labelledby="myLargeModalLabel" id="modregister">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background:#377ab7;">
                    <button type="button" class="close" data-dismiss="modal">
                    	<span aria-hidden="true">&times;</span>
                    	<span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">住院转科窗体</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${ctx}/userss/register.do" method="post" id="formInsert">                        
                        <div class="form-group">
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">住院编号:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="username" id="usernameId" readonly/>
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">住院时间:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="date" class="form-control" name="password" id="passwordId"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">医疗证号:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="usercode" id="usercodeId"/>
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">社保卡号:</label>
                            </div>                           
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="password" class="form-control" name="password" id="passwordId"/>
                            </div>
                        </div>
                        <div class="form-group">
                         	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">病人姓名:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="certificateid" id="certificateid" maxlength="18" />
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">病人年 龄:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="age" id="age" maxlength="3" 
                                	onkeyup="value=value.replace(/\D/g,'')"/>
                            </div>                            
                        </div>
                        <div class="form-group">
                        	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">主管医生:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="phone" id="phone" maxlength="11"/>						
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">病房床位:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="email" id="email"/>
                            </div>
                        </div>
                        <div class="form-group">
                        	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">主管医生:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">                          	
	                            <select name="basedetailId2" id="basedetailId2" class="form-control">
                                   <option value="0">-- 请选择科室 --</option>
                                   <c:forEach items="${BasedetailListt}" var="p">
                                       <option value="${p.basedetailId}">${p.basedetailname}</option>
                                   </c:forEach>
                                </select>                                   
                            </div>         
                        	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">病房床位:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <select name="userroleId" id="userroleId" class="form-control">
                                   <option value="0">-- 请选择角色 --</option>
                                   <c:forEach items="${UserroleList}" var="p">
                                       <option value="${p.userroleId}">${p.userrolename}</option>
                                   </c:forEach>
                                </select>           	                               
                            </div>        
                        </div>
                       
						<div class="form-group" style="margin-top:20px;">
							<div class="col-sm-2 col-sm-offset-4">
								<button type="button" onclick="insert()"class="btn btn-primary btn-block btn-radius">提 交</button>								
							</div>						
							<div class="col-sm-2">
								<button type="button" class="btn btn-primary btn-block btn-radius" data-dismiss="modal">返 回</button>
							</div>
						</div>
                    </form>
                   
                </div>
            </div>
        </div>
    </div>
                 
    <script src="${ctx}/assets/jquery/bsgrid.all.min.js"></script>
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/jquery-2.0.3.min.js"></script>     
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>   
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/lang/grid.zh-CN.min.js"></script>
    <script src="${ctx}/assets/jquery/bsgrid.all.min.js" type="text/javascript"></script>
    <script src="${ctx}/assets/js/customfunction.js"></script>
    <script src="${ctx}/assets/js/jquery.form.js"></script>
    <script src="${ctx}/assets/js/ace.min.js"></script>
    <script src="${ctx}/assets/layer/layer.js"></script> 
    
    <script type="text/javascript">
        
        //点击住院转科	
		$("#ZhuanKeId").click(function() {	   
			$("#modregister").modal('show');
		});
        
        //页面加载
    	$(function(){
        	           	
        });    
    	
    	//打开页面加载
    	window.onload=danhao;
    	
    	//表单重置             
        document.getElementById("resetId").onclick=function(){       
        	var mzregnoId =document.getElementById("mzregnoId");
        	mzregnoId.defanltValue=mzregnoId.value;
        	document.forms[0].reset();
        	danhao();       
        }
    	
    	//自动生成编号
    	function danhao(){
    		var a = "";
				$.ajax({						
					async : false,
					cache : false,
					type : 'POST',
					contentType : 'application/json',
					dataType : "json",
					url : "${ctx}/OuGuaHaoController/mzregno.do",
					error : function() {
						alert('获取失败');
						frameElement.api.close();
					},
					success : function(data) {
					    
						a = data.msg;
					}
				});
			$("#mzregnoId").val(a); //文本框显示值    	
    	}
    	    	
    	//验证身份证号
		$("#certificateid").change(function(){		
			var certificateid=document.getElementById("certificateid");
			var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			if(certificateid.value.constructor==String){
				var re =certificateid.value.match(reg);
				if(re==null){
					layer.alert("身份证号码不存在，请输入正确的身份证号",{icon:0,title:'提示'});
					$("#certificateid").val("");
				}			
			}		
		});   	
    	    	
    	//门诊挂号
      	function insert(){
    	   		
    		var mzregno=$("#mzregnoId").val();
			var regtime=$("#regtime").val();
			var patientId=$("#patientId").val();			
			var patientname=$("#patientname").val();
			var basedetailId1=$("#XingBieId").val();
			var age=$("#age").val();
			var certificateid=$("#certificateid").val();		
			var cardno=$("#cardno").val();
			var socialsecurityno=$("#socialsecurityno").val();	
			var lxbasedetailId=$("#GuaHaoLX").val();
			var registerno=$("#registerno").val();
			var userId=$("#userId").val();
			var ksbasedetailId=$("#KeShiId").val();
			var regfee=$("#regfee").val();
			var pay=$("#pay").val();
			//复诊挂号病人
			var firstdate=$("#firstdate").val();
			var jzbasedetailId=$("JiuZhenId").val();
			
			if (mzregno!=null && mzregno!="" && patientname!=null && patientname!=""&& 
				certificateid!=null && certificateid!="") {

                 $("#formInsert").ajaxSubmit(function(data){
					var layerIndex=layer.load();
					if((typeof data )=="string"){
						data=JSON.parse(data);
					}
					console.log(data);
					layer.close(layerIndex);
					if(data.state==true){
					
						layer.alert(data.msg);
						
						setTimeout('TiaoZhuan()', 2000);//延迟2秒
											   
			    	} else {
			    		layer.alert(data.msg);
					}
				}); 		 
               
            } else {
            	layer.alert("请您先填写完整信息" ,{icon:0,title:'提示'});
            }						
			
		}  	
		
		// 延迟跳转 
		function TiaoZhuan(){
			window.location.href="${ctx}/OuGuaHaoController/GuaHao.do";
		}
		
		// 通过值改变事件： 根据商品ID，获得价格 
	    function fun(strs){
		   //获得值
		   var str = strs.value;	   
		   //获得价格
		   var  regfee = str.split("_")[1];
		   //根据ID查询费用
		   document.getElementById("regfee").value=regfee;		   
		   //注意：获得数量
		   var  count =  document.getElementById("registerno").value;
		   //如果数量不为空，则可以计算金额
		   if(count!=""){
			   document.getElementById("money").value= parseInt(count)*parseFloat(regfee);
		   }
		
		}
		
		//通过失去焦点事件： 根据数量，价格 计算金额
		function fun2(num){
		   //获得数量值
		   var str = num.value;
		   //获得价格
		   var  regfee =document.getElementById("regfee").value;	   
		   //计算
		   document.getElementById("money").value= parseInt(str)*parseFloat(regfee);		
		}
		
		//计算找回金额
		function jian(){
			//获取减数
			var pay=document.getElementById('pay').value;
			//获取被减数
			var money=document.getElementById('money').value;
			//根据ID查询计算结果并输出
			var ZhaoHuiJinE=document.getElementById('ZhaoHuiJinE');
				ZhaoHuiJinE.value=Number(pay)-Number(money);
		}			
    
    	//页面关闭按钮
        function btnTuiChu(){
        	$("#GuaHaoJieMian").hide();
        }
    
    </script>   
    
  </body>
</html>
