<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<link rel="stylesheet" href="${ctx}/assets/content/css/style.css" type="text/css"></link>
<link rel="stylesheet" href="${ctx}/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"></link>
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
	ul,li{
		font-size: 16px;
	}	
	.Verification {
		width: 243px;
		height: 48px;
		border-right: 1px solid #90a2bc;
		border-radius: 3px;
		background: url(${ctx}/assets/content/images/Password.png) no-repeat;
		line-height: 48px;
		padding-left: 44px;
		font-size: 14px;
	}	
	.Identity {
		margin-top: -3px;
		margin-left: -4px;
		border: 1px solid #90a2bc;
		border-radius: 3px;
		background-color: ecf5fa;
	}
	</style>

</head>
<body onkeydown="Enter()" style="background-color:#1c77ac; background-image:url(${ctx}/assets/content/images/loginbg3.png);background-repeat:no-repeat; background-position:center top; overflow:hidden;">
				
	<div class="logintop">
		<span style="font-size:16px">欢迎登录金商家医院管理系统</span>
		<ul>
			<li><a href="#help">帮助</a></li>			
			<li><a href="#cancel">取消</a></li>			
		</ul>		
	</div>

	<!-- 获取用户名和密码登录 -->		
	<div class="loginbody">
		<div class="loginbox">
			<form action="${ctx}/userss/login.do" method="post" id="fmLogin">
				<ul>
					<li>
						<input name="username" type="text" class="loginuser" placeholder="请输入登录账号"/>
					</li>
					<li>								
						<input name="password" type="password" class="loginpwd" 
							onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')" placeholder="请输入登录密码"/>
					</li>
					<li>
						<input name="identityKey" type="text" class="Verification" placeholder="请输入验证码"/>
						<img id="ImageIdentity" class="Identity" src="${ctx}/userss/identity.do" onclick="resetIdentity()">
					</li>
					<li>		
						<button type="button" id="btnSubmit" style="font-size:16px" class="loginbtn" onclick="login()">登录</button>
						<label><input type="checkbox" name="ck" />记住密码</label>
						<label><a id="register">注册</a></label>
					</li>
				</ul>
			</form>				
		</div>
	</div>
	
	<!--注册用户信息-->
    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="modregister">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" style="background:#377ab7;">
                    <button type="button" class="close" data-dismiss="modal">
                    	<span aria-hidden="true">&times;</span>
                    	<span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title">注册用户信息</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="${ctx}/userss/register.do" method="post" id="formInsert">                        
                        <div class="form-group">
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">用户名称:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="username" id="usernameId" placeholder="请输入用户名(必填)" />
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">密 码:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="password" class="form-control" name="password" id="passwordId" placeholder="请输入密码(必填)" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">用户编码:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="usercode" id="usercodeId" readonly />
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">性 别:</label>
                            </div>                           
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                            	 <select name="basedetailId1" id="basedetailId1" class="form-control">
                                   <option value="0">-- 请选择性别 --</option>
                                   <c:forEach items="${BasedetailList}" var="p">
                                       <option value="${p.basedetailId}">${p.basedetailname}</option>
                                   </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                         	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">身份证号:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="certificateid" id="certificateid" placeholder="请输入证件号(必填)" 
                                	maxlength="18" />
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">年 龄:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="age" id="age" placeholder="请输入年龄" 
                                	maxlength="3" onkeyup="value=value.replace(/\D/g,'')"/>
                            </div>                            
                        </div>
                        <div class="form-group">
                        	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">手机号码:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入手机号码"
                                 	maxlength="11"/>						
                            </div>
                             <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">邮 箱:</label>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱" />
                            </div>
                        </div>
                        <div class="form-group">
                        	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">科室类型:</label>
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
                                <label class="control-label">角色类型:</label>
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
                        <div class="form-group">                       	
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">详细地址:</label>
                            </div>
                            <div class="col-lg-10 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="location" id="location" placeholder="请输入详细地址" />
                            </div>                            
                        </div>
                        <div class="form-group">  
                         	<div class="col-lg-2 col-md-2 col-sm-2 text-right">
                                <label class="control-label">用户备注:</label>
                            </div>
                            <div class="col-lg-7 col-md-4 col-sm-4 reset">
                                <input type="text" class="form-control" name="memo" id="memo" placeholder="请输入备注" />
                            </div>                         
                            <div class="col-lg-2 col-md-2 col-sm-2 text-right">
                           		<label class="control-label">
                           			<input type="checkbox" id="userreviewno" name="userreviewno" type="checkbox" value="false"/>审核否
                           		</label>                               
                            </div>
                        </div>
						<div class="form-group" style="margin-top:20px;">
							<div class="col-sm-2 col-sm-offset-3">
								<button type="button" onclick="insert()"class="btn btn-primary btn-block btn-radius">提 交</button>								
							</div>
							<div class="col-sm-2">
								<button type="button" id="resetId"class="btn btn-primary btn-block btn-radius">重 置</button>
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
	
	<script type="text/javascript" src="${ctx}/assets/content/js/jquery.js"></script>	
	<script type="text/javascript" src="${ctx}/assets/bootstrap-3.3.7-dist/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/js/jquery.form.js"></script>
	<script type="text/javascript" src="${ctx}/assets/js/customfunction.js"></script>
	<script type="text/javascript" src="${ctx}/assets/layer/layer.js"></script>
	
	<!-- 用户登录 -->
	<script type="text/javascript">	
		
		//加载页面
		$(function() {		
			//设置登录面板居中		
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});			
			$(window).resize(function() {
				$('.loginbox').css({
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
			});
						
		});		
				
		// 刷新验证码点击事件
		function resetIdentity(){
			$("#ImageIdentity").attr("src", "${ctx}/userss/identity.do?time=" + new Date().getTime());
		}				 
		
		//登录按钮点击事件				
	    function login() {
			$("#fmLogin").ajaxSubmit(function(data){
			var layerIndex=layer.load();
				if((typeof data )=="string"){
					data=JSON.parse(data);
				}
				console.log(data);
				layer.close(layerIndex);
				if(data.state==true){
					window.location.href="${ctx}/userss/main.do";				   
			    } else {
			    	layer.alert(data.msg);
				}
			}); 			
		}		

		//Enter键登录
		function Enter() {
			if (event.keyCode == 13) {
				$("#btnSubmit").click();
			}
		};
				
		//点击用户注册 		
		$("#register").click(function() {
		    $("#resetId").click(); 
		    bianhao();//加载自动生成编号
			$("#modregister").modal('show');
		});
		
		//保存注册用户信息
		function insert(){   		
    		var username=$("#usernameId").val();
			var password=$("#passwordId").val();
			var usercode=$("#usercodeId").val();			
			var basedetailId1=$("#basedetailId1").val();
			var certificateid=$("#certificateid").val();
			var age=$("#age").val();
			var phone=$("#phone").val();		
			var email=$("#email").val();
			var basedetailId2=$("#basedetailId2").val();
			var userroleId=$("#userroleId").val();	
			var memo=$("#memo").val();
			var userreviewno;
			if ($("#userreviewno").prop("checked") == true) {
                 userreviewno = $("#userreviewno").val("true");
            }
            else {
                 userreviewno = $("#userreviewno").val("false");
            }
			var location=$("#location").val();
			
			if (username!=null && username!="" && password!=null && password!="" && 
				usercode!=null && usercode !=""&& certificateid!=null && certificateid!="" ) {	

                 $("#formInsert").ajaxSubmit(function(date){                
					var layerIndex=layer.load();
					if((typeof date )=="string"){
						date=JSON.parse(date);
					}					
					console.log(date);
					layer.close(layerIndex);
					if(date.state==true){
						layer.alert(date.msg);							   
			    	} else {
			    		layer.alert(date.msg);
					}
				}); 		 
               
            } else {
                layer.alert("请您填写完必填信息");
            }									
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
		
		//验证手机号码
		$("#phone").change(function(){		
			var phone=document.getElementById("phone");
			var reg = /[1][3-9][0-9]{9,9}/;
			if(phone.value.constructor==String){
				var re =phone.value.match(reg);
				if(re==null){
					layer.alert("号码不存在，请输入正确的手机号码",{icon:0,title:'提示'});
					$("#phone").val("");
				}			
			}		
		});
		
		//验证邮箱 
		$("#email").change(function(){		
			var email=document.getElementById("email");
			var reg =  /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
			if(email.value.constructor==String){
				var re =email.value.match(reg);
				if(re==null){
					layer.alert("邮箱格式错误或不存在，请输入正确的邮箱",{icon:0,title:'提示'});
					$("#email").val("");
				}			
			}		
		});
		
		//自动生成编号
		function bianhao(){    		
    		var a = "";
				$.ajax({						
					async : false,
					cache : false,
					type : 'POST',
					contentType : 'application/json',
					dataType : "json",
					url : "${ctx}/userss/usercode.do",
					error : function() {
						layer.alert("获取失败");
						frameElement.api.close();
					},
					success : function(data) {
						a = data.msg;
					}
				});
			$("#usercodeId").val(a);    	
    	}	
    	
    	//表单重置，限制编号不清空       
        document.getElementById("resetId").onclick=function(){               
        	var usercodeId =document.getElementById("usercodeId");
        	usercodeId.defanltValue=usercodeId.value;
        	document.forms[1].reset();       	
        	bianhao();         	    
        }	
		
	</script>

</body>
</html>
