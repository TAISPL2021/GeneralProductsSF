package co.edu.javeriana;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class derivacionTAIS {

	private static final String FILENAME = "../../Variabilidad/ArbolVariabilidad/configs/default.xml";

	public static void main(String[] args) {

		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try (InputStream is = readXmlFileIntoInputStream("default.xml")) {

			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(is);

			doc.getDocumentElement().normalize();



			NodeList list = doc.getElementsByTagName("feature");

			for (int temp = 0; temp < list.getLength(); temp++) {

				Node node = list.item(temp);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					// get staff's attribute
					String feature = element.getAttribute("feature");
					String automatic = element.getAttribute("automatic");
					String manual = element.getAttribute("manual");
					String name = element.getAttribute("name");
					
					System.out.print(feature + "\n");
					System.out.print(automatic+ "\n");
					System.out.print(manual+ "\n");
					System.out.print(name+ "\n");
					

					if ("selected".equals(automatic) || "selected".equals(manual)) {
						String featName = element.getAttribute("name");
						switch (featName) {
						case "RegistroDeUsuario":
							break;
						case "GestionDePerfil":
							break;
						case "InicioSesion":
							break;
						case "VisualizarProductos":
							break;
						case "BuscarProductos":
							break;
						case "CompraProductos":
							break;
						case "Inventario":
							String propiedad = "eureka.instance.prefer-ip-address";
							Properties prop = leerPropiedades("src/main/resources/application.properties", propiedad);
							String valor = prop.getProperty(propiedad);
							if (valor.equals("true")) {
								modificarPropiedades("src/main/resources/application.properties", prop,
										"eureka.instance.prefer-ip-address", "false");
							}

							break;
						case "Facturacion":
							break;
						case "Promocion":
							break;
						case "GestionDeUsuarios":
							break;
						case "Pedidos":
							break;
						case "PagoElectronico":

							break;
						case "Reporte":
							break;

						}
					}

				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

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
