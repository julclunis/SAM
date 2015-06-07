package logic.sas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.teragram.catcon.TgMCatHandle;
import com.teragram.catcon.TgMCatQuery;
import com.teragram.catcon.TgMCatQueryResult;

public class ProcessDirectory {

	static String resultsLocation = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\03 - Results and Data\\OrganizationCultureClassification01.csv";
	static String projectName = "OrganizationalCultureProfile";

	static String serverToQuery = "localhost"; //"http://lsci-teragram.slis.kent.edu/"
	static TgMCatHandle sasServerH = null;

	static FileWriter fileWriter = null;
	static PrintWriter printWriter = null;
	static File startingFileDirecotry = null;

	static int numberofqueries = 0;

	public static void main(String[] args) throws Exception {
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
		printWriter.print("Metadata?");
		printWriter.print(", \t");
		printWriter.println("Concept Classified");

		if (args.length == 0) {
			System.out.println("file args is empty");
		} else {
			startingFileDirecotry = new File(args[0]);

			if (startingFileDirecotry.isFile()) {
				System.out.print("This is not a directory!");
				// this is where the process should only process one text

			} else {
				System.out.println("Intializing Direcotry Processing: ");
				processDirectoryFileForBatch(startingFileDirecotry.listFiles());
			}
		}

		printWriter.flush();
		fileWriter.close();

	}

	private static void processDirectoryFileForBatch(File[] fileSourceList)
			throws Exception {

			TgMCatQueryResult r = null;
			TgMCatQuery q = null;
		
		
		for (File file : fileSourceList) {
			if (file.isDirectory()) {
				System.out.println("starting directory" + file.getName());
				processDirectoryFileForBatch(file.listFiles());

			} else if (file.getName().endsWith(".txt")) {

			
				q = new TgMCatQuery();

				System.out.println(file.getParent().substring(
						file.getParent().lastIndexOf("\\"))+ "starting the analysis process for _ " + file.getName());
			

				q.addToProjectList(projectName);
				q.setDocumentFile(file);
				q.setGetMatchPositions(true);

				try {
					r = sasServerH.query(q);
					saveToTheResults(r, file);

				} catch (Exception e) {

					System.out.println(file.getAbsolutePath());
					e.printStackTrace();

				}

				if (r == null) {
					return;
				}

			}
		}
	}

	public static void saveToTheResults(TgMCatQueryResult resultstosave, File file)
			throws IOException {

		int nb_categoriesForTheResultOfTheDocument;
		
		try {

			nb_categoriesForTheResultOfTheDocument = resultstosave.getNbCategories();
			System.out.println(".    Number of Categoreies/Concept discovered for "
					+ file.getAbsolutePath() + " is " + nb_categoriesForTheResultOfTheDocument);

			for (int i = 0; i < nb_categoriesForTheResultOfTheDocument; i++) {
				numberofqueries++;

				printWriter.print(numberofqueries);
				printWriter.print(", \t");
				printWriter.print(file.getAbsolutePath());
				printWriter.print(", \t");
				printWriter.print(file.getName());
				printWriter.print(", \t");
				printWriter.print(file.getParent().substring(
						file.getParent().lastIndexOf("\\")));
				printWriter.print(", \t");
				printWriter.print(resultstosave.getCategoryRelevance(i));
				printWriter.print(", \t");
				printWriter.print(resultstosave.getNbMatchesForCategory(i));
				printWriter.print(", \t");
				printWriter.print(resultstosave.getCategoryMetaData(i));
				printWriter.print(", \t");
				printWriter.println(resultstosave.getCategoryName(i));

			}

		} catch (Exception e) {

		} finally {
			System.out.println(file.getParent().substring(
					file.getParent().lastIndexOf("\\"))+ ":     Analysis Completed");
		}

	}
}







// http://stackoverflow.com/questions/3154488/best-way-to-iterate-through-a-directory-in-java

// printWriter.flush();
// fileWriter.close();

// int nb_categories = r.getNbCategories();
// System.out.println("There are " +nb_categories
// +" Number of categories for file = "
// + fileProcessing.getAbsolutePath() );
// h.addServer("http://lsci-teragram.slis.kent.edu", 6500);
// static String resultsLocation = "C:\\testbameforfile6.csv";