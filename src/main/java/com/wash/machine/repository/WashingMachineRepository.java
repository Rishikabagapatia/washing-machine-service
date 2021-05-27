package com.wash.machine.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wash.machine.entity.WashingMachine;

@Repository
public interface WashingMachineRepository extends CrudRepository<WashingMachine, Long> {
    List<WashingMachine> findAll();
    Optional<WashingMachine> findBySerialNumber(String serialNumber);
    WashingMachine save(WashingMachine appliance);
}