package com.saturnPulse.SaturnPulse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturnPulse.SaturnPulse.Entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Admin> findByName(String name);

}
