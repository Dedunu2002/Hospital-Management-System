/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;

import actors.patient;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dinithi
 */
public class patientConnect {
    private final String filePath = Paths.get("patient.txt").toAbsolutePath().toString();
    
    public List<patient> loadPatient(){
        List<patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    patients.add(patient.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing patient data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for(patient patient : patients){
            System.out.println(patient.getFullName());
        }
        return patients;
    }
    
    public boolean savePatient(patient Patient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(Patient.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving patient: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletePatient(String patientName) {
        List<patient> Patients = loadPatient();
        boolean found = false;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (patient Patient : Patients) {
                if (!Patient.getFullName().equals(patientName)) {
                    writer.write(Patient.toString());
                    writer.newLine();
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error updating patient file: " + e.getMessage());
            return false;
        }
        
        if (!found) {
            System.out.println("Patient with Name " + patientName + " not found.");
        }
        return found;
    }
    
    // Update patient details
     public boolean updatePatientFile(String patientName, String newPhone, String newEmail, String newAddress, String newDate, String newDoctorName, String newComments) {
        List<patient> patients = loadPatient();  // Load the current list of patients
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate through each patient in the list
            for (patient Patient : patients) {
                // Check if the patient's name matches the one to be updated
                if (Patient.getFullName().equalsIgnoreCase(patientName)) {
                    // Update patient's details
                    Patient.setPhone(newPhone);
                    Patient.setEmail(newEmail);
                    Patient.setAddress(newAddress);
                    Patient.setDate(newDate);
                    Patient.setDoctorName(newDoctorName);
                    Patient.setComments(newComments);
                    found = true;  // Mark the patient as found
                }
                // Write the patient (whether updated or not) back to the file
                writer.write(Patient.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating patient file: " + e.getMessage());
            return false;  // Return false if there’s an error during IO operations
        }

        // If no patient was found, print a message
        if (!found) {
            System.out.println("Patient with Name " + patientName + " not found.");
        }
        return found;  // Return true if the patient was found and updated
    }
    
    

}
