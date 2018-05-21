package de.hwrberlin.FriendsForFun.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    public class AppConf {
    	@Bean
    	public NutzerManager nutzerManager() {
    		return new NutzerManager();
    	}
    	
    	@Bean
    	public OrtManager ortManager() {
    		return new OrtManager();
    	}
    
    	@Bean
    	public EventManager eventManager() {
    		return new EventManager();
    	}
    
    }
    
}