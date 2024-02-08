package com.micro.microservice.service;

import com.micro.microservice.entities.Lieu;
import com.micro.microservice.repository.LieuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class LieuServiceImpl implements LieuService{
    LieuRepository lieuRepository;

    @Override
    public List<Lieu> retrieveAllLieu() {
        return lieuRepository.findAll();
    }

    @Override
    public Lieu addLieu(Lieu l) {
        return lieuRepository.save(l);
    }

    @Override
    public Lieu updateLieu(Lieu l) {
        return lieuRepository.save(l);
    }

    @Override
    public Lieu retrieveLieu(Long idLieu) {
        return lieuRepository.findById(idLieu).get() ;
    }

    @Override
    public void removeLieu(Long idLieu) {
        lieuRepository.deleteById(idLieu);

    }

}
