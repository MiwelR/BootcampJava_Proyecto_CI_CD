package com.example.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.GasolineCar;
import com.example.demo.service.GasolineCarService;

@Path("/gasoline")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class GasolineCarController {

	private GasolineCarService gasolineCarService;

	public GasolineCarController(GasolineCarService gasolineCarService) {
		this.gasolineCarService = gasolineCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/gasoline
	 */
    @GET
    public List<GasolineCar> findAll(){
        return gasolineCarService.findAll();
    }
	
    /**
     * GET
     * http://localhost:8080/api/gasoline/1
     * http://localhost:8080/api/gasoline/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	GasolineCar gasolineCar = gasolineCarService.findOne(id);
        if (gasolineCar == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(gasolineCar).build();
    }

    
    /**
     * GET
     * http://localhost:8080/api/gasoline/manufacturer/Mazda
     * http://localhost:8080/api/gasoline/manufacturer/Subaru
     */
    @GET
    @Path("/manufacturer/{manufacturer}")
    public List<GasolineCar> findByManufacturer(@PathParam("manufacturer") String manufacturer) {
    	return gasolineCarService.findByManufacturer(manufacturer);
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/gasoline/color/Black
     * http://localhost:8080/api/gasoline/color/White
     */
    @GET
    @Path("/color/{color}")
    public List<GasolineCar> findByColor(@PathParam("color") String color) {
    	return gasolineCarService.findByColor(color);
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/gasoline/doors/3
     * http://localhost:8080/api/gasoline/doors/5
     */
    @GET
    @Path("/doors/{doors}")
    public List<GasolineCar> findByCarDoors(@PathParam("doors") Integer doors) {
    	return gasolineCarService.findByCarDoors(doors);
    }
    
    
    /**
     * POST http://localhost:8080/api/gasoline
     */
    @POST // CREAR NUEVO
    public Response create(GasolineCar gasolineCar){
        if (gasolineCar.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        GasolineCar result = gasolineCarService.save(gasolineCar);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/gasoline
     */
    @PUT // ACTUALIZAR
    public Response update(GasolineCar gasolineCar){
        if (gasolineCar.getId() == null || gasolineCar.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        GasolineCar result = gasolineCarService.save(gasolineCar);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/gasoline/1
     * http://localhost:8080/api/gasoline/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!gasolineCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/gasoline
     */
    @DELETE
    public Response deleteAll(){
    	gasolineCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
