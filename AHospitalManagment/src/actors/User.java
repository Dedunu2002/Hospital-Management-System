/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actors;

/**
 *
 * @author Dinithi
 */
public class User {
    private String name;
    private String email;
    private String userType;
    private String username;
    private String password;

    public User(String name, String email,String userType, String username, String password) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public User() {
      
    }

   
    public String getName() {
        return name;
    }
    
      public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        // Save in comma-separated format
        return name + "," + email + ","+ userType+ "," + username + "," + password;
    }
    
    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid item data format.");
        }
        String name = parts[0].trim();
        String email = parts[1].trim();
        String userType = parts[2].trim();
        String username = parts[3].trim();
        String password = parts[4].trim();

        return new User(name, email, userType, username,password);
    }
}
