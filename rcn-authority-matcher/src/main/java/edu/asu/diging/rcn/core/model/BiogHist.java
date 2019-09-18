package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface BiogHist {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<String> getPs();

    void setPs(List<String> ps);

    Abstract getAbstractText();

    void setAbstractText(Abstract abstractText);

    ChronList getChronList();

    void setChronList(ChronList chronList);

    List<Citation> getCitations();

    void setCitations(List<Citation> citations);

    ItemList getItemList();

    void setItemList(ItemList itemList);

    Outline getOutline();

    void setOutline(Outline outline);

}