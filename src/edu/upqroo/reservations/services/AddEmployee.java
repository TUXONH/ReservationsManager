/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.daos.ReservationsMongoDao;
import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.daos.UsersMongoDao;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.IfLimitUsersException;
import edu.upqroo.reservations.exceptions.IfUsersExistsException;
import edu.upqroo.reservations.ui.EmployeeData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Moises Barrera
 */
public class AddEmployee extends EmployeeData{

    private static UserService userServices;
    private UsersDao ud = new UsersMongoDao();
    private ReservationsDao  rd = new ReservationsMongoDao();

    public AddEmployee(){
        userServices = new UserServiceImpl(ud,rd);
    }
    
    @Override
    protected void fillFields() {
        
    }

    @Override
    protected void save(Users User) throws IfUsersExistsException, IfLimitUsersException{
        User.setIsAdministrator(false);
            userServices.addUser(User) ;
    }

}
