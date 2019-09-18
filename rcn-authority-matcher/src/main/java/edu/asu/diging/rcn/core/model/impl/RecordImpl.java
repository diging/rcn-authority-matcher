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

import edu.asu.diging.rcn.core.model.Identity;
import edu.asu.diging.rcn.core.model.LanguageDeclaration;
import edu.asu.diging.rcn.core.model.LocalControl;
import edu.asu.diging.rcn.core.model.LocalTypeDeclaration;
import edu.asu.diging.rcn.core.model.MaintenanceAgency;
import edu.asu.diging.rcn.core.model.MaintenanceEvent;

@Entity
public class RecordImpl {

    @Id
    @GeneratedValue(generator = "record_id_generator")
    @GenericGenerator(name = "record_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "RE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    private String recordId;
    private String maintenanceStatus;
    private String publicationStatus;
    
    @OneToOne(targetEntity=MaintenanceAgencyImpl.class, mappedBy="record")
    private MaintenanceAgency maintenanceAgency;
    @OneToOne(targetEntity=LanguageDeclarationImpl.class, mappedBy="record")
    private LanguageDeclaration languageDeclaration;
    
    @OneToMany(targetEntity=LocalTypeDeclarationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="record")
    private List<LocalTypeDeclaration> localTypeDeclarations;
    
    @OneToMany(targetEntity=LocalControlImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LocalControl> localControls;
    
    @OneToMany(targetEntity=MaintenanceEventImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<MaintenanceEvent> maintenanceEventHistory;
    
    @OneToMany(targetEntity=IdentityImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Identity> identities;
    
    
}
