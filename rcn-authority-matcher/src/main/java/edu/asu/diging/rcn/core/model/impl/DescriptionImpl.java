package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.BiogHist;
import edu.asu.diging.rcn.core.model.ExistDates;
import edu.asu.diging.rcn.core.model.Function;
import edu.asu.diging.rcn.core.model.Functions;
import edu.asu.diging.rcn.core.model.GeneralContext;
import edu.asu.diging.rcn.core.model.LanguageUsed;
import edu.asu.diging.rcn.core.model.LanguagesUsed;
import edu.asu.diging.rcn.core.model.LegalStatus;
import edu.asu.diging.rcn.core.model.LegalStatuses;
import edu.asu.diging.rcn.core.model.LocalDescription;

@Entity
public class DescriptionImpl {

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
    
    @OneToOne(targetEntity=FunctionsImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Functions functionsElement;
    
    @OneToOne(targetEntity=GeneralContextImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private GeneralContext generalContext;
    
    @OneToOne(targetEntity=LanguageUsedImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private LanguageUsed languageUsed;
    
    @OneToOne(targetEntity=LanguagesUsedImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private LanguagesUsed languagesUsed;
    
    @OneToOne(targetEntity=LegalStatusImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private LegalStatus legalStatus;
    
    @OneToOne(targetEntity=LegalStatusesImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private LegalStatuses legalStatuses;
    
    @OneToOne(targetEntity=LocalDescriptionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private LocalDescription localDescription;
}
