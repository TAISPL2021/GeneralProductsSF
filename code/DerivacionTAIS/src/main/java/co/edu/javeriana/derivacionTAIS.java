package co.edu.javeriana;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class derivacionTAIS {

	private static final String FILENAME = "../../Variabilidad/ArbolVariabilidad/configs/default.xml";

	public static void main(String[] args) throws IOException {

		  List<String> tmpString;
		  List<String> tmpStringConfig = new ArrayList<>();
		
		 String fileName = "../DerivacionTAIS/src/main/resources/BProductTemplate";
		    File file = new File(fileName);
		 
		    try (Stream linesStream = Files.lines(file.toPath())) {
		    	tmpString = (List<String>) linesStream.collect(Collectors.toList());
		    }
		
		System.out.println("Template -> " + tmpString);
		
		
		File fXmlFile = new File(FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		int counter = 1;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getFirstChild().getChildNodes();

			for (int temp = 2; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				NamedNodeMap nodeMap = nNode.getAttributes();
				Node nameNode = nodeMap != null ? nodeMap.getNamedItem("name") : null;

				if (nameNode != null) {
						Node automatic = nodeMap.getNamedItem("automatic");
						Node manual = nodeMap.getNamedItem("manual");
						
						if (isSelected(automatic, manual)) {
							tmpStringConfig.add(nameNode.getNodeValue().trim());
						}
				}
				
			}
			
			System.out.println("CLIENTE -> " + tmpStringConfig);
			
//			var result = tmpStringConfig.stream().filter(two -> tmpString.stream().anyMatch(one -> one.equals(two))).collect(Collectors.toList());
			
			var result = tmpString.stream().filter(two -> tmpStringConfig.stream().anyMatch(one -> one.equals(two))).collect(Collectors.toList());
			
			System.out.println(result.size());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	
	private static boolean isSelected(Node automatic, Node manual) {
		return (automatic != null && automatic.getNodeValue().equals("selected"))
				|| (manual != null && manual.getNodeValue().equals("selected"));
	}
	

	// read file from resource's folder.
	private static InputStream readXmlFileIntoInputStream(final String fileName) {
		return derivacionTAIS.class.getClassLoader().getResourceAsStream(fileName);
	}

	private static Properties leerPropiedades(String archivoPropiedades, String propiedad) {
		try (InputStream input = new FileInputStream(archivoPropiedades)) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//System.out.println(prop.getProperty(propiedad));
			// System.out.println(prop.getProperty("db.user"));
			// System.out.println(prop.getProperty("db.password"));

			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private static void modificarPropiedades(String archivoPropiedades, Properties prop, String propiedad,
			String newValue) {
		try (FileOutputStream output = new FileOutputStream(archivoPropiedades)) {

			// Properties prop = new Properties();

			prop.setProperty(propiedad, newValue);
			String Salida = output.toString();

			prop.store(output, null);
			output.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
