package com.wash.machine.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wash.machine.entity.WashingMachine;
import com.wash.machine.service.WashingMachineService;

@RestController
public class WashingMachineController {
	
	@Autowired
	WashingMachineService washingMachineService;
	
	@GetMapping("/washingMachines")
	public ResponseEntity<List<WashingMachine>> getAll(){
		List<WashingMachine> washingMachineList = washingMachineService.findAll();				
		return new ResponseEntity<List<WashingMachine>>(washingMachineList, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/washingMachines/{serialNumber}")
	public ResponseEntity<WashingMachine> getBySerialNumber(@PathVariable String serialNumber){
		WashingMachine washingMachine = washingMachineService.findBySerialNumber(serialNumber);				
		return new ResponseEntity<WashingMachine>(washingMachine, new HttpHeaders(), HttpStatus.OK);
	}	

	@PostMapping("/washingMachines")
	public ResponseEntity<WashingMachine> register(@RequestBody WashingMachine washingMachine){
		WashingMachine appliance = washingMachineService.save(washingMachine);
		return new ResponseEntity<WashingMachine>(appliance, new HttpHeaders(), HttpStatus.CREATED);
	}

	
}
