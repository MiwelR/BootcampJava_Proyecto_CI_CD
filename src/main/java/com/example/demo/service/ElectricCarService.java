package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ElectricCar;


public interface ElectricCarService {

	Integer count();

    List<ElectricCar> findAll();

    ElectricCar findOne(Long id);
    
    // Filtros
    List<ElectricCar> findByManufacturer(String manufacturer);
    List<ElectricCar> findByColor(String color);
    List<ElectricCar> findByCarDoors(Integer doors);
    
    ElectricCar save(ElectricCar electricCar);

    boolean delete(Long id);

    void deleteAll();
	
}
