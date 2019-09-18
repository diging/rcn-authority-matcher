package edu.asu.diging.rcn.core.model;

public interface MaintenanceEvent {

    String getId();

    void setId(String id);

    String getAgent();

    void setAgent(String agent);

    String getAgentType();

    void setAgentType(String agentType);

    String getEventType();

    void setEventType(String eventType);

    String getEventDescription();

    void setEventDescription(String eventDescription);

    DateTime getEventDateTime();

    void setEventDateTime(DateTime eventDateTime);

}