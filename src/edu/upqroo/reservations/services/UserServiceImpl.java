/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.domain.Users;
import java.util.List;

/**
 *
 * @author Horacio
 */
public class UserServiceImpl implements UserService{

    private UsersDao  userDao;
    private List<Users> users;
        public UserServiceImpl(UsersDao userDao)
    {
        this.userDao = userDao;
    }
    @Override
    public List<Users> getAllUsers() {
       return userDao.getAllUsers();
    }

    @Override
    public void addUser(Users user) {
        userDao.addUser(user);
    }

    @Override
    public Users login(String NameUser, String pass) throws UserNotExistsException{
       users = getAllUsers();
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getUserName().equals(NameUser) && users.get(i).getPassword().equals(pass))
            {
                return users.get(i);
            }
        }
        throw new UserNotExistsException();
    }
    
}
