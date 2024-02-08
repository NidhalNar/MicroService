package com.micro.microservice.controller;
import com.micro.microservice.entities.Lieu;
import com.micro.microservice.service.LieuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/lieus")
public class LieuController {
    LieuService lieuService;
    @GetMapping("/retrieve-all-lieu")
    public List<Lieu> getLieuList() {
        List<Lieu> listLieu = lieuService.retrieveAllLieu();
        return listLieu;
    }

    @GetMapping("/retrieve-lieu/{lieu-id}")
    public Lieu retrieveLieu(@PathVariable("lieu-id") Long idLieu) {
        return lieuService.retrieveLieu(idLieu);
    }

    @PostMapping("/add-lieu")
    public Lieu addLieu(@RequestBody Lieu e) {
        Lieu lieu = lieuService.addLieu(e);
        return lieu;
    }

    @DeleteMapping("/remove-lieu/{lieu-id}")
    public void removeLieu(@PathVariable("lieu-id") Long idLieu) {
        lieuService.removeLieu(idLieu);
    }

    @PutMapping("/update-lieu")
    public Lieu updateLieu(@RequestBody  Lieu e) {
        Lieu lieu=lieuService.updateLieu(e);
        return lieu;
    }

}

