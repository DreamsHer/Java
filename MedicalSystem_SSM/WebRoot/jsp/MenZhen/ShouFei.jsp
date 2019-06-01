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
    <title>门诊收费</title>    
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
	<div class="container-fluid" id="ShouFeiJieMian" >
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
            <div class="panel-heading">
                <h1 class="panel-title">门诊收费</h1>
            </div>
			<div class="panel-body">
				<form class="form-horizontal" id="formInsert"  method="post">
					<div class="form-group">
						<input type="text" class="hidden" name="ouhosinfoId" id="ouhosinfoId"/>
						<input type="text" class="hidden" name="stockdetailId" id="stockdetailId"/>
						<input type="text" class="hidden" name="chargingitemdetailid" id="chargingitemdetailid"/>
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset" style="margin-top:20px;">收费单号</label>															
						<div class="col-md-2 col-sm-1 reset" style="margin-top:20px;">
							<input type="text" class="form-control" name="prescriptioncode" id="prescriptioncode" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset"style="margin-top:20px;">收费病人</label>											
						<div class="col-md-2 col-sm-1 reset" style="margin-top:20px;">
							<input type="text" class="form-control" name="patientname" id="patientname" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset" style="margin-top:20px;">医生姓名</label>															
						<div class="col-md-2 col-sm-1 reset" style="margin-top:20px;">
							<input type="text" class="form-control" name="username" id="username" readonly>									
						</div>
						<div class="col-sm-1" style="margin-top:20px;">
							<button type="button" id="btnPatientId" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-user"></span>&nbsp;病人</button>
						</div>
					</div>
					<div class="form-group" style="margin-top:10px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">挂号单号</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="mzregno" id="mzregno" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">医疗卡号</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="cardno" id="cardno" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">社保卡号</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="socialsecurityno" id="socialsecurityno" readonly>									
						</div>
						<div class="col-sm-1">
							 <button type="button" onclick="btnStockdetailId()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-ok"></span>&nbsp;划价</button>
						</div>						
					</div>
					<div class="form-group" style="margin-top:10px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">项目名称</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="drugname" id="drugname" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">项目单位</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="basedetailname" id="basedetailname" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">项目单价</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="price" id="price" readonly>
						</div>
						<div class="col-sm-1">
							 <button type="button" onclick="addRow()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">项目数量</label>						
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="amount" id="amount"
								maxlength="8" onkeyup="funChengFa2(this)">
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">发生次数</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="frequency" id="frequency"
								maxlength="8" onkeyup="value=value.replace(/\D/g,'')">							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">优惠金额</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="discount" id="discount" onkeyup="jianshu()"> 									
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="btnDelete()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</button>
						</div>
					</div>					
					<div class="form-group" style="margin-top:20px;">	
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">责任系数</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="coefficient" id="coefficient">									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">项目金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="itemmoney" id="itemmoney" onkeyup="funChengFa(this)" readonly>							
						</div>
						<label class="col-md-1 col-sm-1  control-label reset">应收金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="receivablemoney" id="receivablemoney" readonly>
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary btn-block btn-radius" id="resetId">
								<span class="glyphicon glyphicon-refresh"></span>&nbsp;重置</button>
						</div>
					</div>
					
					<div class="tab-pane" style="margin-left:140px;"> 
						<div style="width:91%;background-color:#FFFFFF;height:180px;">
							<table id="ShouFeiTab" style="width:100%;text-align:center;border-color:#99bce8;" border="solid 1px #ccc;">
								<tr id="tr0" style="line-height:1.8em;background-color:#CCCCFF;border-color:#99bce8;">
									<th w_num="total_line" style="text-align:center;">序号</th>
									<th style="text-align:center;"><input type="checkbox" name="cb1" id="Checkbox7"></th>
									<th w_index="chargingitemdetailid" hidden style="text-align:center;"></th>
									<th w_index="drugname" width="20%" style="text-align:center;">项目名称</th>
									<th w_index="basedetailname" style="text-align:center;">项目单位</th>
									<th w_index="price" style="text-align:center;">项目单价</th>
									<th w_index="amount" style="text-align:center;">项目数量</th>
									<th w_index="itemmoney" style="text-align:center;">项目金额</th>
									<th w_index="discount" style="text-align:center;">优惠金额</th>
									<th w_index="frequency" style="text-align:center;">发生次数</th>
									<th w_index="coefficient" style="text-align:center;">责任系数</th>
								</tr>
							</table>
						</div>
					</div>

					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">支付金额</label>
						<div class="col-md-1 col-sm-1 reset">
							<input type="text" class="form-control" onkeyup="jian()" name="paymentmoney" id="paymentmoney">
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">找零金额</label>
						<div class="col-md-1 col-sm-1 reset">
							<input type="text" class="form-control" name="GoodsCode" id="GoodsCode" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">收费医生</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="userId" id="userId" class="form-control">
								<option value="0">--选择收费医生 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">收费时间</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="chargingtime" id="chargingtime">
						</div>
					</div>
					
					<div class="form-group" style="margin-top:16px;">
						<div class="col-sm-1 col-sm-offset-4">
							<button type="button" onclick="BaoCun()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-check"></span>&nbsp;保存</button>
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-print"></span>&nbsp;打印</button>
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
       
    <!-- 收费病人窗体  -->
    <div class="modal" id="modalId">
        <div class="modal-dialog" style="width:800px;">
            <div class="modal-header" style="background:#377ab7">
                <span>收费病人窗体</span>
                <button type="button" class="close" data-dismiss="modal">
                	<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:320px;">
				<div class="tab-pane">
					<table id="BingRenTable" style="width:100%;">
						<tr>
							<th w_num="total_line">序号</th>
							<th w_index="ouhosinfoId" w_hidden="true"></th>
							<th w_index="patientId" w_hidden="true"></th>
							<th w_index="mzregno">挂号单号</th>
							<th w_index="patientname">病人姓名</th>
							<th w_index="cardno">医疗卡号</th>
							<th w_index="socialsecurityno">社保卡号</th>
							<th w_index="username">医生姓名</th>
						</tr>
					</table>
				</div>
			</div>
        </div>
    </div>
    
    <!-- 调出收费药品信息 -->
    <div class="modal" id="modalTable">
        <div class="modal-dialog" style="width:600px;">
            <div class="modal-header" style="background:#377ab7">
                <span>收费药品信息</span>
                <button type="button" class="close" data-dismiss="modal">
                	<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:320px;">
				<div class="tab-pane">
					<table id="YaoPinTable" style="width:100%;">
						<tr>
							<th w_num="total_line">序号</th>
							<th w_index="stockdetailId" w_hidden="true"></th>
							<th w_index="drugname">药品名称</th>
							<th w_index="basedetailname">药品单位</th>
							<th w_index="price">药品单价</th>
						</tr>
					</table>
				</div>
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
    
    	var ShouFeiTab;
    	var ShouFeiBingRenTab;
    	var YaoPinTable;
    	
    	//打开页面加载
    	window.onload=danhao;
    	
    	//自动生成处方单号
    	function danhao(){
			var b ="";
			$.ajax({
				async : false,
				cache : false,
				type : 'POST',
				contentType : 'application/json',
				dataType : "json",
				url : "${ctx}/OuShouFeiController/ByPrescriptioncode.do",
				error : function() {
					alert('获取失败');
					frameElement.api.close();
				},
				success : function(data) {
					b = data.msg;
				}
			});
			$("#prescriptioncode").val(b);
    	}
    	
    	//表单重置             
        document.getElementById("resetId").onclick=function(){   
            
        	var prescriptioncode =document.getElementById("prescriptioncode");
        	prescriptioncode.defanltValue=prescriptioncode.value;       	
        	
        	document.forms[0].reset();
        	danhao();       
        }       
    
    	//收费病人  
    	$("#btnPatientId").click(function() {		   
			$("#modalId").modal('show');
			ShouFeiBingRenTab.refreshPage();
		});
		
		//收费病人列表		
		ShouFeiBingRenTab = $.fn.bsgrid.init("BingRenTable", {
            url: "${ctx}/OuShouFeiController/ShouFeiBingRen.do",
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
                        	var rowIndex = ShouFeiBingRenTab.getSelectedRowIndex();
                        	if (rowIndex > -1) {
                                var OuhosinfoId  = record.ouhosinfoId; //获取传过来的ID                                
                                $.getJSON("${ctx}/OuShouFeiController/HuiTianXinXi.do?ouhosinfoIdCS="+OuhosinfoId, function (data) {                                                                              
                                    $("#ouhosinfoId").val(data.ouhosinfoId);//隐藏域
                                    $("#mzregno").val(data.mzregno);
                                    $("#patientname").val(data.patientname);
                                    $("#cardno").val(data.cardno);
                                    $("#socialsecurityno").val(data.socialsecurityno);
                                    $("#username").val(data.username);
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
         
        //调出收费药品信息
        function btnStockdetailId(){
        	$("#modalTable").modal('show');
			YaoPinTable.refreshPage();        
        }
		
		//收费药品信息列表		
		YaoPinTable = $.fn.bsgrid.init("YaoPinTable", {
            url: "${ctx}/OuShouFeiController/ShouFeiYaoPin.do",
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
                        	var rowIndex = YaoPinTable.getSelectedRowIndex();
                        	if (rowIndex > -1) {
                                var StockdetailId  = record.stockdetailId; //获取传过来的ID                                
                                $.getJSON("${ctx}/OuShouFeiController/HuiTianYaoPinXinXi.do?stockdetailId="+StockdetailId, function (data) {                                                                              
                                    $("#stockdetailId").val(data.stockdetailId);//隐藏域
                                    $("#drugname").val(data.drugname);
                                    $("#basedetailname").val(data.basedetailname);
                                    $("#price").val(data.price);
                                    $("#modalTable").modal('hide'); //选择后自动关闭
                              });
                           }
                           else {
                               layer.alert('你没有选择信息！', { icon: 2, title: '提示' });
                           }
                        }
                    }
                }  
         });
       
        //页面关闭按钮
		function btnTuiChu(){
        	$("#ShouFeiJieMian").hide();
        }
    
    </script>
	      
	<script type="text/javascript">
		
		 var ShuZu =[]; //定义数据
		 var j=1; //定义表格行号
		 var zongjia =0; 
		 
		function funJiSuan(){					
		   //获取单价
		   var  price =document.getElementById("price").value;		   
		   //获得数量
		   var  amount =document.getElementById("amount").value;	
		   //优惠金额
		   var  discount =document.getElementById("discount").value;   
		   //单价  * 数量  - 优惠金额
		   return parseInt(amount)*parseFloat(price)-parseFloat(discount);		   
		}
        
        //以单价和数量计算项目金额
	    function funChengFa(strs){	    
		   //获得值
		   var str = strs.value;	   
		   //获得价格
		   var  price = str.split("_")[1];
		   //根据ID查询费用
		   document.getElementById("price").value=price;		   
		   //注意：获得数量
		   var  count =  document.getElementById("amount").value;
		   //如果数量不为空，则可以计算金额    
		   if(count!=""){
			   document.getElementById("itemmoney").value= parseInt(count)*parseFloat(price);
		   }		
		}
		
		function funChengFa2(num){
		   //获得数量值
		   var str = num.value;
		   //获得价格
		   var  price =document.getElementById("price").value;	   
		   //计算
		   document.getElementById("itemmoney").value= parseInt(str)*parseFloat(price);	
		} 
		
		//计算找回金额
		function jian(){
			//获取减数
			var paymentmoney=document.getElementById('paymentmoney').value;
			//获取被减数
			var receivablemoney=document.getElementById('receivablemoney').value;
			//根据ID查询计算结果并输出
			var ZhaoHuiJinE=document.getElementById('GoodsCode');
				ZhaoHuiJinE.value=Number(paymentmoney)-Number(receivablemoney);
		}		
		
		//应收金额
		function jianshu(){
			//获取减数
			var itemmoney=document.getElementById('itemmoney').value;
			//获取被减数
			var discount=document.getElementById('discount').value;
			//根据ID查询计算结果并输出
			var ZhaoHuiJinE=document.getElementById('receivablemoney');
			ZhaoHuiJinE.value=Number(itemmoney)-Number(discount);		
		}	   
		 
		 
		//添加收费明细信息到对于表格
		function addRow() {
					
			var amount=$("#amount").val();
			var itemmoney=$("#itemmoney").val();
			var discount=$("#discount").val();
			var frequency=$("#frequency").val();
			var coefficient=$("#coefficient").val();
			
			if(mzregno!=null && mzregno!="" > 0 && drugname!=null && drugname!="" && amount!=null && amount!=""
			  && itemmoney!=null && itemmoney!="" && discount!=null && discount!="" && frequency!=null
			  && frequency!="" && coefficient!=null && coefficient!=""){
				//获取表格对象
				var table1=$("#ShouFeiTab");
				//创建新的一行
				var tr=$('<tr></tr>');
				tr.append('<td style="background-color:#ffff;">'+j+++'</td>');		
				tr.append('<td style="background-color:#ffff;">'+'<input type="checkbox" name="cb1"> ' +'</td>');								
				tr.append('<td style="background-color:#ffff;" hidden>'+$("#chargingitemdetailid").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#drugname").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#basedetailname").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#price").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#amount").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#itemmoney").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#discount").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#frequency").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#coefficient").val()+'</td>');				
				table1.append(tr);　//将文本框信息加进表格
				
				ShuZu.push(				
				$("#stockdetailId").val()+"SS"+				
				$("#amount").val()+"SS"+
				$("#itemmoney").val()+"SS"+
				$("#discount").val()+"SS"+
				$("#frequency").val()+"SS"+
				$("#coefficient").val()+"SS");
				
				//计算总金额
				zongjia+=funJiSuan();				 
		        document.getElementById("receivablemoney").value=zongjia;
		
			}
			else{		
				layer.alert("请先填写要收费的药品信息" ,{icon:0,title:'提示'});		
			}
		
		}
		
		//删除表格行
		function btnDelete() { 
			var checks = document.getElementsByName("cb1"); 
			
			var tbBody = document.getElementById("ShouFeiTab");
			
			for (var i=0; i<checks.length; i++) { 
				if (checks[i].checked) { 
					tbBody.deleteRow(i); 
					btnDelete();
				}  
			}
			
		} 
				
		//保存收费项目信息  
	    function BaoCun() {
	     		     	
			var prescriptioncode=$("#prescriptioncode").val();
			var ouhosinfoId=$("#ouhosinfoId").val();
			var receivablemoney=$("#receivablemoney").val();
			var paymentmoney=$("#paymentmoney").val();
			var userId=$("#userId").val();
			var chargingtime=$("#chargingtime").val();
			
			var a = "";		
			if(ouhosinfoId >0 && paymentmoney !=null && paymentmoney !=""){
				$.ajax({			
				async : false,
				cache : false,
				contentType : 'application/json',  
				dataType : "json",
				url : "${ctx}/OuShouFeiController/PayService.do?suzu="+ShuZu+"&ouhosinfoId="+ouhosinfoId
				+"&prescriptioncode="+prescriptioncode+"&receivablemoney="+receivablemoney
				+"&paymentmoney="+paymentmoney+"&userId="+userId+"&chargingtime="+chargingtime,
				type : 'POST',			
				error : function() {
					layer.alert('获取失败', { icon: 2, title: '提示' });
					frameElement.api.close();
				  },
				success : function() {
					layer.alert('收费成功', { icon: 1, title: '提示' });
					setTimeout('TiaoZhuan()', 2000);//延迟2秒
				  }
				});
			}
			else{
				layer.alert('请先填写完病人信息', { icon: 2, title: '提示' });
			}
		
		}
		
		// 延迟跳转 
		function TiaoZhuan(){
			window.location.href="${ctx}/OuShouFeiController/ShouFei.do";
		}		
	
	</script>
    
    
  </body>
</html>
