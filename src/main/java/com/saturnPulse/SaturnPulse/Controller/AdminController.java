package com.saturnPulse.SaturnPulse.Controller;

import com.saturnPulse.SaturnPulse.Dto.AdminDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saturnPulse.SaturnPulse.DTO.ResponseDTO;
import com.saturnPulse.SaturnPulse.Service.IAdminService;

@RestController
@RequestMapping("admin")
@Slf4j
public class AdminController {

    @Autowired
    private IAdminService service;

    @PostMapping("/save-admin")
    public ResponseEntity<ResponseDTO> save(@RequestBody @Valid AdminDTO dto) {
        log.error(dto.getName());

        return service.save(dto);
    }

}
