/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import data.MainDataList;
import javax.swing.table.AbstractTableModel;
import model.Patient;

/**
 *
 * @author imkus
 */
public class PatientModel extends AbstractTableModel {

    private final String[] columnNames
            = {
                "Patient ID",
                "First Name",
                "Last Name",
                "Email",
                "Phone"
            };

    public PatientModel() {

    }

    @Override
    public int getRowCount() {
        return MainDataList.patientList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Patient patient = MainDataList.patientList.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                patient.getPatientId();
            case 1 ->
                patient.getFirstName();
            case 2 ->
                patient.getLastName();
            case 3 ->
                patient.getEmail();
            case 4 ->
                patient.getPhone();
            default ->
                null;
        };
    }

}
