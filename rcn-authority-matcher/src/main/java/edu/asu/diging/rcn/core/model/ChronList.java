package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface ChronList {

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getId()
     */
    String getId();

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setId(java.lang.String)
     */
    void setId(String id);

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getLocalType()
     */
    String getLocalType();

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setLocalType(java.lang.String)
     */
    void setLocalType(String localType);

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#getChronItems()
     */
    List<ChronItem> getChronItems();

    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.impl.ChronItem#setChronItems(java.util.List)
     */
    void setChronItems(List<ChronItem> chronItems);

}