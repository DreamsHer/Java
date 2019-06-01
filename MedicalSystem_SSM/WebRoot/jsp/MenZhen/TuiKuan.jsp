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
    <title>退药—退款—重打发票</title>    
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
            border:0;
            height:570px;
        }
    </style>                       
  </head>
  
<body>	
	<div class="container-fluid" id="TuiKuanJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
             <div class="panel-heading">
                <h1 class="panel-title">退药—退款—重打发票</h1>
            </div>
			<div class="panel-body"> 
				<form class="form-horizontal" id="formInsert" action="" method="post">
					<div class="form-group">
						<input type="text" class="hidden" name="ouhosinfoId" id="ouhosinfoId" />
						<input type="text" class="hidden" name="chargingitemdetailid" id="chargingitemdetailid" />
						<input type="text" class="hidden" name="chargingitemId" id="chargingitemId" />
						<label class="col-md-1 col-sm-1 col-sm-offset-3 control-label reset" style="margin-top:12px;" >收费单号</label>															
						<div class="col-md-2 col-sm-1 reset" style="margin-top:12px;">
							<input type="text" class="form-control" onkeyup="query()" name="prescriptioncode" id="prescriptioncode" placeholder="请输入收费单号">									
						</div>
						<div class="col-sm-1" style="margin-top:12px;">
							<button type="button" onclick="btnChaXun()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;查询</button>
						</div>
						<div class="col-sm-1" style="margin-top:12px;">
							<button type="button" onclick="btnTuiChu()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出</button>
						</div>
					</div>
					<div class="tab-pane">
						<table id="ChaXunTab" style="width:100%;">
							<tr>
								<th w_num="total_line" width="4%">序号</th> 
								<th w_index="chargingitemdetailid" w_hidden="true"></th>
								<th w_index="chargingitemId" w_hidden="true"></th>
								<th w_index="drugname" width="17%">项目名称</th>
								<th w_index="prescriptioncode" width="13%">收费编号</th>
								<th w_index="basedetailname">项目单位</th>
								<th w_index="amount" >项目数量</th>
								<th w_index="price">项目单价</th>
								<th w_index="itemmoney">项目金额</th>
								<th w_index="paymentmoney">支付金额</th>
								<th w_index="username">收费医生</th>
								<th w_index="coefficient">责任系数</th>
								<th w_index="USERReviewNo" w_render="crearViewButton" width="12%">操作</th>
							</tr>
						</table>
					</div>
				</form>
			</div>
        </div>
    </div>
    
    <!-- 退款退药窗体 -->
    <div class="modal" id="UpdatedChuangTi">
        <div class="modal-dialog" style="width:800px;height:600px;">
            <div class="modal-header" style="background:#377ab7;">
                <span>退款退药窗体</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body" style="background:#ffffff;">

                <form class="form-horizontal form-radius" id="formInsert" action="/YongHuGuanLi/UpdatePreserve" method="post" role="form">

                    <div class="form-group" style="margin-top:10px;">
                        <input type="text" class="hidden" name="usernameID" id="usernameID" />
                        <label class="col-md-2 col-sm-1 control-label reset">退药病人</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="" id="" readonly>
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">医疗卡号</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="password" class="form-control" name="" id="" readonly>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:10px;">
                        <label class="col-md-2 col-sm-1 control-label reset">社保卡号</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="" id="" readonly>
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">药品名称</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="IDnumber" id="IDnumber" readonly>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:10px;">
                        <label class="col-md-2 col-sm-1 control-label reset">发票编号</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="location" id="location" readonly>
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">药品单位</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="IDnumber" id="IDnumber" readonly>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:10px;">
                        <label class="col-md-2 col-sm-1 control-label reset">收费医生</label>
                         <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="IDnumber" id="IDnumber" readonly>
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">药品单价</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="postbox" id="postbox" readonly>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:10px;">
                    	<label class="col-md-2 col-sm-1 control-label reset">药品数量</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="phonenumber" id="phonenumber"
                                   onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')" >
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">药品金额</label>
                       <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="postbox" id="postbox" 
                            	onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top:10px;">
                        <label class="col-md-2 col-sm-1 control-label reset">收费时间</label>
                         <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="IDnumber" id="IDnumber" readonly>
                        </div>
                        <label class="col-md-2 col-sm-1 control-label reset">责任系数</label>
                        <div class="col-md-4 col-sm-1 reset">
                            <input type="text" class="form-control" name="remarks" id="remarks" readonly>
                        </div>
                    </div>

                    <div class="form-group" style="margin-top:20px;">                       
                        <div class="col-sm-2 col-sm-offset-4">
                            <button type="button" class="btn btn-primary form-control" id="btnPreserve">保存</button>
                        </div>
                        <div class="col-sm-2">
                            <button type="button" class="btn btn-danger form-control" data-dismiss="modal">返回</button>
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
	      
    <script type="text/javascript">
    
    	var findByTab;
    
    	//查询已收费列表
    	findByTab = $.fn.bsgrid.init("ChaXunTab", {
    		url: "${ctx}/OuTuiKuanController/ChaXunTuiKuanTuiYao.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 11,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置
        });           
        findByTab.refreshPage();
        
        //条件查询
        function query() {
            var prescriptioncode = $("#prescriptioncode").val();
                       
            findByTab.search({
                prescriptioncode: prescriptioncode,
                
         	});
        }
        
        //自定义权限操作按钮列
        function crearViewButton(record, rowIndex, colIndex, options) {
        	
        	 return '<button type="button" style=display:compact; class="btn btn-success" onclick="Updated(' + record.usernameID + ')">退药退款</button>'
             +"&emsp;"+ '<button type="button" style=display:compact; class="btn btn-danger" onclick="Replay(' + record.usernameID + ')">重打</button>';
                           
        }
		
		function Updated(usernameID){
		
			$("#UpdatedChuangTi").modal('show'); //打开表格窗体
			
			
		
		}
		
		
		
		//页面关闭按钮
		function btnTuiChu(){
			$("#TuiKuanJieMian").hide();
		}
		
    </script>
    
    
  </body>
</html>
