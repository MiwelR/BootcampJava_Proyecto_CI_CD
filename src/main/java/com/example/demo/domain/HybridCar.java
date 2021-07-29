package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasTank;

public class HybridCar extends Vehicle {

	private GasTank gasTank;

	public HybridCar() {
		
	}

	public HybridCar(Long id, String manufacturer, String model, String color, AirConditioner airConditioner, Battery battery, CarDoors carDoors,
			Engine engine, GasTank gasTank) {
		super(id, manufacturer, model, color, airConditioner, battery, carDoors, engine);
		this.gasTank = gasTank != null ? new GasTank(gasTank.getId(), gasTank.getLitersGas()) : null;
	}

	public GasTank getGasTank() {
		return gasTank != null ? new GasTank(gasTank.getId(), gasTank.getLitersGas()) : null;
	}

	public void setGasTank(GasTank gasTank) {
		this.gasTank = gasTank != null ? new GasTank(gasTank.getId(), gasTank.getLitersGas()) : null;
	}

	@Override
	public String toString() {
		return "HybridCar [gasTank=" + gasTank + ", getId()=" + getId() + ", getModel()=" + getModel()
				+ ", getAirConditioner()=" + getAirConditioner() + ", getBattery()=" + getBattery() + ", getCarDoors()="
				+ getCarDoors() + ", getEngine()=" + getEngine() + ", getColor()=" + getColor() + ", getManufacturer()="
				+ getManufacturer() + "]";
	}
	
}
