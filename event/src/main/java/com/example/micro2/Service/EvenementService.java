package com.example.micro2.Service;

import com.example.micro2.entity.Evenement;

import java.util.List;

public interface EvenementService {
    List<Evenement> retrieveAllEvenement();

    Evenement addEvenement(Evenement b);

    Evenement updateEvenement(Evenement b);

    Evenement retrieveEvenement(Long idEvenement);

    void removeEvenement(Long idEvenement);
}
