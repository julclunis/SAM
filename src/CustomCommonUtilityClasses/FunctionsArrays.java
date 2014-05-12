/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomCommonUtilityClasses;

/**
 *
 * @author Sammy
 */
public class FunctionsArrays {

        public static String[] processAndChunkContentAsArrayOfStrings(String contentFromTextFile, int maximumSizeForAnalsys) {

        String[] arrayOfString = null;
        
        arrayOfString = HelperClass.splitByNumber(contentFromTextFile.toString(), maximumSizeForAnalsys);
        System.out.println("Divided file of size " + contentFromTextFile.length() + " by the number of " + arrayOfString.length + ":");
        return arrayOfString;

    }
    public static String[] processAndChunkContentAsArrayOfStrings(String stringContent, String countryName, String fileForDocumentName, int maximumSizeForAnalsys) {

        String[] arrayOfString = null;
        arrayOfString = HelperClass.splitByNumber(stringContent, maximumSizeForAnalsys);
        System.out.println("The " + fileForDocumentName + " file for County " + countryName + " has been split into " + arrayOfString.length + "calls. " + "The total document size was " + stringContent.length());
        return arrayOfString;

    }



}
