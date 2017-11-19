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
		//��ʱ��WorkbookӦ���Ǵ� �ͻ���������ϴ������� uploadFile��,��ʵ����ȡ���ش��̵�һ����  
		String userUploadFile = "";
        POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(userUploadFile));  
        HSSFWorkbook wb=new HSSFWorkbook(fs);  
        HSSFSheet hssfSheet=wb.getSheetAt(0);  
          
        if(hssfSheet!=null){  
            //����excel,�ӵڶ��п�ʼ �� rowNum=1,�����ȡ��Ԫ�������,Ȼ����и�ʽ����,���������ݿ�  
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

                //���ڵ�Ԫ��������Ҫ�������⴦��  
                System.out.println(DateUtil.formatString(ExcelUtil.formatCell2(hssfRow.getCell(4)), "yyyy-MM-dd"));  

            }  
        }  
        JSONObject result=new JSONObject();  
        result.put("success", "true");  

	}
}
