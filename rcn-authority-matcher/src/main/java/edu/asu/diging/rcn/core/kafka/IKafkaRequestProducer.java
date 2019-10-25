package edu.asu.diging.rcn.core.kafka;

import edu.asu.diging.rcn.core.exceptions.MessageCreationException;
import edu.asu.diging.rcn.kafka.messages.model.Message;

public interface IKafkaRequestProducer {

    /* (non-Javadoc)
     * @see edu.asu.giles.service.kafka.impl.IOCRRequestProducer#sendOCRRequest(java.lang.String)
     */
    void sendRequest(Message msg, String topic) throws MessageCreationException;

}