package edu.asu.diging.rcn.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.asu.diging.eaccpf.data.MasterMatchRepository;
import edu.asu.diging.eaccpf.data.MatchRepository;
import edu.asu.diging.eaccpf.model.NameEntry;
import edu.asu.diging.eaccpf.model.Record;
import edu.asu.diging.eaccpf.model.match.MasterMatch;
import edu.asu.diging.eaccpf.model.match.Match;
import edu.asu.diging.eaccpf.model.match.impl.MasterMatchImpl;
import edu.asu.diging.rcn.core.model.match.IMatchResult;
import edu.asu.diging.rcn.core.model.match.IRecordPresentation;
import edu.asu.diging.rcn.core.model.match.impl.MatchResult;
import edu.asu.diging.rcn.core.model.match.impl.RecordPresentation;
import edu.asu.diging.rcn.core.service.IMatchManager;
import edu.asu.diging.rcn.core.service.INameUtility;
import edu.asu.diging.rcn.core.service.IRecordManager;

@Service
@Transactional
public class MatchManager implements IMatchManager {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MasterMatchRepository masterMatchRepo;

    @Autowired
    private IRecordManager recordManager;

    @Autowired
    private INameUtility nameUtility;

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.asu.diging.rcn.core.service.impl.IMatchManager#list(java.lang.String,
     * org.springframework.data.domain.Pageable)
     */
    @Override
    public List<IMatchResult> list(String jobId, Pageable pageable) {
        // List<Object[]> recordIds = matchRepository.getMatchedRecordIds(jobId,
        // pageable);
        List<MasterMatchImpl> matches = masterMatchRepo.findByJobId(jobId, pageable);
        List<IMatchResult> results = new ArrayList<>();
        for (MasterMatch master : matches) {
            IMatchResult result = new MatchResult();
            result.setMaster(master);
            result.setMatch(master.getMaster());
            Record baseRecord = recordManager.get(master.getMaster().getBaseRecordId());
            Record comparedRecord = recordManager.get(master.getMaster().getCompareRecordId());

            IRecordPresentation baseRecordPres = new RecordPresentation();
            baseRecordPres.setNameEntries(getNameEntries(baseRecord));
            baseRecordPres.setRecord(baseRecord);
            baseRecordPres.setNames(new ArrayList<>());
            for (NameEntry entry : baseRecordPres.getNameEntries()) {
                baseRecordPres.getNames().add(nameUtility.getName(entry));
            }
            result.setBaseRecord(baseRecordPres);

            IRecordPresentation compareRecordPres = new RecordPresentation();
            compareRecordPres.setNameEntries(getNameEntries(comparedRecord));
            compareRecordPres.setRecord(comparedRecord);
            compareRecordPres.setNames(new ArrayList<>());
            for (NameEntry entry : compareRecordPres.getNameEntries()) {
                compareRecordPres.getNames().add(nameUtility.getName(entry));
            }
            result.setMatchedRecord(compareRecordPres);

            results.add(result);

        }
        return results;
    }

    @Override
    public int getTotalMatches(String jobId) {
        return matchRepository.countMatchedRecordIds(jobId);
    }

    private List<NameEntry> getNameEntries(Record record) {
        if (record.getIdentity() == null) {
            return Collections.EMPTY_LIST;
        }
        if (record.getIdentity().getNameEntries() == null) {
            return Collections.EMPTY_LIST;
        }

        return record.getIdentity().getNameEntries();
    }
}
