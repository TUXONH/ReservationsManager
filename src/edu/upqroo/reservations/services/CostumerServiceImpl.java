/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.CustomersDao;
import edu.upqroo.reservations.domain.Customers;
import edu.upqroo.reservations.exceptions.IfCostumerExistsException;
import edu.upqroo.reservations.exceptions.isEmptyCostumerDataException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio
 */
public class CostumerServiceImpl implements CostumerService{
    private CustomersDao customersDao;
    private boolean exists = false;

    public CostumerServiceImpl(CustomersDao customers) {
        this.customersDao = customers;
        this.exists = false;
    }
    
    @Override
    public boolean checkIfCustomerExists(Customers customer){
        this.exists = false;
        for (int i = 0; i < this.getAllCustomers().size(); i++) {
            if(this.customersDao.getAllCustomers().get(i).getName() == customer.getName() && this.customersDao.getAllCustomers().get(i).getLastName() == customer.getLastName() && this.customersDao.getAllCustomers().get(i).getAddress() == customer.getAddress()){
                this.exists = true;
            }
        }
        return this.exists;
    }
    @Override
    public void addCustormer(Customers customer) {
        boolean costumerExists = this.checkIfCustomerExists(customer);
        if(costumerExists){
            throw new IfCostumerExistsException();
        }else{
            this.customersDao.addCustormer(customer);
        }
    }

    @Override
    public void UpdateCustomer(Customers customer) {
        if(customer.getName() != "" && customer.getLastName() != "" && customer.getAddress() != ""){
            try {
                throw new isEmptyCostumerDataException();
            } catch (isEmptyCostumerDataException ex) {
                Logger.getLogger(CostumerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.customersDao.UpdateCustomer(customer);
    }

    @Override
    public List<Customers> getAllCustomers() {
        return this.customersDao.getAllCustomers();
    }

    @Override
    public boolean DeleteCustomer(int id) {
        return this.customersDao.DeleteCustomer(id);
    }
    
}
