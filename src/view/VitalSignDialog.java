/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeIncrement;
import dao.EncounterDao;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Encounter;
import model.VitalSign;
import model.table.EncounterModel;
import utill.Patterns;
import utill.SimpleDocumentListener;

/**
 *
 * @author imkus
 */
public class VitalSignDialog extends javax.swing.JFrame {

    /**
     * Creates new form VitalSignDialog
     */
    int patientId;
    int doctorId;
    EncounterDao ed;

    public VitalSignDialog(int patientId, int doctorId) {
        initComponents();
        this.patientId = patientId;
        this.doctorId = doctorId;
        ed = new EncounterDao();
        encounterTable.setModel(new EncounterModel(ed.getAllByPatientAndDoctor(doctorId, patientId)));
        DatePickerSettings dateSettings = datePicker.getSettings();
        dateSettings.setAllowKeyboardEditing(false);
        dateSettings.setAllowEmptyDates(false);
        dateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);

        TimePickerSettings timeSettings = timePicker.getSettings();
        timeSettings.setAllowKeyboardEditing(false);
        timeSettings.setAllowEmptyTimes(false);
        timePicker.setTime(LocalTime.now().with((temp) -> {
            int currentMinute = temp.get(ChronoField.MINUTE_OF_DAY);
            int interval = (currentMinute / 15) * 15;
            temp = temp.with(ChronoField.SECOND_OF_MINUTE, 0);
            temp = temp.with(ChronoField.MILLI_OF_SECOND, 0);
            return temp.with(ChronoField.MINUTE_OF_DAY, interval);
        }));
        timeSettings.generatePotentialMenuTimes(TimeIncrement.FifteenMinutes, null, null);

        datePicker.setDateToToday();
//        dateTimePicker.timePicker.setTimeToNow();

        tempField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.numberPattern, tempField.getText())) {
                tempField.setForeground(Color.black);
            } else {
                tempField.setForeground(Color.red);
            }
        });
        sysPressureField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.numberPattern, tempField.getText())) {
                sysPressureField.setForeground(Color.black);
            } else {
                sysPressureField.setForeground(Color.red);
            }
        });
        diaPressureField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.numberPattern, tempField.getText())) {
                diaPressureField.setForeground(Color.black);
            } else {
                diaPressureField.setForeground(Color.red);
            }
        });
        pulseField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.numberPattern, tempField.getText())) {
                pulseField.setForeground(Color.black);
            } else {
                pulseField.setForeground(Color.red);
            }
        });
        weightField.getDocument().addDocumentListener((SimpleDocumentListener) e -> {
            if (Pattern.matches(Patterns.numberPattern, tempField.getText())) {
                weightField.setForeground(Color.black);
            } else {
                weightField.setForeground(Color.red);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        weightField = new javax.swing.JTextField();
        pulseField = new javax.swing.JTextField();
        sysPressureField = new javax.swing.JTextField();
        tempField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        encounterTable = new javax.swing.JTable();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        timePicker = new com.github.lgooddatepicker.components.TimePicker();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        diaPressureField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        diagnosticField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Temperature:");

        jLabel2.setText("Blood Pressure:");

        jLabel3.setText("Pulse:");

        jLabel4.setText("Weight:");

        jLabel5.setText("Date:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Add Vitals");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Encounters");

        encounterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        encounterTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(encounterTable);

        jLabel8.setText("Time:");

        jLabel9.setText("Sys:");

        jLabel10.setText("Dia:");

        jLabel11.setText("Diagnostic");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sysPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diaPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(weightField)
                            .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tempField)
                            .addComponent(pulseField)
                            .addComponent(timePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(diagnosticField))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tempField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sysPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(diaPressureField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pulseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(weightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(diagnosticField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        if (tempField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Temperature field not alllowed empty",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sysPressureField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Sys field not alllowed empty",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (diaPressureField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Dia field not alllowed empty",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (pulseField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Pulse field not alllowed empty",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (weightField.getText().isBlank()) {
            JOptionPane.showMessageDialog(this,
                    "Weight field not alllowed empty",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.numberPattern, tempField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Temperature field can be numbers only",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.numberPattern, sysPressureField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Sys field can be numbers only",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.numberPattern, diaPressureField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Dia field can be numbers only",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.numberPattern, pulseField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Pulse field can be numbers only",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Pattern.matches(Patterns.numberPattern, weightField.getText())) {
            JOptionPane.showMessageDialog(this,
                    "Weight field can be numbers only",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        VitalSign vitalSign = new VitalSign();
        vitalSign.setBloodPressure(sysPressureField.getText() + "\\" + diaPressureField.getText());
        vitalSign.setDate(datePicker.getDate());
        vitalSign.setTime(timePicker.getTime());
        vitalSign.setPulse(Integer.parseInt(pulseField.getText()));
        vitalSign.setDiagnostic(diagnosticField.getText());

        vitalSign.setWeight(Integer.parseInt(weightField.getText()));
        vitalSign.setTemperature(Integer.parseInt(tempField.getText()));

        ed.add(new Encounter(doctorId, patientId, vitalSign));
        JOptionPane.showMessageDialog(this,
                "Encounter saved successfully",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);

    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JTextField diaPressureField;
    private javax.swing.JTextField diagnosticField;
    private javax.swing.JTable encounterTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pulseField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField sysPressureField;
    private javax.swing.JTextField tempField;
    private com.github.lgooddatepicker.components.TimePicker timePicker;
    private javax.swing.JTextField weightField;
    // End of variables declaration//GEN-END:variables
}
