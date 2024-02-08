package com.example.sponsornidhal.sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sponsors")
public class SponsorDetailControllerAPI {
    private String title="Hello, i'm the Sponsor Micro Service";

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(title);
        return  title;
    }

    @Autowired
    private SponsorDetailService sponsorDetailService;

    @RequestMapping
    public List<SponsorDetail> getListCandid() {
        return sponsorDetailService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SponsorDetail> createCandidat(@RequestBody SponsorDetail candidat) {
        return new ResponseEntity<>(sponsorDetailService.addCandidat(candidat), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SponsorDetail> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody SponsorDetail candidat){
        return new ResponseEntity<>(sponsorDetailService.updateCandidat(id, candidat), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(sponsorDetailService.deleteCandidat(id), HttpStatus.OK);
    }

}
