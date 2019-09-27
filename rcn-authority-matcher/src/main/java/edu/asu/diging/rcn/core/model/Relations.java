package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Relations {

    String getId();

    void setId(String id);

    List<CpfRelation> getCpfRelations();

    void setCpfRelations(List<CpfRelation> cpfRelations);

    List<FunctionRelation> getFunctionRelations();

    void setFunctionRelations(List<FunctionRelation> functionRelations);

    List<ResourceRelation> getResourceRelations();

    void setResourceRelations(List<ResourceRelation> resourceRelations);

}