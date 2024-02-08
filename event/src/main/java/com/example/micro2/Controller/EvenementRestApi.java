package com.example.micro2.Controller;

import com.example.micro2.Service.EvenementServiceImpl;
import com.example.micro2.entity.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenements")

public class EvenementRestApi {
     @Autowired
    private EvenementServiceImpl evenementService;

    @GetMapping
    public ResponseEntity<List<Evenement>> getAllEvenements() {
        List<Evenement> evenements = evenementService.retrieveAllEvenement();
        return ResponseEntity.ok(evenements);
    }

    @GetMapping("/{idEvenement}")
    public ResponseEntity<Evenement> getEvenementById(@PathVariable Long idEvenement) {
        Evenement evenement = evenementService.retrieveEvenement(idEvenement);
        return ResponseEntity.ok(evenement);
    }

    @PostMapping
    public ResponseEntity<Evenement> addEvenement(@RequestBody Evenement evenement) {
        Evenement addedEvenement = evenementService.addEvenement(evenement);
        return new ResponseEntity<>(addedEvenement, HttpStatus.CREATED);
    }

    @PutMapping("/{idEvenement}")
    public ResponseEntity<Evenement> updateEvenement(@PathVariable Long idEvenement, @RequestBody Evenement evenement) {
        evenement.setId(idEvenement);
        Evenement updatedEvenement = evenementService.updateEvenement(evenement);
        return ResponseEntity.ok(updatedEvenement);
    }

    @DeleteMapping("/{idEvenement}")
    public ResponseEntity<String> removeEvenement(@PathVariable Long idEvenement) {
        evenementService.removeEvenement(idEvenement);
        return ResponseEntity.ok("Evenement supprimé avec succès.");
    }
}


