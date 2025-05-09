package com.example.tech_spec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_spec.model.Subscription;
import com.example.tech_spec.model.dto.SubDTO;
import com.example.tech_spec.service.SubscriptionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> addSubscription(
            @PathVariable Long userId,
            @Valid @RequestBody SubDTO request) {
        Subscription subscription = subscriptionService.addSubForUser(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }

    @GetMapping
    public ResponseEntity<List<SubDTO>> getUserSubscriptions(@PathVariable Long userId) {
        List<SubDTO> subscriptions = subscriptionService.getUserSubs(userId);
        return ResponseEntity.ok(subscriptions);
    }

    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(
            @PathVariable Long userId,
            @PathVariable Long subscriptionId) {
        subscriptionService.deleteSub(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
