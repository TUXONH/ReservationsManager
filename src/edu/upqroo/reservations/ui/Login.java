/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.ui;

import edu.upqroo.reservations.daos.CustomersDao;
import edu.upqroo.reservations.daos.CustomersMongoDao;
import edu.upqroo.reservations.daos.ReservationsDao;
import edu.upqroo.reservations.daos.ReservationsMongoDao;
import edu.upqroo.reservations.daos.UsersDao;
import edu.upqroo.reservations.daos.UsersMongoDao;
import edu.upqroo.reservations.domain.Reservations;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.exceptions.isEmptyUserDataException;
import edu.upqroo.reservations.services.CostumerService;
import edu.upqroo.reservations.services.CostumerServiceImpl;
import edu.upqroo.reservations.services.ReservationService;
import edu.upqroo.reservations.services.ReservationServiceImpl;
import edu.upqroo.reservations.services.UserService;
import edu.upqroo.reservations.services.UserServiceImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class Login extends javax.swing.JFrame {
    UsersDao con;
    UserService userService;
    ReservationsDao dao;
    ReservationService Reservacion;
    CustomersDao CD = new CustomersMongoDao();
    CostumerService  serviceCostumer = new CostumerServiceImpl(CD);
    CostumerService costumersService = null;
    ReservationService reservationService = null;
    /**
     * Creates new form Login
     */
    public Login(CostumerService costumersService, ReservationService reservationService) {
        initComponents();
        this.costumersService = costumersService;
        this.reservationService = reservationService;
        con = new UsersMongoDao();
        dao = new ReservationsMongoDao();
        Reservacion = new ReservationServiceImpl(dao);
        userService = new UserServiceImpl(con,dao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        Parameter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        login.setText("Log in");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        JUserName.setToolTipText("");

        jLabel2.setText("Password");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setText("Número de Reservación");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Acceso Solo de Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(login))
                            .addComponent(JPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(JUserName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Parameter, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(JUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Parameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(68, 68, 68))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        Users user = null;
        if(JUserName.getText()=="" && JPassword.getText()==""){
            JOptionPane.showMessageDialog(null, "Los Campos estan Vacios");
            return;
        }
        user = userService.Login(JUserName.getText(), JPassword.getText());
        if(user != null)
        {
            if(user.getIsAdministrator()){
                Admin Administrador = new Admin(userService, Reservacion, this.costumersService, this.reservationService);
                Administrador.open();
            } else {
                CustomersUI venderdor = new CustomersUI(serviceCostumer);
                venderdor.open();
            }
         //   Menu menu = new Menu(user);
           // menu.setVisible(true);
            super.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "El usuario y la contraseña son invalidados");
        }
    }//GEN-LAST:event_loginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!Parameter.getText().trim().isEmpty()){
            int parametro = Integer.parseInt(Parameter.getText().trim());
            Reservations  reserva = Reservacion.GetReservation(parametro);
            if(reserva != null){
                ReservationUI nueva = new ReservationUI(reserva);
                nueva.open();
            } else {
            JOptionPane.showMessageDialog(null, "La reserva no exite");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tienes puesto el parametro");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JTextField JUserName;
    private javax.swing.JTextField Parameter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
