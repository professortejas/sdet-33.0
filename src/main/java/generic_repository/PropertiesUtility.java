package generic_repository;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {

	static Properties properties=null;
	public static void initializeProperty(String path) throws Throwable  {
		FileInputStream fis=new FileInputStream(path);
		properties=new Properties();
		properties.load(fis);
	}
	
	public static String fetchValue(String key) {
		String value = properties.getProperty(key);
		return value;
	}
}
