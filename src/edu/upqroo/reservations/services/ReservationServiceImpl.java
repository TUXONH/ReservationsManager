/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.domain.Reservations;
import edu.upqroo.reservations.exceptions.isEmptyReservationDataException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if(reservation.getDescription() == "")
        {
                        try {
                throw new isEmptyReservationDataException();
            } catch (isEmptyReservationDataException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.reservationsDao.addReservation(reservation);
    }

    @Override
    public void UpdateReservation(Reservations reservation) {
        if (reservation.getTypeReservation() > 0 && reservation.getDescription() != ""){
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
        Reservations reservations = this.reservationsDao.GetReservation(id);
        return reservations;
    }
    
}