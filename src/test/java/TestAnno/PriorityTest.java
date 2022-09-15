package TestAnno;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority = 0)
	
	public void orgTest() {
		System.out.println("Create Organisation");
	}
	@Test(priority = 1)
	
	public void industryTest() {
		System.out.println("Org with Industry Created");
	}
	@Test(priority = 0)
	
	public void contactTest() {
		System.out.println("Contact Created");
	}
}
