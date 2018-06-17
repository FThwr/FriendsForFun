package de.hwrberlin.FriendsForFun.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventteilnehmerManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;
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
    	public KategorieManager kategorieManager() {
    		return new KategorieManager();
    	}
    	
    	@Bean
    	public NutzerManager nutzerManager() {
    		return new NutzerManager();
    	}
    	
    	@Bean
    	public AktivitaetManager aktivtaetManager() {
    		return new AktivitaetManager();
    	}
    	
    	@Bean
    	public OrtManager ortManager() {
    		return new OrtManager();
    	}
    	
    	@Bean
    	public AktivitaetManager aktivitaetManager() {
    		return new AktivitaetManager();
    	}
    
    	@Bean
    	public EventManager eventManager() {
    		return new EventManager();
    	}
    	
    	@Bean
    	public EventteilnehmerManager eventteilnehmerManager() {
    		return new EventteilnehmerManager();
    	}
    
    }
    
}