/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.services;

import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.ui.EmployeeData;

/**
 * 
 * @author Moises Barrera
 */
public class AddEmployee extends EmployeeData{

    public AddEmployee(UserService service) {
        super(service);
    }


    @Override
    protected void fillFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void save(Users User) {
        userService.addUser(User);
    }

}
