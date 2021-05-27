package com.wash.machine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_WASHING_MACHINE")
public class WashingMachine {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME",nullable = false)
	private String name;
	
	@Column(name = "TYPE",nullable = false)
	private String type;
	
	@Column(name = "MODEL",nullable = false)
	private String model;
	
	@Column(name = "SERIAL_NUMBER",nullable = false)
	private String serialNumber;
	
	public WashingMachine() {
		
	}

	public WashingMachine(long id, String name, String type, String model, String serialNumber) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.model = model;
		this.serialNumber = serialNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "WashingMachine [id=" + id + ", name=" + name + ", type=" + type + ", model=" + model + ", serialNumber="
				+ serialNumber + "]";
	}
	
}
