package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.ChargingPort;
import com.example.demo.domain.pieces.Engine;

public class ElectricCar extends Vehicle {

	private ChargingPort chargingPort;

	public ElectricCar() {

	}

	public ElectricCar(Long id, String manufacturer, String model, String color, AirConditioner airConditioner, Battery battery, CarDoors carDoors,
			Engine engine, ChargingPort chargingPort) {
		super(id, manufacturer, model, color, airConditioner, battery, carDoors, engine);
		this.chargingPort = chargingPort != null ? new ChargingPort(chargingPort.getId(), chargingPort.getNumPorts(), chargingPort.getTimeCharge()) : null;
	}

	public ChargingPort getChargingPort() {
		return chargingPort != null ? new ChargingPort(chargingPort.getId(), chargingPort.getNumPorts(), chargingPort.getTimeCharge()) : null;
	}

	public void setChargingPort(ChargingPort chargingPort) {
		this.chargingPort = chargingPort != null ? new ChargingPort(chargingPort.getId(), chargingPort.getNumPorts(), chargingPort.getTimeCharge()) : null;
	}

	@Override
	public String toString() {
		return "ElectricCar [chargingPort=" + chargingPort + ", getId()=" + getId() + ", getModel()=" + getModel()
				+ ", getAirConditioner()=" + getAirConditioner() + ", getBattery()=" + getBattery() + ", getCarDoors()="
				+ getCarDoors() + ", getEngine()=" + getEngine() + ", getColor()=" + getColor() + ", getManufacturer()="
				+ getManufacturer() + "]";
	}
	
}
