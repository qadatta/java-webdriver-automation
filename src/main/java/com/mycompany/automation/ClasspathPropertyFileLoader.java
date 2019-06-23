package com.mycompany.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasspathPropertyFileLoader extends Properties {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Properties loadProperties(String propertyFile) throws IOException {
        Properties properties = new Properties();
        InputStream stream = null;
        try {
         
        // this is loading null values for properties	
           stream = this.getClass().getResourceAsStream( propertyFile);
            File dir1 = new File(".");
            System.out.println(dir1.getCanonicalPath());
            System.out.println(dir1.getCanonicalFile() + "/target/classes/" + propertyFile);
            if (stream == null) {
                stream = new FileInputStream(dir1.getCanonicalFile() + "/target/classes/" + propertyFile);
            }
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return properties;

    }
}
