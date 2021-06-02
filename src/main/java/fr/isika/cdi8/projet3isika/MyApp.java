package fr.isika.cdi8.projet3isika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication 
public class MyApp extends SpringBootServletInitializer  {
	
	public static void main(String[] args) {
		//SpringApplication.run(MyApp.class, args);
		
		SpringApplication app = new SpringApplication(MyApp.class);
	app.setAdditionalProfiles("initData");
	ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8080/myJsfSpringBootApp");
		
		
	}

}
