package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Address {

    String getId();

    void setId(String id);

    String getLocalType();

    void setLocalType(String localType);

    List<AddressLine> getAddressLines();

    void setAddressLines(List<AddressLine> addressLines);

}