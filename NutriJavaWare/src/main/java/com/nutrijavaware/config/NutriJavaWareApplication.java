package com.nutrijavaware.config;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.nutrijavaware.JFrame.SingUp;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NutriJavaWareApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(NutriJavaWareApplication.class, args);	
		SwingUtilities.invokeLater(() -> new SingUp());
		
	}
}
