package com.example.tech_spec.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name =  "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;
    @JsonIgnore
    @OneToMany(cascade =  {CascadeType.PERSIST,
    CascadeType.MERGE , CascadeType.REFRESH})
    @JoinTable(name = "user_subscriptions",
    joinColumns = @JoinColumn(name = "user_id")
    ,inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    private List<Subscription> subscriptions = new ArrayList<>();


}
