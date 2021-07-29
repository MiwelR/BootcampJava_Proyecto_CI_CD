package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Vehicle;

public class VehicleFactoryTest {

	
	@Test
	@DisplayName("Test createByType")
	void createByTypeTest() throws IllegalArgumentException {
		// Electric Type
		Vehicle electric = VehicleFactory.createByType("electric");
		assertNotNull(electric);
		electric.getEngine().start();
		assertEquals(false, electric.getEngine().getOn());
		
		// Gasoline Type
		Vehicle gasoline = VehicleFactory.createByType("gasoline");
		assertNotNull(gasoline);
		assertEquals(false, gasoline.getEngine().getOn());
		
		// Hybrid Type
		Vehicle hybrid = VehicleFactory.createByType("hybrid");
		assertNotNull(hybrid);
		assertEquals(false, hybrid.getEngine().getOn());
		
		// Error Type
		assertThrows(IllegalArgumentException.class, () -> {
			VehicleFactory.createByType("");
			});
	}
	
}
