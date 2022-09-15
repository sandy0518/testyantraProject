package SeleniumPackage;

import java.util.Date;

import org.testng.annotations.Test;

public class PrintDate {
	@Test
	
	public void date() {
		Date d=new Date();
		String currentDate = d.toString().replace(":", "_").replace(" ", "_");
		System.out.println(currentDate);
	}
}
