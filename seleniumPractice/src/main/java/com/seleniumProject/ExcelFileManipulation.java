package com.seleniumProject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//excel file--->workbook---->sheet--->row--->cell
public class ExcelFileManipulation {
    public static void main(String[] args) throws IOException {
        FileInputStream file=new FileInputStream("C:\\Users\\anish\\IdeaProjects\\seleniumPractice\\testData\\dateTest.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        int totalRow=sheet.getLastRowNum();
        int totalCell=sheet.getRow(1).getLastCellNum();
        System.out.println("totat row"+totalRow);
        System.out.println("totat cell"+totalCell);
        for(int r=0;r<=totalRow;r++){
           XSSFRow currentRow= sheet.getRow(r);
            for(int c=0;c<totalCell;c++){
               XSSFCell cell= currentRow.getCell(c);
                System.out.print(cell.toString()+"\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
