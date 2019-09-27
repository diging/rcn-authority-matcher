package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Mandates {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<Citation> getCitations();

    void setCitations(List<Citation> citations);

    ItemList getItemList();

    void setItemList(ItemList itemList);

    Outline getOutline();

    void setOutline(Outline outline);

    List<String> getPs();

    void setPs(List<String> ps);

    List<String> getDescriptiveNote();

    void setDescriptiveNote(List<String> descriptiveNote);

    List<Mandate> getMandates();

    void setMandates(List<Mandate> mandates);

}