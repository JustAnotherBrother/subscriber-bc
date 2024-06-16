package com.example.subscriber_bc.service;

import com.example.subscriber_bc.entity.SubscriberEntity;
import com.example.subscriber_bc.exception.SubscriberException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.subscriber_bc.repository.SubscriberRepository;
import com.example.subscriber_bc.service.validator.SubscriberValidator;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriberService {

    private SubscriberRepository subscriberRepository;
    private final boolean NEW_SUBSCRIBER = true;

    @Transactional
    public SubscriberEntity createSubscriber(SubscriberEntity subscriberEntity) {

        SubscriberValidator subscriberValidator = new SubscriberValidator(subscriberEntity, subscriberRepository).validate();

        if (!subscriberValidator.isValid()) {
            throw new SubscriberException("Errors while creating a subscriber", subscriberValidator.getSubscriberApiErrors());
        }

        subscriberEntity.setActive(NEW_SUBSCRIBER);

        return subscriberRepository.save(subscriberEntity);
    }

    @Transactional
    public SubscriberEntity updateSubscriber(SubscriberEntity subscriberEntity) {

        SubscriberValidator subscriberValidator = new SubscriberValidator(subscriberEntity, subscriberRepository).validate();

        if (!subscriberValidator.isValid()) {
            throw new SubscriberException("Errors while updating a subscriber", subscriberValidator.getSubscriberApiErrors());
        }

        SubscriberEntity existingSubscriber = subscriberRepository
                .findById(subscriberEntity.getId())
                .orElseThrow(() -> new SubscriberException(String.format("Can't update the subscriber with id %s : he doesn't exist.", subscriberEntity.getId())));

        existingSubscriber.setFirstName(subscriberEntity.getFirstName());
        existingSubscriber.setLastName(subscriberEntity.getLastName());
        existingSubscriber.setMail(subscriberEntity.getMail());
        existingSubscriber.setPhoneNumber(subscriberEntity.getPhoneNumber());
        existingSubscriber.setActive(subscriberEntity.isActive());

        return subscriberRepository.save(existingSubscriber);
    }

    public List<SubscriberEntity> searchSubscriber(SubscriberEntity subscriberEntity) {
        return subscriberRepository.findByIdOrFirstNameOrLastNameOrMailOrPhoneNumberOrIsActive(
                subscriberEntity.getId(),
                subscriberEntity.getFirstName(),
                subscriberEntity.getLastName(),
                subscriberEntity.getMail(),
                subscriberEntity.getPhoneNumber(),
                subscriberEntity.isActive());
    }

    public List<SubscriberEntity> getAllSubscibers() {
        return subscriberRepository.findAll();
    }

    @Transactional
    public SubscriberEntity resiliateSubscriber(Long id) {
        SubscriberEntity existingSubscriber = subscriberRepository.findById(id).orElseThrow(() -> new SubscriberException(String.format("Can't resiliate the subscriber with id %s : he doesn't exist.", id)));
        existingSubscriber.setActive(false);
        return subscriberRepository.save(existingSubscriber);
    }

}
