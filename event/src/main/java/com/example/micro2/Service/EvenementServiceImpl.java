package com.example.micro2.Service;

import com.example.micro2.Repository.EvenementRepository;
import com.example.micro2.entity.Evenement;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public List<Evenement> retrieveAllEvenement() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement addEvenement(Evenement evenement) {
       
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
       
        Long idEvenement = evenement.getId();
        if (evenementRepository.existsById(idEvenement)) {
           
            return evenementRepository.save(evenement);
        } else {
           
            throw new EntityNotFoundException("Evenement non trouvé avec l'ID : " + idEvenement);
        }
    }

    @Override
    public Evenement retrieveEvenement(Long idEvenement) {

        return evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new EntityNotFoundException("Evenement non trouvé avec l'ID : " + idEvenement));
    }

    @Override
    public void removeEvenement(Long idEvenement) {
       
        if (evenementRepository.existsById(idEvenement)) {
            evenementRepository.deleteById(idEvenement);
        } else {
            throw new EntityNotFoundException("Evenement non trouvé avec l'ID : " + idEvenement);
        }
    }
}
