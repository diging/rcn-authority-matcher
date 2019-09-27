package edu.asu.diging.rcn.core.model;

import java.util.List;

public interface Description {

    String getId();

    void setId(String id);

    BiogHist getBiogHist();

    void setBiogHist(BiogHist biogHist);

    ExistDates getExistDates();

    void setExistDates(ExistDates existDates);

    List<Function> getFunctions();

    void setFunctions(List<Function> functions);

    List<Functions> getFunctionsElement();

    void setFunctionsElement(List<Functions> functionsElement);

    GeneralContext getGeneralContext();

    void setGeneralContext(GeneralContext generalContext);

    List<LanguageUsed> getLanguagesUsed();

    void setLanguagesUsed(List<LanguageUsed> languagesUsed);

    List<LanguagesUsed> getLanguagesUsedGroups();

    void setLanguagesUsedGroups(List<LanguagesUsed> languagesUsedGroups);

    List<LegalStatus> getLegalStatuses();

    void setLegalStatuses(List<LegalStatus> legalStatuses);

    List<LegalStatuses> getLegalStatuseGroups();

    void setLegalStatuseGroups(List<LegalStatuses> legalStatuseGroups);

    List<LocalDescription> getLocalDescriptions();

    void setLocalDescriptions(List<LocalDescription> localDescriptions);

    List<LocalDescriptions> getLocalDescriptionGroups();

    void setLocalDescriptionGroups(List<LocalDescriptions> localDescriptionGroups);

    List<Mandate> getMandates();

    void setMandates(List<Mandate> mandates);

    List<Mandates> getMandateGroups();

    void setMandateGroups(List<Mandates> mandateGroups);

    List<Occupation> getOccupations();

    void setOccupations(List<Occupation> occupations);

    List<Occupations> getOccupationGroups();

    void setOccupationGroups(List<Occupations> occupationGroups);

    List<Place> getPlaces();

    void setPlaces(List<Place> places);

    List<Places> getPlaceGroups();

    void setPlaceGroups(List<Places> placeGroups);

    List<StructureOrGenealogy> getStructureGenealogy();

    void setStructureGenealogy(List<StructureOrGenealogy> structureGenealogy);

}