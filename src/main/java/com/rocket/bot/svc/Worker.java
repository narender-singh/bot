package com.rocket.bot.svc;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.cloud.dialogflow.v2.Agent;
import com.google.cloud.dialogflow.v2.GetIntentRequest;
import com.google.cloud.dialogflow.v2.IntentsClient;
import com.google.cloud.dialogflow.v2.ProjectName;

public class Worker {

	private Agent agent;

	@Autowired
	private IntentsClient iClient;

	public Worker(IntentsClient agentsClient) {
		this.iClient = agentsClient;
		ProjectName name = ProjectName.of("Dummy Bot");		
	}

}
