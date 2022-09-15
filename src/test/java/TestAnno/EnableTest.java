package TestAnno;

import org.testng.annotations.Test;

public class EnableTest {
	@Test 

	public void orgTest() {
		System.out.println("Create Organisation");
	}
	@Test(enabled = false) //if we give false then it will not execute

	public void industryTest() {
		System.out.println("Org with Industry Created");
	}
	@Test

	public void contactTest() {
		System.out.println("Contact Created");
	}
}
