package com.example.subscriber_bc.repository;

import com.example.subscriber_bc.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {
    Optional<SubscriberEntity> findByMail(String mail);

    List<SubscriberEntity> findByIdOrFirstNameOrLastNameOrMailOrPhoneNumberOrIsActive(Long id, String firstName, String lastName, String mail, String phoneNumber, boolean isActive);
}
