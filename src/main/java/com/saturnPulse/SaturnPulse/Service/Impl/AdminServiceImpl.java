package com.saturnPulse.SaturnPulse.Service.Impl;

import java.util.Optional;

import com.saturnPulse.SaturnPulse.Dto.AdminDTO;
import com.saturnPulse.SaturnPulse.Entity.Admin;
import com.saturnPulse.SaturnPulse.Exception.AdminException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saturnPulse.SaturnPulse.Constants.Status;
import com.saturnPulse.SaturnPulse.DTO.ResponseDTO;

import com.saturnPulse.SaturnPulse.Repository.AdminRepository;
import com.saturnPulse.SaturnPulse.Service.IAdminService;


@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<ResponseDTO> save(@Valid AdminDTO source) {
        try {
            Optional<Admin> adminList = adminRepository.findByName(source.getName());
            Admin admin = new Admin();
            if (adminList.isEmpty()) {
                modelMapper.map(source, admin);
                ResponseDTO responseDTO =
                        new ResponseDTO(Status.CREATED, Status.SUCCESS, Status.SAVE_MSG, adminRepository.save(admin));
                return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
            } else {
                ResponseDTO responseDTO = new ResponseDTO(Status.ALREADY_EXIST, Status.FAILED, Status.EXIST_MSG, null);
                return new ResponseEntity<>(responseDTO, HttpStatus.ALREADY_REPORTED);
            }
        } catch (Exception ex) {
            ResponseDTO responseDTO = new ResponseDTO(Status.INTERNAL_ERROR, Status.FAILED, Status.INTERNAL_ERROR_MSG, null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
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

        Optional<Admin> admin = adminRepository.findById(Long.valueOf(id));
        if (admin.isPresent()) {
            ResponseDTO responseDTO = new ResponseDTO(Status.OK, Status.SUCCESS, Status.FETCH_MSG, admin);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }else {
			throw  new AdminException("admin Not Found");
		}
    }

    @Override
    public ResponseEntity<ResponseDTO> update(AdminDTO source) {
        // TODO Auto-generated method stub
        return null;
    }


}
