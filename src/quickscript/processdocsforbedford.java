package quickscript;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

import mx.bigdata.jcalais.CalaisClient;
import mx.bigdata.jcalais.CalaisConfig;
import mx.bigdata.jcalais.CalaisObject;
import mx.bigdata.jcalais.CalaisResponse;
import mx.bigdata.jcalais.rest.CalaisRestClient;

import org.apache.commons.io.IOUtils;

import com.teragram.catcon.TgMCatException;
import com.teragram.catcon.TgMCatQuery;
import com.teragram.catcon.TgMCatQueryResult;
import com.teragram.fileconverter.Client;
import com.teragram.fileconverter.Exception;
import com.teragram.fileconverter.Input;
import com.teragram.fileconverter.Output;

public class processdocsforbedford {

	// process document from the media and policiticans
	// need to convert documents with sas document conversion server
	// then process with opencalais
	static File startingFileDirecotry = new File(
			"C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\02 - Documents for Processing\\Politician Data Files");
	static String resultsLocation = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\03 - Results and Data\\OpenCalaisResults02ForPolicitalDiscours-Politician02.csv";

	static PrintWriter printWriter = null;
	static FileWriter fileWriter = null;

	private static CalaisClient clientForOpenCalais = null;
	private static CalaisResponse response = null;
	private static CalaisConfig configSetingsForOpenCalais = null;
	static int numberofqueries = 0;



	public static void main(String[] args) throws TgMCatException,
			java.lang.Exception {
		try {
			fileWriter = new FileWriter(resultsLocation);
			printWriter = new PrintWriter(fileWriter);

			printWriter.print("File Path");
			printWriter.print(", \t");
			printWriter.print("File Name");
			printWriter.print(", \t");
			printWriter.print("File Parent");
			printWriter.print(", \t");
			printWriter.print("Entity Type");
			printWriter.print(", \t");
			printWriter.print("Entity Relevance");
			printWriter.print(", \t");
			printWriter.print("--------");
			printWriter.print(", \t");
			printWriter.println("Entity Name");

			processDirectoryFileForBatch(startingFileDirecotry.listFiles());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			printWriter.flush();
			fileWriter.close();
		}

	}

	private static void processDirectoryFileForBatch(File[] fileSourceList)
			throws TgMCatException, java.lang.Exception {

		for (File file : fileSourceList) {
			if (file.isDirectory()) {
				System.out.println("starting directory: " + file.getName());
				processDirectoryFileForBatch(file.listFiles());

			} else if (file.getName().endsWith(".txt")
					|| file.getName().endsWith(".docx")) {

				System.out.println("Initiating Procssing: " + file.getName()
						+ " from directory " + file.getParent());
				System.out.println("Converting Document to TEXT:");
				String tempStreing = convertDocToTxtWithDocumentCoversionServer(file);
				try {
					ConfigureAndConnectToOpenCalais();
					response = clientForOpenCalais.analyze(tempStreing, configSetingsForOpenCalais);

					if (response != null) {

						saveToTheResults(response, file);
					}
		
				} catch (java.net.SocketTimeoutException e1) {
					System.out.println("here ----- Failure here .............");

				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	private static String convertDocToTxtWithDocumentCoversionServer(
			File fileToConvert) 
	{
		Client clientForFC = new Client("localhost", 54321);
		String toreturn = null;

		try {
			InputStream inputstre = new FileInputStream(fileToConvert);
			Input inputfile = new Input();
			byte[] fffff = IOUtils.toByteArray(inputstre);
			inputfile.content = fffff;
			Output outputhere = clientForFC.convert(inputfile);
			toreturn = outputhere.text;

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toreturn;
	}

	public static void saveToTheResults(CalaisResponse resultstosave, File file)
			throws java.lang.Exception {

		try {

			for (CalaisObject entity : resultstosave.getEntities()) {

				printWriter.print(file.getAbsolutePath());
				printWriter.print(",");
				printWriter.print(file.getName());
				printWriter.print(",");
				printWriter.print(file.getParent().substring(
						file.getParent().lastIndexOf("\\")));
				printWriter.print(",");
				printWriter.print(entity.getField("_type"));
				printWriter.print(",");
				printWriter.print(entity.getField("relevance"));
				printWriter.print(",");
				printWriter.print("----------");
				printWriter.print(",");
				printWriter.println("\"" + entity.getField("name") + "\"");

			}

		} finally {
			System.out.println(file.getParent().substring(
					file.getParent().lastIndexOf("\\"))
					+ ":     Analysis Completed");
		}

	}

	private static void ConfigureAndConnectToOpenCalais() {

		clientForOpenCalais = new CalaisRestClient("j4sq7tc2k3yxpdtzd4pjvd5b");
		configSetingsForOpenCalais = new CalaisConfig();

		// http://www.opencalais.com/documentation/calais-web-service-api/forming-api-calls/input-parameters
		configSetingsForOpenCalais.set(
				CalaisConfig.ProcessingParam.CALCULATE_RELEVANCE_SCORE, "true");

		configSetingsForOpenCalais.set(CalaisConfig.ConnParam.READ_TIMEOUT,
				100000000);
		configSetingsForOpenCalais.set(CalaisConfig.ConnParam.CONNECT_TIMEOUT,
				1000000);

	}
}
