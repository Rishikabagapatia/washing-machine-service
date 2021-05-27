package com.wash.machine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wash.machine.entity.WashingMachine;
import com.wash.machine.exception.DataNotFoundException;
import com.wash.machine.repository.WashingMachineRepository;

@Service
public class WashingMachineServiceImpl implements WashingMachineService{
	
	@Autowired
	WashingMachineRepository washingMachineRepository;

	@Override
	public List<WashingMachine> findAll() {		
		List<WashingMachine> washingMachineList = washingMachineRepository.findAll();
		if(washingMachineList==null || washingMachineList.isEmpty()) {
			throw new DataNotFoundException("No Washing Machine Found");
		}
		return washingMachineList;
	}

	@Override
	public WashingMachine findBySerialNumber(String serialNumber) {
		Optional<WashingMachine> washingMachine = washingMachineRepository.findBySerialNumber(serialNumber);
		if(washingMachine.isPresent()){
			return washingMachine.get();
		}
		else {
			throw new DataNotFoundException("Washing Machine not found for serial number " + serialNumber);
		}
	}

	@Override
	public WashingMachine save(WashingMachine appliance) {
		String serialNumber = appliance.getSerialNumber();
		
		Optional<WashingMachine> washingMachine = washingMachineRepository.findBySerialNumber(serialNumber);
		if(washingMachine.isPresent()){
			throw new RuntimeException("Washing Machine already exist for serial number " + serialNumber);
		}
		else {
			return washingMachineRepository.save(appliance);
		}
	}
}
