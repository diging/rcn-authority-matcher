package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Item;

@Entity
public class ItemImpl implements Item {

    @Id
    @GeneratedValue(generator = "item_id_generator")
    @GenericGenerator(name = "item_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "IT"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    private String itemText;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#getItemText()
     */
    @Override
    public String getItemText() {
        return itemText;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Item#setItemText(java.lang.String)
     */
    @Override
    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
    
}
