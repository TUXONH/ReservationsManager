/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.domain.Users;
import java.util.List;

/**
 *
 * @author Horacio
 */
public interface UserService {
    List<Users> getAllUsers();
    void addUser(Users user);
    Users login(String NameUser, String pass);
}
