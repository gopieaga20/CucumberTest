package dataProvider;

import java.io.IOException;
import java.util.Map;

public class GetData {

	public static void main(String[] args) throws IOException {
		ConfigFileReader config = new ConfigFileReader();
		ReadExcel ex = new ReadExcel(config.getExcelpath(), 0);
		Map<String, Map<String,String>>  excelData = ex.getExcelasMap();
		System.out.println(excelData);
		System.out.println(excelData.get("1").get("Username"));
	}

}
