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
public class TypeOfReservation {
    public static int Hotel=1;
    public static int Avion=2;
    public static int HotelMasAvion=3;
    public static int Autobus=4;

    public static int getHotel() {
        return Hotel;
    }

    public static int getAvion() {
        return Avion;
    }

    public static int getHotelMasAvion() {
        return HotelMasAvion;
    }

    public static int getAutobus() {
        return Autobus;
    }
    
}
