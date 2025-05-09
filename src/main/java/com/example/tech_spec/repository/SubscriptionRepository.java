package com.example.tech_spec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tech_spec.model.Subscription;
import com.example.tech_spec.model.User;
import com.example.tech_spec.model.dto.SubDTO;

public interface SubscriptionRepository  extends JpaRepository<Subscription,Long>{
    @Query("SELECT s.subscriptionType, COUNT(s) as count FROM Subscription s GROUP BY s.subscriptionType ORDER BY count DESC")
List<Object[]> findTop3PopularSubscriptions(org.springframework.data.domain.Pageable pageable);
  
List<Subscription> findByUserId(@Param("userId") Long userId);
    Optional<Subscription> findByIdAndUserId(Long subscriptionId, Long userId);
}
