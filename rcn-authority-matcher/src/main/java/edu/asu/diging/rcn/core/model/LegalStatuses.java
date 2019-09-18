package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface LegalStatuses {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<Citation> getCitations();

    void setCitations(List<Citation> citations);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<LegalStatus> getLegalStatuses();

    void setLegalStatuses(List<LegalStatus> legalStatuses);

    ItemList getItemList();

    void setItemList(ItemList itemList);

    Outline getOutline();

    void setOutline(Outline outline);

    List<String> getPs();

    void setPs(List<String> ps);

}