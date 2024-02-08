package com.example.sponsornidhal.sponsor;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SponsorDetail implements Serializable {
    //Sponsor ID, Sponsor Name, Contact Person, Contact Number, Email, Logo, Sponsorship Level

    private static final long serialVersionUID = 795450928237931201L;

    @Id
    @GeneratedValue
    private long idSponsor;
    private String nameSponsor,email,number;

    public SponsorDetail(String nameSponsor, String email, String number) {
        this.nameSponsor = nameSponsor;
        this.email = email;
        this.number = number;
    }
}
