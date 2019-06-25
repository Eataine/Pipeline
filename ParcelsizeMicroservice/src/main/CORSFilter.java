package main;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

@Provider
public class CORSFilter implements ContainerResponseFilter{
	
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		    
		    response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
		    response.getHttpHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept");
		    response.getHttpHeaders().add("Access-Control-Allow-Methods", "POST, GET");

		    return response;
	}
		
}
