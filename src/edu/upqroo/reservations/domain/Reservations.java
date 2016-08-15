/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.domain;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Moises Barrera
 */
public class Reservations {
    private int id;
    private String CostumersName;
    private int SellerId;
    private Date SaleDate;
    private Date DepartureDate;
    private Date CompletionDate;
    //Clasificacion de Resevación
    private int TypeReservation;
    private String Description;
    private double Amount;
    private int Currency;
    private boolean ItsOk;
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getSellerId() {
        return SellerId;
    }

    public void setSellerId(int SellerId) {
        this.SellerId = SellerId;
    }

    public Date getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(Date SaleDate) {
        this.SaleDate = SaleDate;
    }

    public Date getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(Date DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public Date getCompletionDate() {
        return CompletionDate;
    }

    public void setCompletionDate(Date CompletionDate) {
        this.CompletionDate = CompletionDate;
    }

    public int getTypeReservation() {
        return TypeReservation;
    }

    public void setTypeReservation(int TypeReservation) {
        this.TypeReservation = TypeReservation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public int getCurrency() {
        return Currency;
    }

    public void setCurrency(int Currency) {
        this.Currency = Currency;
    }

    public boolean isItsOk() {
        return ItsOk;
    }

    public void setItsOk(boolean ItsOk) {
        this.ItsOk = ItsOk;
    }

    public String getCostumersName() {
        return CostumersName;
    }

    public void setCostumersName(String CostumersName) {
        this.CostumersName = CostumersName;
    }
    
    
}
