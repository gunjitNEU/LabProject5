/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import data.MainDataList;
import javax.swing.table.AbstractTableModel;
import model.Doctor;
import model.Hospital;

/**
 *
 * @author imkus
 */
public class DoctorModel extends AbstractTableModel {

    private final String[] columnNames
            = {
                "Doctor ID",
                "First Name",
                "Last Name",
                "Email",
                "Phone",
                "Hospital"
            };

    public DoctorModel() {

    }

    @Override
    public int getRowCount() {
        return MainDataList.doctorList.size();
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
        Doctor doctor = MainDataList.doctorList.get(rowIndex);
        Hospital hospital = MainDataList.hospitalList.stream().filter((h) -> h.getHospitalId() == doctor.getHospitalId()).findAny().get();

        return switch (columnIndex) {
            case 0 ->
                doctor.getDoctorId();
            case 1 ->
                doctor.getFirstName();
            case 2 ->
                doctor.getLastName();
            case 3 ->
                doctor.getEmail();
            case 4 ->
                doctor.getPhone();
            case 5 ->
                hospital.getName();
            default ->
                null;
        };
    }

}
