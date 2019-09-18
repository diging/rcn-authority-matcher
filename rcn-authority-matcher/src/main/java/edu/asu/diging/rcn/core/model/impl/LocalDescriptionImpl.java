package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Citation;
import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;
import edu.asu.diging.rcn.core.model.LocalDescription;
import edu.asu.diging.rcn.core.model.PlaceEntry;
import edu.asu.diging.rcn.core.model.Term;

@Entity
public class LocalDescriptionImpl implements LocalDescription {

    @Id
    @GeneratedValue(generator = "localDesc_id_generator")
    @GenericGenerator(name = "localDesc_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LDE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=CitationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Citation> citations;
    
    @OneToOne(targetEntity=DateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Date date;
    
    @OneToOne(targetEntity=DateRangeImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateRange dateRange;
    
    @OneToOne(targetEntity=DateSetImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private DateSet dateSet;
    
    @ElementCollection
    private List<String> descriptiveNote;
    
    @OneToOne(targetEntity=PlaceEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private PlaceEntry placeEntry;
    
    @OneToOne(targetEntity=TermImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Term term;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getCitations()
     */
    @Override
    public List<Citation> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getDate()
     */
    @Override
    public Date getDate() {
        return date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setDate(edu.asu.diging.rcn.core.model.Date)
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getDateSet()
     */
    @Override
    public DateSet getDateSet() {
        return dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setDateSet(edu.asu.diging.rcn.core.model.DateSet)
     */
    @Override
    public void setDateSet(DateSet dateSet) {
        this.dateSet = dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getPlaceEntry()
     */
    @Override
    public PlaceEntry getPlaceEntry() {
        return placeEntry;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setPlaceEntry(edu.asu.diging.rcn.core.model.PlaceEntry)
     */
    @Override
    public void setPlaceEntry(PlaceEntry placeEntry) {
        this.placeEntry = placeEntry;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#getTerm()
     */
    @Override
    public Term getTerm() {
        return term;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.LocalDescription#setTerm(edu.asu.diging.rcn.core.model.Term)
     */
    @Override
    public void setTerm(Term term) {
        this.term = term;
    }
    
}
