package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Item;
import edu.asu.diging.rcn.core.model.ItemList;

@Entity
public class ItemListImpl implements ItemList {

    @Id
    @GeneratedValue(generator = "itemList_id_generator")
    @GenericGenerator(name = "itemList_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "IL"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=ItemImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Item> items;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#getItems()
     */
    @Override
    public List<Item> getItems() {
        return items;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ItemList#setItems(java.util.List)
     */
    @Override
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
