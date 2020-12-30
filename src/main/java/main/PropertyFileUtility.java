package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
private static final Properties props = new Properties();
	
	public static String readPropertyFile(String finalPath, String Key)
	{
		try{
    
			File file = new File(finalPath);
			FileInputStream fileIStream = new FileInputStream(file);
			props.load(fileIStream);
			fileIStream.close();
			return props.getProperty(Key);
			
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public static void putProperty(String key, String value) {
		props.put(key, value);
	}
	

}