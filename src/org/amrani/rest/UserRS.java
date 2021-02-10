package org.amrani.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.amrani.model.Commune;

@SuppressWarnings("unused")
@Path("user")
public class UserRS {

	@GET @Path("{code-postal}")
	
	public Commune helloWorld(
			@PathParam("code-postal") String codePostal) {
		return new Commune(codePostal, "Paris");
	}
}

