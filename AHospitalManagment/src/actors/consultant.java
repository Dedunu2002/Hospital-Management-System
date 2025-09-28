/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actors;

/**
 *
 * @author Dinithi
 */
public class consultant {
    private String name;
    private String gender;
    private String specialization;
    private double charges;


    public consultant(String name, String gender, String specialization, double charges) {
        this.name = name;
        this.gender = gender;
        this.specialization = specialization;
        this.charges = charges;
    }

    // Public getter and setter methods to provide controlled access

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        if (charges > 0) { // Validation to ensure price is positive
            this.charges = charges;
        } else {
            System.out.println("Charges must be positive.");
        }
    }

    @Override
    public String toString() {
        return  name+","+gender+","+specialization+","+charges;
    }
    
    public static consultant fromString(String ConsultantData) {
        String[] parts = ConsultantData.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid consultant data format. Expected 'name, gender, specialization and charges'.");
        }

        String name = parts[0].trim();
        String gender = parts[1].trim();
        String specialization = parts[2].trim();
        double charges = Double.parseDouble(parts[3].trim());
        

        
        return new consultant(name, gender, specialization, charges);
    }
}
