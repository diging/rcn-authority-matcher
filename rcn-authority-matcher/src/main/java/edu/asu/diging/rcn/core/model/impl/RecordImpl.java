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

import edu.asu.diging.rcn.core.model.ConventionDeclaration;
import edu.asu.diging.rcn.core.model.Description;
import edu.asu.diging.rcn.core.model.Identity;
import edu.asu.diging.rcn.core.model.LanguageDeclaration;
import edu.asu.diging.rcn.core.model.LocalControl;
import edu.asu.diging.rcn.core.model.LocalTypeDeclaration;
import edu.asu.diging.rcn.core.model.MaintenanceAgency;
import edu.asu.diging.rcn.core.model.MaintenanceEvent;
import edu.asu.diging.rcn.core.model.Relations;
import edu.asu.diging.rcn.core.model.RightsDeclaration;
import edu.asu.diging.rcn.core.model.SetComponent;
import edu.asu.diging.rcn.core.model.Source;

@Entity
public class RecordImpl {

    @Id
    @GeneratedValue(generator = "record_id_generator")
    @GenericGenerator(name = "record_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "RE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @OneToMany(targetEntity=ConventionDeclarationImpl.class)
    private List<ConventionDeclaration> conventionDeclarations;
    
    @OneToOne(targetEntity=LanguageDeclarationImpl.class, mappedBy="record")
    private LanguageDeclaration languageDeclaration;
    
    @OneToMany(targetEntity=LocalTypeDeclarationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="record")
    private List<LocalTypeDeclaration> localTypeDeclarations;
    
    @OneToMany(targetEntity=LocalControlImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LocalControl> localControls;
    
    @OneToOne(targetEntity=MaintenanceAgencyImpl.class, mappedBy="record")
    private MaintenanceAgency maintenanceAgency;
    
    private String maintenanceStatus;
    
    private String otherRecordId;
    
    @OneToMany(targetEntity=MaintenanceEventImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<MaintenanceEvent> maintenanceEventHistory;
    
    private String publicationStatus;
    
    private String recordId;
    
    @OneToOne(targetEntity=RightsDeclarationImpl.class)
    private RightsDeclaration rightsDeclaration;
    
    @OneToMany(targetEntity=SourceImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Source> sources;
    
    @OneToMany(targetEntity=IdentityImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Identity> identities;
    
    @OneToMany(targetEntity=DescriptionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Description> description;
    
    @OneToMany(targetEntity=RelationsImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Relations> relations;
    
    @OneToMany(targetEntity=SetComponentImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<SetComponent> setComponents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ConventionDeclaration> getConventionDeclarations() {
        return conventionDeclarations;
    }

    public void setConventionDeclarations(List<ConventionDeclaration> conventionDeclarations) {
        this.conventionDeclarations = conventionDeclarations;
    }

    public LanguageDeclaration getLanguageDeclaration() {
        return languageDeclaration;
    }

    public void setLanguageDeclaration(LanguageDeclaration languageDeclaration) {
        this.languageDeclaration = languageDeclaration;
    }

    public List<LocalTypeDeclaration> getLocalTypeDeclarations() {
        return localTypeDeclarations;
    }

    public void setLocalTypeDeclarations(List<LocalTypeDeclaration> localTypeDeclarations) {
        this.localTypeDeclarations = localTypeDeclarations;
    }

    public List<LocalControl> getLocalControls() {
        return localControls;
    }

    public void setLocalControls(List<LocalControl> localControls) {
        this.localControls = localControls;
    }

    public MaintenanceAgency getMaintenanceAgency() {
        return maintenanceAgency;
    }

    public void setMaintenanceAgency(MaintenanceAgency maintenanceAgency) {
        this.maintenanceAgency = maintenanceAgency;
    }

    public String getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(String maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }

    public String getOtherRecordId() {
        return otherRecordId;
    }

    public void setOtherRecordId(String otherRecordId) {
        this.otherRecordId = otherRecordId;
    }

    public List<MaintenanceEvent> getMaintenanceEventHistory() {
        return maintenanceEventHistory;
    }

    public void setMaintenanceEventHistory(List<MaintenanceEvent> maintenanceEventHistory) {
        this.maintenanceEventHistory = maintenanceEventHistory;
    }

    public String getPublicationStatus() {
        return publicationStatus;
    }

    public void setPublicationStatus(String publicationStatus) {
        this.publicationStatus = publicationStatus;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public RightsDeclaration getRightsDeclaration() {
        return rightsDeclaration;
    }

    public void setRightsDeclaration(RightsDeclaration rightsDeclaration) {
        this.rightsDeclaration = rightsDeclaration;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<Identity> getIdentities() {
        return identities;
    }

    public void setIdentities(List<Identity> identities) {
        this.identities = identities;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<Relations> getRelations() {
        return relations;
    }

    public void setRelations(List<Relations> relations) {
        this.relations = relations;
    }

    public List<SetComponent> getSetComponents() {
        return setComponents;
    }

    public void setSetComponents(List<SetComponent> setComponents) {
        this.setComponents = setComponents;
    }
    
}
