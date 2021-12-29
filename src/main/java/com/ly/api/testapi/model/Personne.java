package com.ly.api.testapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Personne")


public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    private Integer tel;
    private  String password;
}
