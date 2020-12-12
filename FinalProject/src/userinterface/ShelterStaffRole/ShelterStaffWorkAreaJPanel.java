/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ShelterStaffRole;

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
public class ShelterStaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    UserAccount userAccount;
    /**
     * Creates new form ShelterAssistantWorkAreaJPanel
     */
    public ShelterStaffWorkAreaJPanel(JPanel container, UserAccount ua) {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAnimals = new javax.swing.JTable();
        btnUpdateInfo = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        btnProcess = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("Hello,");

        jLabel2.setText("Role: Shelter Staff");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manage Animals");

        tblAnimals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Animal ID", "Type", "Breed", "Age", "Name", "Shelter Status", "Message", "Hospital Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAnimals);

        btnUpdateInfo.setText("Update Information");
        btnUpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateInfoActionPerformed(evt);
            }
        });

        valueLabel.setText("<Shelter Staff>");

        btnProcess.setText("Pick Up Pet!");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(142, 142, 142))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProcess, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnUpdateInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void popTable(){
        DefaultTableModel model = (DefaultTableModel) tblAnimals.getModel();
        model.setRowCount(0);
        
        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof AnimalRecord) {                             
                Object row[] = new Object[8];
                row[0] = wr;
                row[1] = ((AnimalRecord) wr).getReportingRequest().getAnimalType();
                row[2] = ((AnimalRecord) wr).getBreed() ==null?"--": ((AnimalRecord) wr).getBreed();
                row[3] = ((AnimalRecord) wr).getAge() ==null?"--": ((AnimalRecord) wr).getAge();
                row[4] = ((AnimalRecord) wr).getPetName() ==null?"--": ((AnimalRecord) wr).getPetName();
                row[5] = ((AnimalRecord) wr).getShelterRequest().getStatus() ==null?"--": ((AnimalRecord) wr).getShelterRequest().getStatus();             
                row[6] = ((AnimalRecord) wr).getShelterRequest().getLatestMessage()==null?"--": ((AnimalRecord) wr).getShelterRequest().getLatestMessage();
                row[7] = ((AnimalRecord) wr).getHospitalRequest().getStatus()==null?"--":((AnimalRecord) wr).getHospitalRequest().getStatus();
                ((DefaultTableModel) tblAnimals.getModel()).addRow(row);
            }
        }
    }
    
    private void btnUpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateInfoActionPerformed
        // TODO add your handling code here:
        int row = tblAnimals.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a task from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblAnimals.getValueAt(row, 0);

        if (ar.getShelterRequest().getStatus().equals("Pet transferred to shelter") || ar.getShelterRequest().getStatus().equals("Posted")) {
            UpdateInfoJPanel jp = new UpdateInfoJPanel(container, ar);
            container.add("UpdateInfoJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);            
        } else if (ar.getShelterRequest().getStatus().equals("Staff Assigned")) {
            JOptionPane.showMessageDialog(null, "Pls do pick up process first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
             JOptionPane.showMessageDialog(null, "Something wrong, you cannot update now!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
    }//GEN-LAST:event_btnUpdateInfoActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int row = tblAnimals.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a task from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        AnimalRecord ar = (AnimalRecord)tblAnimals.getValueAt(row, 0);
        
        if (ar.getVetRequest().isAbleForShelter() == false) {
            JOptionPane.showMessageDialog(null, "Pls wait for vet to complete treat process.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ar.getShelterRequest().getStatus().equals("Pet transferred to shelter")) {
             JOptionPane.showMessageDialog(null, "Staff pick up process already completed", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }else if (ar.getShelterRequest().getStatus().equals("Posted")) {
            JOptionPane.showMessageDialog(null, "Already completed!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            StaffProcessJPanel jp = new StaffProcessJPanel(container, ar);
            container.add("VetProcessJPanel",jp);
            CardLayout layout = (CardLayout)container.getLayout();
            layout.next(container);
        }
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnUpdateInfo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAnimals;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
