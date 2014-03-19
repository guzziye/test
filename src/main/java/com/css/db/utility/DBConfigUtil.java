package com.css.db.utility;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Database configuration utility
 * 
 * @author AIS
 */
public class DBConfigUtil {

	/**
	 * Read configuration data of database for whole application
	 * 
	 * @return
	 */
	public static NamedNodeMap readDbConfig() {
		NamedNodeMap map = null;
		try {
			File file = new File("src/main/webapp/META-INF/context.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			Node resourceNode = doc.getElementsByTagName("Resource").item(0);
			map = resourceNode.getAttributes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
