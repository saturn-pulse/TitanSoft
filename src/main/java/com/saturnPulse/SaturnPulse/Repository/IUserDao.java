package com.saturnPulse.SaturnPulse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saturnPulse.SaturnPulse.Enities.Admin;


public interface IUserDao extends JpaRepository<Admin, Long>{

}
