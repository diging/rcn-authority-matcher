package edu.asu.diging.rcn.core.model;

public enum EntityType {
    PERSON("person"),
    CORPORATE_BODY("corporateBody"),
    FAMILY("family");
    
    private String type;
    
    private EntityType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
}
