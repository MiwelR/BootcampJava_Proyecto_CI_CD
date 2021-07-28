package com.example.demo.service;

import com.example.demo.domain.Vehicle;

public class VehicleFactory {

	private static final String ELECTRIC = "electric";
	private static final String GASOLINE = "gasoline";
	private static final String HYBRID = "hybrid";
	
	public VehicleFactory() {
		
	}
	
	public static Vehicle createByType(String type) {
		
		return switch (type) {
			case ELECTRIC -> VehicleFacade.createElectric();
			case GASOLINE -> VehicleFacade.createGasoline();
			case HYBRID -> VehicleFacade.createHybrid();
			default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
	
}
