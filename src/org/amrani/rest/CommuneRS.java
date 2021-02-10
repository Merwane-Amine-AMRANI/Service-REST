package org.amrani.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.amrani.model.Commune;

@Path("commune")
public class CommuneRS {

	@GET @Path("{code-postal}")
	
	public Commune helloWorld(
			@PathParam("code-postal") String codePostal) {
		return new Commune(codePostal, "Paris");
	}
}


