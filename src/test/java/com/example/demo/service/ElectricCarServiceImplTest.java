package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.ChargingPort;
import com.example.demo.domain.pieces.Engine;

class ElectricCarServiceImplTest {

	ElectricCarService electriccars;
	
	@BeforeEach
	void setUp() throws Exception {
		electriccars = new ElectricCarServiceImpl();
		this.loadCars();

	}
	
	private void loadCars() throws Exception {
		electriccars.deleteAll();
	    ElectricCar electricCar1 = new ElectricCar(1L, "Tesla", "Model S", "Black",
	    			new AirConditioner(1L, 5),
					new Battery(1L, "95kWh"),
					new CarDoors(1L, 4),
					new Engine(1L, 2500D, 190D),
					new ChargingPort(1L, 2, "40 minutos"));
			
	    	ElectricCar electricCar2 = new ElectricCar(2L, "Audi", "E-Tron", "White", 
	    			new AirConditioner(1L, 6),
					new Battery(1L, "100kWh"),
					new CarDoors(1L, 5),
					new Engine(1L, 3000D, 200D),
					new ChargingPort(1L, 3, "35 minutos"));
			
	    	ElectricCar electricCar3 = new ElectricCar(3L, "Nissan", "Leaf", "Red", 
	    			new AirConditioner(1L, 4),
					new Battery(1L, "85kWh"),
					new CarDoors(1L, 3),
					new Engine(1L, 1800D, 120D),
					new ChargingPort(1L, 1, "45 minutos"));
			
			
	    	electriccars.save(electricCar1);
	    	electriccars.save(electricCar2);
	    	electriccars.save(electricCar3);
	}
	
	
	@Test
	@DisplayName("Test count")
	void countTest() {
		
		Integer count = electriccars.count();
		assertEquals(3, count);
		
		electriccars.delete(1L);
		
		count = electriccars.count();
		assertEquals(2, count);
		
		electriccars.deleteAll();
		
		count = electriccars.count();
		assertEquals(0, count);
	}
	
	
	@Test
	@DisplayName("Test findAll")
	void findAllTest() {
		
		List<ElectricCar> find = electriccars.findAll();
		assertEquals(3, find.size());
		
		electriccars.delete(1L);
		
		find = electriccars.findAll();
		assertEquals(2, find.size());
		
		for (ElectricCar find1 : find) {
			assertNotNull(find1.getId());
		}	
	}
	
	
	@Test
	@DisplayName("Test findOne 1L")
	void findOne1LTest() {
		
		ElectricCar find = electriccars.findOne(1L);
		assertEquals(1L, find.getId());
		assertNotNull(find);
	}
	
	
	@Test
	@DisplayName("Test findOne Any")
	void findOneAnyTest() {
		
		ElectricCar find1 = electriccars.findOne(1L);
		ElectricCar find2 = electriccars.findOne(2L);
		ElectricCar find3 = electriccars.findOne(3L);
		
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
		
		List<ElectricCar> find = electriccars.findByManufacturer("Tesla");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByManufacturer("Audi");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByManufacturer("Nissan");
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByColor")
	void findByColorTest() {
		
		List<ElectricCar> find = electriccars.findByColor("Black");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByColor("White");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByColor("Red");
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByCarDoors")
	void findByCarDoorsTest() {
		
		List<ElectricCar> find = electriccars.findByCarDoors(3);
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByCarDoors(4);
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = electriccars.findByCarDoors(5);
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test saveCreate")
	void saveCreateTest() {
		ElectricCar electricCar1 = new ElectricCar(0L, "Tesla", "Model S", "Black",
    			new AirConditioner(1L, 5),
				new Battery(1L, "95kWh"),
				new CarDoors(1L, 4),
				new Engine(1L, 2500D, 190D),
				new ChargingPort(1L, 2, "40 minutos"));
		
		ElectricCar save = electriccars.save(electricCar1);
		assertNotNull(save);
		assertEquals(4L, save.getId());
		assertEquals(4, electriccars.findAll().size());
		
		ElectricCar electricCar2 = new ElectricCar(null, "Tesla", "Model S", "Black",
    			new AirConditioner(1L, 5),
				new Battery(1L, "95kWh"),
				new CarDoors(1L, 4),
				new Engine(1L, 2500D, 190D),
				new ChargingPort(1L, 2, "40 minutos"));
		save = electriccars.save(electricCar2);
	}
	
	@Test
	@DisplayName("Test saveEdit")
	void saveEditTest() {
		ElectricCar electricCar1 = new ElectricCar(1L, "Tesla Editado", "Model S", "Black",
    			new AirConditioner(1L, 5),
				new Battery(1L, "95kWh"),
				new CarDoors(1L, 4),
				new Engine(1L, 2500D, 190D),
				new ChargingPort(1L, 2, "40 minutos"));
		
		ElectricCar save = electriccars.save(electricCar1);
		assertNotNull(save);
		assertEquals(1L, save.getId());
		assertEquals(3, electriccars.findAll().size());
	}
	
	@Test
	@DisplayName("Test delete")
	void deleteTest() {
		
		electriccars.delete(1L);
		assertEquals(2, electriccars.findAll().size());
		assertFalse(electriccars.delete(null));
		assertFalse(electriccars.delete(999L));
	}
	
}
