package com.example.candidats.Service;

import com.example.candidats.Entity.Candidat;
import com.example.candidats.Repo.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {

	@Autowired
	private CandidatRepository candidatRepository;

	public List<Candidat> getAll(){
		return candidatRepository.findAll();
	}

	public Candidat addCandidat(Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	public Candidat updateCandidat(int id, Candidat newCandidat) {
		if (candidatRepository.findById(id).isPresent()) {
			Candidat existingCandidat = candidatRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setEmail(newCandidat.getEmail());

			return candidatRepository.save(existingCandidat);
		} else
			return null;
	}
	public String deleteCandidat(int id) {
		if (candidatRepository.findById(id).isPresent()) {
			candidatRepository.deleteById(id);
			return "candidat supprimé";
		} else
			return "Le candidat n'existe pas";
	}
}
