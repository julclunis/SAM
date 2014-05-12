/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Sammy
 */
public class SemanticAnalysisProjectConfigurationMetadata {


  
    private String OCApiKey;
    private String MaxSizeForDocPerOCCall;
    private String FileType;
    private boolean includeSocialTags;
    private String LocationForCallBackToSave;
    private String LocationForExtractEntities;
   

    /**
     * Get the value of includeSocialTags
     *
     * @return the value of includeSocialTags
     */
    public boolean isIncludeSocialTags() {
        return includeSocialTags;
    }

    /**
     * Set the value of includeSocialTags
     *
     * @param includeSocialTags new value of includeSocialTags
     */
    public void setIncludeSocialTags(boolean includeSocialTags) {
        this.includeSocialTags = includeSocialTags;
    }

    /**
     * Get the value of LocationForExtractEntities
     *
     * @return the value of LocationForExtractEntities
     */
    public String getLocationForExtractEntities() {
        return LocationForExtractEntities;
    }

    /**
     * Set the value of LocationForExtractEntities
     *
     * @param LocationForExtractEntities new value of LocationForExtractEntities
     */
    public void setLocationForExtractEntities(String LocationForExtractEntities) {
        this.LocationForExtractEntities = LocationForExtractEntities;
    }

    /**
     * Get the value of LocationForCallBackToSave
     *
     * @return the value of LocationForCallBackToSave
     */
    public String getLocationForCallBackToSave() {
        return LocationForCallBackToSave;
    }

    /**
     * Set the value of LocationForCallBackToSave
     *
     * @param LocationForCallBackToSave new value of LocationForCallBackToSave
     */
    public void setLocationForCallBackToSave(String LocationForCallBackToSave) {
        this.LocationForCallBackToSave = LocationForCallBackToSave;
    }

    /**
     * Get the value of FileType
     *
     * @return the value of FileType
     */
    public String getFileType() {
        return FileType;
    }

    /**
     * Set the value of FileType
     *
     * @param FileType new value of FileType
     */
    public void setFileType(String FileType) {
        this.FileType = FileType;
    }

    /**
     * Get the value of MaxSizeForDocPerOCCall
     *
     * @return the value of MaxSizeForDocPerOCCall
     */
    public String getMaxSizeForDocPerOCCall() {
        return MaxSizeForDocPerOCCall;
    }

    /**
     * Set the value of MaxSizeForDocPerOCCall
     *
     * @param MaxSizeForDocPerOCCall new value of MaxSizeForDocPerOCCall
     */
    public void setMaxSizeForDocPerOCCall(String MaxSizeForDocPerOCCall) {
        this.MaxSizeForDocPerOCCall = MaxSizeForDocPerOCCall;
    }

    /**
     * Get the value of OCApiKey
     *
     * @return the value of OCApiKey
     */
    public String getOCApiKey() {
        return OCApiKey;
    }

    /**
     * Set the value of OCApiKey
     *
     * @param OCApiKey new value of OCApiKey
     */
    public void setOCApiKey(String OCApiKey) {
        this.OCApiKey = OCApiKey;
    }

    //project document workflow saving
}
