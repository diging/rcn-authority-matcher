package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Item;
import edu.asu.diging.rcn.core.model.Level;

public class LevelImpl implements Level {

    @Id
    @GeneratedValue(generator = "level_id_generator")
    @GenericGenerator(name = "level_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "LE"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=LevelImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<LevelImpl> subLevels;
    
    @OneToMany(targetEntity=ItemImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> items;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#getSubLevels()
     */
    @Override
    public List<LevelImpl> getSubLevels() {
        return subLevels;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#setSubLevels(java.util.List)
     */
    @Override
    public void setSubLevels(List<LevelImpl> subLevels) {
        this.subLevels = subLevels;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#getItems()
     */
    @Override
    public List<Item> getItems() {
        return items;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Level#setItems(java.util.List)
     */
    @Override
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
