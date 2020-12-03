/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CoordinatorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.RescueEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.VolunteerRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoxi
 */
public class AssignVolunteerJPanel extends javax.swing.JPanel {

    private JPanel container;
    EcoSystem system;
    AnimalRecord animalRecord;
    
    
    /**
     * Creates new form AssignCarreirJPanel
     */
    public AssignVolunteerJPanel(JPanel container, EcoSystem sys, AnimalRecord ar) {
        initComponents();
        this.container = container;
        this.system = sys;
        this.animalRecord = ar;
        popTable();
    }

    public void popTable(){
        DefaultTableModel model = (DefaultTableModel) tblVolunteer.getModel();
        model.setRowCount(0);
        
        for (Network n : system.getNetworkList()) {        
        
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                //System.out.println(e.getWorkQueue().getWorkRequestList().size());
                if (e instanceof RescueEnterprise) {
                    System.out.println("in rescue enterprise"); //test
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof VolunteerOrganization) {
                            //for (WorkRequest wq : org.getWorkQueue().getWorkRequestList()) {
                             //   System.out.println("in workrequest"); //test
                             //   if (wq instanceof AnimalRecord) {
                             //       System.out.println("in animal record"); //test
                             //       if (((AnimalRecord)wq).getReportingRequest().getAssignedCoordinator() == userAccount) {
                             for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                                 if (ua.getRole().toString() == "Volunteer") {                             
                                        Object row[] = new Object[3];
                                        row[0] = ua;
                                        row[1] = ua.getEmployee().getId();
                                        row[2] = ua.getWorkQueue().getWorkRequestList().size();
          
                                        ((DefaultTableModel) tblVolunteer.getModel()).addRow(row);
                                 }
                             }
                        }
                    }
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVolunteer = new javax.swing.JTable();
        btnViewOnMap = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();

        tblVolunteer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Volunteer", "Volunteer ID", "Number of Task"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVolunteer);

        btnViewOnMap.setText("View on Map");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAssign.setText("Assgin Volunteer");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnAssign)
                        .addGap(53, 53, 53)
                        .addComponent(btnViewOnMap))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign)
                    .addComponent(btnViewOnMap))
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:   
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        NewAssignedCaseJPanel nacjp = (NewAssignedCaseJPanel) component;
        nacjp.popTable();
        
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int row = tblVolunteer.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a volunteer from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        UserAccount ua = (UserAccount)tblVolunteer.getValueAt(row, 0);
        
        String status = "Waiting for Volunteer";
        animalRecord.getMsgList().add(status);
        animalRecord.setStatus(status);
        animalRecord.getVolunteerRequest().setVolunteer(ua);
        ua.getWorkQueue().getWorkRequestList().add(animalRecord);
        
        JOptionPane.showMessageDialog(null, "Request sent to volunteer !");
        popTable();
        btnAssign.setEnabled(false);
        btnViewOnMap.setEnabled(false);
    }//GEN-LAST:event_btnAssignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewOnMap;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVolunteer;
    // End of variables declaration//GEN-END:variables
}
