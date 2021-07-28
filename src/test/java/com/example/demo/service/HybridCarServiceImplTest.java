package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasTank;

public class HybridCarServiceImplTest {

HybridCarService hybridcars;
	
	@BeforeEach
	void setUp() throws Exception {
		hybridcars = new HybridCarServiceImpl();
		this.loadCars();

	}
	
	private void loadCars() throws Exception {
		hybridcars.deleteAll();
		HybridCar hybridCar1 = new HybridCar(1L, "Toyota", "Yaris", "Green", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "50kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1100D, 90D),
				new GasTank(1L, 75));
		
    	HybridCar hybridCar2 = new HybridCar(2L, "Toyota", "C-HR", "Silver", 
    			new AirConditioner(1L, 6),
				new Battery(1L, "80kWh"),
				new CarDoors(1L, 4),
				new Engine(1L, 2500D, 110D),
				new GasTank(1L, 80));
		
    	HybridCar hybridCar3 = new HybridCar(3L, "Renault", "Grand Scénic", "Lightblue", 
    			new AirConditioner(1L, 7),
				new Battery(1L, "90kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1800D, 120D),
				new GasTank(1L, 95));
			
			
	    	hybridcars.save(hybridCar1);
	    	hybridcars.save(hybridCar2);
	    	hybridcars.save(hybridCar3);
	}
	
	
	@Test
	@DisplayName("Test count")
	void countTest() {
		
		Integer count = hybridcars.count();
		assertEquals(3, count);
		
		hybridcars.delete(1L);
		
		count = hybridcars.count();
		assertEquals(2, count);
		
		hybridcars.deleteAll();
		
		count = hybridcars.count();
		assertEquals(0, count);
	}
	
	
	@Test
	@DisplayName("Test findAll")
	void findAllTest() {
		
		List<HybridCar> find = hybridcars.findAll();
		assertEquals(3, find.size());
		
		hybridcars.delete(1L);
		
		find = hybridcars.findAll();
		assertEquals(2, find.size());
		
		for (HybridCar find1 : find) {
			assertNotNull(find1.getId());
		}	
	}
	
	
	@Test
	@DisplayName("Test findOne 1L")
	void findOne1LTest() {
		
		HybridCar find = hybridcars.findOne(1L);
		assertEquals(1L, find.getId());
		assertNotNull(find);
	}
	
	
	@Test
	@DisplayName("Test findOne Any")
	void findOneAnyTest() {
		
		HybridCar find1 = hybridcars.findOne(1L);
		HybridCar find2 = hybridcars.findOne(2L);
		HybridCar find3 = hybridcars.findOne(3L);
		
		assertEquals(1L, find1.getId());
		assertEquals(2L, find2.getId());
		assertEquals(3L, find3.getId());
		assertNotNull(find1);
		assertNotNull(find2);
		assertNotNull(find3);
	}
	
	
	@Test
	@DisplayName("Test findByManufacturer")
	void findByManufacturerTest() {
		
		List<HybridCar> find = hybridcars.findByManufacturer("Renault");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = hybridcars.findByManufacturer("Toyota");
		assertEquals(2, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByColor")
	void findByColorTest() {
		
		List<HybridCar> find = hybridcars.findByColor("Green");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = hybridcars.findByColor("Silver");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = hybridcars.findByColor("Lightblue");
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByCarDoors")
	void findByCarDoorsTest() {
		
		List<HybridCar> find = hybridcars.findByCarDoors(4);
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = hybridcars.findByCarDoors(5);
		assertEquals(2, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test saveCreate")
	void saveCreateTest() {
		HybridCar hybridCar1 = new HybridCar(0L, "Toyota", "Yaris", "Green", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "50kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1100D, 90D),
				new GasTank(1L, 75));
		
		HybridCar save = hybridcars.save(hybridCar1);
		assertNotNull(save);
		assertEquals(4L, save.getId());
		assertEquals(4, hybridcars.findAll().size());
		
		HybridCar hybridCar2 = new HybridCar(null, "Toyota", "Yaris", "Green", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "50kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1100D, 90D),
				new GasTank(1L, 75));
		save = hybridcars.save(hybridCar2);
	}
	
	@Test
	@DisplayName("Test saveEdit")
	void saveEditTest() {
		HybridCar hybridCar1 = new HybridCar(1L, "Toyota Editado", "Yaris", "Green", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "50kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1100D, 90D),
				new GasTank(1L, 75));
		
		HybridCar save = hybridcars.save(hybridCar1);
		assertNotNull(save);
		assertEquals(1L, save.getId());
		assertEquals(3, hybridcars.findAll().size());
	}
	
	@Test
	@DisplayName("Test delete")
	void deleteTest() {
		
		hybridcars.delete(1L);
		assertEquals(2, hybridcars.findAll().size());
		assertFalse(hybridcars.delete(null));
		assertFalse(hybridcars.delete(999L));
	}
	
}
