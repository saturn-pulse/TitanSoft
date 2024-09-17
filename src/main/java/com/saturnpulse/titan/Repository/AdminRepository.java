package com.saturnpulse.titan.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturnpulse.titan.Entity.Admin;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Optional<Admin> findByName(String name);

	Optional<Admin> findByUserName(String username);
}
