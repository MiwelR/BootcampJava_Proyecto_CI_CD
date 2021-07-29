package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.GasolineCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasolineTank;

public class GasolineCarServiceImplTest {

GasolineCarService gasolinecars;
	
	@BeforeEach
	void setUp() throws Exception {
		gasolinecars = new GasolineCarServiceImpl();
		this.loadCars();

	}
	
	private void loadCars() throws Exception {
		gasolinecars.deleteAll();
		GasolineCar gasolineCar1 = new GasolineCar(1L, "Mazda", "MX-5", "Yellow", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "35kWh"),
				new CarDoors(1L, 2),
				new Engine(1L, 2500D, 190D),
				new GasolineTank(1L, 80));
		
    	GasolineCar gasolineCar2 = new GasolineCar(2L, "Subaru", "BRZ", "Blue", 
    			new AirConditioner(1L, 4),
				new Battery(1L, "40kWh"),
				new CarDoors(1L, 3),
				new Engine(1L, 2000D, 180D),
				new GasolineTank(1L, 80));
		
    	GasolineCar gasolineCar3 = new GasolineCar(3L, "Peugeot", "2008", "Darkblue", 
    			new AirConditioner(1L, 6),
				new Battery(1L, "50kWh"),
				new CarDoors(1L, 5),
				new Engine(1L, 1200D, 110D),
				new GasolineTank(1L, 50));
			
			
	    	gasolinecars.save(gasolineCar1);
	    	gasolinecars.save(gasolineCar2);
	    	gasolinecars.save(gasolineCar3);
	}
	
	
	@Test
	@DisplayName("Test count")
	void countTest() {
		
		Integer count = gasolinecars.count();
		assertEquals(3, count);
		
		gasolinecars.delete(1L);
		
		count = gasolinecars.count();
		assertEquals(2, count);
		
		gasolinecars.deleteAll();
		
		count = gasolinecars.count();
		assertEquals(0, count);
	}
	
	
	@Test
	@DisplayName("Test findAll")
	void findAllTest() {
		
		List<GasolineCar> find = gasolinecars.findAll();
		assertEquals(3, find.size());
		
		gasolinecars.delete(1L);
		
		find = gasolinecars.findAll();
		assertEquals(2, find.size());
		
		for (GasolineCar find1 : find) {
			assertNotNull(find1.getId());
		}	
	}
	
	
	@Test
	@DisplayName("Test findOne 1L")
	void findOne1LTest() {
		
		GasolineCar find = gasolinecars.findOne(1L);
		assertEquals(1L, find.getId());
		assertNotNull(find);
	}
	
	
	@Test
	@DisplayName("Test findOne Any")
	void findOneAnyTest() {
		
		GasolineCar find1 = gasolinecars.findOne(1L);
		GasolineCar find2 = gasolinecars.findOne(2L);
		GasolineCar find3 = gasolinecars.findOne(3L);
		
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
		
		List<GasolineCar> find = gasolinecars.findByManufacturer("Mazda");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByManufacturer("Subaru");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByManufacturer("Peugeot");
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByColor")
	void findByColorTest() {
		
		List<GasolineCar> find = gasolinecars.findByColor("Yellow");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByColor("Blue");
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByColor("Darkblue");
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test findByCarDoors")
	void findByCarDoorsTest() {
		
		List<GasolineCar> find = gasolinecars.findByCarDoors(2);
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByCarDoors(3);
		assertEquals(1, find.size());
		assertNotNull(find);
		
		find = gasolinecars.findByCarDoors(5);
		assertEquals(1, find.size());
		assertNotNull(find);
	}
	
	@Test
	@DisplayName("Test saveCreate")
	void saveCreateTest() {
		GasolineCar gasolineCar1 = new GasolineCar(0L, "Mazda", "MX-5", "Yellow", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "35kWh"),
				new CarDoors(1L, 2),
				new Engine(1L, 2500D, 190D),
				new GasolineTank(1L, 80));
		
		GasolineCar save = gasolinecars.save(gasolineCar1);
		assertNotNull(save);
		assertEquals(4L, save.getId());
		assertEquals(4, gasolinecars.findAll().size());
		
		GasolineCar gasolineCar2 = new GasolineCar(null, "Mazda", "MX-5", "Yellow", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "35kWh"),
				new CarDoors(1L, 2),
				new Engine(1L, 2500D, 190D),
				new GasolineTank(1L, 80));
		save = gasolinecars.save(gasolineCar2);
	}
	
	@Test
	@DisplayName("Test saveEdit")
	void saveEditTest() {
		GasolineCar gasolineCar1 = new GasolineCar(1L, "Mazda Editado", "MX-5", "Yellow", 
    			new AirConditioner(1L, 5),
				new Battery(1L, "35kWh"),
				new CarDoors(1L, 2),
				new Engine(1L, 2500D, 190D),
				new GasolineTank(1L, 80));
		
		GasolineCar save = gasolinecars.save(gasolineCar1);
		assertNotNull(save);
		assertEquals(1L, save.getId());
		assertEquals(3, gasolinecars.findAll().size());
	}
	
	@Test
	@DisplayName("Test delete")
	void deleteTest() {
		
		gasolinecars.delete(1L);
		assertEquals(2, gasolinecars.findAll().size());
		assertFalse(gasolinecars.delete(null));
		assertFalse(gasolinecars.delete(999L));
	}
	
}
