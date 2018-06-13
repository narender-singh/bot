package com.rocket.bot.ws;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectReader;

import com.fasterxml.jackson.databind.JsonNode;

@Path("/")
public class BotSvcImpl {

	@Autowired
	private ObjectReader reader;
	
	
	@Path("/")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON, MediaType.WILDCARD})
	public Response onMessage(String json) throws IOException {
		JsonNode node = reader.readTree(json);		
		return Response.status(Response.Status.OK).entity(node.toString()).build();
	}
}
