package br.com.lucasbibianot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	/**
	 * Retorna a planilha desejada para a sua leitura (Utilizando o nome do arquivo)
	 * 
	 * @param fileName
	 * @param planilha
	 * @return
	 * @throws IOException
	 */
	public static XSSFSheet abrirPlanilha(String fileName, int planilha) throws IOException {
		File myFile = new File(fileName);
		FileInputStream fis = new FileInputStream(myFile);
		return abrirPlanilha(fis, planilha);
	}

	/**
	 * Retorna a planilha desejada para a sua leitura (Utilizando o objeto File)
	 * 
	 * @param fileName
	 * @param planilha
	 * @return
	 * @throws IOException
	 */
	public static XSSFSheet abrirPlanilha(InputStream fis, int planilha) throws IOException {
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		return myWorkBook.getSheetAt(planilha);
	}

	/**
	 * 
	 * Retorna o valor de uma determinada celular
	 * 
	 * @param cell
	 * @return
	 */
	public static Object recuperarValorCelula(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return cell.getNumericCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return null;
		}
	}
}
