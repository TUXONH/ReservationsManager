/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upqroo.reservations.daos;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import edu.upqroo.reservations.domain.Users;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
        List<Users> AllUsers = new ArrayList<Users>();
        AllUsers = getAllUsers();
       int iden=0;
        if(AllUsers.size()>0)       
            iden = AllUsers.get(AllUsers.size()-1).getId()+1;
        else 
            iden=1;
        CrearMongoDao();
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", iden);
        obj.put("Name", user.getName());
        obj.put("LastName", user.getLastName());
        obj.put("UserName", user.getUserName());
        obj.put("Password", user.getPassword());
        obj.put("IsAdministrator", user.getIsAdministrator());
        System.out.println(obj.toString());
        tabla.insert(obj);
        mongo.close();
    }

    @Override
    public boolean DeleteUser(int id) {
        CrearMongoDao();
        BasicDBObject obj = new BasicDBObject();
        obj.put( "id", id );
        tabla.remove(obj);
        mongo.close();
        CrearMongoDao();
        BasicDBObject data = new BasicDBObject();
        data.put("id", id);
        DBCursor cursor = tabla.find(data);
        mongo.close();
        if(cursor.hasNext()){
            return false;
        }
        return true;
    }

    @Override
    public void UpdateUser(Users user) {
        CrearMongoDao();
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("id", user.getId());
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", user.getId());
        obj.put("Name", user.getName());
        obj.put("LastName", user.getLastName());
        obj.put("UserName", user.getUserName());
        obj.put("Password", user.getPassword());
        obj.put("IsAdministrator", user.getIsAdministrator());
        System.out.println(obj.toString());
        tabla.update(filtro, obj);
        mongo.close();
    }

    @Override
    public List<Users> getAllUsers() {
        CrearMongoDao();
        DBCursor cursor = tabla.find();
        List<Users> AllUsers = new ArrayList<Users>();
        while(cursor.hasNext()){
            String json = cursor.next().toString();
            Users user = gson.fromJson(json, Users.class);
            AllUsers.add(user);
        }
        mongo.close();
        return AllUsers;
    }

    @Override
    public Users GetUser(int id) {
        CrearMongoDao();
        BasicDBObject data = new BasicDBObject();
        data.put("id", id);
        DBCursor cursor = tabla.find(data);
        String json = cursor.next().toString();
        Users user = gson.fromJson(json, Users.class);
        mongo.close();
        return user;
    }

    @Override
    public Users Login(String User, String Password) {
        CrearMongoDao();
        BasicDBObject data = new BasicDBObject();
        data.put("UserName", User);
        data.put("Password", Password);
        DBCursor cursor = tabla.find(data);
        Users user=null;
        if(cursor.hasNext()){
            String json = cursor.next().toString();
            user = gson.fromJson(json, Users.class);
        }
        mongo.close();
        return user;
    }
}
