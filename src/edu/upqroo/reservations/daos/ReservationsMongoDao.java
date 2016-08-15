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
import edu.upqroo.reservations.domain.Reservations;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Moises Barrera
 */
public class ReservationsMongoDao implements ReservationsDao{

    DB db;
    DBCollection tabla;
    Gson gson = new Gson();
    Mongo mongo;
    
     public void CrearMongoDao(){
        try {
            mongo = new Mongo("localhost",27017);
            db = mongo.getDB("ReservationsManager");
            tabla = db.getCollection("Reservations");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ReservationsMongoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void addReservation(Reservations reservation) {
        List<Reservations> AllReservations = new ArrayList<Reservations>();
        AllReservations = GetAllReservations();
       int iden=0;
        if(AllReservations.size()>0)       
            iden = AllReservations.get(AllReservations.size()-1).getId()+1;
        else 
            iden=1;
        CrearMongoDao();
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", iden);
        obj.put("CostumersName", reservation.getCostumersName());
        obj.put("SellerId", reservation.getSellerId());
        obj.put("SaleDate", reservation.getSaleDate());
        obj.put("DepartureDate", reservation.getDepartureDate());
        obj.put("CompletionDate", reservation.getCompletionDate());
        obj.put("TypeReservation", reservation.getTypeReservation());
        obj.put("Description", reservation.getDescription());
        obj.put("Amount", reservation.getAmount());
        obj.put("Currency", reservation.getCurrency());
        obj.put("ItsOk", reservation.isItsOk());
        System.out.println(obj.toString());
        tabla.insert(obj);
        mongo.close();
    }

    @Override
    public void UpdateReservation(Reservations reservation) {
        CrearMongoDao();
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("id", reservation.getId());
        BasicDBObject obj = new BasicDBObject();
        obj.put("id", reservation.getId());
        obj.put("CostumersName", reservation.getCostumersName());
        obj.put("SellerId", reservation.getSellerId());
        obj.put("SaleDate", reservation.getSaleDate());
        obj.put("DepartureDate", reservation.getDepartureDate());
        obj.put("CompletionDate", reservation.getCompletionDate());
        obj.put("TypeReservation", reservation.getTypeReservation());
        obj.put("Description", reservation.getDescription());
        obj.put("Amount", reservation.getAmount());
        obj.put("Currency", reservation.getCurrency());
        obj.put("ItsOk", reservation.isItsOk());
        System.out.println(obj.toString());
        tabla.update(filtro, obj);
        mongo.close();
    }

    @Override
    public boolean DeleteReservation(int id) {
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
    public List<Reservations> GetAllReservations() {
        CrearMongoDao();
        DBCursor cursor = tabla.find();
        List<Reservations> AllReservations = new ArrayList<Reservations>();
        while(cursor.hasNext()){
            String json = cursor.next().toString();
            Reservations reservation = gson.fromJson(json, Reservations.class);
            AllReservations.add(reservation);
        }
        mongo.close();
        return AllReservations;
    }

    @Override
    public Reservations GetReservation(int id) {
       CrearMongoDao();
        BasicDBObject data = new BasicDBObject();
        data.put("id", id);
        DBCursor cursor = tabla.find(data);
        Reservations reservation= null;
        if(cursor.hasNext()){
            String json = cursor.next().toString();
            reservation = gson.fromJson(json, Reservations.class);
        }
        mongo.close();
        return reservation;
    }

}
