package Model;

import org.apache.poi.ss.usermodel.Row;

public class TestStep {
	public String action;
	public String element;
	public String value;
	
	public TestStep(Row r) {
		this.action =  r.getCell(0).getStringCellValue();
		try{
		this.element =  r.getCell(1).getStringCellValue();
		}catch(Exception e){
			this.element = null;
		}
		try{
			this.value =  r.getCell(2).getStringCellValue();
		}catch(Exception e){
			this.value = null;
		}
	}
}
