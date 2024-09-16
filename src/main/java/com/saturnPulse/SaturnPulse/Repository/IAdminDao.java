package com.saturnPulse.SaturnPulse.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturnPulse.SaturnPulse.Enities.Admin;


public interface IAdminDao extends JpaRepository<Admin, Long>{

	Optional<Admin> findByName(String name);

}
