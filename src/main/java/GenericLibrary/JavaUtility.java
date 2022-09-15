package GenericLibrary;

import java.util.Random;

public class JavaUtility {
	/**
	 * @author saisandeep
	 * @return
	 */
	public static int generateRandomNumber() {
		Random r=new Random();
		int randomNum = r.nextInt(1000);	
		return randomNum;
	}
}
