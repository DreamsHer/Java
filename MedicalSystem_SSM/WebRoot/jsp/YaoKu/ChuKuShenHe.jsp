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
    <title>药品出库—审核</title>    
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
	<div class="container-fluid" id="ChuKuJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
             <div class="panel-heading">
                <h1 class="panel-title">药品出库—审核</h1>
            </div>
			<div class="panel-body">
				<form class="form-horizontal" id="formInsert" action="" method="post">				
					<div class="form-group" style="margin-top:20px;">
						<input type="text" class="hidden" name="ouhosinfoId" id="ouhosinfoId" />						
						<label class="col-md-1 col-sm-1 control-label reset">领药药房</label>															
						<div class="col-md-2 col-sm-1 reset" >							
							<select name="drugroomId" id="drugroomId" class="form-control">
								<option value="0">--选择药房--</option>
								<c:forEach items="${drugroomList}" var="p">
									<option value="${p.drugroomId}">${p.drugroomname}</option>
								</c:forEach>
							</select>				
						</div>	
						<label class="col-md-1 col-sm-1 control-label reset">出库类型</label>						
						<div class="col-md-2 col-sm-1 reset" >							
							<select name="basedetailId" id="basedetailId" class="form-control">
								<option value="0">--选择类型--</option>
								<c:forEach items="${BasedetailList}" var="p">
									<option value="${p.basedetailId}">${p.basedetailname}</option>
								</c:forEach>
							</select>				
						</div>	
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary btn-block btn-radius" 
							onclick="YaoPinXinXi()">药品批号</button>
						</div>																				
						<div class="col-md-2 col-sm-1 reset" >
							<input type="text" class="form-control" name="" id="" readonly>									
						</div>	
						<label class="col-md-1 col-sm-1  control-label reset">药品名称</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="amount" id="amount" readonly>
						</div>										
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1  control-label reset">散量数量</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="amount" id="amount" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">散量单价</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">散量单位</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">散量金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1  control-label reset">整量数量</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="amount" id="amount" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">整量单价</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">整量单位</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">整量金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1  control-label reset">出库单号</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="outstockcode" id="outstockcode" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">当前结存</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">结存金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" readonly>							
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="addRow()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="btnDelete()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</button>
						</div>
					</div>					
					<div class="tab-pane" id="">
						<table id="ShouFeiTab" style="width:100%;">
							<tr>
								<th w_num="total_line">序号</th>
								<th w_index="attendanceID" w_hidden="true"></th>
								<th w_index="username">药品分类</th>
								<th w_index="ordernumber">药品名称</th>
								<th w_index="sendname">规格型号</th>
								<th w_render="bsgrdSendadrss">单位</th>
								<th w_index="sendphonenumber">数量</th>
								<th w_index="takename">换算系数</th>
							</tr>
						</table>
					</div>					
				</form>
				<div class="form-group" style="margin-top:10px;">
					<div class="col-sm-1 col-sm-offset-3">
						<button type="button" onclick="btnInsert()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;新增</button>
					</div>
						<div class="col-sm-1">
						<button type="button" class="btn btn-primary btn-block btn-radius"
							id=""><span class="glyphicon glyphicon-ok"></span>&nbsp;审核</button>
					</div>
					<div class="col-sm-1">
						<button type="button" onclick="" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-print"></span>&nbsp;打印</button>
					</div>
					<div class="col-sm-1">
						<button type="button" onclick="" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-log-out"></span>&nbsp;导出</button>
					</div>
					<div class="col-sm-1">
						<button type="button" class="btn btn-primary btn-block btn-radius"
							id="btnDingDanId"><span class="glyphicon glyphicon-download-alt"></span>&nbsp;生成</button>
					</div>
					<div class="col-sm-1">
						<button type="button" onclick="btnTuiChu()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出</button>
					</div>
				</div>				
			</div>
        </div>       
    </div>
    
    <!-- 已入库药品信息窗体  -->
    <div class="modal" id="modalId">
        <div class="modal-dialog" style="width:1050px;">
            <div class="modal-header" style="background:#377ab7">
                <span>已入库药品信息窗体</span>
                <button type="button" class="close" data-dismiss="modal">
                	<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:330px;">
				<div class="tab-pane">
					<table id="CaiGouXinXiTable" style="width:100%;">
						<tr>
							<th w_num="total_line">序号</th>
							<th w_index="stockdetailId" w_hidden="true"></th>
							<th w_index="stockcode">请购单号</th>
							<th w_index="companyname">供应商</th>
							<th w_index="drugname">药品名称</th>
							<th w_index="spec">药品批号</th>
							<th w_index="stocknum">数量</th>
							<th w_index="price">单价</th>
							<th w_index="basedetailname">单位</th>
							<th w_index="effectivedates">有效日期</th>
							<th w_index="coefficient">责任系数</th>
						</tr>
					</table>
				</div>
			</div>
        </div>
    </div>
    
    <!-- 药品采购计划表窗体 -->   
    <div class="modal" id="ChaXunChuangTi">
        <div class="modal-dialog" style="width:1200px;">
            <div class="modal-header" style="background:#377ab7;">
                <span>药品采购计划表</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:520px;">
            	
            	<form class="form-horizontal" id="formInsert" action="" method="post">

					<div class="form-group">
						<label class="col-md-1 col-sm-1 control-label reset">请领单号</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="amount" id="amount">
						</div>
						<div class="col-sm-1">
							<button type="button"
								class="btn btn-primary btn-block btn-radius" id="btnInsert">查询</button>
						</div>
						<div class="col-sm-1">
							<button type="button"
								class="btn btn-primary btn-block btn-radius" id="btnInsert">生成</button>
						</div>
						<div class="col-sm-1">
							<button type="button"
								class="btn btn-primary btn-block btn-radius" id="btnInsert">打印</button>
						</div>
						<div class="col-sm-1">
							<button type="button"
								class="btn btn-primary btn-block btn-radius" id="btnInsert">导出</button>
						</div>
						<div class="col-sm-1">
							<button type="button"
								class="btn btn-primary btn-block btn-radius" data-dismiss="modal">退出</button>
						</div>
					</div>

					<div class="tab-pane">
						<table id="BingRenTable" style="width:100%;">
							<tr>							
								<th w_check="true"></th>
								<th w_index="attendanceID" w_hidden="true"></th>
								<th w_index="username">药品分类</th>
								<th w_index="ordernumber">药品名称</th>
								<th w_index="sendname">规格型号</th>
								<th w_render="bsgrdSendadrss">散量单位</th>
								<th w_index="sendphonenumber">散量数量</th>
								<th w_index="sendphonenumber">散量单位</th>
								<th w_index="sendphonenumber">整量数量</th>
								<th w_index="sendphonenumber">整量单位</th>
								<th w_index="sendphonenumber">药房名称</th>
							</tr>
						</table>
					</div>

					<div class="tab-pane" style="margin-top:20px;">
						<table id="DaiChuKuTab" style="width:100%;">
							<tr>							
								<th w_check="true"></th>
								<th w_index="attendanceID" w_hidden="true"></th>
								<th w_index="username">药品名称</th>
								<th w_index="ordernumber">药品批号</th>
								<th w_index="sendname">规格型号</th>
								<th w_render="bsgrdSendadrss">药品单位</th>
								<th w_index="sendphonenumber">药品零售价</th>
								<th w_index="sendphonenumber">药品数量</th>
								<th w_index="sendphonenumber">整量零售价</th>
								<th w_index="sendphonenumber">零售价金额</th>
								<th w_index="sendphonenumber">散量零售价</th>
								<th w_index="sendphonenumber">零售价金额</th>
							</tr>
						</table>
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
    
    	var CaiGouXinXiTable;
    	
    	function YaoPinXinXi(){
    		$("#modalId").modal('show');
    		CaiGouXinXiTable.refreshPage();    	
    	}
    	
    	//收费病人列表		
		CaiGouXinXiTable = $.fn.bsgrid.init("CaiGouXinXiTable", {
            url: "${ctx}/YkRuKuController/QingGouRuKu.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 8,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置 
            event: { //双击表格回填病人信息
                   customRowEvents: {
                    	//(record行记录值,rowIndex行索引值,trObj:tr目标,options选择的东西)
                        click: function (record, rowIndex, trObj, options) {                       
                        	var rowIndex = CaiGouXinXiTable.getSelectedRowIndex();
                        	if (rowIndex > -1) {
                                var StockdetailId  = record.stockdetailId; //获取传过来的ID                                
                                $.getJSON("${ctx}/YkRuKuController/HuiTianXinXi.do?StockdetailId="+StockdetailId, function (data) {                                                                              
                                    $("#stockdetailId").val(data.stockdetailId);//隐藏域
                                    $("#stockcode").val(data.stockcode);
                                    $("#companyname").val(data.companyname);
                                    $("#drugname").val(data.drugname);
                                    $("#spec").val(data.spec);
                                    $("#stocknum").val(data.stocknum);
                                    $("#price").val(data.price);
                                    $("#basedetailname12").val(data.basedetailname);
                                    $("#basedetailname13").val(data.basedetailname);
                                    $("#effectivedates").val(data.effectivedates);
                                    $("#coefficient").val(data.coefficient);
                                    $("#modalId").modal('hide'); //选择后自动关闭
                              });
                           }
                           else {
                               layer.alert('你没有选择信息！', { icon: 2, title: '提示' });
                           }
                        }
                    }
                }  
            
         });
    
    </script>
	      
    <script type="text/javascript">
    
    	//页面关闭按钮
		function btnTuiChu(){
        	$("#ChuKuJieMian").hide();
        }
    
    	var ShouFeiTab;
    	var ShouFeiBingRenTab;
    	    	    
    	//收费项目列表
    	ShouFeiTab = $.fn.bsgrid.init("ShouFeiTab", {
    		url: "${ctx}/OrderformController/ShouFeiBingRen.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 8,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置               
        });           
        //ShouFeiTab.refreshPage();
       
    
    	//收费病人  
    	$("#btnDingDanId").click(function() {		   
			$("#ChaXunChuangTi").modal('show');
		});
		//收费病人列表		
		ShouFeiBingRenTab = $.fn.bsgrid.init("BingRenTable", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 6,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
    	
    	var DaiChuKuTab
    	//收费病人列表		
		DaiChuKuTab = $.fn.bsgrid.init("DaiChuKuTab", {
            url: "${ctx}/MenZhenController/.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 6,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置              
        });
    	
    
    </script>
    
    
    <!-- 自动生成编号 -->
	<script type="text/javascript">
		
		//打开页面加载
    	window.onload=danhao;
    	
    	//自动生成编号
    	function danhao(){
    		var a = "";
			$.ajax({						
				async : false,
				cache : false,
				type : 'POST',
				contentType : 'application/json',  
				dataType : "json",
				url : "${ctx}/YKChuKuController/getOutstockcode.do",
				error : function() {
					alert('获取失败');
					frameElement.api.close();
				},
				success : function(data) {
					a = data.msg;
				}
			});
			$("#outstockcode").val(a);  
    	}
	
	</script>      
    
    
  </body>
</html>
