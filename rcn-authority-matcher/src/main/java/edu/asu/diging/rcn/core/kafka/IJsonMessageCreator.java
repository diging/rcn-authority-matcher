package edu.asu.diging.rcn.core.kafka;
import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.kafka.messages.model.Message;

public interface IJsonMessageCreator {

    public String createMessage(Message ms) throws MessageCreationException;
}