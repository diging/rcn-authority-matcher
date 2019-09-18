package edu.asu.diging.rcn.core.model.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import edu.asu.diging.rcn.core.model.Abstract;
import edu.asu.diging.rcn.core.model.BiogHist;
import edu.asu.diging.rcn.core.model.ChronList;
import edu.asu.diging.rcn.core.model.Citation;
import edu.asu.diging.rcn.core.model.ItemList;
import edu.asu.diging.rcn.core.model.Outline;

@Entity
public class BiogHistImpl implements BiogHist {

    @Id
    @GeneratedValue(generator = "bioHist_id_generator")
    @GenericGenerator(name = "bioHist_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "BH"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @ElementCollection
    private List<String> ps;
    
    @OneToOne(targetEntity=AbstractImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Abstract abstractText;
    
    @OneToOne(targetEntity=ChronListImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private ChronList chronList;
    
    @OneToMany(targetEntity=CitationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Citation> citations;
    
    @OneToOne(targetEntity=ItemListImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private ItemList itemList;
    
    @OneToOne(targetEntity=OutlineImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Outline outline;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getPs()
     */
    @Override
    public List<String> getPs() {
        return ps;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setPs(java.util.List)
     */
    @Override
    public void setPs(List<String> ps) {
        this.ps = ps;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getAbstractText()
     */
    @Override
    public Abstract getAbstractText() {
        return abstractText;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setAbstractText(edu.asu.diging.rcn.core.model.Abstract)
     */
    @Override
    public void setAbstractText(Abstract abstractText) {
        this.abstractText = abstractText;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getChronList()
     */
    @Override
    public ChronList getChronList() {
        return chronList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setChronList(edu.asu.diging.rcn.core.model.ChronList)
     */
    @Override
    public void setChronList(ChronList chronList) {
        this.chronList = chronList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getCitations()
     */
    @Override
    public List<Citation> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getItemList()
     */
    @Override
    public ItemList getItemList() {
        return itemList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setItemList(edu.asu.diging.rcn.core.model.ItemList)
     */
    @Override
    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#getOutline()
     */
    @Override
    public Outline getOutline() {
        return outline;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.BiogHist#setOutline(edu.asu.diging.rcn.core.model.Outline)
     */
    @Override
    public void setOutline(Outline outline) {
        this.outline = outline;
    }
    
}
