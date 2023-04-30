/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.CommunityDao;
import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Community;
import model.table.CommunityModel;
import utill.Patterns;
import utill.SimpleDocumentListener;

/**
 *
 * @author gunjitarora
 */
public class CommunityCRUD extends javax.swing.JPanel {

    /**
     * Creates new form CommunityCRUD
     */
    CommunityDao cd;

    public CommunityCRUD() {
        initComponents();

        cd = new CommunityDao();
        communityTable.setModel(new CommunityModel(cd.getAll()));
        cityComboBox.setModel(new DefaultComboBoxModel<>(Community.City.values()));
        pinCodeField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (pinCodeField.getText().length() < 6 || pinCodeField.getText().length() > 6) {
                pinCodeField.setForeground(Color.red);
            } else {
                pinCodeField.setForeground(Color.black);
            }
        });
        districtField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.alpabetPattern, districtField.getText())) {
                districtField.setForeground(Color.black);
            } else {
                districtField.setForeground(Color.red);
            }
        });
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
        communityTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        areaField = new javax.swing.JTextField();
        districtField = new javax.swing.JTextField();
        pinCodeField = new javax.swing.JTextField();
        cityComboBox = new javax.swing.JComboBox<>();
        communityIdField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addButton = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        communityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        communityTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(communityTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Community List");

        jLabel2.setText("Area:");

        jLabel3.setText("District:");

        jLabel4.setText("Pin Code:");

        jLabel5.setText("City:");

        jLabel6.setText("Community Id:");

        communityIdField.setEnabled(false);

        updateButton.setText("Update");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Selection");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cityComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 83, Short.MAX_VALUE)
                                        .addComponent(pinCodeField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(districtField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(areaField)
                                        .addComponent(communityIdField)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(viewButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton)
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(areaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(districtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pinCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(communityIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (communityTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select community from list", "No community Slected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cd.remove((int) communityTable.getValueAt(communityTable.getSelectedRow(), 0));
        communityTable.setModel(new CommunityModel(cd.getAll()));
        clearButton.doClick();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        cityComboBox.setSelectedIndex(0);
        areaField.setText("");
        districtField.setText("");
        pinCodeField.setText("");
        communityIdField.setText("");
        addButton.setEnabled(true);
        updateButton.setEnabled(false);

    }//GEN-LAST:event_clearButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if (areaField.getText().isBlank() || districtField.getText().isBlank() || pinCodeField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "All fields are compulsory",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pinCodeField.getText().length() < 6 || pinCodeField.getText().length() > 6) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Pin Code",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.alpabetPattern, districtField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Invalid District",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Community c = new Community();
        c.setArea(areaField.getText());
        c.setCity((Community.City) cityComboBox.getSelectedItem());
        c.setDistrict(districtField.getText());
        c.setPinCode(pinCodeField.getText());
        cd.add(c);
        clearButton.doClick();
        communityTable.setModel(new CommunityModel(cd.getAll()));

    }//GEN-LAST:event_addButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:

        if (communityTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select community from list", "No community Slected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Community community = cd.get((int) communityTable.getValueAt(communityTable.getSelectedRow(), 0));
        cityComboBox.setSelectedItem(community.getCity());
        areaField.setText(community.getArea());
        districtField.setText(community.getDistrict());
        pinCodeField.setText(community.getPinCode());
        communityIdField.setText(String.valueOf(community.getCommunityId()));
        addButton.setEnabled(false);
        updateButton.setEnabled(true);

    }//GEN-LAST:event_viewButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (areaField.getText().isBlank() || districtField.getText().isBlank() || pinCodeField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "All fields are compulsory",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pinCodeField.getText().length() < 6 || pinCodeField.getText().length() > 6) {
            JOptionPane.showMessageDialog(this,
                    "Invalid Pin Code",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.alpabetPattern, districtField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Invalid District",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Community c = cd.get((int) communityTable.getValueAt(communityTable.getSelectedRow(), 0));
        c.setArea(areaField.getText());
        c.setCity((Community.City) cityComboBox.getSelectedItem());
        c.setDistrict(districtField.getText());
        c.setPinCode(pinCodeField.getText());
        cd.update(c);
        clearButton.doClick();
        communityTable.setModel(new CommunityModel(cd.getAll()));

    }//GEN-LAST:event_updateButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        clearButton.doClick();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField areaField;
    private javax.swing.JComboBox<Community.City> cityComboBox;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField communityIdField;
    private javax.swing.JTable communityTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField districtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pinCodeField;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
