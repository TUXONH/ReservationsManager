/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.daos;

import edu.upqroo.reservations.domain.Users;
import java.util.*;

/**
 *
 * @author Moises Barrera
 */
public interface UsersDao {
    void addUser(Users user);
    boolean DeleteUser(int id);
    void UpdateUser(Users user);
    List<Users> getAllUsers();
    Users GetUser(int id);
}