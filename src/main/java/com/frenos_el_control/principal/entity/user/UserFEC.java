package com.frenos_el_control.principal.entity.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userfec")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFEC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "name",nullable = false,length = 30, unique = true)
    private String name;
    @Column(name = "lastname",length = 70)
    private String lastname;
    @Column(name = "password",nullable = false,length = 72)
    private String password;
    @Column(name = "url_img")
    private String ulrImg;
}
