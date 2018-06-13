package com.rocket.bot;

import org.apache.camel.builder.RouteBuilder;

import com.rocket.core.Rocket;

public class Bot extends RouteBuilder {

	public static void main(String... args) {
		Rocket.build().withClasses(Bot.class, BotConfiguration.class).withProperty("http.port", "8080").initialize().launchAndWait();
	}

	@Override
	public void configure() throws Exception {
		from("jetty:http://0.0.0.0:{{http.port}}/?matchOnUriPrefix=true").to("cxfbean:botSvc");
	}
}
