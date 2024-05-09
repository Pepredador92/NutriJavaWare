package com.nutrijavaware.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Patient {

	private String name;
	private int age;
	
	public Patient(String nombre, int edad) {
		super();
		this.name = nombre;
		this.age = edad;
	}
	
}
