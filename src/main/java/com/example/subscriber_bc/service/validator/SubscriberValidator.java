package com.example.subscriber_bc.service.validator;

import com.example.subscriber_bc.entity.SubscriberEntity;
import com.example.subscriber_bc.repository.SubscriberRepository;
import org.apache.commons.lang3.StringUtils;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

public class SubscriberValidator extends AbstarctSubscriberValidator<SubscriberEntity> {

    private final SubscriberRepository subscriberRepository;

    public SubscriberValidator(SubscriberEntity subscriberEntity, SubscriberRepository subscriberRepository) {
        super(subscriberEntity);
        this.subscriberRepository = subscriberRepository;

    }

    @Override
    public SubscriberValidator validate() {

        if (StringUtils.isEmpty(objectToValidate.getFirstName())) {
            addSubscriberApiError(new SubscriberApiError("firstName", objectToValidate.getFirstName(), "The first name is empty."));
        }
        if (StringUtils.isEmpty(objectToValidate.getLastName())) {
            addSubscriberApiError(new SubscriberApiError("lastName", objectToValidate.getLastName(), "The last name is empty."));
        }
        if (StringUtils.isEmpty(objectToValidate.getMail())) {
            addSubscriberApiError(new SubscriberApiError("mail", objectToValidate.getMail(), "The mail is empty."));
        } else {
            subscriberRepository.findByMail(objectToValidate.getMail()).ifPresent(existingSubscriber -> {
                if (!Objects.equals(objectToValidate.getId(), existingSubscriber.getId())) {
                    addSubscriberApiError(new SubscriberApiError("mail", objectToValidate.getMail(), "This mail already exists for another subscriber."));
                }
            });


        }
        if (StringUtils.isEmpty(objectToValidate.getPhoneNumber())) {
            addSubscriberApiError(new SubscriberApiError("phoneNumber", objectToValidate.getPhoneNumber(), "The phone number is empty."));
        }

        return this;
    }
}
