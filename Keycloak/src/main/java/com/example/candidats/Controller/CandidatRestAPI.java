package com.example.candidats.Controller;

import com.example.candidats.Entity.Candidat;
import com.example.candidats.Service.CandidatService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestAPI {
	private String title = "Hello, I'm the candidate Microservice";
	@Autowired
	private CandidatService candidatService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@RequestMapping(value = "/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat, KeycloakAuthenticationToken auth) {
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
		KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
		boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");

		if (hasUserRole) {
			return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);
		} else {
			System.out.println("failed");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}


	@GetMapping("/users")
	public ResponseEntity<List<Candidat>> getAllCandidats(KeycloakAuthenticationToken auth) {
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
		KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
		boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("user");

		if (hasUserRole) {
			List<Candidat> candidats = candidatService.getAll();
			return new ResponseEntity<>(candidats, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}



	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
												   @RequestBody Candidat candidat){
		return new ResponseEntity<>(candidatService.updateCandidat(id, candidat), HttpStatus.OK);
	}
	@DeleteMapping(value = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id, KeycloakAuthenticationToken auth){
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) auth.getPrincipal();
		KeycloakSecurityContext context = principal.getKeycloakSecurityContext();
		boolean hasUserRole = context.getToken().getRealmAccess().isUserInRole("admin");
		if (hasUserRole) {
		return new ResponseEntity<>(candidatService.deleteCandidat(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
