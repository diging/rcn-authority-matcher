package edu.asu.diging.rcn.web.auth.forms;

public class MatchDatasetsForm {

    private String baseDataset;
    private String compareDataset;
    
    public String getBaseDataset() {
        return baseDataset;
    }
    public void setBaseDataset(String baseDataset) {
        this.baseDataset = baseDataset;
    }
    public String getCompareDataset() {
        return compareDataset;
    }
    public void setCompareDataset(String compareDataset) {
        this.compareDataset = compareDataset;
    }
       
}
