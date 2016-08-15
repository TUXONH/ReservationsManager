/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.domain.Customers;
import java.util.List;

/**
 *
 * @author Horacio
 */
public interface CostumerService {
    void addCustormer(Customers customer);
    void UpdateCustomer(Customers customer);
    List<Customers> getAllCustomers();
    boolean DeleteCustomer(int id);
}
