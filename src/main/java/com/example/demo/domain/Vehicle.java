package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.CarDoors;

public abstract class Vehicle {

	private Long id;
	private String manufacturer;
	private String model;
	private String color;
	private AirConditioner airConditioner;
	private Battery battery;
	private CarDoors carDoors;
	private Engine engine;
	
	protected Vehicle() {
		
	}

	protected Vehicle(Long id, String manufacturer, String model, String color, AirConditioner airConditioner, Battery battery, CarDoors carDoors,
			Engine engine) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.color = color;
		this.airConditioner = airConditioner != null ? new AirConditioner(airConditioner.getId(), airConditioner.getNumAirVents()) : null;
		this.battery = battery != null ? new Battery(battery.getId(), battery.getCapacity()) : null;
		this.carDoors = carDoors != null ? new CarDoors(carDoors.getId(), carDoors.getDoors()) : null;
		this.engine = engine != null ? new Engine(engine.getId(), engine.getCc(), engine.getCv()) : null;
//		this.airConditioner.start();
//		this.battery.start();
//		this.engine.start();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public AirConditioner getAirConditioner() {
		return airConditioner != null ? new AirConditioner(airConditioner.getId(), airConditioner.getNumAirVents()) : null;
	}
	public void setAirConditioner(AirConditioner airConditioner) {
		this.airConditioner = airConditioner != null ? new AirConditioner(airConditioner.getId(), airConditioner.getNumAirVents()) : null;
	}
	public Battery getBattery() {
		return battery != null ? new Battery(battery.getId(), battery.getCapacity()) : null;
	}
	public void setBattery(Battery battery) {
		this.battery = battery != null ? new Battery(battery.getId(), battery.getCapacity()) : null;
	}
	public CarDoors getCarDoors() {
		return carDoors != null ? new CarDoors(carDoors.getId(), carDoors.getDoors()) : null;
	}
	public void setCarDoors(CarDoors carDoors) {
		this.carDoors = carDoors != null ? new CarDoors(carDoors.getId(), carDoors.getDoors()) : null;
	}
	public Engine getEngine() {
		return engine != null ? new Engine(engine.getId(), engine.getCc(), engine.getCv()) : null;
	}
	public void setEngine(Engine engine) {
		this.engine = engine != null ? new Engine(engine.getId(), engine.getCc(), engine.getCv()) : null;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", color=" + color
				+ ", airConditioner=" + airConditioner + ", battery=" + battery + ", carDoors=" + carDoors + ", engine="
				+ engine + "]";
	}
	
}
