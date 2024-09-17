package com.saturnpulse.titan.Service.Impl;

import java.util.Optional;

import com.saturnpulse.titan.Dto.AdminDTO;
import com.saturnpulse.titan.Entity.Admin;
import com.saturnpulse.titan.Exception.AdminException;
import com.saturnpulse.titan.Service.IAdminService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saturnpulse.titan.Constants.Status;
import com.saturnpulse.titan.Dto.ResponseDTO;

import com.saturnpulse.titan.Repository.AdminRepository;


@Service
public class AdminServiceImpl implements IAdminService, UserDetailsService {

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
        } else {
            throw new AdminException("admin Not Found");
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> update(AdminDTO source) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<Admin> admin =
                adminRepository.findByUserName(username);
        if (admin.isPresent()) {

            return User.builder().password(admin.get().getPassword())
                    .username(admin.get().getUserName()).build();
        } else {
            throw new UsernameNotFoundException("no admin found");
        }

    }
}
