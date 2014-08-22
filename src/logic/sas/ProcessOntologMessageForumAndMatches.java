package logic.sas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.teragram.catcon.TgMCatHandle;
import com.teragram.catcon.TgMCatQuery;
import com.teragram.catcon.TgMCatQueryResult;

public class ProcessOntologMessageForumAndMatches {

	static File startingFileDirecotry = new File("C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\02 - Documents for Processing\\Ontolog - messageforumcontent");
	
	static String resultsLocation = "C:\\Users\\sdavids6\\Google Drive\\Bedford\\Projects\\03 - Results and Data\\OrganizationCultureClassification01.csv";
	
	static String projectName = "OrganizationalCultureProfile";

	static String serverToQuery = "localhost"; // "http://lsci-teragram.slis.kent.edu/"
	static TgMCatHandle sasServerH = null;

	static FileWriter fileWriter = null;
	static PrintWriter printWriter = null;

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
						file.getParent().lastIndexOf("\\"))
						+ "starting the analysis process for _ "
						+ file.getName());

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

	public static void saveToTheResults(TgMCatQueryResult resultstosave,
			File file) throws IOException {

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
				for (int j = 0; j < resultstosave.getNbMatchesForCategory(i) ; j++) {
					
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
}
