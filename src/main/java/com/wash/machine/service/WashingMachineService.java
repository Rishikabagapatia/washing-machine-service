package com.wash.machine.service;

import java.util.List;

import com.wash.machine.entity.WashingMachine;

public interface WashingMachineService {
	
	List<WashingMachine> findAll();
    WashingMachine findBySerialNumber(String serialNumber);
    WashingMachine save(WashingMachine appliance);

}
