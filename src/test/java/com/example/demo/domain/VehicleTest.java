package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;

public class VehicleTest {

	
	@Test
	@DisplayName("Test VehicleElectricParams")
	void vehicleElectricParams() {
		// Model
		Vehicle vehicle1 = new ElectricCar();
		vehicle1.setModel("Civic");
		assertEquals("Civic", vehicle1.getModel());
		
		// Manufacturer
		vehicle1.setManufacturer("Honda");
		assertEquals("Honda", vehicle1.getManufacturer());
		
		// Color
		vehicle1.setColor("Blue");
		assertEquals("Blue", vehicle1.getColor());
		
		// AirConditioner
		vehicle1.setAirConditioner(new AirConditioner(1L, 4));
		assertNotNull(vehicle1.getAirConditioner());
		
		vehicle1.setAirConditioner(null);
		assertNull(vehicle1.getAirConditioner());
		
		// Battery
		vehicle1.setBattery(new Battery(1L, "20 minutos"));
		assertNotNull(vehicle1.getBattery());
		
		vehicle1.setBattery(null);
		assertNull(vehicle1.getBattery());
		
		// CarDoors
		vehicle1.setCarDoors(new CarDoors(1L, 5));
		assertNotNull(vehicle1.getCarDoors());
		
		vehicle1.setCarDoors(null);
		assertNull(vehicle1.getCarDoors());
		
		// Engine
		vehicle1.setEngine(new Engine(1L, 2.0, 3.0));
		assertNotNull(vehicle1.getEngine());
		
		vehicle1.setEngine(null);
		assertNull(vehicle1.getEngine());
		
		// ToString
		assertNotNull(vehicle1.toString());
	}
	
	@Test
	@DisplayName("Test VehicleGasolineParams")
	void vehicleGasolineParams() {
		// Model
		Vehicle vehicle2 = new GasolineCar();
		vehicle2.setModel("Civic");
		assertEquals("Civic", vehicle2.getModel());
		
		// Manufacturer
		vehicle2.setManufacturer("Honda");
		assertEquals("Honda", vehicle2.getManufacturer());
		
		// Color
		vehicle2.setColor("Blue");
		assertEquals("Blue", vehicle2.getColor());
		
		// AirConditioner
		vehicle2.setAirConditioner(new AirConditioner(1L, 4));
		assertNotNull(vehicle2.getAirConditioner());
		
		vehicle2.setAirConditioner(null);
		assertNull(vehicle2.getAirConditioner());
		
		// Battery
		vehicle2.setBattery(new Battery(1L, "20 minutos"));
		assertNotNull(vehicle2.getBattery());
		
		vehicle2.setBattery(null);
		assertNull(vehicle2.getBattery());
		
		// CarDoors
		vehicle2.setCarDoors(new CarDoors(1L, 5));
		assertNotNull(vehicle2.getCarDoors());
		
		vehicle2.setCarDoors(null);
		assertNull(vehicle2.getCarDoors());
		
		// Engine
		vehicle2.setEngine(new Engine(1L, 2.0, 3.0));
		assertNotNull(vehicle2.getEngine());
		
		vehicle2.setEngine(null);
		assertNull(vehicle2.getEngine());
		
		// ToString
		assertNotNull(vehicle2.toString());
	}
	
	@Test
	@DisplayName("Test VehicleHybridParams")
	void vehicleHybridParams() {
		// Model
		Vehicle vehicle3 = new HybridCar();
		vehicle3.setModel("Civic");
		assertEquals("Civic", vehicle3.getModel());
		
		// Manufacturer
		vehicle3.setManufacturer("Honda");
		assertEquals("Honda", vehicle3.getManufacturer());
		
		// Color
		vehicle3.setColor("Blue");
		assertEquals("Blue", vehicle3.getColor());
		
		// AirConditioner
		vehicle3.setAirConditioner(new AirConditioner(1L, 4));
		assertNotNull(vehicle3.getAirConditioner());
		
		vehicle3.setAirConditioner(null);
		assertNull(vehicle3.getAirConditioner());
		
		// Battery
		vehicle3.setBattery(new Battery(1L, "20 minutos"));
		assertNotNull(vehicle3.getBattery());
		
		vehicle3.setBattery(null);
		assertNull(vehicle3.getBattery());
		
		// CarDoors
		vehicle3.setCarDoors(new CarDoors(1L, 5));
		assertNotNull(vehicle3.getCarDoors());
		
		vehicle3.setCarDoors(null);
		assertNull(vehicle3.getCarDoors());
		
		// Engine
		vehicle3.setEngine(new Engine(1L, 2.0, 3.0));
		assertNotNull(vehicle3.getEngine());
		
		vehicle3.setEngine(null);
		assertNull(vehicle3.getEngine());
		
		// ToString
		assertNotNull(vehicle3.toString());
	}
}
