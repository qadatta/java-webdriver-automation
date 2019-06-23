package com.mycompany.automation;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	private static Properties fwProperties;
	public static String projectLocation;

	static {
		try {
			File oFile = new File(".project");
			projectLocation = oFile.getAbsolutePath();
			projectLocation = projectLocation.substring(0,projectLocation.lastIndexOf("\\"));
			fwProperties = new ClasspathPropertyFileLoader().loadProperties("framework.properties");
			System.out.println(fwProperties.toString());
		} catch (IOException e) {
			System.out.println("Problem in loading framework property file");
			e.printStackTrace();
			
		}
	}

	public static final String REMOTE_EXECUTE = fwProperties.getProperty("remote.execution");

	public static final String HUB_URL = fwProperties.getProperty("hub.url");

	// URL against which the test is going to run.
	public static final String APP_URL = fwProperties.getProperty("app.url");

	public static final String BROWSER = fwProperties.getProperty("test.browser");
	public static final String BROWSER_VERSION = fwProperties.getProperty("test.browserVersion");


	public static final String PLATFORM = fwProperties.getProperty("test.platform");
	
	public static final int PAGE_LOAD_TIMEOUT = Integer.parseInt(fwProperties.getProperty("test.pageLoadTimeout"));

	public static final int SCRIPT_TIMEOUT = Integer.parseInt(fwProperties.getProperty("test.scriptTimeout"));

	public static final int IMPLICITLY_WAIT = Integer.parseInt(fwProperties.getProperty("test.implicitlyWait"));

	public static final String SCREENSHOT_PATH = fwProperties.getProperty("test.screenshotPath");

	public static final String INCLUDE_GROUP = fwProperties.getProperty("test.includeGroups");

	public static final String EXCLUDE_GROUP = fwProperties.getProperty("test.excludeGroups");


	// Database related data
	public static final String DB_HOST = fwProperties.getProperty("dbHost");
	public static String DB_PORT = fwProperties.getProperty("dbPort");
	public static String DB_USER_NAME = fwProperties.getProperty("dbUserName");
	public static String DB_USER_PWD = fwProperties.getProperty("dbUserPassword");
	public static String DB_SCHEMA = fwProperties.getProperty("dbSchema");


}
