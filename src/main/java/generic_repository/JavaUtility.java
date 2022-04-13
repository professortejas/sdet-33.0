package generic_repository;

import java.util.Random;

public class JavaUtility {

	public static long convertStringToLong(String timeout) {
		long timeouts = Long.parseLong(timeout);
		return timeouts;
	}
	
	public static int generateRandomNumber(int limit) {
		Random ran=new Random();
		int randomNumber=ran.nextInt(limit);
		return randomNumber;
	}
}
