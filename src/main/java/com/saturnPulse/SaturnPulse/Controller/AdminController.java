package com.saturnPulse.SaturnPulse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saturnPulse.SaturnPulse.DTO.AdminDTO;
import com.saturnPulse.SaturnPulse.DTO.ResponseDTO;
import com.saturnPulse.SaturnPulse.Service.IAdminService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private IAdminService service;
	
	@PostMapping("save")
	public ResponseEntity<ResponseDTO> save(@Validated @RequestBody AdminDTO dto)
	{
		return service.save(dto);
	}
	
}
