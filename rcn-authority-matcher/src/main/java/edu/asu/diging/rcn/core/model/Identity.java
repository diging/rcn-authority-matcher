package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Identity {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    String getIdentityType();

    void setIdentityType(String identityType);

    EntityId getEntityId();

    void setEntityId(EntityId entityId);

    EntityType getEntityType();

    void setEntityType(EntityType entityType);

    String getDescriptiveNote();

    void setDescriptiveNote(String descriptiveNote);

    List<NameEntry> getNameEntries();

    void setNameEntries(List<NameEntry> nameEntries);

    List<NameEntryParallel> getNameEntriesParallel();

    void setNameEntriesParallel(List<NameEntryParallel> nameEntriesParallel);

}