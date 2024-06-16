package com.example.subscriber_bc.controller;

import com.example.subscriber_bc.entity.SubscriberEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.subscriber_bc.service.SubscriberService;

import java.util.List;

@RestController()
@RequestMapping("/api/subscribers")
@AllArgsConstructor
public class SubscriberController {

    private SubscriberService subscriberService;

    @PostMapping
    public SubscriberEntity createSubscriber(@RequestBody SubscriberEntity subscriberEntity) {
        return subscriberService.createSubscriber(subscriberEntity);
    }

    @PostMapping("update")
    public SubscriberEntity updateSubscriber(@RequestBody SubscriberEntity subscriberEntity) {
        return subscriberService.updateSubscriber(subscriberEntity);
    }

    @GetMapping("resilier/{id}")
    public SubscriberEntity resilierSubscriber(@PathVariable Long id) {
        return subscriberService.resiliateSubscriber(id);
    }

    @GetMapping("search")
    public List<SubscriberEntity> searchSubscriber(@RequestBody SubscriberEntity subscriberEntity) {
        return subscriberService.searchSubscriber(subscriberEntity);
    }

    @GetMapping("all")
    public List<SubscriberEntity> getAllSubscibers() {
        return subscriberService.getAllSubscibers();
    }
}
