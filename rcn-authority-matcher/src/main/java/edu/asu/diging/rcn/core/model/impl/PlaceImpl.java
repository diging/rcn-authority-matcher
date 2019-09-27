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

import edu.asu.diging.rcn.core.model.Address;
import edu.asu.diging.rcn.core.model.Citation;
import edu.asu.diging.rcn.core.model.Date;
import edu.asu.diging.rcn.core.model.DateRange;
import edu.asu.diging.rcn.core.model.DateSet;
import edu.asu.diging.rcn.core.model.Place;
import edu.asu.diging.rcn.core.model.PlaceEntry;
import edu.asu.diging.rcn.core.model.PlaceRole;

@Entity
public class PlaceImpl implements Place {

    @Id
    @GeneratedValue(generator = "place_id_generator")
    @GenericGenerator(name = "place_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "PL"), 
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
    
    @OneToMany(targetEntity=AddressImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Address> addresses;
    
    @OneToMany(targetEntity=PlaceEntryImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PlaceEntry> placeEntries;
    
    @OneToMany(targetEntity=PlaceRoleImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<PlaceRole> placeRoles;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getCitations()
     */
    @Override
    public List<Citation> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getDate()
     */
    @Override
    public Date getDate() {
        return date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setDate(edu.asu.diging.rcn.core.model.Date)
     */
    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getDateRange()
     */
    @Override
    public DateRange getDateRange() {
        return dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setDateRange(edu.asu.diging.rcn.core.model.DateRange)
     */
    @Override
    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getDateSet()
     */
    @Override
    public DateSet getDateSet() {
        return dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setDateSet(edu.asu.diging.rcn.core.model.DateSet)
     */
    @Override
    public void setDateSet(DateSet dateSet) {
        this.dateSet = dateSet;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getDescriptiveNote()
     */
    @Override
    public List<String> getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setDescriptiveNote(java.util.List)
     */
    @Override
    public void setDescriptiveNote(List<String> descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getAddresses()
     */
    @Override
    public List<Address> getAddresses() {
        return addresses;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setAddresses(java.util.List)
     */
    @Override
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getPlaceEntries()
     */
    @Override
    public List<PlaceEntry> getPlaceEntries() {
        return placeEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setPlaceEntries(java.util.List)
     */
    @Override
    public void setPlaceEntries(List<PlaceEntry> placeEntries) {
        this.placeEntries = placeEntries;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#getPlaceRoles()
     */
    @Override
    public List<PlaceRole> getPlaceRoles() {
        return placeRoles;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Place#setPlaceRoles(java.util.List)
     */
    @Override
    public void setPlaceRoles(List<PlaceRole> placeRoles) {
        this.placeRoles = placeRoles;
    }
}
