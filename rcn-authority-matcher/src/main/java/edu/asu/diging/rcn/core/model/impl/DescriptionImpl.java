package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.BiogHist;
import edu.asu.diging.rcn.core.model.Description;
import edu.asu.diging.rcn.core.model.ExistDates;
import edu.asu.diging.rcn.core.model.Function;
import edu.asu.diging.rcn.core.model.Functions;
import edu.asu.diging.rcn.core.model.GeneralContext;
import edu.asu.diging.rcn.core.model.LanguageUsed;
import edu.asu.diging.rcn.core.model.LanguagesUsed;
import edu.asu.diging.rcn.core.model.LegalStatus;
import edu.asu.diging.rcn.core.model.LegalStatuses;
import edu.asu.diging.rcn.core.model.LocalDescription;
import edu.asu.diging.rcn.core.model.LocalDescriptions;
import edu.asu.diging.rcn.core.model.Mandate;
import edu.asu.diging.rcn.core.model.Mandates;
import edu.asu.diging.rcn.core.model.Occupation;
import edu.asu.diging.rcn.core.model.Occupations;
import edu.asu.diging.rcn.core.model.Place;
import edu.asu.diging.rcn.core.model.Places;
import edu.asu.diging.rcn.core.model.StructureOrGenealogy;

@Entity
public class DescriptionImpl implements Description {

