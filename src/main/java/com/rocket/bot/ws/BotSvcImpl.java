package com.rocket.bot.ws;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;

public class BotSvcImpl implements IBotService {

	public Response onMessage(JsonNode json) {
		return Response.status(Response.Status.OK).build();
	}
}
