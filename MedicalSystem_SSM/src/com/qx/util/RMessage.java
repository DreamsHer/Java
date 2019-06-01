package com.qx.util;

import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RMessage {

	/**
	 * 
	 * @param out
	 *            printWriter pw;
	 * @param object
	 *            返回提示
	 * @param list
	 *            返回列表
	 * @param Json
	 *            返回json数据
	 */
	@SuppressWarnings("rawtypes")
	public static void returnMessage(PrintWriter out, Object object, List list,
			String Json) {

		JSONObject jsonObject = null;
		JSONArray jsonArray = null;
		
		if (Tools.isNotNull(Json)) {
			jsonObject = JSONObject.fromObject(Json);
		} else if (object != null) {

			jsonObject = JSONObject.fromObject(object);
		} else {
			jsonArray = JSONArray.fromObject(list);

		}

		if (Tools.isNotNull(String.valueOf(jsonObject))) {

			out.write(String.valueOf(jsonObject));
		} else {
			out.write(jsonArray.toString());
		}

		out.close();

	}
}
