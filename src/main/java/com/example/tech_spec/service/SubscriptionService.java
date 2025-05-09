package com.example.tech_spec.service;

import java.util.List;
import java.util.Map;

import com.example.tech_spec.model.SubscriptionType;
import com.example.tech_spec.model.Subscription;
import com.example.tech_spec.model.User;
import com.example.tech_spec.model.dto.SubDTO;

public interface SubscriptionService {
    Subscription save(Subscription sub);
    Subscription addSubForUser(Long userId , SubDTO dto);
    List<SubDTO> getUserSubs(Long userId);
    void deleteSub(Long userId, Long subscriptionId);
    List<Map<String, Object>> getTop3PopularSubscriptions();
    
}
