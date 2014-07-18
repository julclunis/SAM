/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sammy
 */
package ViewModels;

import static CustomCommonUtilityClasses.FunctionsArrays.processAndChunkContentAsArrayOfStrings;

import CustomCommonUtilityClasses.HelperClass;
import Models.SemanticAnalysisProjectConfigurationMetadata;

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

public class SamOpenCalaisEntityExtractionViewModel {

    private File fileMain = null;
    private File directoryForBatchProcessing = null;
    private SemanticAnalysisProjectConfigurationMetadata sam = null;
    private static CalaisClient clientForOpenCalais = null;
    private static CalaisResponse response = null;
    private static CalaisConfig configSetingsForOpenCalais = null;
    private static Writer writer = null;
    private static String fileTextPayoutLocation = null;
    private static FileWriter fw = null;
    private static PrintWriter out = null;
    
    
    
    public SamOpenCalaisEntityExtractionViewModel() { }
    
    public File getFileMain() {
        return fileMain;
    }

    public void setFileMain(File fileMainName) {
        fileMain = fileMainName;
    }

    public File getDirectoryForBatchProcessing() {
        return directoryForBatchProcessing;
    }

    public void setDirectoryForBatchProcessing(File directoryForBatchProcessingName) {
        directoryForBatchProcessing = directoryForBatchProcessingName;
    }

    public SemanticAnalysisProjectConfigurationMetadata getSam() {
        return sam;
    }

