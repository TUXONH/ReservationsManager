/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.daos;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import edu.upqroo.reservations.domain.Users;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Moises Barrera
 */
public class UsersMongoDao implements UsersDao{

    
    DB db;
    DBCollection tabla;
    Gson gson = new Gson();
    Mongo mongo;
    
     public void CrearMongoDao(){
        try {
            mongo = new Mongo("localhost",27017);
            db = mongo.getDB("ReservationsManager");
            tabla = db.getCollection("Users");
        } catch (UnknownHostException ex) {
            Logger.getLogger(UsersMongoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addUser(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateUser(Users user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users GetUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
