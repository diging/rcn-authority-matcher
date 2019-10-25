package edu.asu.diging.rcn.core.service;

import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.simpleusers.core.model.IUser;

public interface IMatchingManager {

    void startMatching(String baseDataset, String compareDataset, IUser user) throws MessageCreationException;

}