package org.amrani.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("userID")
public class UserID {

	@GET @Path("{ID}")
	@Produces (MediaType.TEXT_XML)
	public Response SimpleService(
			@PathParam("ID") int ID) {
		
		if(ID%2==0)
			return Response.status(200).build();
		else
			return Response.status(404).build();

	}
}
