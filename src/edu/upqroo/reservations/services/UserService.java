/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.domain.TableResults;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.IfLimitUsersException;
import edu.upqroo.reservations.exceptions.IfUsersExistsException;
import edu.upqroo.reservations.exceptions.isEmptyUserDataException;
import java.util.List;

/**
 *
 * @author Horacio
 */
public interface UserService {
    void addUser(Users user) throws IfUsersExistsException, IfLimitUsersException;
    boolean DeleteUser(int id);
    void UpdateUser(Users user);
    List<Users> getAllUsers();
    Users GetUser(int id);
    Users Login(String User, String Password);
    List<TableResults> GetResultVentas();
}
