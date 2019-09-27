package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;
import edu.asu.diging.rcn.core.model.FunctionRelation;
import edu.asu.diging.rcn.core.model.PlaceEntry;
import edu.asu.diging.rcn.core.model.RelationEntry;

@Entity
public class FunctionRelationImpl implements FunctionRelation {

    @Id
    @GeneratedValue(generator = "cpfRelation_id_generator")
    @GenericGenerator(name = "cpfRelation_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "CPFR"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String cpfRelationType;
    private String lastDateTimeVerified;
    
    @OneToMany(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Date> date;
    
    @OneToMany(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DateRange> dateRange;
    
    @OneToMany(targetEntity=DateSetImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<DateSet> dateSet;
    
    @ElementCollection
    private List<String> descriptiveNote;
    
    // we'll ignore  objectBinWrap mand objectXMLWrap
    
    @OneToMany(targetEntity=PlaceEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PlaceEntry> placeEntries;
    
    @OneToMany(targetEntity=RelationEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<RelationEntry> relationEntries;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getCpfRelationType()
     */
    @Override
    public String getCpfRelationType() {
        return cpfRelationType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setCpfRelationType(java.lang.String)
     */
    @Override
    public void setCpfRelationType(String cpfRelationType) {
        this.cpfRelationType = cpfRelationType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getLastDateTimeVerified()
     */
    @Override
    public String getLastDateTimeVerified() {
        return lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setLastDateTimeVerified(java.lang.String)
     */
    @Override
    public void setLastDateTimeVerified(String lastDateTimeVerified) {
        this.lastDateTimeVerified = lastDateTimeVerified;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getDate()
     */
    @Override
    public List<Date> getDate() {
        return date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setDate(java.util.List)
     */
    @Override
    public void setDate(List<Date> date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getDateRange()
     */
    @Override
    public List<DateRange> getDateRange() {
        return dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setDateRange(java.util.List)
     */
    @Override
    public void setDateRange(List<DateRange> dateRange) {
        this.dateRange = dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getDateSet()
     */
    @Override
    public List<DateSet> getDateSet() {
        return dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setDateSet(java.util.List)
     */
    @Override
    public void setDateSet(List<DateSet> dateSet) {
        this.dateSet = dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getPlaceEntries()
     */
    @Override
    public List<PlaceEntry> getPlaceEntries() {
        return placeEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setPlaceEntries(java.util.List)
     */
    @Override
    public void setPlaceEntries(List<PlaceEntry> placeEntries) {
        this.placeEntries = placeEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#getRelationEntries()
     */
    @Override
    public List<RelationEntry> getRelationEntries() {
        return relationEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.CpfRelation#setRelationEntries(java.util.List)
     */
    @Override
    public void setRelationEntries(List<RelationEntry> relationEntries) {
        this.relationEntries = relationEntries;
    }
    
}
