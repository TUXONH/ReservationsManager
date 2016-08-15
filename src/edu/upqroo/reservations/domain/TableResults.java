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
public class TableResults {
    public String Name;
    public int TotalVentas;
    public int Hotel;
    public int Vuelos;
    public int HotelMasVuelos;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTotalVentas() {
        return TotalVentas;
    }

    public void setTotalVentas(int TotalVentas) {
        this.TotalVentas = TotalVentas;
    }

    public int getHotel() {
        return Hotel;
    }

    public void setHotel(int Hotel) {
        this.Hotel = Hotel;
    }

    public int getVuelos() {
        return Vuelos;
    }

    public void setVuelos(int Vuelos) {
        this.Vuelos = Vuelos;
    }

    public int getHotelMasVuelos() {
        return HotelMasVuelos;
    }

    public void setHotelMasVuelos(int HotelMasVuelos) {
        this.HotelMasVuelos = HotelMasVuelos;
    }
    
    
}
