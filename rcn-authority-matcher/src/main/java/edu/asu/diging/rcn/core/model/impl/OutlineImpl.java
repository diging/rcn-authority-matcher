package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Level;
import edu.asu.diging.rcn.core.model.Outline;

@Entity
public class OutlineImpl implements Outline {

    @Id
    @GeneratedValue(generator = "outline_id_generator")
    @GenericGenerator(name = "outline_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "OU"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=LevelImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Level> levels;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#getLevels()
     */
    @Override
    public List<Level> getLevels() {
        return levels;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Outline#setLevels(java.util.List)
     */
    @Override
    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
    
}
