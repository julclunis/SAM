package logic.sas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.teragram.catcon.TgMCatException;
import com.teragram.catcon.TgMCatHandle;
import com.teragram.catcon.TgMCatQuery;
import com.teragram.catcon.TgMCatQueryResult;
import com.teragram.fileconverter.Client;
import com.teragram.fileconverter.Exception;
import com.teragram.fileconverter.Input;
import com.teragram.fileconverter.Output;

public class FOOORFUUUUNNCopyOfConvertAndProcessDocsForSasClassification {

	static File startingFileDirecotry = new File(
			//"C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\02 - Documents for Processing\\Country Categorization Research Text Data - by Countries\\TKE Document Files\\Nepal");
	"C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\02 - Documents for Processing");

	// Politician Data Files
	// Egypt Wikileaked Cables

	static String resultsLocation = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\03 - Results and Data\\forfun\\tforfunanalysisALL.csv";

	static String projectName00 = "WikiLeaks Profile";
	static String projectName01 = "PolicticalDiscourseInt-ExtLanguageProfile";
	static String projectName02 = "Ken";// Transportation
	static String projectName03 = "OrganizationalCultureProfile";
	static String projectName04 = "FinalCountryProfileMay2014";
	static String projectName05 = "IPTC";

	// PolicticalDiscourseInt-ExtLanguageProfile
	// WikiLeaks Profile

	static String serverToQuery = "localhost"; // "http://lsci-teragram.slis.kent.edu/"
	static TgMCatHandle sasServerH = null;

	static FileWriter fileWriter = null;
	static PrintWriter printWriter = null;

	static int numberofqueries = 0;

	static File currentFileProcessing = null;

	public static void main(String[] args) throws TgMCatException,
			java.lang.Exception {
		sasServerH = new TgMCatHandle();
		sasServerH.addServer("localhost", 6500);

		fileWriter = new FileWriter(resultsLocation);
		printWriter = new PrintWriter(fileWriter);

		printWriter.print("number of queries");
		printWriter.print(", \t");
		printWriter.print("Absolute Path");
		printWriter.print(", \t");
		printWriter.print("File Name");
		printWriter.print(", \t");
		printWriter.print("Parent Directory");
		printWriter.print(", \t");
		printWriter.print("Relevance");
		printWriter.print(", \t");
		printWriter.print("Number of Matches");
		printWriter.print(", \t");
		printWriter.print("--------");
		printWriter.print(", \t");
		printWriter.print("Concept Classified");
		printWriter.print(", \t");
		printWriter.println("Matches");

		if (startingFileDirecotry.isFile()) {
			System.out.print("This is not a directory!");

		} else {
			System.out.println("Intializing Direcotry Processing: ");
			processDirectoryFileForBatch(startingFileDirecotry.listFiles());
		}

		printWriter.flush();
		fileWriter.close();

	}

	private static void processDirectoryFileForBatch(File[] fileSourceList)
			throws TgMCatException, java.lang.Exception {

		TgMCatQueryResult r = null;
		TgMCatQuery q = null;
		File tempFileForProcessing = null;

		for (File file : fileSourceList) {
			if (file.isDirectory()) {
				System.out.println("starting directory" + file.getName());
				processDirectoryFileForBatch(file.listFiles());

			} else if (file.getName().endsWith(".txt")
					|| file.getName().endsWith(".docx")) {

				currentFileProcessing = file;
				q = new TgMCatQuery();

				System.out.println(file.getParent().substring(
						file.getParent().lastIndexOf("\\"))
						+ "starting the analysis process for _ "
						+ file.getName());

				q.addToProjectList(projectName00);
				q.addToProjectList(projectName01);
				q.addToProjectList(projectName02);
				q.addToProjectList(projectName03);
				q.addToProjectList(projectName04);
				q.addToProjectList(projectName05);

				tempFileForProcessing = File.createTempFile(
						"tempfilebeforeconversion", "txt");

				Writer writetotemp = new BufferedWriter(new FileWriter(tempFileForProcessing));
				writetotemp.write(convertDocToTxtWithDocumentCoversionServer(currentFileProcessing));
				writetotemp.close();

				q.setDocumentFile(tempFileForProcessing);
				q.setGetMatchPositions(true);

				try {
					r = sasServerH.query(q);
					saveToTheResults(r, currentFileProcessing);

				} catch (Exception e) {

					System.out.println(currentFileProcessing.getAbsolutePath());
					e.printStackTrace();

				}

				if (r == null) {
					return;
				}

			}
		}
	}

	public static void saveToTheResults(TgMCatQueryResult resultstosave,
			File file) throws java.lang.Exception {

		int nb_categoriesForTheResultOfTheDocument;

		try {

			nb_categoriesForTheResultOfTheDocument = resultstosave
					.getNbCategories();

			System.out
					.println(".    Number of Categoreies/Concept discovered for "
							+ file.getAbsolutePath()
							+ " is "
							+ nb_categoriesForTheResultOfTheDocument);

			for (int i = 0; i < nb_categoriesForTheResultOfTheDocument; i++) {
				numberofqueries++;

				printWriter.print(numberofqueries);
				printWriter.print(",");
				printWriter.print(file.getAbsolutePath());
				printWriter.print(",");
				printWriter.print(file.getName());
				printWriter.print(",");
				printWriter.print(file.getParent().substring(
						file.getParent().lastIndexOf("\\")));
				printWriter.print(",");
				printWriter.print(resultstosave.getCategoryRelevance(i));
				printWriter.print(",");
				printWriter.print(resultstosave.getNbMatchesForCategory(i));
				printWriter.print(",");
				printWriter.print("----------");
				printWriter.print(",");
				printWriter.print(resultstosave.getCategoryName(i));
				printWriter.print(",");
				printWriter.print("\"");
				for (int j = 0; j < resultstosave.getNbMatchesForCategory(i); j++) {

					printWriter.print(resultstosave.getMatchPhrase(i, j));

					printWriter.print(", ");
				}
				printWriter.print("\"");
				printWriter.println("");
			}

		} catch (Exception e) {

		} finally {
			System.out.println(file.getParent().substring(
					file.getParent().lastIndexOf("\\"))
					+ ":     Analysis Completed");
		}

	}

	private static String convertDocToTxtWithDocumentCoversionServer(
			File fileToConvert) {

		Client clientForFC = new Client("localhost", 54321);
		String toreturn = null;

		try {
			String tempstringtoremovenonascii = FileUtils
					.readFileToString(fileToConvert);
			tempstringtoremovenonascii = tempstringtoremovenonascii.replaceAll(
					"[^\\p{ASCII}]", ""); // http://www.java2novice.com/java_string_examples/remove-non-ascii-chars/
			tempstringtoremovenonascii = tempstringtoremovenonascii.replaceAll(
					"[^\\x20-\\x7e]", ""); // http://stackoverflow.com/questions/6772221/what-is-the-better-approach-to-trim-unprintable-characters-from-a-string
	

			FileUtils.writeStringToFile(fileToConvert,
					tempstringtoremovenonascii);

			InputStream inputstre = new FileInputStream(fileToConvert);

			Input inputfile = new Input();
			byte[] fffff = IOUtils.toByteArray(inputstre);

			// inputstre.close();
			inputfile.content = fffff;

			Output outputhere = clientForFC.convert(inputfile);

			toreturn = outputhere.text;

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

			System.out.println(e1.getMessage());
		} catch (IOException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
			System.out.println("ioeception");

		} catch (Exception e111) {
			// TODO Auto-generated catch block
			e111.printStackTrace();
			System.out.println("just exception");
		}

		return toreturn;

	}

}
