package edu.asu.diging.rcn.core.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.diging.eaccpf.data.RecordRepository;
import edu.asu.diging.eaccpf.model.Record;
import edu.asu.diging.eaccpf.model.impl.RecordImpl;
import edu.asu.diging.rcn.core.service.IRecordManager;

@Service
@Transactional
public class RecordManager implements IRecordManager {

    @Autowired
    private RecordRepository recordRepo;
   
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.service.impl.IRecordManager#get(java.lang.String)
     */
    @Override
    public Record get(String id) {
        Optional<RecordImpl> recordOptional = recordRepo.findById(id);
        if (recordOptional.isPresent()) {
            Record record = recordOptional.get();
            if(record.getIdentity() != null) {
                record.getIdentity().getDescriptiveNote().size();
                record.getIdentity().getEntityIds().size();
                record.getIdentity().getNameEntries().forEach(n -> {
                    if(n.getAlternativeForms() != null) {
                        n.getAlternativeForms().size();
                    }
                    if(n.getAuthorizedForms() != null) {
                        n.getAuthorizedForms().size();
                    }
                    if(n.getParts() != null) {
                        n.getParts().size();
                    }
                    if(n.getPreferredForms() != null) {
                        n.getPreferredForms().size();
                    }
                    if(n.getUseDates() != null) {
                        n.getUseDates().getDates().size();
                        n.getUseDates().getDateSets().size();
                        n.getUseDates().getDateRanges().size();
                    }
                });
                record.getIdentity().getNameEntriesParallel().size();
            }
            record.getConventionDeclarations().forEach(c -> c.getDescriptiveNote().size());
            record.getLanguageDeclarations().size();
            record.getLocalTypeDeclarations().forEach(d -> d.getDescriptiveNote().size());
            record.getLocalControls().forEach(c -> c.getDateRanges().size());
            record.getLocalControls().forEach(c -> c.getDates().size());
            record.getMaintenanceAgency().getDescriptiveNote().size();
            record.getMaintenanceEventHistory().forEach(e -> e.getEventDescription().size());
            record.getRightsDeclarations().forEach(d -> d.getDescriptiveNote().size());
            record.getSources().forEach(s -> {
                s.getRelationEntries().size();
                s.getDescriptiveNote().size();
            });
            if (record.getDescription() != null) {
                if (record.getDescription().getBiogHists() != null) {
                    record.getDescription().getBiogHists().forEach(b -> {
                        b.getCitations().size();
                        b.getPs().size();
                    });
                }
                
                if (record.getDescription().getExistDates() != null) {
                    record.getDescription().getExistDates().getDates().size();
                    record.getDescription().getExistDates().getDateRanges().size();
                }
                
                if (record.getDescription().getFunctionsElement() != null) {
                    record.getDescription().getFunctionsElement().forEach(f -> {
                        f.getCitations().size();
                        f.getDescriptiveNote().size();
                        f.getFunctions().size();
                        f.getFunctions().forEach(fu -> {
                            fu.getTerm().getText();
                            fu.getDescriptiveNote().size();
                        });
                        f.getItemLists().size();
                        f.getOutlines().size();
                        f.getPs().size();
                    });
                }
                
                if (record.getDescription().getPlaces() != null) {
                    record.getDescription().getPlaces().forEach(p -> {
                        p.getAddresses().size();
                        p.getCitations().size();
                        p.getDateRanges().size();
                        p.getDates().size();
                        p.getDateSets().size();
                        p.getDescriptiveNote().size();
                        p.getPlaceEntries().size();
                        p.getPlaceRoles().size();
                    });
                }
                
                if (record.getDescription().getPlaceGroups() != null) {
                    record.getDescription().getPlaceGroups().forEach(p -> {
                        p.getCitations().size();
                        p.getDescriptiveNote().size();
                        p.getItemLists().size();
                        p.getOutlines().size();
                        p.getPlaces().forEach(pl -> {
                            pl.getAddresses().size();
                            pl.getCitations().size();
                            pl.getDateRanges().size();
                            pl.getDates().size();
                            pl.getDateSets().size();
                            pl.getDescriptiveNote().size();
                            pl.getPlaceEntries().size();
                            pl.getPlaceRoles().size();
                        });
                        p.getPs().size();
                    });
                }
            }
            
            return record;
        }
        return null;
    }
}
