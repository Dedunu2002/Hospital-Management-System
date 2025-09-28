/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;

import actors.consultant;
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
public class consultantConnect {
    private final String filePath = Paths.get("consultant.txt").toAbsolutePath().toString();
    
     public List<consultant> loadConsultant() {
        List<consultant> Consultants = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Consultants.add(consultant.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing consultant data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for (consultant Consultant : Consultants) {
            System.out.println(Consultant.getName());
        }
        return Consultants;
    }


    public boolean saveConsultant(consultant Consultant) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(Consultant.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving consultant: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteConsultant(String consultantName) {
        List<consultant> Consultants = loadConsultant();
        boolean found = false;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (consultant Consultant : Consultants) {
                if (!Consultant.getName().equals(consultantName)) {
                    writer.write(Consultant.toString());
                    writer.newLine();
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error updating consultant file: " + e.getMessage());
            return false;
        }
        
        if (!found) {
            System.out.println("Consultant with Name " + consultantName + " not found.");
        }
        return found;
    }
    
    
    public boolean updateConsultantFile(String consultantName, String newGender, String newSpecialization, double charges) {
    List<consultant> Consultants = loadConsultant();
    boolean found = false;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (consultant Consultant : Consultants) {
            if (Consultant.getName().equalsIgnoreCase(consultantName)) {
                // Update consultant details
                Consultant.setGender(newGender);
                Consultant.setSpecialization(newSpecialization);
                Consultant.setCharges(charges);
                found = true;
            }
            writer.write(Consultant.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error updating consultant file: " + e.getMessage());
        return false;
    }

    if (!found) {
        System.out.println("Consultant with Name " + consultantName + " not found.");
    }
    return found;
}

    
    
}
