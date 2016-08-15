/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.services;

import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.domain.Reservations;
import edu.upqroo.reservations.domain.TableResults;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.IfLimitUsersException;
import edu.upqroo.reservations.exceptions.IfUsersExistsException;
import edu.upqroo.reservations.exceptions.isEmptyUserDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio
 */
public class UserServiceImpl implements UserService{
    private UsersDao usersDao;
    private ReservationsDao Reservation;
    private int maxcontacts=10;
    private boolean exists;

    public UserServiceImpl(UsersDao usersDao, ReservationsDao Reservation) {
        this.usersDao = usersDao;
        this.Reservation = Reservation;
        this.exists = false;
    }
    
    @Override
    public void addUser(Users user) throws IfUsersExistsException, IfLimitUsersException{
        if(maxcontacts >0){
            for (int i = 0; i < this.usersDao.getAllUsers().size(); i++) {
                if(this.usersDao.getAllUsers().get(i).getUserName().equalsIgnoreCase(user.getUserName()) ){
                    throw new IfUsersExistsException();
                }
            }
            if(!this.exists){
                this.usersDao.addUser(user);
                this.maxcontacts--;
            }
        } else {
           throw new IfLimitUsersException();
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
        
        if(User == "" || Password == ""){
            try {
                throw new isEmptyUserDataException();
            } catch (isEmptyUserDataException ex) {
                return user;
            }
        }
        List<Users> AllUsers = this.usersDao.getAllUsers();
        for (int i = 0; i < AllUsers.size(); i++) {
            /*
                System.out.println(AllUsers.get(i).getId());
                System.out.println(AllUsers.get(i).getName());
                System.out.println(AllUsers.get(i).getLastName());
                System.out.println(">>"+AllUsers.get(i).getUserName()+"<<");
                System.out.println(AllUsers.get(i).getPassword());
                System.out.println(AllUsers.get(i).getIsAdministrator());
                
                System.out.println(">>"+User+"<<");
                System.out.println(Password);
                
                System.out.println(AllUsers.get(i).getUserName().equalsIgnoreCase(User));
                
                System.out.println(AllUsers.get(i).getPassword()==Password);
                */
            if(AllUsers.get(i).getUserName().equalsIgnoreCase(User) && AllUsers.get(i).getPassword().equalsIgnoreCase(Password)){
                System.out.println("Entro");
                user = AllUsers.get(i);
            }
        }
        return user;
    }
    
    @Override
    public List<TableResults> GetResultVentas() {
        List<Users> AllUsers = getAllUsers();
        List<Reservations> AllReservations =  Reservation.GetAllReservations();
        List<TableResults> Results = new ArrayList<TableResults>();
        for(int i=0;i<AllUsers.size();i++){
            TableResults tmp = new TableResults();
            tmp.setName(AllUsers.get(i).getName());
            Results.add(tmp);
        }
        for(int i=0;i<AllUsers.size();i++){
            for(int x=0;x<AllReservations.size();x++){
                if(AllReservations.get(x).getSellerId()== AllUsers.get(i).getId()){
                    Results.get(i).setTotalVentas(Results.get(i).getTotalVentas()+1);
                    switch(AllReservations.get(x).getTypeReservation()){
                        case 1:
                            //HOTEL
                            Results.get(i).setHotel(Results.get(i).getHotel()+1);
                            break;
                        case 2:
                            //AVION
                            Results.get(i).setVuelos(Results.get(i).getVuelos()+1);
                            break;
                        case 3:
                            //AVION+ HOTEL
                            Results.get(i).setHotelMasVuelos(Results.get(i).getHotelMasVuelos()+1);
                            break;
                        default :
                            //NADA
                            break;
                    }
                }
            }
        }
        return Results;
    }
}


/*  user.setId(this.usersDao.getAllUsers().get(i).getId());
    user.setIsAdministrator(this.usersDao.getAllUsers().get(i).getIsAdministrator());
    user.setLastName(this.usersDao.getAllUsers().get(i).getLastName());
    user.setName(this.usersDao.getAllUsers().get(i).getName());
    user.setPassword(this.usersDao.getAllUsers().get(i).getPassword());
    user.setUserName(this.usersDao.getAllUsers().get(i).getUserName());  */