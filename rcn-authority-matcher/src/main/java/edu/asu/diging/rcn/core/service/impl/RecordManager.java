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
            return record;
        }
        return null;
    }
}
