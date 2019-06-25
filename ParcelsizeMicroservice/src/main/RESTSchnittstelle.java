package main;

import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

@Path("getPackageSize")
public class RESTSchnittstelle {
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response getPackageSize(ParcelSize par) {
		System.out.println("[INFO] http request received");
		
		ParcelSize parcel = new ParcelSize();
		parcel.setHeight(par.getHeight());
		parcel.setLength(par.getLength());
		parcel.setWidth(par.getWidth());
		parcel.setParcelSize(parcel.calculateParcelSize());
		
		return Response.status(202).entity(parcel).build();
	}
	public static void main(String args[]) {
		
		ResourceConfig rc = new PackagesResourceConfig("main");
	    rc.getProperties().put(
	        "com.sun.jersey.spi.container.ContainerResponseFilters",
	        "main.CORSFilter");
	    
		HttpServer server;
		try {
			server = HttpServerFactory.create("http://localhost:3333/main", rc);
			server.start();
			//JOptionPane.showMessageDialog(null, "Ende");
			//server.stop(0);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
