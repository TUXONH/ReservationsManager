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
public class IfLimitUsersException extends Exception{
    private static String message="Limite Alcanzado";
    public IfLimitUsersException (){
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
