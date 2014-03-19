package com.css.eshop.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {

	@Path("/{username}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUser(@PathParam("username") String username) {
		// log.debug("username:{}", username);
		return username;
	}
}
