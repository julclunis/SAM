/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customCommonUtilityClasses;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;

/**
 *    Documentation
    http://commons.apache.org/proper/commons-io/download_io.cgi
    http://commons.apache.org/proper/commons-io/apidocs/overview-summary.html
    http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileUtils.html#readFileToString%28java.io.File%29
    http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
    http://www.tutorialspoint.com/java/io/java_io_bufferedreader.htm
    http://docs.oracle.com/javase/7/docs/api/javax/swing/text/JTextComponent.html#read%28java.io.Reader%2C%20java.lang.Object%29
    http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    http://www.java-tips.org/java-se-tips/java.io/how-to-read-file-in-java.html
    http://stackoverflow.com/questions/18584228/java-program-find-string-length-from-user-input
    http://stackoverflow.com/questions/13585327/getting-text-read-from-a-file-into-a-jframe
    http://www.homeandlearn.co.uk/java/read_a_textfile_in_java.html
    http://docs.oracle.com/javase/7/docs/api/java/io/DataInputStream.html
   
    
    // http://stackoverflow.com/questions/1660034/replace-last-part-of-string
    // http://www.ibiblio.org/xml/books/xmljava/chapters/ch03s03.html
 * @author Sammy Transforming Text Between ContentTypes within Java
 */

public class HelperClass {


    //need configuring
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }

    //need testing
    public static String[] splitByNumber(String s, int chunkSize) {
        int chunkCount = (s.length() / chunkSize) + (s.length() % chunkSize == 0 ? 0 : 1);
        String[] returnVal = new String[chunkCount];
        for (int i = 0; i < chunkCount; i++) {
            returnVal[i] = s.substring(i * chunkSize, Math.min((i + 1) * chunkSize - 1, s.length()));
        }
        return returnVal;
    }

    //needs removed or functional
    public static void makesomethinghappn() { //http://stackoverflow.com/questions/2885173/java-how-to-create-and-write-to-a-file
        Writer writer = null;                 // for more reading from the source that gave them http://docs.oracle.com/javase/tutorial/essential/io/file.html

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));
            writer.write("Something");
        } catch (IOException ex) {
            // report
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }

    }

    //wasteful
    public static String readContentFromText(File filetoberead) {

        String contentToReturn = null;
        try {
            contentToReturn = FileUtils.readFileToString(filetoberead);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return contentToReturn;

    }
    
    


}



//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//
//import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
//import java.io.OutputStream;
