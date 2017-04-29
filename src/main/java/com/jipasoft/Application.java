package com.jipasoft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableScheduling
@PropertySource("application.properties")
public class Application {

	@SuppressWarnings("resource")
	public static void main(String... args) {
		new AnnotationConfigApplicationContext(Application.class);
	}
}
