package com.example.sponsornidhal.sponsor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SponsorDetailService {
    @Autowired
    private SponsorDetailRepository sponsorDetailRepository;

    public List<SponsorDetail> getAll(){
        return sponsorDetailRepository.findAll();
    }
    public SponsorDetail addCandidat(SponsorDetail candidate) {
        return sponsorDetailRepository.save(candidate);
    }

    public SponsorDetail updateCandidat(long id, SponsorDetail newCandidat) {
        if (sponsorDetailRepository.findById(id).isPresent()) {

            SponsorDetail existingCandidat = sponsorDetailRepository.findById(id).get();
            existingCandidat.setNameSponsor(newCandidat.getNameSponsor());
            existingCandidat.setNumber(newCandidat.getNumber());
            existingCandidat.setEmail(newCandidat.getEmail());

            return sponsorDetailRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteCandidat(long id) {
        if (sponsorDetailRepository.findById(id).isPresent()) {
            sponsorDetailRepository.deleteById(id);
            return "sponsor supprimé";
        } else
            return "sponsor non supprimé";
    }
}
