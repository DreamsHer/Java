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
    <title>库房—综合统计</title>    
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
	<div class="container-fluid" id="KuFangTongJi">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
             <div class="panel-heading">
                <h1 class="panel-title">库房—综合统计</h1>
            </div>
			<div class="panel-body"> 
				<form class="form-horizontal" id="formInsert" action="${ctx}/MenZhenController/TongJiBaoBiao.do" method="post">				
					<!-- 统计列表 -->
					<ul id="myTab" class="nav nav-tabs">
						 <li class="active"><a href="#JinKuXinXi" data-toggle="tab">进库—数据明细</a></li>
                         <li><a href="#ChuKuXinXi" data-toggle="tab">出库—数据明细</a></li>
                         <li><a href="#DangQianKuCun" data-toggle="tab">当前库存数据</a></li>
                         <li><a href="#DiGaoKuCun" data-toggle="tab">最低最高库存</a></li>
                    </ul>					
					<div id="myTabContent" class="tab-content" style="margin-top:10px;">					
						<!--进库—数据明细 -->
						<div class="tab-pane active" id="JinKuXinXi">
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 control-label reset">进库单号</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId" placeholder="请输入进库单号">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">药品名称</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId" placeholder="请输入药品名称">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">进库时间</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name="prescriptioncode"
										id="prescriptioncodeId">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
										<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
								<div class="col-sm-1">
									<button type="button" onclick="btnTuiChu()"
										class="btn btn-primary btn-block btn-radius">
										<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出
									</button>
								</div>
							</div>
							<table id="tabJinKuXinXi" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="chargingitemdetailid" w_hidden="true"></th>
									<th w_index="invoicecode">收费单号</th>
									<th w_index="itemname">项目名称</th>
									<th w_index="username">收费医生</th>
									<th w_index="basedetailname">收费科室</th>
									<th w_index="paymentmoney">支付金额</th>
									<th w_index="receivablemoney">实收金额</th>
									<th w_index="discount">优惠金额</th>
								</tr>
							</table>
						</div>
						
						<!-- 出库—数据明细 -->
						<div class="tab-pane" id="ChuKuXinXi">
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 control-label reset">出库单号</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name=""
										id="" placeholder="请输入出库单号">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">领药单位</label>
								<div class="col-md-2 col-sm-1 reset">
									<select name="basedetailId" id="KSbasedetailId" class="form-control">
										<option value="0">--请输入领药单位--</option>
										<c:forEach items="${BasedetailListtt}" var="p">
											<option value="${p.basedetailId}">${p.basedetailname}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">出库时间</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name=""
										id="">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
										<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
								<div class="col-sm-1">
									<button type="button" onclick="btnTuiChu()"
										class="btn btn-primary btn-block btn-radius">
										<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出
									</button>
								</div>
							</div>
							<table id="tabChuKuXinXi" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="" w_hidden="true"></th>
									<th w_index="">收费单号</th>
									<th w_index="">项目名称</th>
									<th w_index="">收费医生</th>
									<th w_render="">收费科室</th>
									<th w_index="">药品金额</th>
									<th w_index="">收费时间</th>
									<th w_index="">应收金额</th>
									<th w_index="">实收金额</th>
									<th w_index="">优惠金额</th>
								</tr>
							</table>
						</div>
					
						<!-- 当前库存数据 -->
						<div class="tab-pane" id="DangQianKuCun">
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">收费单号</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name=""
										id="" placeholder="请输入收费单号">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">收费时间</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name=""
										id="">
								</div>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name=""
										id="">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
										<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
								<div class="col-sm-1">
									<button type="button" onclick="btnTuiChu()"
										class="btn btn-primary btn-block btn-radius">
										<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出
									</button>
								</div>
							</div>
							<table id="tabDangQianKuCun" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="" w_hidden="true"></th>
									<th w_index="">收费单号</th>
									<th w_index="">项目名称</th>
									<th w_index="">收费医生</th>
									<th w_render="">收费科室</th>
									<th w_index="">药品金额</th>
									<th w_index="">收费时间</th>
									<th w_index="">应收金额</th>
									<th w_index="">实收金额</th>
									<th w_index="">优惠金额</th>
								</tr>
							</table>
						</div>
						
						<!-- 最低最高库存 -->
						<div class="tab-pane" id="DiGaoKuCun">
							<div class="form-group" style="margin-top:20px;">
								<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">收费单号</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="text" class="form-control" name=""
										id="" placeholder="请输入收费单号">
								</div>
								<label class="col-md-1 col-sm-1 control-label reset">收费时间</label>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name=""
										id="">
								</div>
								<div class="col-md-2 col-sm-1 reset">
									<input type="date" class="form-control" name=""
										id="">
								</div>
								<div class="col-sm-1">
									<button type="button" class="btn btn-primary btn-block btn-radius" id="">
										<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
								</div>
								<div class="col-sm-1">
									<button type="button" onclick="btnTuiChu()"
										class="btn btn-primary btn-block btn-radius">
										<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出
									</button>
								</div>
							</div>
							<table id="tabDiGaoKuCun" style="width:100%;">
								<tr>
									<th w_num="total_line">序号</th>
									<th w_index="" w_hidden="true"></th>
									<th w_index="">收费单号</th>
									<th w_index="">项目名称</th>
									<th w_index="">收费医生</th>
									<th w_render="">收费科室</th>
									<th w_index="">药品金额</th>
									<th w_index="">收费时间</th>
									<th w_index="">应收金额</th>
									<th w_index="">实收金额</th>
									<th w_index="">优惠金额</th>
								</tr>
							</table>
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
	   
	<!-- 进库—数据明细 -->
    <script type="text/javascript">
    
    	var tabJinKuXinXi;
    	    	
        tabJinKuXinXi = $.fn.bsgrid.init("tabJinKuXinXi", {
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
        tabJinKuXinXi.refreshPage();
        
         //条件查询
        function query() {
        
            var itemname = $("#itemname").val();
            var userId =$("#userId").val();
            var basedetailId =$("#KSbasedetailId").val();
                       
            tabJinKuXinXi.search({
                itemname: itemname,
                userId: userId,
                basedetailId:basedetailId,
                
         	});
        }       
    
    </script>
	   
	<!-- 出库—数据明细   -->  
	<script type="text/javascript">
		
		var tabChuKuXinXi;
		
		//加载页面
    	$(function(){
    		   	  	
    	});
    	
    	tabChuKuXinXi = $.fn.bsgrid.init("tabChuKuXinXi", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 13,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
        
        //关闭当前界面
        function btnTuiChu(){
        	$("#KuFangTongJi").hide();
        }
	
	</script>
    
    <!-- 当前库存数据 -->
    <script type="text/javascript">
		
		var tabDangQianKuCun;
		
		//加载页面
    	$(function(){
    		   	  	
    	});
    	
    	tabDangQianKuCun = $.fn.bsgrid.init("tabDangQianKuCun", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 13,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
        
        //关闭当前界面
        function btnTuiChu(){
        	$("#KuFangTongJi").hide();
        }
	
	</script>
	
	<!-- 最低最高库存 -->
	<script type="text/javascript">
		
		var tabDiGaoKuCun;
		
		//加载页面
    	$(function(){
    		   	  	
    	});
    	
    	tabDiGaoKuCun = $.fn.bsgrid.init("tabDiGaoKuCun", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 13,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
        
        //关闭当前界面
        function btnTuiChu(){
        	$("#KuFangTongJi").hide();
        }
	
	</script>
         
  </body>
</html>
