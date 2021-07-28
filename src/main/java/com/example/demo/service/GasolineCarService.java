package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.GasolineCar;


public interface GasolineCarService {

	Integer count();

    List<GasolineCar> findAll();

    GasolineCar findOne(Long id);
    
    // Filtros
    List<GasolineCar> findByManufacturer(String manufacturer);
    List<GasolineCar> findByColor(String color);
    List<GasolineCar> findByCarDoors(Integer doors);

    GasolineCar save(GasolineCar gasolineCar);

    boolean delete(Long id);

    void deleteAll();
	
}
