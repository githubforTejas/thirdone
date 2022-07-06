package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getValueFromExcel(String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum );
		String data = cell.toString();
		return data;
	}
	/**
	 * it is used to write the data into Excel file
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */


	public void WriteDataIntoExcel(String SheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis2=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IPathConstants.excelPath);
		book.write(fout);
	}



	/**
	 * to get the numeric value
	 */
	public String getNumericValueFromExcel(String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum );
		DataFormatter data=new DataFormatter();
		String numericValue = data.formatCellValue(cell);
		return numericValue;

	}
	/**
	 * 
	 */
	public int getdoubleValueFromExcel(String SheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1=new FileInputStream(IPathConstants.excelPath);
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(SheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum );
		String data = cell.toString();
		int value = Integer.parseInt(data);
		return value;

	}
}