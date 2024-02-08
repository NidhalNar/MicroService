package com.micro.microservice.service;



import com.micro.microservice.entities.Lieu;

import java.util.List;

public interface LieuService {
    List<Lieu> retrieveAllLieu();

    Lieu addLieu(Lieu l);

    Lieu updateLieu(Lieu l);

    Lieu retrieveLieu(Long idLieu);

    void removeLieu(Long idLieu);
}
