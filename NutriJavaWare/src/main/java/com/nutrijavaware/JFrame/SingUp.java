package com.nutrijavaware.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nutrijavaware.controller.JsonDataSignUp;
import com.nutrijavaware.model.Patient;





public class SingUp extends JFrame{
	
		private JFrame frame;
		private JPanel panel;
		private JTextField nameField;
		private JTextField ageField;

		public SingUp() {
			super("Sing Up the Patient. ");
			initializeUI();
		}

		private void initializeUI() {
			frame = new JFrame("NutriJavaWare");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 300);

			panel = new JPanel();
			frame.add(panel);
			placeComponents(panel);

			frame.setVisible(true);
		}

		private void placeComponents(JPanel panel) {
			panel.setLayout(null);

			JLabel nameLabel = new JLabel("Nombre: ");
			nameLabel.setBounds(10, 20, 80, 25);
			panel.add(nameLabel);

			nameField = new JTextField(20);
			nameField.setBounds(100, 20, 165, 25);
			panel.add(nameField);

			JLabel ageLabel = new JLabel("Edad:");
			ageLabel.setBounds(10, 50, 80, 25);
			panel.add(ageLabel);

			ageField = new JTextField(20);
			ageField.setBounds(100, 50, 165, 25);
			panel.add(ageField);

			JButton saveButton = new JButton("Guardar");
			saveButton.setBounds(10, 80, 80, 25);
			saveButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						String name = nameField.getText();
						int age = Integer.parseInt(ageField.getText());
						Patient patient = new Patient(name, age);
						JsonDataSignUp jsonHandler = new JsonDataSignUp("patients.json");
						jsonHandler.savePatient(patient);
					}catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(frame, "Please, write a valid age.", "Format Error", JOptionPane.ERROR_MESSAGE);
			        }					
				
				}
			});
			panel.add(saveButton);
		}

	
}
