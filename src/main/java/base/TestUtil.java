package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends BaseTest{
	
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/InputParameters.properties";

	/* Reading properties file for test data */
	public TestUtil(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("InputParameters.properties not found at " + propertyFilePath);
		}		
	}
	
	/* fetching PageURL from properties file */
	public String getPageURL(){
		String pageURL = properties.getProperty("pageURL");
		if(pageURL!= null) return pageURL;
		else throw new RuntimeException("pageURL not specified in the InputParameters.properties file.");		
	}
	
	/* fetching status from properties file */
	public String getStatus(){
		String status = properties.getProperty("status");
		if(status!= null) return status;
		else throw new RuntimeException("status not specified in the InputParameters.properties file.");		
	}
	
	/*
	 * public String getUsername(){ String username =
	 * properties.getProperty("username"); if(username!= null) return username; else
	 * throw new
	 * RuntimeException("username not specified in the InputParameters.properties file."
	 * ); }
	 * 
	 * public String getPassword(){ String password =
	 * properties.getProperty("password"); if(password!= null) return password; else
	 * throw new
	 * RuntimeException("pageURL not specified in the InputParameters.properties file."
	 * ); }
	 */


}