package com.nutrijavaware.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nutrijavaware.model.Patient;

public class JsonDataSignUp {

	private ObjectMapper objectMapper;
	private String filePath;

	public JsonDataSignUp(String filePath) {
		this.objectMapper = new ObjectMapper();
		this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		this.filePath = filePath;
	}

	public void savePatient(Patient patient) {
		
		 List<Patient> patients = loadPatients();
		 patients.add(patient);
		 
		try {
			objectMapper.writeValue(new File(filePath), patients);
			System.out.println("Data saved in Json Format.");
		} catch (IOException e) {
			System.out.println("Error saving patient: " + e.getMessage());
		}
	}

	public List<Patient> loadPatients(){
		try {
			File file = new File(filePath);
			if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Patient.class));
            } else {
                return new ArrayList<>(); 
            }
		}catch (IOException e) {
            System.err.println("Error loading the patient list: " + e.getMessage());
            return new ArrayList<>();
		}

	}
}
