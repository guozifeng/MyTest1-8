package com.guo.offer.testeasyapi;

import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.guo.offer.testSimpleDateFormat.DateUtil;

/**
 * Excel�ļ���������: ����������ݵ���ͨexcel��ģ��excel�ļ�,��Ԫ���ʽ����
 * 
 * @author ����ɭ
 *
 */
public class ExcelUtil {

	/**
	 * ������ݵ���ͨ��excel�ļ���
	 * 
	 * @param rs
	 * @param wb
	 * @param headers
	 * @throws Exception
	 */
	public static void fillExcelData(ResultSet rs, Workbook wb, String[] headers) throws Exception {
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(0);

		// �������ͷ : "���","����","�绰","Email","QQ","��������"
		for (int i = 0; i < headers.length; i++) {
			row.createCell(i).setCellValue(headers[i]);
		}

		// ���������
		int rowIndex = 1;
		while (rs.next()) {
			row = sheet.createRow(rowIndex++);
			for (int i = 0; i < headers.length; i++) {
				Object objVal = rs.getObject(i + 1);
				if (objVal instanceof Date) {
					row.createCell(i).setCellValue(DateUtil.formatDate((Date) objVal, "yyyy-MM-dd"));
				} else {
					row.createCell(i).setCellValue(objVal.toString());
				}
			}
		}
	}

	/**
	 * ������ݵ�ģ��excel�ļ�
	 * 
	 * @param rs
	 * @param templateFileName
	 * @return
	 * @throws Exception
	 */
	public static Workbook fillExcelDataWithTemplate(ResultSet rs, String templateFileName) throws Exception {
		// ����:�ӱ��ش��̶�ȡģ��excel�ļ�,Ȼ���ȡ��һ��sheet
		InputStream inp = ExcelUtil.class.getResourceAsStream("/com/steadyjack/template/" + templateFileName);
		POIFSFileSystem fs = new POIFSFileSystem(inp);
		Workbook wb = new HSSFWorkbook(fs);
		Sheet sheet = wb.getSheetAt(0);

		// ��ʼд�����ݵ�ģ����: ��Ҫע�����,��Ϊ��ͷ�Լ����ú�,�ʶ���Ҫ������ͷ
		int cellNums = sheet.getRow(0).getLastCellNum();
		int rowIndex = 1;
		while (rs.next()) {
			Row row = sheet.createRow(rowIndex++);
			for (int i = 0; i < cellNums; i++) {
				Object objVal = rs.getObject(i + 1);
				if (objVal instanceof Date) {
					row.createCell(i).setCellValue(DateUtil.formatDate((Date) objVal, "yyyy-MM-dd"));
				} else {
					row.createCell(i).setCellValue(objVal.toString());
				}
			}
		}
		return wb;
	}

	/**
	 * ����Ԫ���ʽ�ļ򵥷�ʽ
	 * 
	 * @param hssfCell
	 * @return
	 */
	public static String formatCell(HSSFCell hssfCell) {
		if (hssfCell == null) {
			return "";
		} else {
			if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(hssfCell.getBooleanCellValue());
			} else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				return String.valueOf(hssfCell.getNumericCellValue());
			} else {
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}

	/**
	 * ����Ԫ���ʽ�ĵڶ��ַ�ʽ: ������ζԵ�Ԫ�����������ڵĴ���
	 * 
	 * @param cell
	 * @return
	 */
	public static String formatCell2(HSSFCell cell) {
		if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

			// ��Ե�Ԫ��ʽΪ���ڸ�ʽ
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}
			return String.valueOf(cell.getNumericCellValue());
		} else {
			return cell.getStringCellValue();
		}
	}

	/**
	 * ����Ԫ���ʽ�ĵ����ַ���:�Ƚ�ȫ��
	 * 
	 * @param cell
	 * @return
	 */
	public static String formatCell3(HSSFCell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:

			// ���ڸ�ʽ�Ĵ���
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}

			return String.valueOf(cell.getNumericCellValue());

		// �ַ���
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		// ��ʽ
		case HSSFCell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();

		// �հ�
		case HSSFCell.CELL_TYPE_BLANK:
			return "";

		// ����ȡֵ
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";

		// ��������
		case HSSFCell.CELL_TYPE_ERROR:
			return cell.getErrorCellValue() + "";
		}

		return "";
	}
}
