package com.wash.machine;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import com.wash.machine.entity.WashingMachine;
import com.wash.machine.repository.WashingMachineRepository;

@SpringBootTest
class WashingMachineServiceApplicationTests {
		  
	 @Autowired
	 private WashingMachineRepository repository;
		 
	 @Test
     void testRegister() {
		//repository.save((new WashingMachine(5l, "LG 7Kg Top Machine", "Fully Automatic", "YB6553","SN452425")));		 
        WashingMachine machine = new WashingMachine(6l, "Samsung 6Kg Top Machine", "Semi Automatic", "YB6543","SN452425");
        Optional<WashingMachine> washineMachine = repository.findBySerialNumber(machine.getSerialNumber());
        if(washineMachine.isPresent()) {
        	 Assertions.fail("Washing Machine already exist with same serial number");
        }else {
        	 repository.save(machine);
        }
     }

    @Test
    void testFindBySerialNumber() {
          
        Optional<WashingMachine> washineMachine = repository.findBySerialNumber("SN452425");
        Assertions.assertTrue(washineMachine.isPresent(), "Washing Machine not found for given serial number");
    }
    
   
    
}
