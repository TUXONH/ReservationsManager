/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.daos;

import edu.upqroo.reservations.domain.Customers;
import java.util.*;
/**
 *
 * @author Moises Barrera
 */
public interface CustomersDao {
    void addCustormer(Customers customer);
    void UpdateCustomer(Customers customer);
    List<Customers> getAllCustomers();
}
