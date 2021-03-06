package cc.aaron67.ytst.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Config {

	private static Properties properties = new Properties();

	private final static Logger logger = Logger.getLogger(Config.class);

	static {
		try {
			System.out.println("读取配置文件");
			String configFilePath = System.getProperty("user.dir") + "/init.properties";
			PropertyConfigurator.configure(configFilePath);
			properties.load(new BufferedInputStream(new FileInputStream(configFilePath)));
		} catch (IOException e) {
			logger.error("读配置文件出错" + System.getProperty("line.separator") + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
