package com.example.subscriber_bc.service.validator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class AbstarctSubscriberValidator<T> {

    T objectToValidate;

    List<SubscriberApiError> subscriberApiErrors;

    public AbstarctSubscriberValidator(T t) {
        objectToValidate = t;
        subscriberApiErrors = new ArrayList<>();
    }

    public abstract SubscriberValidator validate();

    public boolean isValid() {
        return subscriberApiErrors.isEmpty();
    }

    public void addSubscriberApiError(SubscriberApiError subscriberApiError) {
        subscriberApiErrors.add(subscriberApiError);
    }

}
