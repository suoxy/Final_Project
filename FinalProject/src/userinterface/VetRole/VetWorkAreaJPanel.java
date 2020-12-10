/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VetRole;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suoxiyue
 */
public class VetWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel  container;
    UserAccount userAccount;
    /**
     * Creates new form DogVetWorkAreaJPanel
     */
    public VetWorkAreaJPanel(JPanel container, UserAccount ua) {
        initComponents();
        this.container = container;
        this.userAccount = ua;
        
        valueLabel.setText(ua.getEmployee().getName());
        popTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVetWork = new javax.swing.JTable();
        btnAccept = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        jLabel1.setText("Vet Work Area");

        tblVetWork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Case ID", "Animal Type", "Message", "Status", "Able to Shelter"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVetWork);
        if (tblVetWork.getColumnModel().getColumnCount() > 0) {
            tblVetWork.getColumnModel().getColumn(0).setResizable(false);
            tblVetWork.getColumnModel().getColumn(1).setResizable(false);
            tblVetWork.getColumnModel().getColumn(2).setResizable(false);
            tblVetWork.getColumnModel().getColumn(3).setResizable(false);
            tblVetWork.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        jLabel3.setText("Hello,");

        jLabel2.setText("Role: Veterinarian");

        valueLabel.setText("<Vet>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void popTable(){
        DefaultTableModel model = (DefaultTableModel) tblVetWork.getModel();
        model.setRowCount(0);
        
        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof AnimalRecord) {                             
                Object row[] = new Object[5];
                row[0] = wr;
                row[1] = ((AnimalRecord) wr).getReportingRequest().getAnimalType();
                if (((AnimalRecord) wr).getVetRequest().getLatestMessage() == null) {
                    row[2] = ((AnimalRecord) wr).getHospitalRequest().getLatestMessage();
                } else {
                    row[2] = ((AnimalRecord) wr).getVetRequest().getLatestMessage();
                }
                
                if (((AnimalRecord) wr).getVetRequest().getStatus() == null) {
                    row[3] = ((AnimalRecord) wr).getHospitalRequest().getStatus();
                } else {
                    row[3] = ((AnimalRecord) wr).getVetRequest().getStatus();
                }          
                row[4] = ((AnimalRecord) wr).getVetRequest().isAbleForShelter();
                ((DefaultTableModel) tblVetWork.getModel()).addRow(row);
            }
        }
    }
    
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int row = tblVetWork.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a task from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblVetWork.getValueAt(row, 0);
        
        
        if (ar.getVetRequest().getStatus().equals("Vet Declined")) {
            JOptionPane.showMessageDialog(null, "You cannot handle this declined task!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if ( !(ar.getVolunteerRequest().getStatus().equals("Volunteer Completed"))) {
            JOptionPane.showMessageDialog(null, " Pls wait for volunteer takes animal here!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if ( !(ar.getVetRequest().getStatus().equals("Vet Accepted")) && !(ar.getVetRequest().getStatus().equals("Vet Completed"))) {
            JOptionPane.showMessageDialog(null, " Accept task first!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
        
            VetProcessJPanel jp = new VetProcessJPanel(container, ar);
            container.add("VetProcessJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
        int row = tblVetWork.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a task from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblVetWork.getValueAt(row, 0);
        //System.out.println(ar.getHospitalRequest().getStatus()); // test
        if (ar.getVetRequest().getStatus() != null && ar.getVetRequest().getStatus().equals("Vet Completed")) {
            JOptionPane.showMessageDialog(null, "Already completed!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ar.getVetRequest().setStatus("Vet Accepted");
        ar.addMessage("Vet accepted task.");
        JOptionPane.showMessageDialog(null, "Task accepted");
        popTable();
    }//GEN-LAST:event_btnAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVetWork;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
