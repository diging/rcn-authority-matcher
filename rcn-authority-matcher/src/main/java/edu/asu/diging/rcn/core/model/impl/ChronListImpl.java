package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.ChronItem;
import edu.asu.diging.rcn.core.model.ChronList;

@Entity
public class ChronListImpl implements ChronList {

    @Id
    @GeneratedValue(generator = "chronList_id_generator")
    @GenericGenerator(name = "chronList_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "CL"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=ChronItemImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ChronItem> chronItems;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getId()
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setId(java.lang.String)
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getLocalType()
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setLocalType(java.lang.String)
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getChronItems()
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#getChronItems()
     */
    @Override
    public List<ChronItem> getChronItems() {
        return chronItems;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setChronItems(java.util.List)
     */
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronList#setChronItems(java.util.List)
     */
    @Override
    public void setChronItems(List<ChronItem> chronItems) {
        this.chronItems = chronItems;
    }
    
}
