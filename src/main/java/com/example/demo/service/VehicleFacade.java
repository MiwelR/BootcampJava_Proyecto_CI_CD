package com.example.demo.service;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.GasolineCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.Vehicle;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.ChargingPort;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasTank;
import com.example.demo.domain.pieces.GasolineTank;


public class VehicleFacade {

	private VehicleFacade() {
		
	}
	
	public static Vehicle createElectric() {
		// vehicle pieces
		AirConditioner airConditioner = new AirConditioner(1L, 6);
		Battery battery = new Battery(1L, "90kWh");
		CarDoors carDoors = new CarDoors(1L, 5);
		Engine engine = new Engine(1L, 2500D, 180D);
		
		// vehicle exclusive pieces
		ChargingPort chargingPort = new ChargingPort(1L, 2, "90 minutos");
		
		// generating vehicle type
		ElectricCar electricCar = new ElectricCar(1L, "Coche", "Eléctrico", "Azul", airConditioner, battery, carDoors, engine, chargingPort);
		electricCar.getBattery().start();
		electricCar.getEngine().start();
		electricCar.getAirConditioner().start();
		
		return electricCar;
	}
	
	public static Vehicle createGasoline() {
		// vehicle pieces
		AirConditioner airConditioner = new AirConditioner(1L, 4);
		Battery battery = new Battery(1L, "40kWh");
		CarDoors carDoors = new CarDoors(1L, 4);
		Engine engine = new Engine(1L, 3500D, 250D);
		
		// vehicle exclusive pieces
		GasolineTank gasolineTank = new GasolineTank(1L, 80);
		
		// generating vehicle type
		GasolineCar gasolineCar = new GasolineCar(1L, "Coche", "Gasolina", "Blanco", airConditioner, battery, carDoors, engine, gasolineTank);
		gasolineCar.getBattery().start();
		gasolineCar.getEngine().start();
		gasolineCar.getAirConditioner().start();
		
		return gasolineCar;
		
	} 
	
	public static Vehicle createHybrid() {
		// vehicle pieces
		AirConditioner airConditioner = new AirConditioner(1L, 5);
		Battery battery = new Battery(1L, "70kWh");
		CarDoors carDoors = new CarDoors(1L, 3);
		Engine engine = new Engine(1L, 2000D, 140D);
		
		// vehicle exclusive pieces
		GasTank gasTank = new GasTank(1L, 95);
		
		// generating vehicle type
		HybridCar hybridCar = new HybridCar(1L, "Coche", "Híbrido", "Negro", airConditioner, battery, carDoors, engine, gasTank);
		hybridCar.getBattery().start();
		hybridCar.getEngine().start();
		hybridCar.getAirConditioner().start();
		
		return hybridCar;
	} 
	
}