    public void setSam(SemanticAnalysisProjectConfigurationMetadata samName) {
        sam = samName;
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

    private void processFileForBatch(File[] fileSourceList) {
        //http://stackoverflow.com/questions/3154488/best-way-to-iterate-through-a-directory-in-java
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

        requestAnalysisForEachStringInArrayFromOpenCalaisAndSave(processAndChunkContentAsArrayOfStrings(HelperClass.readContentFromText(file), 97000), file.getName());

    }

    private void ConfigureAndConnectToOpenCalais() {

        clientForOpenCalais = new CalaisRestClient(sam.getOCApiKey());
        configSetingsForOpenCalais = new CalaisConfig();

        fileTextPayoutLocation = sam.getLocationForCallBackToSave();//"C:\\Users\\Sammy\\Desktop\\payloadfromOCWithSocialTags";

        //   http://www.opencalais.com/documentation/calais-web-service-api/forming-api-calls/input-parameters
        configSetingsForOpenCalais.set(CalaisConfig.ProcessingParam.CALCULATE_RELEVANCE_SCORE, "true");
        // TODO add function to change to see if user wants to receive relevance score
        configSetingsForOpenCalais.set(CalaisConfig.ConnParam.READ_TIMEOUT, 100000);
        configSetingsForOpenCalais.set(CalaisConfig.ConnParam.CONNECT_TIMEOUT, 100000);

    }

    private void requestAnalysisForEachStringInArrayFromOpenCalaisAndSave(String[] contentStringArray, String fileOrignalName) {

        ConfigureAndConnectToOpenCalais();

        for (int numberOfCallPerDocument = 0; numberOfCallPerDocument < contentStringArray.length; numberOfCallPerDocument++) {
            try {
                response = clientForOpenCalais.analyze(contentStringArray[numberOfCallPerDocument], configSetingsForOpenCalais);
                if (response != null) {
                    saveOpenCalaisResults(numberOfCallPerDocument, response.getPayload().toString(), fileOrignalName);
                    extractEntitiesAndSaveFileAsCSV(response, fileOrignalName, numberOfCallPerDocument);
                }

            } catch (IOException e) {
                System.out.println("Error when Getting at openCalais ");
                System.out.println(e.getMessage());
                System.out.println(e.getLocalizedMessage());
                System.out.println(e.getStackTrace().toString());
            }
        }
    }

    private static void saveOpenCalaisResults(int xOf, String responesFromOpenCalais, String nameOfOriginalFile) throws IOException {

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileTextPayoutLocation + "\\" + nameOfOriginalFile + "_" + xOf), "utf-8"));
        writer.write(responesFromOpenCalais);
        writer.close();
  
    }

    private void extractEntitiesAndSaveFileAsCSV(CalaisResponse responseFromOpenCalais, String nameOfOriginalFile, int numberofcalls) {
            //TODO incorporate a way to save extracted entities as RDF or CSV
        try {
            fw = new FileWriter(sam.getLocationForExtractEntities() + "\\" + nameOfOriginalFile+ "_0" +numberofcalls+ ".csv");
            out = new PrintWriter(fw);

            //extract and print results to put put.############################
            for (CalaisObject entity : responseFromOpenCalais.getEntities()) {

                System.out.println(
                        nameOfOriginalFile
                        + "\t" + "   " + entity.getField("_type")
                        + "\t\t" + "   " + entity.getField("relevance")
                        + "\t" + "   " + entity.getField("name"));

                out.print(nameOfOriginalFile);
                out.print(", \t");
                out.print(entity.getField("_type"));
                out.print(", \t \t");
                out.print(entity.getField("relevance"));
                out.print(", \t");
                out.println(entity.getField("name"));

            }

            for (CalaisObject tags : response.getSocialTags()) {

                System.out.println(
                        nameOfOriginalFile
                        + "\t" + "   " + tags.getField("_typeGroup")
                        + "\t\t" + "   " + "-----"
                        + "\t" + "   " + tags.getField("name"));

                out.print(nameOfOriginalFile);
                out.print(",   \t");
                out.print(tags.getField("_typeGroup"));
                out.print(", \t\t");
                out.print(tags.getField("\"-----\""));
                out.print(", \t");
                out.println(tags.getField("name"));

            }
            //TODO code to save or extract more OpenCalais's Objects(metadata)results for extracted entities#######################

        } catch (IOException ioe) {
            System.out.println("There was an issue when sending the content to the opencalais for " + " and for file ");
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
















/*
 * 
 * 
 * 
 */
			// openCalaisAnalysisObject = new
			// SAMOpenCalaisEngine(fileTobeAnalyzied, SAPCM, true);
//         int returnVal = jFileChooser1.showOpenDialog(this);
//         if(returnVal == JFileChooser.APPROVE_OPTION){
//         
//         
//         }
//filePathToAnalyzied = file.toPath();
//jSelectFileToReadTextTextField.read( new FileReader( file.getAbsolutePath() ), null );
//            System.out.println("getCurrentDirectory(): "
//                    + jFileChooser1.getCurrentDirectory());
//            System.out.println("getSelectedFile() : "
//                    + jFileChooser1.getSelectedFile());
//fileMain.getAbsolutePath()
//<editr-fold  desc=" code trash from march/3/2014 ">     //defaultstate="collapsed"
//for (File file : fileSource.listFiles(new FileExtensionFilter("txt"))) {
//        if (file.isDirectory()) {
//           // System.out.println("Directory: " + file.getName());
//            processFileForBatch(file); // Calls same method again.
//        } else {
//    
//        }
//  maximumSizeForAnalsys = Integer.parseInt(sam.getMaxSizeForDocPerOCCall()); //97000;
// CalaisConfig.UserParam.
//</editor-fold>
//<edito-fold  desc=" code variables ">     //defaultstate="collapsed"
//  maximumSizeForAnalsys = Integer.parseInt(sam.getMaxSizeForDocPerOCCall()); //97000;
// CalaisConfig.UserParam.
//</editor-fold>
    
// The semantic engine is going to have a base class constructor. 
// ctor(file file)
// ctor(file directory, boon includeSubDirecotories)
 
    //configure....
//public void ProcessContentFromTextWithOpenCalais(string[] content) 
//publish the results
//module method options or precedure/scripts     
//public void ConsumeTextFromRepository(file repositorylocation){process and prepare}
//this is used to return an array of strings in chunks to be processed by OpenCalai.
//The content can not be 
//<editr-fold defaultstate="collapsed" desc="trash/discarded code ">
//2.0 This is the program decides on what process to activate.
//Based on the user need, he or she will want to:
//          1. copy text to a textpanel
//          2. upload a one file
//          3. batch file processing. 
//if(entity..getField)
//                    } else if(contentFromUI != null){
//                        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileTextPayoutLocation + "\\0" + xf + "0_" + "contentfromui" + ".txt"), "utf-8"));
//                            writer.write(response.getPayload().toString());
//        else if (contentFromUI != null) {
//
//            System.out.println("Processing content from UI File:");
//            arrayofstringsfortesting = processAndChunkContentAsArrayOfStrings(contentFromUI, 97000);
//            requestAnalysisFromOpenCalais(arrayofstringsfortesting);
//
//        } 
//  writer.write(response.getPayload().toString());
//    public static void ProcessFileTextAndCallOpenCalaisRestService(String contentToAnalyze) {
//
//        ConfigureAndConnectToOpenCalais();
//        arrayofstringsfortesting = ProcessAndPrepareContentAsAnArrayOfStrings(contentToAnalyze);
//        SendArrayOfStringsToOpenCalais(arrayofstringsfortesting);
//
//    }
// System.out.println("Configuring and Connecting to OpenCalais:");
//System.out.println("Creating Client and Configuration Settings for OpenCalais: More information can be foud here https://code.google.com/p/j-calais/source/browse/trunk/src/main/java/mx/bigdata/jcalais/CalaisConfig.java?r=55 ");
//    public static void ProcessFileTextAndCallOpenCalaisRestService(File fileRecieved) {
//
//        fileMain = fileRecieved;
//        System.out.println("File: " + fileMain.getName() + "; ");
//        System.out.println("From location: " + fileMain.getAbsolutePath() + "; ");
//        System.out.println("With length of : " + fileMain.length() + "; ");
//
//        ConfigureAndConnectToOpenCalais();
//        arrayofstringsfortesting = ProcessAndPrepareContentAsAnArrayOfStrings(fileMain);
//        SendArrayOfStringsToOpenCalais(arrayofstringsfortesting);
//
//    }
//
//    private static String[] ProcessAndPrepareContentAsAnArrayOfStrings(File fileMain) {
//
//        //System.out.println("Preparing Data to send to OpenCalais");
//        String[] arrayOfString = null;
//
//        //ConvertToStringFromFile--
//       
//        arrayOfString = TTBC.splitByNumber(contentFromTextFile.toString(), maximumSizeForAnalsys);
//
//        //System.out.println("Divided file of size " + contentFromTextFile.length() + " by the number of " + arrayOfString.length + ":");
//        return arrayOfString;
//
//    }
//########################################################################################################################
//
//        System.out.println("The content has been divided and now it is being sent to OpenCalais Web Service API (REST)");
//        System.out.println("The number of calls will be - " + arrayofstringsfortesting.length);
//        System.out.println("Beginning Analysis now ......................................................................................................................");
//   
//              try {
//                  } catch (java.net.SocketTimeoutException e) {
//
//                    System.out.println("#SocketTimeoutException Caught Here -----");
//                    System.out.println(configSetingsForOpenCalais.get(CalaisConfig.ConnParam.READ_TIMEOUT));
//                    System.out.println(configSetingsForOpenCalais.get(CalaisConfig.ConnParam.CONNECT_TIMEOUT));
//                    System.out.println(e.getMessage());
//                    System.out.println(e.getLocalizedMessage());
//                    System.out.println(e.getStackTrace().toString());
//
//                } catch (IOException ex) {
//                    System.out.println("There was an issue with getting response. Response is NULL");
//                    System.out.println("#IOException Caught Here -----");
//                    System.out.println("#4444444444444444444444444444444444-");
//                    System.out.println("There was a issue witht he response from OpenCalais");
//                    System.out.println("We should really put the catch expectuions in here. ");
//                    System.out.println(ex.getMessage());
//                    System.out.println(ex.getLocalizedMessage());
//                    System.out.println(ex.getStackTrace().toString());
//
//                } 
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//  String textToAnalyze, String textFileNameLocationFile, String fileName
//Convert file to Test\string, file name.     
//    filePathToAnalyzed.getName().toString();
//failed//TTBC.readFile(filePathToAnalyzed.toString(), StandardCharsets.UTF_8);
//            br = new FileReader(filePathToAnalyzed);
//            
//            contentFromTextFile = br.
// InputStream is = new FileInputStream(fileToAnalyzed);
//  contentFromTextFile = //IOUtils(is, "UTF-8");
//            
//            
//            contentFromTextFile = new InputStream(new FileReader(filePathToAnalyzed))
//BufferedReader br = null;
//String TextFileNameLoc = textFileNameLocationFile;
//process text
//send array of strings to OpenCalais for analysis. 
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//Create Payout File For Further Analysis. The content is in JSON. 
//System.out.println("Preparing Data to send to OpenCalais");
//  System.out.println("Something nowhere ");
//</editor-fold>
//        try {
//            if (fileTobeAnalyzied != null) {
//                jTextForOpenCalaisToAnalyzeTextPane.read(new FileReader(fileTobeAnalyzied), null);
//            }
//
//        } catch (Exception e) {
//        }
// arrayofstringsfortesting = ;//processAndChunkContentAsArrayOfStrings( 97000);
//, countryDirectoryName.getName().toString(), textFromCountryFileName.getName().toString());
//            fileTobeAnalyzied = file;
// openCalaisAnalysisObject.setFileMain(file);
// System.out.println(fileTobeAnalyzied.isDirectory());
// private static String[] arrayofstringsfortesting = null;
//need to implement for batch constructor
//logFileWriter;
//mulitople files are bing selected at the directory level
// = new SemanticAnalysisProjectConfigurationMetadata();
//openCalaisAnalysisObject.getSam()
//fileTobeAnalyzied.isDirectory()
//------------> now i need to send this along with the file/directory to OpenCalais Semantic Engine Analysis
//            if (openCalaisAnalysisObject.getFileMain()  fileTobeAnalyzied.isDirectory() != true) {   
//
//            openCalaisAnalysisObject = new SAMOpenCalaisEngine(fileTobeAnalyzied, SAPCM);
// private File fileTobeAnalyzied = null;
//private SemanticAnalysisProjectConfigurationMetadata SAPCM = null;
//            // ConfigureAndConnectToOpenCalais();
//            fileLogReport = fileLogReport.concat("\n File: " + fileMain.getName() + "; ");
//            fileLogReport = fileLogReport.concat("\n " + "From location: " + fileMain.getAbsolutePath() + "; ");
//            fileLogReport = fileLogReport.concat("\n " + "With length of : " + fileMain.length() + "; ");
//   ConfigureAndConnectToOpenCalais();
//##################################################################################
//   for (File fileFromBatch : ) {
//<edtor-fold  desc=" need to configure  ">
//   for (File textFromCountryFileName : fileFromBatch.listFiles(new FileExtensionFilter("txt"))) {
//  }
//##################################################################################### //
//</editor-fold> 
//
//    public SAMOpenCalaisEngine(File file, SemanticAnalysisProjectConfigurationMetadata sapcm1) {
//
////        fileMain = file;
////        sam = sapcm1;
//
//  
//    }
//
//    public SAMOpenCalaisEngine(File directoryLocationForBatchProcessing, SemanticAnalysisProjectConfigurationMetadata sapcm1, boolean includeSubDirectories) {
//
////        directoryForBatchProcessing = directoryLocationForBatchProcessing;
////        sam = sapcm1;
//    }
    //////////////////////////////////////////
  //  private static String fileLogReport = null;

               // System.out.println("stringbuliderdirectory" + strbif.toString());
//      shortName =   shortName.c" ------" +oncat(" ------" + perfile.getName());
                // shortName =  shortName.concat(); 
                //  System.out.println(perfile.getName());
                // File[] listofDirecotyrandfile =  openCalaisAnalysisObject.getDirectoryForBatchProcessing().listFiles();
                //System.out.println(sourfilestuff[0].)
        //save json returned from ##########################################
        //  if (fileMain != null) {
      //  }*/