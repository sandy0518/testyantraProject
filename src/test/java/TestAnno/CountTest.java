package TestAnno;

import org.testng.annotations.Test;

public class CountTest {
	@Test 

	public void orgTest() {
		System.out.println("Create Organisation");
	}
	@Test(invocationCount = 3) 
	
	public void industryTest() {
		System.out.println("Org with Industry Created");
	}
	@Test

	public void contactTest() {
		System.out.println("Contact Created");
	}
}
