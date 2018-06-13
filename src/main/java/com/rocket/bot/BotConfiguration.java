package com.rocket.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rocket.bot.ws.BotSvcImpl;;

@Configuration
public class BotConfiguration {

	@Bean
	public BotSvcImpl botSvc(){
		return new BotSvcImpl();
	}
}
