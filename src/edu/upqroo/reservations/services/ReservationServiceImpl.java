/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.domain.Reservations;
import java.util.List;

/**
 *
 * @author Horacio
 */
public class ReservationServiceImpl implements ReservationService{
    private ReservationsDao reservationsDao;
    private boolean exists = false;
    public ReservationServiceImpl(ReservationsDao reservationsDao) {
        this.reservationsDao = reservationsDao;
        this.exists = false;
    }
    
    @Override
    public void addReservation(Reservations reservation) {
        for (int i = 0; i < this.reservationsDao.GetAllReservations().size(); i++) {
            if (this.reservationsDao.GetAllReservations().get(i).getTypeReservation() == reservation.getTypeReservation() || 
                this.reservationsDao.GetAllReservations().get(i).getDescription() == reservation.getDescription() ||
                this.reservationsDao.GetAllReservations().get(i).getCostumers() == reservation.getCostumers()){
                    this.exists = true;
            }
        }
        if(!this.exists){
            this.reservationsDao.addReservation(reservation);
        }
    }

    @Override
    public void UpdateReservation(Reservations reservation) {
        if (reservation.getTypeReservation() > 0 && reservation.getDescription() != "" && reservation.getCostumers().size() > 0){
            this.reservationsDao.UpdateReservation(reservation);
        }
    }

    @Override
    public boolean DeleteReservation(int id) {
        return this.reservationsDao.DeleteReservation(id);
    }

    @Override
    public List<Reservations> GetAllReservations() {
        return this.reservationsDao.GetAllReservations();
    }

    @Override
    public Reservations GetReservation(int id) {
        Reservations reservations = null;
        for (int i = 0; i < this.GetAllReservations().size(); i++) {
            if(this.reservationsDao.GetAllReservations().get(i).getId() == id){
                reservations = this.reservationsDao.GetAllReservations().get(i);
            }
        }
        return reservations;
    }
    
}