package com.guo.offer.testeasyapi;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {
		// 此时的Workbook应该是从 客户端浏览器上传过来的 uploadFile了,其实跟读取本地磁盘的一个样
		String strPath = "C:\\Users\\Administrator\\Desktop\\a.xlsx";
		// 构造 XSSFWorkbook 对象，strPath 传入文件路径
		XSSFWorkbook xwb = new XSSFWorkbook(strPath);
		// 读取第一章表格内容
		XSSFSheet sheet = xwb.getSheetAt(0);
		// 定义 row、cell
		XSSFRow row;
		String cell;
		// 循环输出表格中的内容
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				// 通过 row.getCell(j).toString() 获取单元格内容，
				cell = row.getCell(j).toString();
				System.out.print(cell + "\t");
			}
			System.out.println("");
		}

	}
}
