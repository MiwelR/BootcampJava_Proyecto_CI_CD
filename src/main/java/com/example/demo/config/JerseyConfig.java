package com.example.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@ApplicationPath("/api") // Anotación de Jersey para especificar la ruta base http de entrada a la aplicación
@Component // Anotación Spring para que se creen los objetos automáticamente
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// declarar donde estan las clases controladoras
		this.packages("com.example.demo.rest");
	}

	
}
