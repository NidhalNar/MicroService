package com.example.micro2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Evenement")
public class Evenement implements Serializable {


    @Id
    @GeneratedValue
    private long id;
    private String nomE ,description;
    private Date dateDebut;
    private Date dateFin;

  

  





}
