package com.qx.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * excel导出处理
 * 
 */
public class ExportExcel {
	/**
	 * 生成excel表格并输出
	 */
	public static void outFile(HttpServletResponse response, List<?> data, String fileName) {
		// 创建workbook(工作簿)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建名称为‘sheel’的表(工作表)
		Sheet sheet = wb.createSheet("sheel");
		// 创建Excel中索引中为0的行(标题行)
		Row row = sheet.createRow(0);
		// 设置单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		// 单元格居中样式
		style.setAlignment(HorizontalAlignment.CENTER);
		// 获取传递的数据
		Field[] fields = data.get(0).getClass().getDeclaredFields();
		// 创建单元格的索引值
		int index = 0;
		// 创建单元格的名称
		String name = "";
		
		// 遍历标题名称添加到Excel表头
		for(Field f:fields){
			// 判断接口描述注释是否存在
			if(f.isAnnotationPresent(MyInterface.class)){
				// 获取接口描述注释的值
				MyInterface a = f.getAnnotation(MyInterface.class);
				// 获取注释的索引值
				index = a.columnIndex();
				// 获取注释的名称
				name = a.columnName();
				// 创建Excel的单元格
				creCell(row, index, name, style);
			}
		}
		
		// 创建行的索引值
		int rowIndex = 1;
		// 遍历数据添加到Excel
		for(Object obj:data){
			// 创建行
			row = sheet.createRow(rowIndex++);
			// 遍历数据行的字段添加到单元格中
			for(Field f:fields){
				f.setAccessible(true);
				// 判断接口描述注释是否存在
				if(f.isAnnotationPresent(MyInterface.class)){
					// 获取接口描述注释的值
					MyInterface a = f.getAnnotation(MyInterface.class);
					// 获取注释的索引值
					index = a.columnIndex();
					try {
						//创建单元格并设置单元格的值
						creCell(row, index, String.valueOf(f.get(obj)), style);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		// 定义一个输出流
		OutputStream outputStream = null;
		try {
			// 获取一个response的输出流
			outputStream = response.getOutputStream();
			// 获取导出文件名称
			String Name = fileName + getTimeStamp() + ".xls";
			
			// application/x-msdownload-告诉浏览器这是一个要保存到本地的下载的文件
			// application/octet-stream-任意的字节流,会强制浏览器打开save as对话框(下载提示框)来保存文件
			// 提示浏览器下载文件
			response.setContentType("application/x-msdownload");
			
			// 设置输出文件的名称-可以输出中文名称文件(URLEncoder.encode(Name, "UTF-8"))
			response.setHeader("Content-Disposition", "attachment; filename="  
                    + URLEncoder.encode(Name, "UTF-8"));
			
			// 把工作簿内容写入文件输出流中
			wb.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 判断工作簿是否存在,如果存在则关闭
				if (wb != null) {
					try {
						wb.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				// 判断流是否为空,不为空则关闭
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 创建单元格
	 * 
	 * @param row
	 * @param c
	 * @param cellValue
	 * @param style
	 */
	private static void creCell(Row row, int c, String cellValue, CellStyle style) {
		// 创建单元格
		Cell cell = row.createCell(c);
		// 设置单元格的值
		cell.setCellValue(cellValue);
		// 设置单元格样式
		cell.setCellStyle(style);
	}
	
	/**
	 * 获取当前日期时间
	 * @return
	 */
	public static String getTimeStamp() {
		// 获取当前日期时间
		Date date = new Date();
		// 把获取的日期时间转换成字符串格式化日期时间
		String str = new SimpleDateFormat("yyyy-MM-dd-hh-MM-ss-SSSS").format(date);
		// 返回字符串类型日期时间
		return str;
	}
	
	
	
	
	
	
}
