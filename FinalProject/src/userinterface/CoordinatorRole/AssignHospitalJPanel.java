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
import Business.Organization.AnimalHospitalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AnimalRecord;
import Business.WorkQueue.HospitalRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoxi
 */
public class AssignHospitalJPanel extends javax.swing.JPanel {

    private JPanel container;
    EcoSystem system;
    AnimalRecord animalRecord;
    
    /**
     * Creates new form AssignVetJPanel
     */
    public AssignHospitalJPanel(JPanel container, EcoSystem sys, AnimalRecord ar) {
        initComponents();
        this.container = container;
        this.system = sys;
        this.animalRecord = ar;
        
        popTable();
    }

        public void popTable(){
        DefaultTableModel model = (DefaultTableModel)tblHospital.getModel();
        model.setRowCount(0);
        
        for (Network n : system.getNetworkList()) {        
        
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                //System.out.println(e.getWorkQueue().getWorkRequestList().size());
                if (e instanceof RescueEnterprise) {
                    //System.out.println("in rescue enterprise"); //test
                    for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof AnimalHospitalOrganization) {
                            //for (WorkRequest wq : org.getWorkQueue().getWorkRequestList()) {
                             //   System.out.println("in workrequest"); //test
                             //   if (wq instanceof AnimalRecord) {
                             //       System.out.println("in animal record"); //test
                             //       if (((AnimalRecord)wq).getReportingRequest().getAssignedCoordinator() == userAccount) {
                             //for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                             //    if (ua.getRole().toString() == "HospitalAdmin") {                             
                                        Object row[] = new Object[4];
                                        row[0] = org;
                                        row[1] = org.getOrganizationID();
                                        row[2] = org.getEmployeeDirectory().getEmployeeList().size(); // this is size of whole organization
//                                        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
//                                            System.out.println("ua role: " + ua.getRole()); //test
//                                            if (ua.getRole().toString().equals("HospitalAdmin") ) {
//                                                row[3] = ua;
//                                                break;
//                                            } else {
//                                                row[3] = "Hospital has no administrator";
//                                            }
//                                        }
                                        row[3] = org.getWorkQueue().getWorkRequestList().size();
                                        ((DefaultTableModel)tblHospital.getModel()).addRow(row);
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

        btnAssign = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHospital = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        comboAdmin = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnAssign.setText("Assgin Hospital");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        tblHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Animal Hospital", "Organization ID", "Number of Available Vets", "# of Task"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHospital);

        jButton2.setText("View on Map");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAdmin.setText("Hospital Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        jLabel1.setText("Message to hospital:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(774, 774, 774)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmin)
                    .addComponent(comboAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(443, 443, 443)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AssignedCaseJPanel nacjp = (AssignedCaseJPanel) component;
        nacjp.popTable();
        nacjp.reset();
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int row = tblHospital.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a hosptail from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Organization org = (Organization)tblHospital.getValueAt(row, 0);        
        UserAccount ua = (UserAccount)comboAdmin.getSelectedItem();
        
        if (txtMessage.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Please write a message to hospital", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (ua == null) {
            JOptionPane.showMessageDialog(null, "Please select an hospital admin", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        //HospitalRequest hr = new HospitalRequest();
        //hr.setHospitalOrg(org);
        //ua.getWorkQueue().getWorkRequestList().add(hr);       
        
        animalRecord.getHospitalRequest().setHospitalOrg(org);
        animalRecord.getHospitalRequest().setStatus("Hospital Assigned");
        animalRecord.addMessage("Coordinator assign hospital. Message: " + txtMessage.getText());
        animalRecord.getHospitalRequest().setLatestMessage(txtMessage.getText());
        ua.getWorkQueue().getWorkRequestList().add(animalRecord);
        org.getWorkQueue().getWorkRequestList().add(animalRecord);
        
        JOptionPane.showMessageDialog(null, "Request sent to Hospital Administrator !");
        popTable();
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        int row = tblHospital.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a hospital from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        comboAdmin.removeAllItems();
        Organization org = (Organization)tblHospital.getValueAt(row, 0);
        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
            System.out.println("combo role: " + ua.getRole()); //test
            if (ua.getRole().toString().equals("HospitalAdmin") ) {
                comboAdmin.addItem(ua);
            }
        }
    }//GEN-LAST:event_btnAdminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox comboAdmin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHospital;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
