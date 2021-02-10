package org.amrani.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.amrani.model.Commune;

@Path("commune")
public class CommuneRSExample {

	@GET @Path("{ville}/{id}")
	
	public Commune ShowCommune(
			@PathParam("ville") String ville,@PathParam("id") String id) {
		return new Commune(id, ville);
	}
}


