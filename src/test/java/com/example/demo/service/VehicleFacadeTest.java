package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Vehicle;


class VehicleFacadeTest {
	
	@Test
	@DisplayName("Test createElectric")
	void createElectricTest() {
		Vehicle electric = VehicleFacade.createElectric();
		assertNotNull(electric);
	}
	
	@Test
	@DisplayName("Test createGasoline")
	void createGasolineTest() {
		Vehicle gasoline = VehicleFacade.createGasoline();
		assertNotNull(gasoline);
	}
	
	@Test
	@DisplayName("Test createHybrid")
	void createHybridTest() {
		Vehicle hybrid = VehicleFacade.createHybrid();
		assertNotNull(hybrid);
	}
	
}
