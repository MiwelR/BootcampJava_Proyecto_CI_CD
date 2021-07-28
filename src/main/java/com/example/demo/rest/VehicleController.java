package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.service.VehicleFactory;

/**
 * CRUD
 * 
 * RETRIEVE ONE id RETRIEVE ALL
 */
@Component
@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleController {

	/**
	 * http://localhost:8080/api/vehicle
	 * 
	 * @return
	 */
	@GET
	public Response hello() {
		String mensaje = "Portada Vehicle! Puede añadir a la ruta: '/' + tipo de vehículo (electric, gasoline o hybrid)";
		return Response.ok().entity(mensaje).build();
	}

	/**
	 * http://localhost:8080/api/vehicle/electric
	 * http://localhost:8080/api/vehicle/gasoline
	 * http://localhost:8080/api/vehicle/hybrid
	 * 
	 * @param type
	 * @return
	 */
	@GET
	@Path("/{type}")
	public Response createByType(@PathParam("type") String type) {
		System.out.println("VehicleController executing createByType.");
		try {
			return Response
					.ok()
					.entity(VehicleFactory.createByType(type))
					.build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}
	
}
