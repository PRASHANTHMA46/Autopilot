package com.Autopilot.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static Properties prop;

	public static String readProperty(String key) {
		try {
			if (prop == null) {
				prop = new Properties();
				FileInputStream inputStream = new FileInputStream(new File("./Configuration/Config.properties"));
				prop.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public static Properties getProperties() {
		try {
			if (prop == null) {
				prop = new Properties();
				FileInputStream inputStream = new FileInputStream(
						new File("C:\\EngagePlus_5.0\\5.0\\Configuration\\Config.properties"));
				prop.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
