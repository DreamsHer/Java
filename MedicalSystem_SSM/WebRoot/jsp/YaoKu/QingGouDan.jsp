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
    <title>库房—请购单录入</title>    
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
	<div class="container-fluid" id="YaoPinLuRuJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
            <div class="panel-heading">
                <h1 class="panel-title">库房—请购单录入</h1>
            </div>
			<div class="panel-body">
				<form class="form-horizontal" id="formInsert" action="" method="post">
					
					<div class="form-group" style="margin-top:20px;">
						<input type="text" class="hidden" name="stockdetailId" id="stockdetailId"/>
						<input type="text" class="hidden" name="drugId" id="drugId"/>
						<div class="col-sm-1 col-sm-offset-1">
							<button type="button" onclick="btnYaoPin()" class="btn btn-primary btn-block btn-radius"
							 style="margin-left:18px;"><span class="glyphicon glyphicon-zoom-out"></span>&nbsp;药品</button>
						</div>														
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="drugname" id="drugname" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">药品单位</label>						
						<div class="col-md-2 col-sm-1 reset" >	
							<input type="text" class="form-control" name="basedetailname2" id="basedetailname2" readonly>
						</div>
						<label class="col-md-1 col-sm-1  control-label reset">进货单价</label>					
						<div class="col-md-2 col-sm-1 reset" >
							<input type="text" class="form-control" name="price" id="price"  readonly>									
						</div>
						<div class="col-sm-1"> 
							<button type="button" onclick="btnDrug()" class="btn btn-primary btn-block btn-radius">
							<span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">	
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">药品分类</label>						
						<div class="col-md-2 col-sm-1 reset" >
							<input type="text" class="form-control" name="basedetailname1" id="basedetailname1" readonly>									
						</div>					
						<label class="col-md-1 col-sm-1 control-label reset">换算系数</label>															
						<div class="col-md-2 col-sm-1 reset" >
							<input type="text" class="form-control" name="coefficient" id="coefficient" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">请购数量</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="stocknum" id="stocknum" 
								maxlength="8" onkeyup="value=value.replace(/\D/g,'')">									
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="btnDelete()" class="btn btn-primary btn-block btn-radius">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</button>
						</div>
					</div>
					
					<div class="tab-pane" style="margin-left:140px;"> 	
						<div style="width:91%;background-color:#FFFFFF;height:260px;">
							<table id="ShouFeiTab" style="width:100%;text-align:center;border-color:#99bce8;" border="solid 1px #ccc;">
								<tr id="tr0" style="line-height:1.8em;background-color:#CCCCFF;border-color:#99bce8;">
								<th w_num="total_line" style="text-align:center;">序号</th>
								<th style="text-align:center;"><input type="checkbox" name="cb1" ></th>
								<th w_index="stockdetailId" hidden style="text-align:center;"></th>
								<th w_index="drugId" hidden style="text-align:center;"></th>
								<th w_index="drugname" width="20%" style="text-align:center;">药品名称</th>
								<th w_index="basedetailname2" style="text-align:center;">药品单位</th>
								<th w_index="price" style="text-align:center;">药品单价</th>
								<th w_index="basedetailname1" style="text-align:center;">药品分类</th>
								<th w_index="coefficient" style="text-align:center;">换算系数</th>
								<th w_index="stocknum" style="text-align:center;">请购数量</th>
								</tr>
							</table>
						</div>
					</div>
					
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">请购单号</label>
						<div class="col-md-3 col-sm-1 reset">
							<input type="text" class="form-control" name="stockcode" id="stockcode" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">申请日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="applytime" id="applytime">							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">到货日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="arrivaltime" id="arrivaltime">
						</div>
					</div>
					
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">供货单位</label>
						<div class="col-md-3 col-sm-1 reset">
							<select name="companyId" id="companyId" class="form-control">
								<option value="0">--输入供货商名称 --</option>
								<c:forEach items="${CompanyList}" var="p">
									<option value="${p.companyId}">${p.companyname}</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">采购种数</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="drugspecies" id="drugspecies" 
								maxlength="3" onkeyup="value=value.replace(/\D/g,'')">							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">采购金额</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type=""text class="form-control" name="PurchaseMoney" id="PurchaseMoney" readonly>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">						
						<label class="col-md-1 col-sm-1 col-sm-offset-1 control-label reset">采购人员</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="userId" id="userId" class="form-control">
								<option value="0">--输入采购人员 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">登记时间</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="stocktime" id="stocktime" >
						</div>
						
						<div class="col-sm-1"> 
							<button type="button" onclick="btnInsert()" class="btn btn-primary btn-block btn-radius">
							<span class="glyphicon glyphicon-ok"></span>&nbsp;保存</button>
						</div>
						<div class="col-sm-1">  
							<button type="button" onclick="myrefresh()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-refresh"></span>&nbsp;重置</button>
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
       
    <!-- 药品录入窗体  -->
    <div class="modal" id="modalId">
        <div class="modal-dialog" style="width:800px;">
            <div class="modal-header" style="background:#377ab7">
                <span>药品录入窗体</span>
                <button type="button" class="close" data-dismiss="modal">
                	<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:320px;">
				<div class="tab-pane">
					<table id="YaoPinTable" style="width:100%;">
						<tr>
							<th w_num="total_line">序号</th>
							<th w_index="drugId" w_hidden="true"></th>
							<th w_index="drugname">药品名称</th>
							<th w_index="dwbasedetailId" w_hidden="true"></th>
							<th w_index="basedetailname2">药品单位</th>
							<th w_index="price">药品单价</th>
							<th w_index="flbasedetailId" w_hidden="true"></th>
							<th w_index="basedetailname1">药品分类</th>
							<th w_index="coefficient">换算系数</th>
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
	
		var ShuZu =[]; //定义数据
		var j=1; //定义表格行号
		var zongjia=0; //计算总金额
		
		function funJiSuan(){					
		   //获取单价
		   var  price =document.getElementById("price").value;		   
		   //获得数量
		   var  stocknum =document.getElementById("stocknum").value;	   
		   //单价  * 数量
		   return parseInt(stocknum)*parseFloat(price);
		}
		 
		//添加收费明细信息到对于表格
		function btnDrug() {
		
			var drugname=$("#drugname").val();
			var basedetailname2=$("#basedetailname2").val();
			var price=$("#price").val();
			var basedetailname1=$("#basedetailname1").val();
			var coefficient=$("#coefficient").val();
			var stocknum=$("#stocknum").val();
			
			if(stocknum!=null && stocknum!=""){
				//获取表格对象
				var table1=$("#ShouFeiTab");
				//创建新的一行
				var tr=$('<tr></tr>');
				tr.append('<td style="background-color:#ffff;">'+j+++'</td>');		
				tr.append('<td style="background-color:#ffff;">'+'<input type="checkbox" name="cb1"> ' +'</td>');								
				tr.append('<td style="background-color:#ffff;" hidden>'+$("#stockdetailId").val()+'</td>');				
				tr.append('<td style="background-color:#ffff;" hidden>'+$("#drugId").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#drugname").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#basedetailname2").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#price").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#basedetailname1").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#coefficient").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#stocknum").val()+'</td>');			
				table1.append(tr);　//将文本框信息加进表格
				
				ShuZu.push(
				$("#drugId").val()+"SS"+
				$("#stocknum").val()+"SS");	
				
				//计算总金额
				zongjia+=funJiSuan();				 
		        document.getElementById("PurchaseMoney").value=zongjia;
			}
			else{		
				layer.alert("请先填写药品信息和进货数量" ,{icon:0,title:'提示'});		
			}
		
		}
				
		//保存收费项目信息  
	    function btnInsert() {
	     		     				
			var stockcode=$("#stockcode").val();
			var companyId=$("#companyId").val();
			var applytime=$("#applytime").val();
			var arrivaltime=$("#arrivaltime").val();
			var drugspecies=$("#drugspecies").val();
			var userId=$("#userId").val();
			var stocktime=$("#stocktime").val();
			
			var a = "";		
			if(stockcode !=null && stockcode !="" && companyId >0 && drugspecies !=null && drugspecies !=""){
				$.ajax({			
				async : false,
				cache : false,
				contentType : 'application/json',  
				dataType : "json",
				url : "${ctx}/YkLuRuController/AllStockdetail.do?suzu="+ShuZu+"&stockcode="+stockcode
				+"&companyId="+companyId+"&applytime="+applytime+"&arrivaltime="+arrivaltime
				+"&drugspecies="+drugspecies+"&userId="+userId+"&stocktime="+stocktime,
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
				layer.alert('请先填写完进库信息', { icon: 0, title: '提示' });
			}
		
		}
		
		// 延迟跳转 
		function TiaoZhuan(){
			window.location.href="${ctx}/YkLuRuController/QingGouDan.do";
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
	
	</script>     
      
    <script type="text/javascript">
    
    	var YaoPinTable;
    	
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
				url : "${ctx}/YkLuRuController/getStockcode.do",
				error : function() {
					alert('获取失败');
					frameElement.api.close();
				},
				success : function(data) {
					a = data.msg;
				}
			});
			$("#stockcode").val(a);
    	}
    	
    	//点击药品名称事件   	
		function btnYaoPin(){
			$("#modalId").modal('show');
			YaoPinTable.refreshPage();
			
		}
		
		//药品录入列表		
		YaoPinTable = $.fn.bsgrid.init("YaoPinTable", {
            url: "${ctx}/YkLuRuController/YaoPinXinXi.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 8,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置 
            event: { //单击表格行回填病人信息
                   customRowEvents: {
                    	//(record行记录值,rowIndex行索引值,trObj:tr目标,options选择的东西)
                        click: function (record, rowIndex, trObj, options) {                        
                        	var rowIndex = YaoPinTable.getSelectedRowIndex();
                        	if (rowIndex > -1) {
                                var DrugId  = record.drugId; //获取传过来的ID                                
                                $.getJSON("${ctx}/YkLuRuController/HuiTianXinXi.do?drugID="+DrugId, function (data) {
                                    $("#drugId").val(data.drugId);//隐藏域
                                    $("#drugname").val(data.drugname);
                                    $("#basedetailname2").val(data.basedetailname2);
                                    $("#price").val(data.price);
                                    $("#basedetailname1").val(data.basedetailname1);
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
        
        //刷新页面 
        function myrefresh(){
   			window.location.reload();
		}
        
        //页面关闭按钮
		function btnTuiChu(){
        	$("#YaoPinLuRuJieMian").hide();
        }
    
    </script>   
    
  </body>
</html>
