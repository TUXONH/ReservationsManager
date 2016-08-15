/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.exceptions;

/**
 * 
 * @author Moises Barrera
 */
public class IfUsersExistsException extends Exception{
private String message = "User exists, please insert a valid user";
    public IfUsersExistsException(){
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
