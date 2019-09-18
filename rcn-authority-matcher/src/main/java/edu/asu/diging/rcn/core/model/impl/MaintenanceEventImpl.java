package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.DateTime;
import edu.asu.diging.rcn.core.model.MaintenanceEvent;

public class MaintenanceEventImpl implements MaintenanceEvent {

    @Id
    @GeneratedValue(generator = "mainEvent_id_generator")
    @GenericGenerator(name = "mainEvent_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "ME"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String agent;
    private String agentType;
    private String eventType;
    private String eventDescription;
    private DateTime eventDateTime;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getId()
     */
    @Override
    public String getId() {
        return id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getAgent()
     */
    @Override
    public String getAgent() {
        return agent;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setAgent(java.lang.String)
     */
    @Override
    public void setAgent(String agent) {
        this.agent = agent;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getAgentType()
     */
    @Override
    public String getAgentType() {
        return agentType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setAgentType(java.lang.String)
     */
    @Override
    public void setAgentType(String agentType) {
        this.agentType = agentType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getEventType()
     */
    @Override
    public String getEventType() {
        return eventType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setEventType(java.lang.String)
     */
    @Override
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getEventDescription()
     */
    @Override
    public String getEventDescription() {
        return eventDescription;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setEventDescription(java.lang.String)
     */
    @Override
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#getEventDateTime()
     */
    @Override
    public DateTime getEventDateTime() {
        return eventDateTime;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.MaintenanceEvent#setEventDateTime(edu.asu.diging.rcn.core.model.DateTime)
     */
    @Override
    public void setEventDateTime(DateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }
    
}
