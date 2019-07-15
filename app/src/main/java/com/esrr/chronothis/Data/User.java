package com.esrr.chronothis.Data;

public class User {

    public int UserID;
    public String FirstName;
    public String LastName;
    public String Email;

    public User(int userID, String firstName, String lastName, String email){

        UserID = userID;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
    }
}
