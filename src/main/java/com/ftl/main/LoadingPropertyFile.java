package com.ftl.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadingPropertyFile {
	Properties prop = new Properties();
	InputStream inputStream = null;
	String ftlPagePath="";
	public String userDetailsPath="";
	public LoadingPropertyFile() throws IOException{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		inputStream = classLoader.getResourceAsStream("path.properties");
		prop.load(inputStream);
		ftlPagePath = prop.getProperty("templatepath");
		userDetailsPath	= prop.getProperty("userdetailspath");
	}
}
