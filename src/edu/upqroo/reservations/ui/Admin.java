/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upqroo.reservations.ui;

import edu.upqroo.reservations.domain.TableResults;
import edu.upqroo.reservations.domain.Users;
import edu.upqroo.reservations.services.AddEmployee;
import edu.upqroo.reservations.services.EditEmployee;
import edu.upqroo.reservations.services.ReservationService;
import edu.upqroo.reservations.services.UserService;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Moises Barrera
 */
public class Admin extends javax.swing.JFrame {
    
    private UserService userService;
    private ReservationService Reservation;
    

    
    public Admin(UserService User, ReservationService Reservacion) {
        initComponents();
        this.userService = User;
        this.Reservation = Reservacion;
        UpdateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        AddUser = new javax.swing.JButton();
        Parameter = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        EditUser = new javax.swing.JButton();
        DeleteUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableResults = new javax.swing.JTable();
        ActualizarTabla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Admin");

        jLabel2.setText("Users");

        AddUser.setText("AddUser");
        AddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserActionPerformed(evt);
            }
        });

        jLabel3.setText("Parameter");

        EditUser.setText("EditUser");
        EditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserActionPerformed(evt);
            }
        });

        DeleteUser.setText("DeleteUser");
        DeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteUserActionPerformed(evt);
            }
        });

        TableResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee", "Total", "Hotel", "Plane", "Plane+ Hotel"
            }
        ));
        jScrollPane1.setViewportView(TableResults);

        ActualizarTabla.setText("UpdateTable");
        ActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(ActualizarTabla)
                                .addGap(235, 235, 235)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddUser)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Parameter, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(EditUser)
                                .addGap(18, 18, 18)
                                .addComponent(DeleteUser)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddUser)
                            .addComponent(Parameter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(EditUser)
                            .addComponent(DeleteUser))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ActualizarTabla))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateTable(){
        List<TableResults> Result = userService.GetResultVentas();
        TableResults.removeAll();
        DefaultTableModel model = (DefaultTableModel) TableResults.getModel();
        int filas=model.getRowCount();
        filas--;
        while(filas>-1){
            model.removeRow(filas);
            filas--;
        }
        TableResults.setModel(model);
       Object[] fila = new Object[model.getColumnCount()];
        for (int i = 0; i < Result.size(); i++) {
            fila[0] = Result.get(i).getName();
            fila[1] = Result.get(i).getTotalVentas();
            fila[2] = Result.get(i).getHotel();
            fila[3] = Result.get(i).getVuelos();
            fila[4] = Result.get(i).getHotelMasVuelos();
            model.addRow(fila);
        }
        TableResults.setModel(model);
    }
    
    private void ActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarTablaActionPerformed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_ActualizarTablaActionPerformed

    private void AddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserActionPerformed
        // TODO add your handling code here:
        EmployeeData Agregar = new AddEmployee();
        Agregar.open();
    }//GEN-LAST:event_AddUserActionPerformed

    private void EditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditUserActionPerformed
        // TODO add your handling code here:
        if(!Parameter.getText().trim().isEmpty()){
            Users user = userService.GetUser(Integer.parseInt(Parameter.getText()));
            if(user!=null){
                EmployeeData editar = new EditEmployee(user);
                editar.open();
            } else {
            JOptionPane.showMessageDialog(null, "No existe usuario con ese identificador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo del Parametro Vacio");
        }
    }//GEN-LAST:event_EditUserActionPerformed

    private void DeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteUserActionPerformed
        // TODO add your handling code here:
        if(!Parameter.getText().trim().isEmpty()){
            int num = Integer.parseInt(Parameter.getText());
            boolean result = userService.DeleteUser(num);
            if(result){ 
                JOptionPane.showMessageDialog(null, "UsuarioEliminado");
            } else {
            JOptionPane.showMessageDialog(null, "Error el usuario no existe o no se pudo eliminar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo del Parametro Vacio");
        }
    }//GEN-LAST:event_DeleteUserActionPerformed

            
    public void open(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarTabla;
    private javax.swing.JButton AddUser;
    private javax.swing.JButton DeleteUser;
    private javax.swing.JButton EditUser;
    private javax.swing.JTextField Parameter;
    private javax.swing.JTable TableResults;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
