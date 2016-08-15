/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.app;
import edu.upqroo.reservations.daos.CustomersDao;
import edu.upqroo.reservations.daos.CustomersMongoDao;
import edu.upqroo.reservations.services.CostumerService;
import edu.upqroo.reservations.services.CostumerServiceImpl;
import edu.upqroo.reservations.ui.Login;
import edu.upqroo.reservations.ui.CustomersUI;
/**
 *
 * @author Horacio
 */
public class Principal {
    public static void main(String[] args){
        /*
        CustomersDao costumerDao = new CustomersMongoDao();
        CostumerService costumersService = new CostumerServiceImpl(costumerDao);
        CustomersUI customerui = new CustomersUI(costumersService);
        customerui.setVisible(true);
*/
        Login Inicio = new Login();
        Inicio.setVisible(true);
    }
}