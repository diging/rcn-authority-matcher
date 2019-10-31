package edu.asu.diging.rcn.core.model.match.impl;

import edu.asu.diging.eaccpf.model.match.MasterMatch;
import edu.asu.diging.eaccpf.model.match.Match;
import edu.asu.diging.rcn.core.model.match.IMatchResult;
import edu.asu.diging.rcn.core.model.match.IRecordPresentation;

public class MatchResult implements IMatchResult {

    private Match match;
    private MasterMatch master;
    private IRecordPresentation baseRecord;
    private IRecordPresentation matchedRecord;
    
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#getMatch()
     */
    @Override
    public Match getMatch() {
        return match;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#setMatch(edu.asu.diging.eaccpf.model.match.Match)
     */
    @Override
    public void setMatch(Match match) {
        this.match = match;
    }
    @Override
    public MasterMatch getMaster() {
        return master;
    }
    @Override
    public void setMaster(MasterMatch master) {
        this.master = master;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#getBaseRecord()
     */
    @Override
    public IRecordPresentation getBaseRecord() {
        return baseRecord;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#setBaseRecord(edu.asu.diging.eaccpf.model.Record)
     */
    @Override
    public void setBaseRecord(IRecordPresentation baseRecord) {
        this.baseRecord = baseRecord;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#getMatchedRecord()
     */
    @Override
    public IRecordPresentation getMatchedRecord() {
        return matchedRecord;
    }
    /* (non-Javadoc)
     * @see edu.asu.diging.rcn.core.model.match.IMatchRecord#setMatchedRecord(edu.asu.diging.eaccpf.model.Record)
     */
    @Override
    public void setMatchedRecord(IRecordPresentation matchedRecord) {
        this.matchedRecord = matchedRecord;
    }
    
    
}
