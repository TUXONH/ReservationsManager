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
import edu.upqroo.reservations.ui.EmployeeData;

/**
 * 
 * @author Moises Barrera
 */
public class EditEmployee extends EmployeeData{

    private Users user;
    private static UserService userServices;
    private UsersDao ud = new UsersMongoDao();
    private ReservationsDao  rd = new ReservationsMongoDao();
    public EditEmployee(Users User) {
        this.user = User;
        userServices = new UserServiceImpl(ud,rd);
    }


    @Override
    protected void fillFields() {
      Nombre.setText(user.getName());
      Apellido.setText(user.getLastName());
      UserName.setText(user.getUserName());
      Password.setText(user.getPassword());
    }

    @Override
    protected void save(Users User) {
      this.user.setName(User.getName());
      this.user.setLastName(User.getLastName());
      this.user.setPassword(User.getUserName());
      this.user.setPassword(User.getPassword());
      userServices.UpdateUser(user);
    }

}
