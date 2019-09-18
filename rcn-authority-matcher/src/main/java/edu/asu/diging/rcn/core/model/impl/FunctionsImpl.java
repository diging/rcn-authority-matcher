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

import edu.asu.diging.rcn.core.model.Citation;
import edu.asu.diging.rcn.core.model.Function;
import edu.asu.diging.rcn.core.model.Functions;
import edu.asu.diging.rcn.core.model.ItemList;
import edu.asu.diging.rcn.core.model.Outline;

@Entity
public class FunctionsImpl implements Functions {

    @Id
    @GeneratedValue(generator = "funcs_id_generator")
    @GenericGenerator(name = "funcs_id_generator",    
                    parameters = @Parameter(name = "prefix", value = "FS"), 
                    strategy = "edu.asu.diging.rcn.core.data.IdGenerator"
            )
    private String id;
    
    private String localType;
    
    @OneToMany(targetEntity=CitationImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Citation> citations;
    
    private String descriptiveNote;
    
    @OneToMany(targetEntity=FunctionImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Function> functions;
    
    @OneToOne(targetEntity=ItemListImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private ItemList itemList;
    
    @OneToOne(targetEntity=OutlineImpl.class, cascade=CascadeType.ALL, orphanRemoval=true)
    private Outline outline;
    
    @ElementCollection
    private List<String> ps;

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getId()
     */
    @Override
    public String getId() {
        return id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setId(java.lang.String)
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getLocalType()
     */
    @Override
    public String getLocalType() {
        return localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setLocalType(java.lang.String)
     */
    @Override
    public void setLocalType(String localType) {
        this.localType = localType;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getCitations()
     */
    @Override
    public List<Citation> getCitations() {
        return citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setCitations(java.util.List)
     */
    @Override
    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getDescriptiveNote()
     */
    @Override
    public String getDescriptiveNote() {
        return descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setDescriptiveNote(java.lang.String)
     */
    @Override
    public void setDescriptiveNote(String descriptiveNote) {
        this.descriptiveNote = descriptiveNote;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getFunctions()
     */
    @Override
    public List<Function> getFunctions() {
        return functions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setFunctions(java.util.List)
     */
    @Override
    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getItemList()
     */
    @Override
    public ItemList getItemList() {
        return itemList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setItemList(edu.asu.diging.rcn.core.model.ItemList)
     */
    @Override
    public void setItemList(ItemList itemList) {
        this.itemList = itemList;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getOutline()
     */
    @Override
    public Outline getOutline() {
        return outline;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setOutline(edu.asu.diging.rcn.core.model.Outline)
     */
    @Override
    public void setOutline(Outline outline) {
        this.outline = outline;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#getPs()
     */
    @Override
    public List<String> getPs() {
        return ps;
    }

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.Functions#setPs(java.util.List)
     */
    @Override
    public void setPs(List<String> ps) {
        this.ps = ps;
    }
    
    
}
