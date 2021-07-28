package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.ChargingPort;
import com.example.demo.domain.pieces.Engine;

@Service
public class ElectricCarServiceImpl implements ElectricCarService{

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, ElectricCar> electriccars = new HashMap<>();

    static { // hardcoded demo data
    	
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
		
		
    	electriccars.put(1L, electricCar1);
    	electriccars.put(2L, electricCar2);
    	electriccars.put(3L, electricCar3);
    }
    
    @Override
    public Integer count() {
        return electriccars.keySet().size();
    }

    @Override
    public List<ElectricCar> findAll() {
        return new ArrayList<>(electriccars.values());
    }

    @Override
    public ElectricCar findOne(Long id) {
        return electriccars.get(id);
    }
    
    // Filtro de búsqueda por fabricante:
    @Override
    public List<ElectricCar> findByManufacturer(String manufacturer) {
    	
    	ArrayList<ElectricCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, ElectricCar> entry : electriccars.entrySet()) {
    		
    		if(entry.getValue().getManufacturer().equals(manufacturer)) {
    			result.add(entry.getValue());
    		}
		}
    	return result;
    }
    
    // Filtro de búsqueda por color:
    @Override
    public List<ElectricCar> findByColor(String color) {
    	
    	ArrayList<ElectricCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, ElectricCar> entry : electriccars.entrySet()) {
    		
    		if(entry.getValue().getColor().equals(color)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }
    // Filtro de búsqueda por número de puertas:
    @Override
    public List<ElectricCar> findByCarDoors(Integer doors) {
    	
    	ArrayList<ElectricCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, ElectricCar> entry : electriccars.entrySet()) {
    		
    		if(entry.getValue().getCarDoors().getDoors().equals(doors)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }

    @Override
    public ElectricCar save(ElectricCar electricCar) {

    	// asignar un id
        if (electricCar.getId() == null || electricCar.getId() == 0L) // nuevo electric
        	electricCar.setId(getMaxElectricCarId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        electriccars.remove(electricCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el electric en el mapa
        electriccars.put(electricCar.getId(), electricCar);
        return electricCar;
    }

    /**
     * Devuelve el id más alto del mapa electric
     * @return
     */
    private Long getMaxElectricCarId() {
    	if (electriccars.isEmpty())
			return 0L;

        return Collections.max(electriccars.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !electriccars.containsKey(id))
            return false;
        electriccars.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!electriccars.isEmpty())
        	electriccars.clear();
    }
	
}
