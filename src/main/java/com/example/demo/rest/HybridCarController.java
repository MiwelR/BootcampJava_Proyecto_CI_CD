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

import com.example.demo.domain.HybridCar;
import com.example.demo.service.HybridCarService;

@Path("/hybrid")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class HybridCarController {

	private HybridCarService hybridCarService;

	public HybridCarController(HybridCarService hybridCarService) {
		this.hybridCarService = hybridCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/hybrid
	 */
    @GET
    public List<HybridCar> findAll(){
        return hybridCarService.findAll();
    }
	
    /**
     * GET
     * http://localhost:8080/api/hybrid/1
     * http://localhost:8080/api/hybrid/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	HybridCar hybridCar = hybridCarService.findOne(id);
        if (hybridCar == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(hybridCar).build();
    }

    /**
     * GET
     * http://localhost:8080/api/hybrid/manufacturer/Toyota
     * http://localhost:8080/api/hybrid/manufacturer/Renault
     */
    @GET
    @Path("/manufacturer/{manufacturer}")
    public List<HybridCar> findByManufacturer(@PathParam("manufacturer") String manufacturer) {
    	return hybridCarService.findByManufacturer(manufacturer);
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/hybrid/color/Black
     * http://localhost:8080/api/hybrid/color/White
     */
    @GET
    @Path("/color/{color}")
    public List<HybridCar> findByColor(@PathParam("color") String color) {
    	return hybridCarService.findByColor(color);
    }
    
    /**
     * GET
     * http://localhost:8080/api/hybrid/doors/3
     * http://localhost:8080/api/hybrid/doors/5
     */
    @GET
    @Path("/doors/{doors}")
    public List<HybridCar> findByCarDoors(@PathParam("doors") Integer doors) {
    	return hybridCarService.findByCarDoors(doors);
    }
    
    /**
     * POST http://localhost:8080/api/hybrid
     */
    @POST // CREAR NUEVO
    public Response create(HybridCar hybridCar){
        if (hybridCar.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        HybridCar result = hybridCarService.save(hybridCar);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/hybrid
     */
    @PUT // ACTUALIZAR
    public Response update(HybridCar hybridCar){
        if (hybridCar.getId() == null || hybridCar.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        HybridCar result = hybridCarService.save(hybridCar);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/hybrid/1
     * http://localhost:8080/api/hybrid/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!hybridCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/hybrid
     */
    @DELETE
    public Response deleteAll(){
    	hybridCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
