package Functionalities;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class Keywords {
	private String inputFile;
	public String id;
	public String pwd;
	public String phone;
	public String searchAndBuyMobileKeywords[]=new String[4];
	public String loginKeywords[]=new String[4];
	public String logoutKeywords[]=new String[4];

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void loginCredentials() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String credentials[] = new String[5];
		int num = 0;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines

			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 1; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					credentials[num] = cell.getContents();
					num++;

				}
			}
			id = credentials[0];
			pwd = credentials[1];
			System.out.println(id + " " + pwd);

		} catch (BiffException e) {
			System.out.println(e);
		}
	}

	public void testData() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String data[] = new String[5];
		int num = 0;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(1);
			// Loop over first 10 column and lines

			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 1; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					data[num] = cell.getContents();
					num++;

				}
			}
			phone = data[0];
			System.out.println(phone);

		} catch (BiffException e) {
			System.out.println(e);
		}
	}

	public void testScript() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook w;
		String testScript[][] = new String[25][25];
		int num = 0;
		try {
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(2);
			// Loop over first 10 column and lines
			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 0; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);

					testScript[j][i] = cell.getContents();
					num++;

				}
			}

			for (int i = 0; i <4 ; i++) {
				for (int j = 0; j < 5; j++) {

					System.out.print(testScript[j][i] + "\t");
				}
				System.out.println();
			}
			
			//System.out.println("Test Script Name::::,"+testScript[1][1]);
			
				
				for(int i=0;i<4;i++) {
					searchAndBuyMobileKeywords[i]=testScript[i+1][1];
					loginKeywords[i]=testScript[i+1][2];
					logoutKeywords[i]=testScript[i+1][3];
					
				}
			
			System.out.println("Keywords of 1st test case");
			for(String a:loginKeywords) {
				
				System.out.println(a);
				
			}

		} catch (BiffException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws IOException {
		Keywords test = new Keywords();
		test.setInputFile("E:/KeywordDrivenCheck.xls");
		System.out.println("Login Credentials**********");
		test.loginCredentials();
		System.out.println("Test Data***************");
		test.testData();
		System.out.println("Test Script*************");
		test.testScript();
	}

}
