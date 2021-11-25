package co.edu.javeriana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.iterable.S3Objects;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class derivacionTAIS {

	private static final String FILENAME = "../../Variabilidad/ArbolVariabilidad/configs/default.xml";
	private static final String ENVIROMENT = "../../code/front/prueba1/src/environments/environment.ts";
	private static final String INTERNAL_ENVIROMENT = "../DerivacionTAIS/src/main/resources/enviroments/";
	private static final String PATH_FRONT = "../front/prueba1";

	public static void main(String[] args) throws IOException, SAXException {

		List<String> tmpStringConfig = new ArrayList<>();
		List<String> tmpConfigBasico = convertAssets("../DerivacionTAIS/src/main/resources/BProductTemplate");
		List<String> tmpConfigIntermedio = convertAssets("../DerivacionTAIS/src/main/resources/IProductTemplate");
		List<String> tmpConfigCompleto = convertAssets("../DerivacionTAIS/src/main/resources/CProductTemplate");

		File fXmlFile = new File(FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

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
			boolean comparator;

			File fileEnviromentVariabilidad = new File(ENVIROMENT);
			File fileEnviromentConfig = null;

			comparator = tmpStringConfig.equals(tmpConfigBasico);
			if (comparator) {
				System.out.println("Producto Basico Disponible - " + comparator);
				fileEnviromentConfig = new File(INTERNAL_ENVIROMENT + "environment.p1.ts");

				String content = new String(Files.readAllBytes(Paths.get(fileEnviromentConfig.getPath())));

				Files.writeString(Path.of(fileEnviromentVariabilidad.getPath()), content);
				
				cmd();
				uploadS3();
			}

			comparator = tmpStringConfig.equals(tmpConfigIntermedio);
			if (comparator) {
				System.out.println("Producto Intermedio Disponible - " + comparator);
				fileEnviromentConfig = new File(INTERNAL_ENVIROMENT + "environment.p2.ts");

				String content = new String(Files.readAllBytes(Paths.get(fileEnviromentConfig.getPath())));

				Files.writeString(Path.of(fileEnviromentVariabilidad.getPath()), content);

				cmd();
				uploadS3();

			}

			comparator = tmpStringConfig.equals(tmpConfigCompleto);
			if (comparator) {
				System.out.println("Producto Completo Disponible - " + comparator);
				fileEnviromentConfig = new File(INTERNAL_ENVIROMENT + "environment.p3.ts");

				String content = new String(Files.readAllBytes(Paths.get(fileEnviromentConfig.getPath())));

				Files.writeString(Path.of(fileEnviromentVariabilidad.getPath()), content);
				
				cmd();
				uploadS3();

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	private static void uploadS3() throws IOException {
		  AWSCredentials credentials = new BasicAWSCredentials(
	                "", 
	                "");
	        
	        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
	        			.withRegion(Regions.US_EAST_1)
	        			.withCredentials(new AWSStaticCredentialsProvider(credentials))
	        			.build();
	        
//	        front-aws-app
//	        List<Bucket> buckets = s3client.listBuckets();
//	        System.out.println("Your {S3} buckets are:");
//	        for (Bucket b : buckets) {
//	            System.out.println("* " + b.getName());
//	           
//	        }
	        
	        int counter = 0;
	        File [] fullDirectory = new File(PATH_FRONT +"/dist/prueba1").listFiles();

	        for (File file : fullDirectory) {
	            if (file.isFile()) {
	                System.out.println(file.getName());
	                counter++;
	            }
	        }
	        System.out.println(counter);
	}
	
	private static void cmd() throws IOException {
		FileUtils.deleteDirectory( new File(PATH_FRONT +"/dist"));
		
		String comando = "cmd /c cmd.exe /K \" cd "+PATH_FRONT+" && ng build && exit";
		try {
			Runtime.getRuntime().exec(comando).waitFor();

		} catch (Exception ex) {
			System.out.println("ex: " + ex.getMessage());
		}
	}

	private static boolean isSelected(Node automatic, Node manual) {
		return (automatic != null && automatic.getNodeValue().equals("selected"))
				|| (manual != null && manual.getNodeValue().equals("selected"));
	}

	private static List<String> convertAssets(String location) {

		BufferedReader reader;
		String tmpLine = "";
		try {
			reader = new BufferedReader(new FileReader(location));
			String line = reader.readLine();
			while (line != null) {
				tmpLine = line;
				line = reader.readLine();
			}
			reader.close();

			return Arrays.asList(tmpLine.split(","));
		} catch (IOException e) {
			e.printStackTrace();
		}

		throw new RuntimeException();
	}

}
