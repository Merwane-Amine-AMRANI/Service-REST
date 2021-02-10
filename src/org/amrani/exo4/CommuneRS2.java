package org.amrani.exo4;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("commune/create")
public class CommuneRS2 {

	@EJB
	private CommuneEJB communeEJB;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCommune(@FormParam("name") String name, @FormParam("codePostal") String codePostal) {

		Commune commune = new Commune(codePostal, name);

		boolean returnValue = communeEJB.insertIntoBase(commune);

		if (returnValue) {
			return Response.status(Status.CONFLICT).build();
		}

		return Response.status(Status.CREATED).entity(commune).build();

	}

}
