package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface StructureOrGenealogy {

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

}