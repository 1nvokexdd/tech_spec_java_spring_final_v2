package com.example.tech_spec.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.tech_spec.model.SubscriptionType;
import com.example.tech_spec.model.Subscription;
import com.example.tech_spec.model.User;
import com.example.tech_spec.model.dto.SubDTO;
import com.example.tech_spec.repository.SubscriptionRepository;
import com.example.tech_spec.repository.UserRepository;
import com.example.tech_spec.service.SubscriptionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionServiceImpl  implements SubscriptionService{
    private final SubscriptionRepository subRepository;
    private final UserRepository userRepository;
    @Override
    public  Subscription save(Subscription sub){
    log.info("Saving sub: {}",sub.getSubscriptionType());
    return  subRepository.save(sub);
    };
    @Override
    @Transactional
     public  Subscription addSubForUser(Long userId , SubDTO dto){
        log.info("Adding sub for user with id {}: ", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id " + userId + "not found"));
         Subscription subscription = new Subscription();
        subscription.setSubscriptionType(dto.getSubscriptionType());
        subscription.setStartDate(dto.getStartDate());
        subscription.setEndDate(dto.getEndDate());
        subscription.setMonthlyPrice(dto.getMonthlyPrice());
        subscription.setUser(user);
        return subRepository.save(subscription);
    };
    
    
@Override
public List<SubDTO> getUserSubs(Long userId) {
    log.info("Fetching user with id {} subs", userId);
    if (!userRepository.existsById(userId)) {
        throw new RuntimeException("User not found with id: " + userId);
    }
    
    List<Subscription> subscriptions = subRepository.findByUserId(userId);
    return subscriptions.stream()
            .map(sub -> new SubDTO(
                sub.getSubscriptionType(),  // Предполагается, что есть getter
                sub.getStartDate(),          // LocalDate
                sub.getEndDate(),         // LocalDate
                sub.getMonthlyPrice()               // BigDecimal
            ))
            .toList();
}

    @Transactional
    @Override
    public void deleteSub(Long userId, Long subscriptionId) {
        log.info("Deleting  sub with id {} ",subscriptionId);
        Subscription subscription = subRepository.findByIdAndUserId(subscriptionId, userId)
                .orElseThrow(() -> new RuntimeException(
                        "Subscription not found with id: " + subscriptionId + " for user id: " + userId));
        subRepository.delete(subscription);
    }

@Override
public List<Map<String, Object>> getTop3PopularSubscriptions() {
    log.info("Fetching top 3 popular subscriptions");
    return subRepository.findTop3PopularSubscriptions(PageRequest.of(0, 3)).stream()
        .map(res -> {
            Map<String, Object> map = new HashMap<>();
            map.put("subscriptionType", res[0]);
            map.put("count", res[1]);
            return map;
        })
        .collect(Collectors.toList());
}  

}
