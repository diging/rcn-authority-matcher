package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Address;
import edu.asu.diging.rcn.core.model.AddressLine;

@Entity
public class AddressImpl implements Address {

    @Id
    @GeneratedValue(generator = "address_id_generator")
    @GenericGenerator(name = "address_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "AD"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=AddressLineImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<AddressLine> addressLines;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#getAddressLines()
     */
    @Override
    public List<AddressLine> getAddressLines() {
        return addressLines;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Address#setAddressLines(java.util.List)
     */
    @Override
    public void setAddressLines(List<AddressLine> addressLines) {
        this.addressLines = addressLines;
    }
}
