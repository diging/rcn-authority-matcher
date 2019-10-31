package edu.asu.diging.rcn.core.service;

import java.util.List;
import java.util.Map;

import edu.asu.diging.eaccpf.model.NameEntry;

public interface INameUtility {

    Map<PartType, List<String>> getNameParts(NameEntry entry);

    String getName(NameEntry entry);

}