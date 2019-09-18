package edu.asu.diging.rcn.core.model;

import java.util.List;

import edu.asu.diging.rcn.core.model.impl.LevelImpl;

public interface Level {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<LevelImpl> getSubLevels();

    void setSubLevels(List<LevelImpl> subLevels);

    List<Item> getItems();

    void setItems(List<Item> items);

}