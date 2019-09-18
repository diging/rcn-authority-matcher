package edu.asu.diging.rcn.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Abstract;

@Entity
public class AbstractImpl implements Abstract {

    @Id
    @GeneratedValue(generator = "abstract_id_generator")
    @GenericGenerator(name = "abstract_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "AB"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String text;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Abstract#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Abstract#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Abstract#getText()
     */
    @Override
    public String getText() {
        return text;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Abstract#setText(java.lang.String)
     */
    @Override
    public void setText(String text) {
        this.text = text;
    }
    
}
