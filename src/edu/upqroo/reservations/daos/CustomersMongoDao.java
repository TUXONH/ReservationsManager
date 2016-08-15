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
import edu.upqroo.reservations.domain.Customers;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Moises Barrera
 */
public class CustomersMongoDao implements CustomersDao{

     DB db;
    DBCollection tabla;
    Gson gson = new Gson();
    Mongo mongo;
    
     public void CrearMongoDao(){
         try {
             mongo = new Mongo("localhost",27017);
             db = mongo.getDB("ReservationsManager");
             tabla = db.getCollection("Customers");
         } catch (UnknownHostException ex) {
             Logger.getLogger(CustomersMongoDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @Override
    public void addCustormer(Customers customer) {
        List<Customers> AllCustomers = new ArrayList<Customers>();
        AllCustomers = getAllCustomers();
       int iden=0;
        if(AllCustomers.size()>0)       
            iden = AllCustomers.get(AllCustomers.size()-1).getId()+1;
        else 
            iden=1;
        CrearMongoDao();
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", iden);
        obj.put("Name", customer.getName());
        obj.put("LastName", customer.getLastName());
        obj.put("Address", customer.getAddress());
        obj.put("Age", customer.getAge());
        System.out.println(obj.toString());
        tabla.insert(obj);
        mongo.close();
    }

    @Override
    public void UpdateCustomer(Customers customer) {
        CrearMongoDao();
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("id", customer.getId());
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", customer.getId());
        obj.put("Name", customer.getName());
        obj.put("LastName", customer.getLastName());
        obj.put("Address", customer.getAddress());
        obj.put("Age", customer.getAge());
        System.out.println(obj.toString());
        tabla.update(filtro, obj);
        mongo.close();
    }

    @Override
    public List<Customers> getAllCustomers() {
        CrearMongoDao();
        DBCursor cursor = tabla.find();
        List<Customers> AllCustomers = new ArrayList<Customers>();
        while(cursor.hasNext()){
            String json = cursor.next().toString();
            Customers customer = gson.fromJson(json, Customers.class);
            AllCustomers.add(customer);
        }
        mongo.close();
        return AllCustomers;
    }

    @Override
    public boolean DeleteCustomer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
