package de.hwrberlin.FriendsForFun.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
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

	// Startet die Anwendung
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// deaktiviert die Standart Errorpage und erlaubt die Verwendung einer eigenen
	// Errorpage
	@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })

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