package com.guo.offer.testeasyapi;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {
		// ��ʱ��WorkbookӦ���Ǵ� �ͻ���������ϴ������� uploadFile��,��ʵ����ȡ���ش��̵�һ����
		String strPath = "C:\\Users\\Administrator\\Desktop\\a.xlsx";
		// ���� XSSFWorkbook ����strPath �����ļ�·��
		XSSFWorkbook xwb = new XSSFWorkbook(strPath);
		// ��ȡ��һ�±������
		XSSFSheet sheet = xwb.getSheetAt(0);
		// ���� row��cell
		XSSFRow row;
		String cell;
		// ѭ���������е�����
		for (int i = sheet.getFirstRowNum(); i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
				// ͨ�� row.getCell(j).toString() ��ȡ��Ԫ�����ݣ�
				cell = row.getCell(j).toString();
				System.out.print(cell + "\t");
			}
			System.out.println("");
		}

	}
}
