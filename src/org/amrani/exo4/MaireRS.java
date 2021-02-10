package org.amrani.exo4;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("maire")
public class MaireRS {
	@EJB
	private MaireEJB maireEJB;

	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_XML)
	public Response getCommuneByCodePostal(@PathParam("id") int id) {

		Maire maire = maireEJB.findbyId(id);

		if (maire == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(maire).build();
	}

	@GET
	@Path("json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommuneJsonByCodePostal(@PathParam("id") int id) {

		Maire maire = maireEJB.findbyId(id);

		if (maire == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(maire).build();
	}
}
