/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.exceptions;

/**
 *
 * @author Mauricio
 */
public class isEmptyReservationDataException extends Exception{
     private String message = "Some fields are empty, please fill after send";
    public isEmptyReservationDataException(){
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
