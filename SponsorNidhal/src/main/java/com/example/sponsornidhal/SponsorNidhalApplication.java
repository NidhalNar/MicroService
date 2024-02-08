package com.example.sponsornidhal;

import com.example.sponsornidhal.sponsor.SponsorDetail;
import com.example.sponsornidhal.sponsor.SponsorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class SponsorNidhalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SponsorNidhalApplication.class, args);
    }
    @Autowired
    private SponsorDetailRepository sponsorDetailRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // save
            sponsorDetailRepository.save(new SponsorDetail("esprit", "Ch@esprit.tn", "29225165"));
            sponsorDetailRepository.save(new SponsorDetail("sesame", "Ch@esprit.tn", "29225165"));

            sponsorDetailRepository.save(new SponsorDetail("tekup", "Ch@esprit.tn", "29225165"));


            // fetch
            sponsorDetailRepository.findAll().forEach(System.out::println);

        };
    }


}
