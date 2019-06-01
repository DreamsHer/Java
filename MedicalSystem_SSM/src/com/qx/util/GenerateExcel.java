package com.qx.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel处理(导出、导入)
 * 
 * 
 *
 */
public class GenerateExcel {
	
	/**
	 * 生成excel表格并输出
	 * 
	 * @param response 获取响应的数据
	 * @param data 获取输出的数据
	 * @param fileName 获取输出文件名称
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
		// 获取要导出的数据
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
						// 创建单元格并设置单元格的值
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
			
			// 设置输出文件的名称、编码格式-可以输出中文名称文件(URLEncoder.encode(Name, "UTF-8"))
			response.setHeader("Content-Disposition", "attachment; filename="  
                    + URLEncoder.encode(Name, "UTF-8"));
			
			// 把文件输出流内容写入工作簿中
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
	 * @param row 单元格行的索引
	 * @param c 单元格列的索引
	 * @param cellValue 单元格的值
	 * @param style 单元格样式
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
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		// 获取当前日期时间
		Date date = new Date();
		// 把获取的日期时间转换成字符串格式化日期时间
		String str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSSS").format(date);
		// 返回字符串类型日期时间
		return str;
	}
	
	
	
	// 定义获取总行数的全局变量
	public static int TotalRowNumber = 0;
	
	/**
	 * 输入读取excel文件
     * 并把读取到的数据封装到clazz中
     * 
     * @param path 文件路径
     * @param clazz 实体类
     * @return 返回clazz集合
     */
    public static <T extends Object> List<T> readExcelFile(String path, Class<T> clazz) {
    	// 创建一个数据类型为T的列表——存储excel数据
        List<T> list = new ArrayList<T>();
        // 创建文件输入流
        FileInputStream is = null;
        
        try {
        	// 获取上传文件Excel的输入流
            is = new FileInputStream(new File(path));
        } catch (FileNotFoundException e1) {
            throw new RuntimeException("文件路径异常");
        }
        
        // 创建工作簿变量
        Workbook wookbook = null;
        
        // 获取文件的后缀来判断excel文件版本获取工作簿
        if (path.endsWith(".xls")) {
            wookbook = xls(is);
        } else if (path.endsWith(".xlsx")) {
            wookbook = xlsx(is);
        } else {
            throw new RuntimeException("文件出错，非excel文件");
        }
        
        // 获取工作簿第一个工作表(索引为0)
        Sheet sheet = wookbook.getSheetAt(0);
        // 获取工作表的总行数
        int rows = sheet.getLastRowNum();
        // 获取数据总行数
        TotalRowNumber = rows;
        // 获取po实体类所有属性(就是所有定义的字段/包括扩展字段)
        Field[] fields = clazz.getDeclaredFields();
        
        // 定义行变量
        Row row;
        // T类型继承Object(这里是定义一个继承Object类型的变量)
        T obj = null;
    	// 定义列的索引变量
        int coumnIndex = 0;
        // 定义单元格变量
        Cell cell = null;
        // 定义接口变量
        MyInterface myAnnotation = null;
        // 循环总行数
        for (int i = 1; i < rows + 1; i++) {
            // 获取excel行
            row = sheet.getRow(i);
            try {
                // 创建po实体类
                obj = clazz.newInstance();
                for (Field field : fields) {
                    // 设置属性可访问
                	field.setAccessible(true);
                	// 判断接口描述注释是否存在
                    if (field.isAnnotationPresent(MyInterface.class)) {
                    	// 获取接口描述注释的值
                        myAnnotation = field.getAnnotation(MyInterface.class);
                        // 获取注释的索引值
                        coumnIndex = myAnnotation.columnIndex();
                        // 获取单元格
                        cell = row.getCell(coumnIndex);
                        // 设置属性值
                        setFieldValue(obj, field, wookbook, cell);
                    }
                }
                // 添加到列表中
                list.add(obj);
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } finally {
            	try {
            		// 判断工作簿是否为空,不为空则关闭
            		if(wookbook != null){
                        wookbook.close();
            		}
            		// 判断流是否为空,不为空则关闭
            		if(is != null){
                        is.close();
            		}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    
    /**
     * 获取导入数据的总行数
     * 
     * @return
     */
    public static int TotalRows(){
    	// 定义int类型变量
    	int TotalNumber = 0;
    	// 判断获取的行总数是否大于0
    	if(TotalRowNumber > 0){
    		// 获取总行数
    		TotalNumber = TotalRowNumber;
    		// 全局变量为0,防止再次利用
    		TotalRowNumber = 0;
    	}
    	return TotalNumber;
    }
    
    /**
     * 获取excel 2003版本的工作簿
     * 
     * @param is 获取的输入流数据
     * @return
     */
    private static Workbook xls(InputStream is) {
        try {
            // 得到工作簿
            return new HSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 获取excel 2007版本的工作簿
     * 
     * @param is 获取的输入流数据
     * @return
     */
    private static Workbook xlsx(InputStream is) {
        try {
            // 得到工作簿
            return new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 设置属性值
     * 
     * @param obj 操作对象
     * @param field 对象属性
     * @param cell excel单元格的值
     */
    private static void setFieldValue(Object obj, Field field, Workbook wookbook, Cell cell) {
        try {
            if (field.getType() == int.class || field.getType() == Integer.class) {
            	field.set(obj, getInt(cell));
            }
            else if (field.getType() == Double.class || field.getType() == double.class) {
            	field.setDouble(obj, getDouble(null, cell));
            }
            else if (field.getType()== Date.class || field.getType() ==java.sql.Date.class){
            	field.set(obj, getDate(cell));
            }
            else {
            	System.out.println(field);
            	field.set(obj, getString(cell));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
	
    // 返回单元格的值的数据类型(Date类型)
	private static Object getDate(Cell cell) {
		return cell.getDateCellValue();
	}

	// 返回单元格的值的数据类型(String类型)
	private static Object getString(Cell cell) {
		System.out.println(cell);
		return cell.getStringCellValue();
	}
	
	// 返回单元格的值的数据类型(Double类型)
	private static double getDouble(Object object, Cell cell) {
		return cell.getNumericCellValue();
	}
	
	// 返回单元格的值的数据类型(Integet类型)
	private static Integer getInt(Cell cell) {
		//把数据转换成Integer类型
		return Integer.valueOf(cell.toString());
	}
	
	/**
	 * 获取上传文件的数据
	 * 删除保存在项目中的文件
	 * 
	 * @param path
	 * @return
	 */
	public static boolean DeleteFile(String path){
		// 获取需要删除文件的路径
		File file = new File(path);
		// 判断如果文件存在并且格式是文件则进行删除
		if(file.exists() && file.isFile()){
			//删除文件
			file.delete();
			return true;
		} else {
			return false;
		}
	}
	
	
	//导出
	public static void chushi(String jiashiname,String celShouJiNuber,
			int startIndex,int pageSize){
		/*List<driversuperviPo> list = driverService.findByCarName(jiashiname, 
		  	celShouJiNuber, startIndex, pageSize);*/
	}
	
	
	//导入
	public static void main(String[] args) {
		/*List<SBackendkftype> sbackendkftype = readExcelFile("D:/test.xls", SBackendkftype.class);*/
        
        /*for (SBackendkftype sBackendkftype2 : sbackendkftype) {
        	System.out.println(sBackendkftype2);
        	Boolean list=userService.test(sBackendkftype2);
        	System.out.println(list);
        }*/
	}
	
}
