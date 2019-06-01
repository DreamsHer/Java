package com.qx.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qx.po.Chargingitemsdetail;
import com.qx.service.ChargingitemsService;
import com.qx.util.Tools;
import com.qx.vo.Bsgrid;

@Controller
@RequestMapping("/OuTuiKuanController")
public class OuTuiKuanController {
	
	//收费项目
	@Autowired
	private ChargingitemsService chargingitemsService;
	
	/*
	 *  发票重打，退药，退款
	 */
    @RequestMapping("/TuiKuan")
	public String TuiKuan(HttpServletRequest request){				
				
		return "/MenZhen/TuiKuan";
		
	}
    
    /*
     * 查询已收费的退款退药重打信息
     */
    @ResponseBody
    @RequestMapping(value="/ChaXunTuiKuanTuiYao",produces="application/json;charset=UTF-8")
    public String ChaXunTuiKuanTuiYao(HttpServletRequest request){
    	    	    	
    	String strpageSize = request.getParameter("pageSize");
		String strcurPage = request.getParameter("curPage");
		
		String prescriptioncode=request.getParameter("prescriptioncode");
				
		//分页
		Bsgrid<Chargingitemsdetail> bsgrid = new Bsgrid<Chargingitemsdetail>();
		
		if (Tools.isNum(strpageSize) && Tools.isNum(strcurPage)) {
			
			int pageSize = Integer.parseInt(strpageSize);
			int curPage = Integer.parseInt(strcurPage);
			int startIndex = (curPage - 1) * pageSize;
			
			//模糊查询
			String listt ="";			
			if(prescriptioncode !=null){				
				listt="(chargingitems.prescriptioncode like '%"+prescriptioncode+"%')";				
			}else{
				listt="1=1";
			}
			
			List<Chargingitemsdetail> list =chargingitemsService.findPageTuiKuan(listt, startIndex, pageSize);
			int totalRows = chargingitemsService.getTotalRow(listt);

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
