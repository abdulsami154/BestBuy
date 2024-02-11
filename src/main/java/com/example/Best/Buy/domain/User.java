package com.example.Best.Buy.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate createdAt;
//
//    @JsonIgnore
//    @OneToOne(mappedBy = "createdBy" ,cascade = CascadeType.ALL,orphanRemoval = true)
//    private Cart cart;

}
