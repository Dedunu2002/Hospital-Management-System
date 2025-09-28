/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actors;


/**
 *
 * @author Dinithi
 */
public class patient {
     private String fullName;
     private String phone;
     private String email;
     private String address;
    private String date;
    private String doctorName;
    private String comments;

    // Constructor to initialize the object
    public patient(String fullName, String phone, String email, String address, String date, String doctorName, String comments) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.date = date;
        this.doctorName = doctorName;
        this.comments = comments;
    }

    // Public getter and setter methods to provide controlled access

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
   
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        
       this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
       this.date = date;
    }
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
       this.comments = comments;
    }
    

   
    
     @Override
    public String toString() {
        // Save in comma-separated format
        return fullName + "," + phone + "," + email + ","  + address +"," + date + "," + doctorName + "," + comments;
    }
    
    
    public static patient fromString(String PatientData) {
        String[] parts = PatientData.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid patient data format. Expected 'full name, phone, email, address, date, doctorName and comments'");
        }

        String fullName = parts[0].trim();
        String phone = parts[1].trim();
        String email = parts[2].trim();
        String address = parts[3].trim();
        String date = parts[4].trim();
        String doctorName = parts[5].trim();
        String comments = parts[6].trim();
        

        if (fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || date.isEmpty() || doctorName.isEmpty() || comments.isEmpty()) {
            throw new IllegalArgumentException("Patient details cannot be empty.");
        }
        return new patient(fullName, phone, email, address, date, doctorName, comments);
    }


}
