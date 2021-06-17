package com.example.source.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_group")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events;

}
