package org.amrani.exo4;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@SuppressWarnings("unused")
@Path("commune")
public class CommuneRS {

	@EJB
	private CommuneEJB communeEJB;

	@GET
	@Path("{codepostal}")
	@Produces(MediaType.TEXT_XML)
	public Response getCommuneByCodePostal(@PathParam("codepostal") String codePostal) {

		Commune commune = communeEJB.findbyCodePostal(codePostal);

		if (commune == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(commune).build();
	}

	@GET
	@Path("json/{codepostal}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCommuneJsonByCodePostal(@PathParam("codepostal") String codePostal) {

		Commune commune = communeEJB.findbyCodePostal(codePostal);

		if (commune == null) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok(commune).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response deleteByCodePostal(@FormParam("codePostal") String codePostal) {
		communeEJB.deleteByCodePostal(codePostal);
		return Response.status(Status.ACCEPTED).build();
	}

	// @PUT
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateByCodePostal(@FormParam("name") String name, @FormParam("codePostal") String codePostal) {

		Commune commune = communeEJB.findbyCodePostal(codePostal);

		if (commune == null) {
			commune = new Commune(name, codePostal);
			communeEJB.insertIntoBase(commune);
			return Response.status(Status.CREATED).entity(commune).build();
		} else {
			communeEJB.updatebycodePostal(name, codePostal);
			return Response.status(Status.ACCEPTED).build();
		}

	}

}
