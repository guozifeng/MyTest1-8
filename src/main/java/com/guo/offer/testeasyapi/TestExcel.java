package com.guo.offer.testeasyapi;

import java.io.FileInputStream;
import java.sql.Connection;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.alibaba.fastjson.JSONObject;
import com.guo.MyTest18.User;
import com.guo.offer.testSimpleDateFormat.DateUtil;

public class TestExcel {
	public static void main(String[] args) throws Exception {
		test1();
	}
	public static void test1() throws Exception{
		//此时的Workbook应该是从 客户端浏览器上传过来的 uploadFile了,其实跟读取本地磁盘的一个样  
		String userUploadFile = "";
        POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(userUploadFile));  
        HSSFWorkbook wb=new HSSFWorkbook(fs);  
        HSSFSheet hssfSheet=wb.getSheetAt(0);  
          
        if(hssfSheet!=null){  
            //遍历excel,从第二行开始 即 rowNum=1,逐个获取单元格的内容,然后进行格式处理,最后插入数据库  
            for(int rowNum=1;rowNum<=hssfSheet.getLastRowNum();rowNum++){  
                HSSFRow hssfRow=hssfSheet.getRow(rowNum);  
                if(hssfRow==null){  
                    continue;  
                }  
                System.out.println();
                System.out.println(ExcelUtil.formatCell(hssfRow.getCell(0)));  
                System.out.println(ExcelUtil.formatCell(hssfRow.getCell(1)));  
                System.out.println(ExcelUtil.formatCell(hssfRow.getCell(2)));  
                System.out.println(ExcelUtil.formatCell(hssfRow.getCell(3)));  

                //对于单元格日期需要进行特殊处理  
                System.out.println(DateUtil.formatString(ExcelUtil.formatCell2(hssfRow.getCell(4)), "yyyy-MM-dd"));  

            }  
        }  
        JSONObject result=new JSONObject();  
        result.put("success", "true");  

	}
}
