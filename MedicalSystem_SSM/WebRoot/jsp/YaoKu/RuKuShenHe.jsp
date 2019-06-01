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
    <title>药品入库—审核</title>    
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
	<div class="container-fluid" id="RuKuJieMian">
        <div class="panel panel-primary" style="width:100%;min-height:88%;">
            <div class="panel-heading">
                <h1 class="panel-title">药品入库—审核</h1>
            </div>
			<div class="panel-body">
				<form class="form-horizontal" id="formInsert" action="" method="post">				
				   <div class="form-group" style="margin-top:20px;">
						<input type="text" class="hidden" name="stockdetailId" id="stockdetailId"/>
						<div class="col-sm-1">
							<button type="button" onclick="btnCiaGou()" style="margin-left:18px;"
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-zoom-out"></span>&nbsp;选择</button>
						</div>														
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="stockcode" id="stockcode" readonly>									
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">药品名称</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="drugname" id="drugname" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">规格型号</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="spec" id="spec" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">供货单位</label>						
						<div class="col-md-2 col-sm-1 reset" >
							<input type="text" class="form-control" name="companyname" id="companyname" readonly>
						</div>
					</div>					
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 control-label reset">散量单价</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="" id="" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">散量数量</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="" id="" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">散量单位</label>
						<div class="col-md-2 col-sm-1 reset" >	
							<input type="text" class="form-control" name="basedetailname" id="basedetailname12" readonly>								
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">有效日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="effectivedates" id="effectivedates" readonly>
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">											
						<label class="col-md-1 col-sm-1 control-label reset">整量单价</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="price" id="price" readonly>							
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">整量数量</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="stocknum" id="stocknum" readonly>
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">整量单位</label>
						<div class="col-md-2 col-sm-1 reset" >							
							<input type="text" class="form-control" name="basedetailname" id="basedetailname13" readonly>			
						</div>	
						<label class="col-md-1 col-sm-1 control-label reset">责任系数</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="coefficient" id="coefficient" readonly>
						</div>		
					</div>
					<div class="form-group" style="margin-top:20px;">	
						<label class="col-md-1 col-sm-1 control-label reset">进库单号</label>															
						<div class="col-md-2 col-sm-1 reset">
							<input type="text" class="form-control" name="enterstockcode" id="enterstockcode" readonly>									
						</div>																	
						<label class="col-md-1 col-sm-1 control-label reset">进库日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="enterdate" id="enterdate">
						</div>
						<label class="col-md-1 col-sm-1 control-label reset">登记人员</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="djuserId" id="djuserId" class="form-control">
								<option value="0">--登记人员录入 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>	
						</div>                        
                        <label class="col-md-1 col-sm-1 control-label reset">是否审核</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="enterauditorbit" id="enterauditorbit" class="form-control">							
								<option value="False">否</option>
								<option value="True">是</option>
							</select>	
						</div>
					</div>
					<div class="form-group" style="margin-top:20px;">					
						<div class="col-sm-1 col-sm-offset-2">
							<button type="button" onclick="addRow()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus"></span>&nbsp;添加</button>
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="btnDelete()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-trash"></span>&nbsp;删除</button>
						</div>
						<div class="col-sm-1">  
							<button type="button" onclick="myrefresh()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-refresh"></span>&nbsp;重置</button>
						</div>
						<div class="col-sm-1">  
							<button type="button" onclick="btnInsert()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-plus-sign"></span>&nbsp;新增</button>
						</div>
						<div class="col-sm-1">
							<button type="button" onclick="btnShenHe()" 
								class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-ok"></span>&nbsp;审核</button>
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
							<button type="button" onclick="btnTuiChu()" class="btn btn-primary btn-block btn-radius">
								<span class="glyphicon glyphicon-repeat"></span>&nbsp;退出</button>
						</div>
					</div>				
					<div class="tab-pane" style="background-color:#FFFFFF;height:280px;"> 
						<table id="RuKuTab" style="width:100%;text-align:center;border-color:#99bce8;" border="solid 1px #ccc;">
							<tr id="tr0" style="line-height:1.8em;background-color:#CCCCFF;border-color:#99bce8;">
								<th w_num="total_line" style="text-align:center;">序号</th>
								<th style="text-align:center;"><input type="checkbox" name="cb1" id="CheckboxId" value="false"></th>								
								<th w_index="stockdetailId" hidden style="text-align:center;"></th>								
								<th w_index="stockcode" style="text-align:center;">采购单号</th>
								<th w_index="companyname" style="text-align:center;">供货单位</th>
								<th w_index="drugname" style="text-align:center;">药品名称</th>
								<th w_index="spec" style="text-align:center;">规格型号</th>
								<th w_index="stocknum" style="text-align:center;">数量</th>
								<th w_index="price" style="text-align:center;">单价</th>
								<th w_index="basedetailname" style="text-align:center;">单位</th>
								<th w_index="effectivedates" style="text-align:center;">有效日期</th>
								<th w_index="coefficient" style="text-align:center;">责任系数</th>
							</tr>
						</table>
					</div>				
				</form>
			</div>
        </div>       
    </div>
    
    <!-- 请购单入库信息窗体  -->
    <div class="modal" id="modalId">
        <div class="modal-dialog" style="width:1050px;">
            <div class="modal-header" style="background:#377ab7">
                <span>请购单入库信息窗体</span>
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
    
    <!-- 入库单审核窗体 -->
    <div class="modal" id="ShenHeId">
        <div class="modal-dialog" style="width:1200px;">
            <div class="modal-header" style="background:#377ab7;">
                <span>入库单审核</span>
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            </div>
            <div class="modal-body" style="background:#FFFFFF;height:445px;">            	
            	<form class="form-horizontal" id="formInsert" action="" method="post">
					<div class="form-group">
						<label class="col-md-1 col-sm-1 col-sm-offset-2 control-label reset">入库日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="enterdate" id="enterdate">
						</div>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="enterdate" id="enterdate">
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary btn-block btn-radius" id="">查询</button>
						</div>
					</div>
					<div class="tab-pane">
						<table id="ShenHeTable" style="width:100%;">
							<tr>					
								<th w_check="true"></th>
								<th w_index="enterstockdetailId" w_hidden="true"></th>
								<th w_index="enterstockcode">入库单号</th>
								<th w_index="enterdates">入库时间</th>
								<th w_index="companyname">供货单位</th>
								<th w_index="drugname">商品名称</th>
								<th w_index="stocknum">入库数量</th>
								<th w_index="username">登记人</th>
								<th w_render="ShenHeFou">审核否</th>
                        		<th w_index="enterauditorbit" w_hidden="true">审核否</th>								
							</tr>
						</table>
					</div>				
					<div class="form-group" style="margin-top:20px;">
						<label class="col-md-1 col-sm-1 control-label reset">是否审核</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="enterauditorbit" id="enterauditorbit" class="form-control">
								<option value="True">是</option>						
								<option value="False">否</option>
							</select>	
						</div>	
						<label class="col-md-1 col-sm-1 control-label reset">审核人</label>
						<div class="col-md-2 col-sm-1 reset">
							<select name="djuserId" id="djuserId" class="form-control">
								<option value="0">--选择审核人 --</option>
								<c:forEach items="${UsersList}" var="p">
									<option value="${p.userId}">${p.username}</option>
								</c:forEach>
							</select>	
						</div>        															
						<label class="col-md-1 col-sm-1 control-label reset">审核日期</label>
						<div class="col-md-2 col-sm-1 reset">
							<input type="date" class="form-control" name="enterdate" id="enterdate">
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary btn-block btn-radius">审核</button>
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-primary btn-block btn-radius" data-dismiss="modal">退出</button>
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
	
	<!-- 查询请购单入库信息 -->
	<script type="text/javascript">
		
		var CaiGouXinXiTable;		  
    	function btnCiaGou(){
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
         
        //刷新页面 
        function myrefresh(){
   			window.location.reload();
		}
         
        //页面关闭按钮
		function btnTuiChu(){
        	$("#RuKuJieMian").hide();
        }
	
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
				url : "${ctx}/YkRuKuController/getEnterstockcode.do",
				error : function() {
					alert('获取失败');
					frameElement.api.close();
				},
				success : function(data) {
					a = data.msg;
				}
			});
			$("#enterstockcode").val(a);  
    	}
	
	</script>      
	 
	<!-- 新增药品入库信息 -->     	     	     	      	     	     	      	     	      
    <script type="text/javascript">
      		
    	var ShuZu =[]; //定义数据
		var j=1; //定义表格行号
    	
    	//添加收费明细信息到对于表格
		function addRow() {
		
			var stockcode=$("#stockcode").val();
			var companyname=$("#companyname").val();
			var drugname=$("#drugname").val();
			var spec=$("#spec").val();
			var stocknum=$("#stocknum").val();
			var price=$("#price").val();
			var basedetailname=$("#basedetailname12").val();
			var effectivedates=$("#effectivedates").val();
			var coefficient=$("#coefficient").val();
			
			if(stockcode!=null && stockcode!=""){
				//获取表格对象
				var table1=$("#RuKuTab");
				//创建新的一行
				var tr=$('<tr></tr>');
				tr.append('<td style="background-color:#ffff;">'+j+++'</td>');		
				tr.append('<td style="background-color:#ffff;">'+'<input type="checkbox" name="cb1" class="CheckboxId" id="CheckboxId" value="false"> ' +'</td>');								
				tr.append('<td style="background-color:#ffff;" hidden>'+$("#stockdetailId").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#stockcode").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#companyname").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#drugname").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#spec").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#stocknum").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#price").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#basedetailname12").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#effectivedates").val()+'</td>');
				tr.append('<td style="background-color:#ffff;">'+$("#coefficient").val()+'</td>');				
				table1.append(tr);　//将文本框信息加进表格
				
				ShuZu.push($("#stockdetailId").val()+"SS");
		
			}
			else{		
				layer.alert("请先填写要请购的药品信息" ,{icon:0,title:'提示'});		
			}
		
		}
		
		//保存  
	    function btnInsert() {	     		     				
			var enterstockcode=$("#enterstockcode").val();
			var enterdate=$("#enterdate").val();			
			var djuserId=$("#djuserId").val();
			var enterauditorbit=$("#enterauditorbit").val();				
			
			var a = "";		
			if(enterstockcode !=null && enterstockcode !="" && enterdate !=null && enterdate !=""
			&& djuserId !=null && djuserId !=""){
				$.ajax({			
				async : false,
				cache : false,
				contentType : 'application/json',  
				dataType : "json",
				url : "${ctx}/YkRuKuController/AllStockdetail.do?suzu="+ShuZu+"&enterstockcode="+enterstockcode
				+"&enterdate="+enterdate+"&djuserId="+djuserId+"&enterauditorbit="+enterauditorbit,
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
				layer.alert('请先填写完入库信息', { icon: 0, title: '提示' });
			}
		
		}
		
		// 延迟跳转 
		function TiaoZhuan(){
			window.location.href="${ctx}/YkRuKuController/RuKuShenHe.do";
		}
		
		//删除表格行
		function btnDelete() { 
		
			var checks = document.getElementsByName("cb1");
			
			var tbBody = document.getElementById("RuKuTab");			
				
			var avv=0;
			
			for (var i=0; i<checks.length; i++) { 
				if (checks[i].checked) { 
					avv++;
				}  
				else{
					//alert(avv);
				}
			}
			
			if(avv !=0 ){
				
				for (var i=0; i<checks.length; i++){
					if (checks[i].checked) { 
						tbBody.deleteRow(i); 
						btnDelete();
					}					
				}
				
			}
			
			else{				
				layer.alert("请先选择你要删除的信息" ,{icon:2,title:'提示'});				
			}
			
		} 
    	
    
    </script>
    
    <!-- 入库审核 -->
    <script type="text/javascript">
    	
    	var ShenHeTable;
    	
    	//将true和false转换成审核否
        function ShenHeFou(record, rowIndex, colIndex, options) {
            var toVoidNow = ShenHeTable.getRecordIndexValue(record, "enterauditorbit");
            toVoidNow = record.enterauditorbit;
            if (toVoidNow == true || toVoidNow == "true") {
                return '<span style="color:#000000">已审核</span>';
            } else {
                return '<span style="color:red">未审核</span>';
            }
        }
    	
    	//点击审核按钮跳转
    	function btnShenHe(){
         	$("#ShenHeId").modal('show');
         	ShenHeTable.refreshPage();
         }
         
         //修改审核
         ShenHeTable = $.fn.bsgrid.init("ShenHeTable", {
            url: "${ctx}/YkRuKuController/JinKuShenHe.do",
            autoLoad: false,
            stripeRows: true,//隔行变色
            rowHoverColor: true,//划过行变色
            pageSize: 8,
            pageAll: false,
            pageSizeSelect: false,//是否选择分页页数下拉框
            pagingLittleToolbar: true,//精简的图标按钮分页工具条
            pagingToolbarAlign: "left",//分页工具条的显示位置 
         });
         
       /*  Connection conn = DBUtil.getConnection();//获取数据库链接
        PreparedStatement stat = conn.prepareStatement("insert into T_TE_WWW_MANBA (id,name,age) values(?,?,?)");//定义sql语句。
        BasketBollPlayer player = null;
        for(int i=1;i<100000;i++)
        {
            player = new BasketBollPlayer(new Integer(i),"kebi"+i,"age"+1);
            stat.setInt(1, player.getId());
            stat.setString(2, player.getName());
            stat.setString(3, player.getAge());
            stat.addBatch();
            if(i%500==0)//500提交一次，避免数据量太大内存溢出。
            {
                int[] flag = stat.executeBatch();/提交
                stat.clearBatch();//清除。
                System.out.println(flag+"i");
            }
        }
        stat.executeBatch();//提交  */
         
         
    
    </script>
    
  </body>
</html>
