package com.saturnpulse.titan.Service;


import org.springframework.http.ResponseEntity;

import com.saturnpulse.titan.Dto.ResponseDTO;


public interface IBaseService<T> {

	public ResponseEntity<ResponseDTO> save(T source);
	

	public ResponseEntity<ResponseDTO> update(T source);

	public ResponseEntity<ResponseDTO> findAll();
	
	public ResponseEntity<ResponseDTO> findAllActive();
	
	public ResponseEntity<ResponseDTO> findById(String id);
	
	
}
