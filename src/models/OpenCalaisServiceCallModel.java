/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sammy
 */
package models;

import static helper.FunctionsArrays.processAndChunkContentAsArrayOfStrings;
import helper.HelperClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import mx.bigdata.jcalais.CalaisClient;
import mx.bigdata.jcalais.CalaisConfig;
import mx.bigdata.jcalais.CalaisObject;
import mx.bigdata.jcalais.CalaisResponse;
import mx.bigdata.jcalais.rest.CalaisRestClient;

public class OpenCalaisServiceCallModel {

	private File fileMain = null;
	private File directoryForBatchProcessing = null;
	private OpenCalaisConfigurationMetadata sam = null;
	private static CalaisClient clientForOpenCalais = null;
	private static CalaisResponse response = null;
	private static CalaisConfig configSetingsForOpenCalais = null;
	private static Writer writer = null;
	private static String fileTextPayoutLocation = null;
	private static FileWriter fw = null;
	private static PrintWriter out = null;

	public File getFileMain() {
		return fileMain;
	}

	public OpenCalaisConfigurationMetadata getSam() {
		return sam;
	}

	public File getDirectoryForBatchProcessing() {
		return directoryForBatchProcessing;
	}

	public void initiateAndProcessOpenCalaisCall() {

		if (fileMain != null) {
			divideAndAnalyze(fileMain);
		} else if (directoryForBatchProcessing != null) {
			processFileForBatch(directoryForBatchProcessing.listFiles());
		} else {
			System.out.println("not file was submitted for analysis ");
		}

		fileMain = null;
		directoryForBatchProcessing = null;
	}

	public void setDirectoryForBatchProcessing(
			File directoryForBatchProcessingName) {
		directoryForBatchProcessing = directoryForBatchProcessingName;
	}

	public void setSam(OpenCalaisConfigurationMetadata samName) {
		sam = samName;
	}

	public void setFileMain(File fileMainName) {
		fileMain = fileMainName;
	}

	private void processFileForBatch(File[] fileSourceList) {
		// http://stackoverflow.com/questions/3154488/best-way-to-iterate-through-a-directory-in-java
		for (File file : fileSourceList) {
			if (file.isDirectory()) {
				System.out.println("directory: " + file.getName());
				processFileForBatch(file.listFiles());

			} else if (file.getName().endsWith(".txt")) {
				System.out.println("File from Batch: " + file.getName());
				divideAndAnalyze(file);
			}
		}
	}

	private void divideAndAnalyze(File file) {

		requestAnalysisForEachStringInArrayFromOpenCalaisAndSave(processAndChunkContentAsArrayOfStrings(HelperClass.readContentFromText(file), 97000),	file.getName());

	}

	private void ConfigureAndConnectToOpenCalais() {

		clientForOpenCalais = new CalaisRestClient(sam.getOCApiKey());
		configSetingsForOpenCalais = new CalaisConfig();

		fileTextPayoutLocation = sam.getLocationForCallBackToSave();// "C:\\Users\\Sammy\\Desktop\\payloadfromOCWithSocialTags";

		// http://www.opencalais.com/documentation/calais-web-service-api/forming-api-calls/input-parameters
		configSetingsForOpenCalais.set(
				CalaisConfig.ProcessingParam.CALCULATE_RELEVANCE_SCORE, "true");
		// TODO add function to change to see if user wants to receive relevance
		// score
		configSetingsForOpenCalais.set(CalaisConfig.ConnParam.READ_TIMEOUT,
				100000);
		configSetingsForOpenCalais.set(CalaisConfig.ConnParam.CONNECT_TIMEOUT,
				100000);

	}

	private void requestAnalysisForEachStringInArrayFromOpenCalaisAndSave(
			String[] contentStringArray, String fileOrignalName) {

		ConfigureAndConnectToOpenCalais();

		for (int numberOfCallPerDocument = 0; numberOfCallPerDocument < contentStringArray.length; numberOfCallPerDocument++) {
			try {
				response = clientForOpenCalais.analyze(
						contentStringArray[numberOfCallPerDocument],
						configSetingsForOpenCalais);
				if (response != null) {
					saveOpenCalaisResults(numberOfCallPerDocument, response
							.getPayload().toString(), fileOrignalName);
					extractEntitiesAndSaveFileAsCSV(response, fileOrignalName,
							numberOfCallPerDocument);
				}

			} catch (IOException e) {
				System.out.println("Error when Getting at openCalais ");
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getStackTrace().toString());
			}
		}
	}

	private static void saveOpenCalaisResults(int xOf,
			String responesFromOpenCalais, String nameOfOriginalFile)
			throws IOException {

		writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileTextPayoutLocation + "\\"
						+ nameOfOriginalFile + "_" + xOf), "utf-8"));
		writer.write(responesFromOpenCalais);
		writer.close();

	}

	private void extractEntitiesAndSaveFileAsCSV(
			CalaisResponse responseFromOpenCalais, String nameOfOriginalFile,
			int numberofcalls) {
		// TODO incorporate a way to save extracted entities as RDF or CSV
		try {
			fw = new FileWriter(sam.getLocationForExtractEntities() + "\\"
					+ nameOfOriginalFile + "_0" + numberofcalls + ".csv");
			out = new PrintWriter(fw);

			// extract and print results to put put.############################
			for (CalaisObject entity : responseFromOpenCalais.getEntities()) {

				System.out.println(nameOfOriginalFile + "\t" + "   "
						+ entity.getField("_type") + "\t\t" + "   "
						+ entity.getField("relevance") + "\t" + "   "
						+ entity.getField("name"));

				out.print(nameOfOriginalFile);
				out.print(", \t");
				out.print(entity.getField("_type"));
				out.print(", \t \t");
				out.print(entity.getField("relevance"));
				out.print(", \t");
				out.println(entity.getField("name"));

			}

			for (CalaisObject tags : response.getSocialTags()) {

				System.out.println(nameOfOriginalFile + "\t" + "   "
						+ tags.getField("_typeGroup") + "\t\t" + "   "
						+ "-----" + "\t" + "   " + tags.getField("name"));

				out.print(nameOfOriginalFile);
				out.print(",   \t");
				out.print(tags.getField("_typeGroup"));
				out.print(", \t\t");
				out.print(tags.getField("\"-----\""));
				out.print(", \t");
				out.println(tags.getField("name"));

			}
			// TODO code to save or extract more OpenCalais's
			// Objects(metadata)results for extracted
			// entities#######################

		} catch (IOException ioe) {
			System.out
					.println("There was an issue when sending the content to the opencalais for "
							+ " and for file ");
			System.out.println(ioe.getMessage());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("except here one. ");

		} finally {
			try {

				out.flush();
				fw.close();

			} catch (Exception ex) {
				System.out.println("- Final Exception Notification Here");
				System.out.println(ex.getMessage());

			}
		}
	}
}
