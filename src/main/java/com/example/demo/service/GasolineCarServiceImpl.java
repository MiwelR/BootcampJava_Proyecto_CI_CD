package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.GasolineCar;
import com.example.demo.domain.pieces.AirConditioner;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CarDoors;
import com.example.demo.domain.pieces.Engine;
import com.example.demo.domain.pieces.GasolineTank;

@Service
public class GasolineCarServiceImpl implements GasolineCarService {

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, GasolineCar> gasolinecars = new HashMap<>();

    static { // hardcoded demo data
    	
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
		
		
    	gasolinecars.put(1L, gasolineCar1);
    	gasolinecars.put(2L, gasolineCar2);
    	gasolinecars.put(3L, gasolineCar3);
    }
    
    @Override
    public Integer count() {
        return gasolinecars.keySet().size();
    }

    @Override
    public List<GasolineCar> findAll() {
        return new ArrayList<>(gasolinecars.values());
    }

    @Override
    public GasolineCar findOne(Long id) {
        return gasolinecars.get(id);
    }

    
    // Filtro de búsqueda por fabricante:
    @Override
    public List<GasolineCar> findByManufacturer(String manufacturer) {
    	
    	ArrayList<GasolineCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, GasolineCar> entry : gasolinecars.entrySet()) {
    		
    		if(entry.getValue().getManufacturer().equals(manufacturer)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }
    
    
    // Filtro de búsqueda por color:
    @Override
    public List<GasolineCar> findByColor(String color) {
    	
    	ArrayList<GasolineCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, GasolineCar> entry : gasolinecars.entrySet()) {
    		
    		if(entry.getValue().getColor().equals(color)) {
    			result.add(entry.getValue());
    		}	
		}
    	return result;
    }
    
    
    // Filtro de búsqueda por número de puertas:
    @Override
    public List<GasolineCar> findByCarDoors(Integer doors) {
    	
    	ArrayList<GasolineCar> result = new ArrayList<>();
    	
    	for(Map.Entry<Long, GasolineCar> entry : gasolinecars.entrySet()) {
    		
    		if(entry.getValue().getCarDoors().getDoors().equals(doors)) {
    			result.add(entry.getValue());
    		}	
		}
    	
    	return result;
    }
    
    @Override
    public GasolineCar save(GasolineCar gasolineCar) {

    	// asignar un id
        if (gasolineCar.getId() == null || gasolineCar.getId() == 0L) // nuevo gasolinecar
        	gasolineCar.setId(getMaxGasolineCarId() + 1); // genera id y lo asigna 

        // en caso de actualizar primero lo eliminamos
        gasolinecars.remove(gasolineCar.getId()); // en caso de que ya exista lo quita para actualizarlo

        // guarda el gasolinecar en el mapa
        gasolinecars.put(gasolineCar.getId(), gasolineCar);
        return gasolineCar;
    }

    /**
     * Devuelve el id más alto del mapa gasolinecar
     * @return
     */
    private Long getMaxGasolineCarId() {
    	if (gasolinecars.isEmpty())
			return 0L;

        return Collections.max(gasolinecars.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || !gasolinecars.containsKey(id))
            return false;
        gasolinecars.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!gasolinecars.isEmpty())
        	gasolinecars.clear();
    }
	
}
