/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.daos;

import edu.upqroo.reservations.domain.Reservations;
import java.util.*;
/**
 *
 * @author Moises Barrera
 */
public interface ReservationsDao {
    void addReservation(Reservations reservation);
    void UpdateReservation(Reservations reservation);
    boolean DeleteReservation(int id);
    List<Reservations> GetAllReservations();
    Reservations GetReservation(int id);
}
