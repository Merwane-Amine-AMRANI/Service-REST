package org.amrani.exo3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("commune/Paris")
public class CommuneRS {


	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	public Response getCommune( @PathParam("id") long ident ) {
		Commune commune = new Commune(ident,"Paris");
		return Response.ok(commune).build();
	}
}
