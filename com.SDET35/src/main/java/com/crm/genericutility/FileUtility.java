package com.crm.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
/**
 * it is used to get common data from property file based on the key which you have specified as a argument
 * 
 * @throws IOException 
 * 
 */
	public String getPropertyKeyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.filePath);
		Properties prop=new Properties();
		prop.load(fis); 
		String value = prop.getProperty(key);
		return value;
		}	
}
