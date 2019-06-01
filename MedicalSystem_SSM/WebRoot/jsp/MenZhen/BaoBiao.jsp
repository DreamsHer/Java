<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>统计报表</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">		
	<link href="${ctx}/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${ctx}/assets/jquery.bsgrid-1.37/merged/bsgrid.all.min.css" rel="stylesheet" />
    <link href="${ctx}/assets/jquery.bsgrid-1.37/css/skins/grid_blue.min.css" rel="stylesheet" />   
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
            height:570px;          
            border:0;
        }
    </style>                       
  </head>
  
<body>	
	<div class="container-fluid" id="BaoBiaoJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
             <div class="panel-heading">
                <h1 class="panel-title">统计报表</h1>
            </div>
			<div class="panel-body"> 
				<form class="form-horizontal" id="formInsert" action="${ctx}/MenZhenController/TongJiBaoBiao.do" method="post">				
					<!-- 统计列表 -->
					<ul id="myTab" class="nav nav-tabs">
						 <li class="active"><a href="#QiTaTongJi" data-toggle="tab">综合统计</a></li>
						 <li><a href="#XianKuanTongJi" data-toggle="tab">收费人现款统计</a></li>                         
                    </ul>					
					<div id="myTabContent" class="tab-content" style="margin-top:10px;">						
						<!-- 综合统计 -->
						<div class="tab-pane active" id="QiTaTongJi">							
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">项目名称</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name="drugname" id="drugname" placeholder="请输入收费项目名称">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">收费医生</label>
								<div class="col-md-2 col-sm-1 reset">
									<select name="userId" id="userId" class="form-control">
										<option value="0">--输入收费医生名称 --</option>
										<c:forEach items="${UsersList}" var="p">
											<option value="${p.userId}">${p.username}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">收费科室</label>
								<div class="col-md-2 col-sm-1 reset">
									<select name="basedetailId" id="KSbasedetailId" class="form-control">
										<option value="0">--请输入收费科室名称--</option>
										<c:forEach items="${BasedetailListtt}" var="p">
											<option value="${p.basedetailId}">${p.basedetailname}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-1">
									<button type="button" onclick="query()" class="btn btn-primary btn-block btn-radius">
									<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
							</div>
							<table id="tabShouFeiXiangMu" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="chargingitemdetailid" w_hidden="true"></th>
									<th w_index="prescriptioncode">收费单号</th>
									<th w_index="drugname">项目名称</th>
									<th w_index="username">收费医生</th>
									<th w_index="basedetailname">收费科室</th>
									<th w_index="paymentmoney">支付金额</th>
									<th w_index="receivablemoney">实收金额</th>
									<th w_index="discount">优惠金额</th>
								</tr>
							</table>
						</div>
						
						<!-- 收费人现款统计 -->
						<div class="tab-pane" id="XianKuanTongJi">
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">收费单号</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId" placeholder="请输入收费单号">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">收费时间</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId">
								</div>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
										<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
							</div>
							<table id="tabXianKuanTongJi" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="attendanceID" w_hidden="true"></th>
									<th w_index="username">收费单号</th>
									<th w_index="ordernumber">项目名称</th>
									<th w_index="sendname">收费医生</th>
									<th w_render="bsgrdSendadrss">收费科室</th>
									<th w_index="sendphonenumber">药品金额</th>
									<th w_index="takename">收费时间</th>
									<th w_index="takeadress">应收金额</th>
									<th w_index="takename">实收金额</th>
									<th w_index="takeadress">优惠金额</th>
								</tr>
							</table>

							<div class="form-group" style="margin-top:30px;">
								<label
									class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">回签情况</label>
								<div class="col-md-2 col-sm-1 reset">
									<select name="basedetailId" id="basedetailId"
										class="form-control">
										<option value="0">-- 选择回签情况 --</option>
										<c:forEach items="${BasedetailList}" var="p">
											<option value="${p.basedetailId}">${p.basedetailname}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">交费情况</label>
								<div class="col-md-2 col-sm-1 reset">
									<select name="basedetailId" id="basedetailId"
										class="form-control">
										<option value="0">-- 选择交费情况 --</option>
										<c:forEach items="${BasedetailListt}" var="p">
											<option value="${p.basedetailId}">${p.basedetailname}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
									<span class="glyphicon glyphicon-check"></span>&nbsp;全部</button>
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
									<span class="glyphicon glyphicon-print"></span>&nbsp;打印</button>
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
									<span class="glyphicon glyphicon-log-out"></span>&nbsp;导出</button>
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" onclick="btnTuiChu()">
									<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出</button>
								</div>
							</div>

						</div>
																								
					</div>						
				</form>
			</div>
        </div>
    </div>
    
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/jquery-1.11.3.min.js"></script>
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/jquery-2.0.3.min.js"></script>
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${ctx}/assets/jquery.bsgrid-1.37/merged/bsgrid.all.min.js"></script>
    <script src="${ctx}/assets/jquery.bsgrid-1.37/js/lang/grid.zh-CN.min.js"></script>
    <script src="${ctx}/assets/bootstrap-3.3.7-dist/js/bootstrap-table.js"></script>
    <script src="${ctx}/assets/js/customfunction.js"></script>
    <script src="${ctx}/assets/js/jquery.form.js"></script>
    <script src="${ctx}/assets/layer/layer.js"></script>
	   
	<!-- 查询综合统计报表 -->
    <script type="text/javascript">
    
    	var tabShouFeiXiangMu;
    	    	
        tabShouFeiXiangMu = $.fn.bsgrid.init("tabShouFeiXiangMu", {
            url: "${ctx}/OuBaoBiaoController/ChaXunQiTaTongJi.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 13,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
        tabShouFeiXiangMu.refreshPage();
        
         //条件查询
        function query() {
        
            var drugname = $("#drugname").val();
            var userId =$("#userId").val();
            var basedetailId =$("#KSbasedetailId").val();
                       
            tabShouFeiXiangMu.search({
                drugname: drugname,
                userId: userId,
                basedetailId:basedetailId,
                
         	});
        }
    
    </script>
	
	<!-- 收费人现款统计    -->  
	<script type="text/javascript">
		//加载页面
    	$(function(){
    		   	  	
    	});   	 
    	
    	var tabXianKuanTongJi;
    	
    	tabXianKuanTongJi = $.fn.bsgrid.init("tabXianKuanTongJi", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 11,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
        
        //关闭当前界面
        function btnTuiChu(){
        	$("#BaoBiaoJieMian").hide();
        }
	
	</script>
	      	
  </body>
</html>
