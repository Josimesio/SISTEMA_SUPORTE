package com.pluma.help.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(HelpdeskApplication.class);

		// Abre navegador APENAS quando o Spring Boot estiver pronto
		app.addListeners((ApplicationListener<ApplicationReadyEvent>) event ->
				openBrowser("http://localhost:8080/login.html"));

		app.run(args);
	}

	private static void openBrowser(String url) {
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(new URI(url));
			} else {
				System.out.println("Abra manualmente no navegador: " + url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
