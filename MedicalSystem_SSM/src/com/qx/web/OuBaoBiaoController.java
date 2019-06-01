package com.qx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.po.Basedetail;
import com.qx.po.Chargingitemsdetail;
import com.qx.po.Users;
import com.qx.service.ChargingitemsService;
import com.qx.service.UserService;
import com.qx.util.Tools;
import com.qx.vo.Bsgrid;

@Controller
@RequestMapping("/OuBaoBiaoController")
public class OuBaoBiaoController {
	
	//用户信息
	@Autowired
	private UserService userService;
	
	//收费项目信息
	@Autowired
	private ChargingitemsService chargingitemsService;
	
	 /*
     * 查询报表统计
     */
    @RequestMapping("/BaoBiao")
	public String BaoBiao(HttpServletRequest request){
								
    	//回签情况
    	List<Basedetail> BasedetailList = userService.findByBaseId(18);
    	request.setAttribute("BasedetailList", BasedetailList);
    			
    	//交费情况
    	List<Basedetail> BasedetailListt = userService.findByBaseId1(19);
    	request.setAttribute("BasedetailListt", BasedetailListt);
    	    	
    	//收费医生
    	List<Users> UsersList = userService.findByDoctor(3,4,5);
    	request.setAttribute("UsersList", UsersList);
    	
    	//收费科室
    	List<Basedetail> BasedetailListtt = userService.findByBaseId2(4);
    	request.setAttribute("BasedetailListtt", BasedetailListtt);
    	
		return "/MenZhen/BaoBiao";
		
	}
    
    /*
     * 查询综合统计报表
     */
    @ResponseBody
    @RequestMapping(value="/ChaXunQiTaTongJi",produces="application/json;charset=UTF-8")
    public String ChaXunQiTaTongJi(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
		
		String drugname=request.getParameter("drugname");
		String userId =request.getParameter("userId");
		String basedetailId =request.getParameter("basedetailId");
		
		String listt ="";		
		if((drugname !=null && drugname !="") || userId !=null || basedetailId !=null){
			
			int struserId=Integer.parseInt(userId);
			int strbasedetailId=Integer.parseInt(basedetailId);
			
			//分页
			Bsgrid<Chargingitemsdetail> bsgrid = new Bsgrid<Chargingitemsdetail>();
			
			if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
				
				int pageSize = Integer.parseInt(strpageSize);
				int curPage = Integer.parseInt(strcurPage);
				int startIndex = (curPage - 1) * pageSize;
				
				//模糊查询
				if((drugname !=null && drugname !="") && struserId >0 && strbasedetailId >0){						
					listt="(drug.drugname like '%"+drugname+"%')" 
					+ " AND  users.User_ID=" + struserId + " AND  basedetail.BaseDetail_ID = "+strbasedetailId;					
				}
				if((drugname !=null && drugname !="") ){
					listt="(drug.drugname like '%"+drugname+"%')";
				}
				if(struserId >0){
					listt="users.User_ID=" + struserId;
				}
				if(strbasedetailId >0){
					listt="basedetail.BaseDetail_ID=" + strbasedetailId;
				}		
				if(drugname =="" && struserId ==0 && strbasedetailId == 0){
					listt="1=1";
				}
				else{
					listt="1=1";
				}
				
				List<Chargingitemsdetail> list =chargingitemsService.findQiTaTongJi(listt, startIndex, pageSize);
				int totalRows = chargingitemsService.getQiTaTongJiRow(listt);

				bsgrid.setCurPage(curPage);
				bsgrid.setTotalRows(totalRows);
				bsgrid.setSuccess(true);
				bsgrid.setData(list);
				
			} else {
				bsgrid.setSuccess(false);
			}
			
			return JSONSerializer.toJSON(bsgrid).toString();
			
		}
		else {
			//分页
			Bsgrid<Chargingitemsdetail> bsgrid = new Bsgrid<Chargingitemsdetail>();
			
			if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
				
				int pageSize = Integer.parseInt(strpageSize);
				int curPage = Integer.parseInt(strcurPage);
				int startIndex = (curPage - 1) * pageSize;
				
				List<Chargingitemsdetail> list =chargingitemsService.findQiTaTongJi("1=1", startIndex, pageSize);
				int totalRows = chargingitemsService.getQiTaTongJiRow("1=1");

				bsgrid.setCurPage(curPage);
				bsgrid.setTotalRows(totalRows);
				bsgrid.setSuccess(true);
				bsgrid.setData(list);
				
			} else {
				bsgrid.setSuccess(false);
			}
			
			return JSONSerializer.toJSON(bsgrid).toString();
		}		
    	
    }

    
    

}
