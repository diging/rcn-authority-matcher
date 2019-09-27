package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.CpfRelation;
import edu.asu.diging.rcn.core.model.FunctionRelation;
import edu.asu.diging.rcn.core.model.Relations;
import edu.asu.diging.rcn.core.model.ResourceRelation;

@Entity
public class RelationsImpl implements Relations {

    @Id
    @GeneratedValue(generator = "relation_id_generator")
    @GenericGenerator(name = "relation_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "REL"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    @OneToMany(targetEntity=CpfRelationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<CpfRelation> cpfRelations;

    @OneToMany(targetEntity=FunctionRelationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<FunctionRelation> functionRelations;

    @OneToMany(targetEntity=ResourceRelationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ResourceRelation> resourceRelations;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#getCpfRelations()
     */
    @Override
    public List<CpfRelation> getCpfRelations() {
        return cpfRelations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#setCpfRelations(java.util.List)
     */
    @Override
    public void setCpfRelations(List<CpfRelation> cpfRelations) {
        this.cpfRelations = cpfRelations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#getFunctionRelations()
     */
    @Override
    public List<FunctionRelation> getFunctionRelations() {
        return functionRelations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#setFunctionRelations(java.util.List)
     */
    @Override
    public void setFunctionRelations(List<FunctionRelation> functionRelations) {
        this.functionRelations = functionRelations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#getResourceRelations()
     */
    @Override
    public List<ResourceRelation> getResourceRelations() {
        return resourceRelations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Relations#setResourceRelations(java.util.List)
     */
    @Override
    public void setResourceRelations(List<ResourceRelation> resourceRelations) {
        this.resourceRelations = resourceRelations;
    }
}
