package com.example.subscriber_bc.exception;

import lombok.Getter;
import com.example.subscriber_bc.service.validator.SubscriberApiError;

import java.util.List;

@Getter
public class SubscriberException extends RuntimeException {
    private List<SubscriberApiError> subscriberApiErrors;

    public SubscriberException(String message) {
        super(message);
    }

    public SubscriberException(String message, List<SubscriberApiError> subscriberApiErrors) {
        super(message);
        this.subscriberApiErrors = subscriberApiErrors;
    }
}
