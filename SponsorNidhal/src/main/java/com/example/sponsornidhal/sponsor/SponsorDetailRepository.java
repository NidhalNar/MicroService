package com.example.sponsornidhal.sponsor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorDetailRepository extends JpaRepository<SponsorDetail, Long> {
}
