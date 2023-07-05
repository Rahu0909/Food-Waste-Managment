package com.boot.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.project.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long>{

}
