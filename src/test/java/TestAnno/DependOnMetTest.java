package TestAnno;

import org.testng.annotations.Test;

public class DependOnMetTest {
	@Test 
	
	public void orgTest() {
		System.out.println("Create Organisation");
	}
	@Test(dependsOnMethods = "orgTest")
	
	public void industryTest() {
		System.out.println("Org with Industry Created");
	}
	@Test(dependsOnMethods = "industryTest")
	
	public void contactTest() {
		System.out.println("Contact Created");
	}
}
