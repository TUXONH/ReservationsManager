/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.isEmptyUserDataException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio
 */
public class UserServiceImpl implements UserService{
    private UsersDao usersDao;
    private int maxcontacts;
    private boolean exists;

    public UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
        this.exists = false;
        this.maxcontacts = 10;
    }
    
    @Override
    public void addUser(Users user) {
        if(this.maxcontacts == 0){
            for (int i = 0; i < this.usersDao.getAllUsers().size(); i++) {
                if(this.usersDao.getAllUsers().get(i).getUserName() == user.getUserName()){
                    this.exists = true;
                }
            }
            if(!this.exists){
                this.usersDao.addUser(user);
                this.maxcontacts--;
            }
        }
    }

    @Override
    public boolean DeleteUser(int id) {
        return this.usersDao.DeleteUser(id);
    }

    @Override
    public void UpdateUser(Users user){
        if(user.getName() == "" || user.getLastName() == ""){
            try {
                throw new isEmptyUserDataException();
            } catch (isEmptyUserDataException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.usersDao.UpdateUser(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return this.usersDao.getAllUsers();
    }

    @Override
    public Users GetUser(int id) {
        return this.usersDao.GetUser(id);
    }

    @Override
    public Users Login(String User, String Password) {
        Users user = null;
        if(User != "" || Password != ""){
            try {
                throw new isEmptyUserDataException();
            } catch (isEmptyUserDataException ex) {
                return user;
            }
        }
        for (int i = 0; i < this.usersDao.getAllUsers().size(); i++) {
            if(this.usersDao.getAllUsers().get(i).getUserName() == User && this.usersDao.getAllUsers().get(i).getPassword() == Password){
                user = this.usersDao.getAllUsers().get(i);
            }
        }
        return user;
    }
}


/*  user.setId(this.usersDao.getAllUsers().get(i).getId());
    user.setIsAdministrator(this.usersDao.getAllUsers().get(i).getIsAdministrator());
    user.setLastName(this.usersDao.getAllUsers().get(i).getLastName());
    user.setName(this.usersDao.getAllUsers().get(i).getName());
    user.setPassword(this.usersDao.getAllUsers().get(i).getPassword());
    user.setUserName(this.usersDao.getAllUsers().get(i).getUserName());*/