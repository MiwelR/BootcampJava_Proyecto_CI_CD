package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasTank;

@Service
public class HybridCarServiceImpl implements HybridCarService {

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, HybridCar> hybridcars = new HashMap<>();

    static { // hardcoded demo data
    	
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
		
		
    	hybridcars.put(1L, hybridCar1);
    	hybridcars.put(2L, hybridCar2);
    	hybridcars.put(3L, hybridCar3);
    }
    
    @Override
    public Integer count() {
        return hybridcars.keySet().size();
    }

    @Override
    public List<HybridCar> findAll() {
        return new ArrayList<>(hybridcars.values());
    }

    @Override
    public HybridCar findOne(Long id) {
        return hybridcars.get(id);
    }

    
    // Filtro de búsqueda por fabricante:
    @Override
    public List<HybridCar> findByManufacturer(String manufacturer) {
    	
    	ArrayList<HybridCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, HybridCar> entry : hybridcars.entrySet()) {
    		
    		if(entry.getValue().getManufacturer().equals(manufacturer)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }
    
    
    // Filtro de búsqueda por color:
    @Override
    public List<HybridCar> findByColor(String color) {
    	
    	ArrayList<HybridCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, HybridCar> entry : hybridcars.entrySet()) {
    		
    		if(entry.getValue().getColor().equals(color)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }
    
    
    // Filtro de búsqueda por número de puertas:
    @Override
    public List<HybridCar> findByCarDoors(Integer doors) {
    	
    	ArrayList<HybridCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, HybridCar> entry : hybridcars.entrySet()) {
    		
    		if(entry.getValue().getCarDoors().getDoors().equals(doors)) {
    			result.add(entry.getValue());
    		}	
		}	
    	return result;
    }
    
    @Override
    public HybridCar save(HybridCar hybridCar) {

    	// asignar un id
        if (hybridCar.getId() == null || hybridCar.getId() == 0L) // nuevo hybridcar
        	hybridCar.setId(getMaxHybridCarId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        hybridcars.remove(hybridCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el hybridcar en el mapa
        hybridcars.put(hybridCar.getId(), hybridCar);
        return hybridCar;
    }

    /**
     * Devuelve el id más alto del mapa hybridcars
     * @return
     */
    private Long getMaxHybridCarId() {
    	if (hybridcars.isEmpty())
			return 0L;

        return Collections.max(hybridcars.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !hybridcars.containsKey(id))
            return false;
        hybridcars.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!hybridcars.isEmpty())
        	hybridcars.clear();
    }
	
}
