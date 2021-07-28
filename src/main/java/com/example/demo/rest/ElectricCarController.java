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

import com.example.demo.domain.ElectricCar;
import com.example.demo.service.ElectricCarService;


@Path("/electric")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class ElectricCarController {

	private ElectricCarService electricCarService;

	public ElectricCarController(ElectricCarService electricCarService) {
		this.electricCarService = electricCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/electric
	 */
    @GET
    public List<ElectricCar> findAll(){
        return electricCarService.findAll();
    }
	
    /**
     * GET
     * http://localhost:8080/api/electric/1
     * http://localhost:8080/api/electric/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	ElectricCar electricCar = electricCarService.findOne(id);
        if (electricCar == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(electricCar).build();
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/electric/manufacturer/Tesla
     * http://localhost:8080/api/electric/manufacturer/Audi
     */
    @GET
    @Path("/manufacturer/{manufacturer}")
    public List<ElectricCar> findByManufacturer(@PathParam("manufacturer") String manufacturer) {
    	return electricCarService.findByManufacturer(manufacturer);
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/electric/color/Black
     * http://localhost:8080/api/electric/color/White
     */
    @GET
    @Path("/color/{color}")
    public List<ElectricCar> findByColor(@PathParam("color") String color) {
    	return electricCarService.findByColor(color);
    }
    
    
    /**
     * GET
     * http://localhost:8080/api/electric/doors/3
     * http://localhost:8080/api/electric/doors/5
     */
    @GET
    @Path("/doors/{doors}")
    public List<ElectricCar> findByCarDoors(@PathParam("doors") Integer doors) {
    	return electricCarService.findByCarDoors(doors);
    }

    
    /**
     * POST http://localhost:8080/api/electric
     */
    @POST // CREAR NUEVO
    public Response create(ElectricCar electricCar){
        if (electricCar.getId() != 0) // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        ElectricCar result = electricCarService.save(electricCar);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/electric
     */
    @PUT // ACTUALIZAR
    public Response update(ElectricCar electricCar){
        if (electricCar.getId() == null || electricCar.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        ElectricCar result = electricCarService.save(electricCar);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/electric/1
     * http://localhost:8080/api/electric/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!electricCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/electric
     */
    @DELETE
    public Response deleteAll(){
    	electricCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
    
}
