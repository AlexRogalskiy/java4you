package com.sensiblemetrics.api.alpenidos.pattern.commander.messaging_service;

import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Commander;
import com.sensiblemetrics.api.alpenidos.pattern.commander.impl.Service;
import com.sensiblemetrics.api.alpenidos.pattern.commander.employee_service.EmployeeDatabase;
import com.sensiblemetrics.api.alpenidos.pattern.commander.exception.DatabaseUnavailableException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The MessagingService is used to send messages to user regarding their order and
 * payment status. In case an error is encountered in payment and this service is
 * found to be unavailable, the order is added to the {@link EmployeeDatabase}.
 */

public class MessagingService extends Service {

    public enum MessageToSend {
        PaymentFail,
        PaymentTrying,
        PaymentSuccessful
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MessageRequest {
        private String reqId;
        private MessageToSend msg;
    }

    public MessagingService(MessagingDatabase db, Exception... exc) {
        super(db, exc);
    }

    /**
     * Public method which will receive request from {@link Commander}.
     */
    public String receiveRequest(final Object... parameters) throws DatabaseUnavailableException {
        int messageToSend = (int) parameters[0];
        String rId = generateId();
        MessageToSend msg = null;
        if (messageToSend == 0) {
            msg = MessageToSend.PaymentFail;
        } else if (messageToSend == 1) {
            msg = MessageToSend.PaymentTrying;
        } else { //messageToSend == 2
            msg = MessageToSend.PaymentSuccessful;
        }
        final MessageRequest req = new MessageRequest(rId, msg);
        return updateDb(req);
    }

    protected String updateDb(final Object... parameters) throws DatabaseUnavailableException {
        MessageRequest req = (MessageRequest) parameters[0];
        if (this.database.get(req.reqId) == null) { //idempotence, in case db fails here
            this.database.add(req); //if successful:
            System.out.println(sendMessage(req.msg));
            return req.reqId;
        }
        return null;
    }

    public String sendMessage(final MessageToSend m) {
        if (m.equals(MessageToSend.PaymentSuccessful)) {
            return "Msg: Your order has been placed and paid for successfully! Thank you for shopping with us!";
        } else if (m.equals(MessageToSend.PaymentTrying)) {
            return "Msg: There was an error in your payment process, we are working on it and will return back to you"
                + " shortly. Meanwhile, your order has been placed and will be shipped.";
        }
        return "Msg: There was an error in your payment process. Your order is placed and has been converted to COD."
            + " Please reach us on CUSTOMER-CARE-NUBER in case of any queries. Thank you for shopping with us!";
    }
}
