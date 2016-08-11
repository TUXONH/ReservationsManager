/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.exceptions;

/**
 *
 * @author Horacio
 */
public class isEmptyUserDataException extends Exception {
    private String message = "Name or Lastname fields are empty, pleasy fill after send";
    public isEmptyUserDataException(){
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
