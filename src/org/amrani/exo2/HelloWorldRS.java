package org.amrani.exo2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("exo1")
public class HelloWorldRS {

	@GET
	@Path("hello-world")
	public String helloWorld() {
		return "<h1> Hello-World !!! </h1>";
	}

	@GET
	@Path("{id}")
	public Response getIdFromParam(@PathParam("id") long id) {
		if (id % 2 == 0) {
			//valeur paire de ID ce service retourne un statut 200
			return Response.status(Status.OK).build();
		} else {
			//valeur impaire, ce service ne retourne rien et un statut 404
			return Response.status(Status.NOT_FOUND).build();
		}

	}
}
