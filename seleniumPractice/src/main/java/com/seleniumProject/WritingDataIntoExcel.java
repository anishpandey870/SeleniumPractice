package com.seleniumProject;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataIntoExcel {
    public static void main(String[] args) throws IOException {
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");
//row 1
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        row1.createCell(1).setCellValue(1234);
        row1.createCell(2).setCellValue("Automation");
//row 3
        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Python");
        row2.createCell(1).setCellValue(675);
        row2.createCell(2).setCellValue("Robot automation");
//row 3
        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("Mysql");
        row3.createCell(1).setCellValue(7828);
        row3.createCell(2).setCellValue("Testing automation");
        //write data into file
        workbook.write(file);
        workbook.close();
        file.close();
        System.out.println("file is created....");
    }
}
