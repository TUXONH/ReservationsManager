/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.domain;

/**
 * 
 * @author Moises Barrera
 */
public class Users {
    private int id;
    private String Name;
    private String LastName;
    private String UserName;
    private String Password;
    private Boolean IsAdministrator;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Boolean getIsAdministrator() {
        return IsAdministrator;
    }

    public void setIsAdministrator(Boolean IsAdministrator) {
        this.IsAdministrator = IsAdministrator;
    }
    
    
    
}
