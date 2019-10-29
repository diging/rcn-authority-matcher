package edu.asu.diging.rcn.core.model.match;

import edu.asu.diging.eaccpf.model.Record;
import edu.asu.diging.eaccpf.model.match.Match;

public interface IMatchResult {

    Match getMatch();

    void setMatch(Match match);

    IRecordPresentation getBaseRecord();

    void setBaseRecord(IRecordPresentation baseRecord);

    IRecordPresentation getMatchedRecord();

    void setMatchedRecord(IRecordPresentation matchedRecord);

}