    @Id
    @GeneratedValue(generator = "desc_id_generator")
    @GenericGenerator(name = "desc_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "DE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @OneToOne(targetEntity=BiogHistImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private BiogHist biogHist;
    
    @OneToOne(targetEntity=ExistDatesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private ExistDates existDates;
    
    @OneToMany(targetEntity=FunctionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Function> functions;
    
    @OneToMany(targetEntity=FunctionsImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Functions> functionsElement;
    
    @OneToOne(targetEntity=GeneralContextImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private GeneralContext generalContext;
    
    @OneToMany(targetEntity=LanguageUsedImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LanguageUsed> languagesUsed;
    
    @OneToOne(targetEntity=LanguagesUsedImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LanguagesUsed> languagesUsedGroups;
    
    @OneToMany(targetEntity=LegalStatusImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LegalStatus> legalStatuses;
    
    @OneToMany(targetEntity=LegalStatusesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LegalStatuses> legalStatuseGroups;
    
    @OneToMany(targetEntity=LocalDescriptionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LocalDescription> localDescriptions;
    
    @OneToMany(targetEntity=LocalDescriptionsImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LocalDescriptions> localDescriptionGroups;
    
    @OneToMany(targetEntity=MandateImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Mandate> mandates;
    
    @OneToMany(targetEntity=MandatesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Mandates> mandateGroups;
    
    @OneToMany(targetEntity=OccupationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Occupation> occupations;
    
    @OneToMany(targetEntity=OccupationsImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Occupations> occupationGroups;
    
    @OneToMany(targetEntity=PlaceImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Place> places;
    
    @OneToMany(targetEntity=PlacesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Places> placeGroups;
    
    @OneToMany(targetEntity=StructureOrGenealogyImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<StructureOrGenealogy> structureGenealogy;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getBiogHist()
     */
    @Override
    public BiogHist getBiogHist() {
        return biogHist;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setBiogHist(edu.asu.diging.rcn.core.model.BiogHist)
     */
    @Override
    public void setBiogHist(BiogHist biogHist) {
        this.biogHist = biogHist;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getExistDates()
     */
    @Override
    public ExistDates getExistDates() {
        return existDates;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setExistDates(edu.asu.diging.rcn.core.model.ExistDates)
     */
    @Override
    public void setExistDates(ExistDates existDates) {
        this.existDates = existDates;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getFunctions()
     */
    @Override
    public List<Function> getFunctions() {
        return functions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setFunctions(java.util.List)
     */
    @Override
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getFunctionsElement()
     */
    @Override
    public List<Functions> getFunctionsElement() {
        return functionsElement;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setFunctionsElement(java.util.List)
     */
    @Override
    public void setFunctionsElement(List<Functions> functionsElement) {
        this.functionsElement = functionsElement;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getGeneralContext()
     */
    @Override
    public GeneralContext getGeneralContext() {
        return generalContext;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setGeneralContext(edu.asu.diging.rcn.core.model.GeneralContext)
     */
    @Override
    public void setGeneralContext(GeneralContext generalContext) {
        this.generalContext = generalContext;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLanguagesUsed()
     */
    @Override
    public List<LanguageUsed> getLanguagesUsed() {
        return languagesUsed;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLanguagesUsed(java.util.List)
     */
    @Override
    public void setLanguagesUsed(List<LanguageUsed> languagesUsed) {
        this.languagesUsed = languagesUsed;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLanguagesUsedGroups()
     */
    @Override
    public List<LanguagesUsed> getLanguagesUsedGroups() {
        return languagesUsedGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLanguagesUsedGroups(java.util.List)
     */
    @Override
    public void setLanguagesUsedGroups(List<LanguagesUsed> languagesUsedGroups) {
        this.languagesUsedGroups = languagesUsedGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLegalStatuses()
     */
    @Override
    public List<LegalStatus> getLegalStatuses() {
        return legalStatuses;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLegalStatuses(java.util.List)
     */
    @Override
    public void setLegalStatuses(List<LegalStatus> legalStatuses) {
        this.legalStatuses = legalStatuses;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLegalStatuseGroups()
     */
    @Override
    public List<LegalStatuses> getLegalStatuseGroups() {
        return legalStatuseGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLegalStatuseGroups(java.util.List)
     */
    @Override
    public void setLegalStatuseGroups(List<LegalStatuses> legalStatuseGroups) {
        this.legalStatuseGroups = legalStatuseGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLocalDescriptions()
     */
    @Override
    public List<LocalDescription> getLocalDescriptions() {
        return localDescriptions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLocalDescriptions(java.util.List)
     */
    @Override
    public void setLocalDescriptions(List<LocalDescription> localDescriptions) {
        this.localDescriptions = localDescriptions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getLocalDescriptionGroups()
     */
    @Override
    public List<LocalDescriptions> getLocalDescriptionGroups() {
        return localDescriptionGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setLocalDescriptionGroups(java.util.List)
     */
    @Override
    public void setLocalDescriptionGroups(List<LocalDescriptions> localDescriptionGroups) {
        this.localDescriptionGroups = localDescriptionGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getMandates()
     */
    @Override
    public List<Mandate> getMandates() {
        return mandates;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setMandates(java.util.List)
     */
    @Override
    public void setMandates(List<Mandate> mandates) {
        this.mandates = mandates;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getMandateGroups()
     */
    @Override
    public List<Mandates> getMandateGroups() {
        return mandateGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setMandateGroups(java.util.List)
     */
    @Override
    public void setMandateGroups(List<Mandates> mandateGroups) {
        this.mandateGroups = mandateGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getOccupations()
     */
    @Override
    public List<Occupation> getOccupations() {
        return occupations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setOccupations(java.util.List)
     */
    @Override
    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getOccupationGroups()
     */
    @Override
    public List<Occupations> getOccupationGroups() {
        return occupationGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setOccupationGroups(java.util.List)
     */
    @Override
    public void setOccupationGroups(List<Occupations> occupationGroups) {
        this.occupationGroups = occupationGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getPlaces()
     */
    @Override
    public List<Place> getPlaces() {
        return places;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setPlaces(java.util.List)
     */
    @Override
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getPlaceGroups()
     */
    @Override
    public List<Places> getPlaceGroups() {
        return placeGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setPlaceGroups(java.util.List)
     */
    @Override
    public void setPlaceGroups(List<Places> placeGroups) {
        this.placeGroups = placeGroups;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#getStructureGenealogy()
     */
    @Override
    public List<StructureOrGenealogy> getStructureGenealogy() {
        return structureGenealogy;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Description#setStructureGenealogy(java.util.List)
     */
    @Override
    public void setStructureGenealogy(List<StructureOrGenealogy> structureGenealogy) {
        this.structureGenealogy = structureGenealogy;
    }
}
