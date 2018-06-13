package com.rocket.bot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rocket.bot.ws.BotSvcImpl;
import com.rocket.bot.ws.IBotService;;

@Configuration
public class BotConfiguration {

	@Bean
	public IBotService botSvc(){
		return new BotSvcImpl();
	}
}
