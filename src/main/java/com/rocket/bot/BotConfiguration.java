package com.rocket.bot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.IntentsSettings;
import com.rocket.bot.ws.BotSvcImpl;;

@Configuration
public class BotConfiguration {

	@Bean
	public BotSvcImpl botSvc() {
		return new BotSvcImpl();
	}

	public Map<String, String> key(ObjectMapper mapper)
			throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		return mapper.readValue(new FileInputStream("/home/nasingh/key.json"),
				new TypeReference<HashMap<String, String>>() {
				});
	}

	public Credentials svcCredentials() throws FileNotFoundException, IOException {
		return ServiceAccountCredentials.fromStream(new FileInputStream("/home/nasingh/key.json"));
	}

	public IntentsClient agentClient(Credentials credentials) throws IOException {
		return IntentsClient.create(IntentsSettings.newBuilder()
				.setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build());
	}
}
