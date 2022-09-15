package TestAnno;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider = "provideMeData")
	public void getMultipleData(String name, int id) {
		System.out.println("The name is "+name+" and id is "+id);
	}
	
	@DataProvider
	public Object[][] provideMeData() {
		Object [][] obj=new Object[3][2];
		
		obj[0][0]="Akash";
		obj[0][1]=101;
		
		obj[1][0]="mukesh";
		obj[1][1]=102;
		
		obj[2][0]="Rakesh";
		obj[2][1]=103;
		
		return obj;
	}
}
