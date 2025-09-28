/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connections;

import actors.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dinithi
 */
public class userConnect {
    private final String filePath = Paths.get("users.txt").toAbsolutePath().toString();;

    // Save user to the file
   public boolean saveCashier(User cashier) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
        writer.write(cashier.toString());
        writer.newLine();
        return true; // Return true if the operation succeeds
    } catch (IOException e) {
        System.err.println("Error saving user: " + e.getMessage());
        return false; // Return false if an exception occurs
    }
}
   
   public boolean deleteUser(String Name) {
        List<User> Users = loadUser();
        boolean found = false;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : Users) {
                if (!user.getName().equals(Name)) {
                    writer.write(user.toString());
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
            System.out.println("User with Name " + Name + " not found.");
        }
        return found;
    }


    // Load all cashiers from the file
    public List<User> loadUser() {
        List<User> cashiers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    cashiers.add(User.fromString(line));
                } catch (IllegalArgumentException e) {
                    System.err.println("Error parsing cashier data: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return cashiers;
    }

    // Validate cashier credentials
    public boolean validateCashier(String username, String password) {
        List<User> cashiers = loadUser();
        return cashiers.stream().anyMatch(cashier ->
            cashier.getUsername().equals(username) && cashier.getPassword().equals(password));
    }

    
}
