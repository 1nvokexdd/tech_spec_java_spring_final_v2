package com.example.tech_spec.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tech_spec.model.SubscriptionType;
import com.example.tech_spec.service.SubscriptionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/subscriptions")
@RequiredArgsConstructor
@RestController
public class SubscripitonTop3Controller {
    private final  SubscriptionService service;

    @GetMapping("/top")
    public ResponseEntity <List<Map<String,Object>>> getTop3Subs(){
    return ResponseEntity.ok(service.getTop3PopularSubscriptions());
    }
}
