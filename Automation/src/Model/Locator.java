package Model;

import org.apache.poi.ss.usermodel.Row;

public class Locator {
	public String screenName;
	public String elementName;
	public String attribute;
	public String attributeValue;
	public String type;
	public String listCount;
	
	public Locator(Row r) {
		this.screenName = r.getCell(0).getStringCellValue();
		this.elementName = r.getCell(1).getStringCellValue();
		this.attribute = r.getCell(2).getStringCellValue();
		this.attributeValue = r.getCell(3).getStringCellValue();
		this.type = r.getCell(4).getStringCellValue();
		this.listCount = r.getCell(5).getStringCellValue();
	}
}
