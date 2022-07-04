package com.example.springboottask4.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handled")
    private boolean is_handled; //обработано или нет

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;
}