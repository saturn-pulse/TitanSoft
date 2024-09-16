package com.saturnPulse.SaturnPulse.Service.Impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saturnPulse.SaturnPulse.Constants.Status;
import com.saturnPulse.SaturnPulse.DTO.AdminDTO;
import com.saturnPulse.SaturnPulse.DTO.ResponseDTO;
import com.saturnPulse.SaturnPulse.Enities.Admin;
import com.saturnPulse.SaturnPulse.Repository.IAdminDao;
import com.saturnPulse.SaturnPulse.Service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IAdminDao dao;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public ResponseEntity<ResponseDTO> save(AdminDTO source) {
	        try {
	            Optional<Admin> leadlist = dao.findByName(source.getName());
	            Admin admin = new Admin();
	            if (leadlist.isEmpty()) {
	                modelMapper.map(source, admin);
	                ResponseDTO rdto = new ResponseDTO(Status.CREATED, Status.SUCCESS, Status.SAVE_MSG, dao.save(admin));
	                return new ResponseEntity<>(rdto, HttpStatus.CREATED);
	            } else {
	                ResponseDTO rdto = new ResponseDTO(Status.ALREADY_EXIST, Status.FAILED, Status.EXIST_MSG, null);
	                return new ResponseEntity<>(rdto, HttpStatus.ALREADY_REPORTED);
	            }
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	            ResponseDTO rdto = new ResponseDTO(Status.INTERNAL_ERROR, Status.FAILED, Status.INTERNAL_ERROR_MSG, null);
	            return new ResponseEntity<>(rdto, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	@Override
	public ResponseEntity<ResponseDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseDTO> findAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseDTO> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<ResponseDTO> update(AdminDTO source) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
