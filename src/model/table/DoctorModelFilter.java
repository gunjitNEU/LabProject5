/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import data.MainDataList;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Doctor;
import model.Hospital;

/**
 *
 * @author imkus
 */
public class DoctorModelFilter extends AbstractTableModel {

    private ArrayList<Doctor> doctorList;

    private final String[] columnNames
            = {
                "First Name",
                "Last Name",
                "Email",
                "Phone",
                "Hospital"
            };

    public DoctorModelFilter(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public int getRowCount() {
        return doctorList.size();
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
        Doctor doctor = doctorList.get(rowIndex);
        Hospital hospital = MainDataList.hospitalList.stream().filter((h) -> h.getHospitalId() == doctor.getHospitalId()).findAny().get();

        return switch (columnIndex) {
            case 0 ->
                doctor.getFirstName();
            case 1 ->
                doctor.getLastName();
            case 2 ->
                doctor.getEmail();
            case 3 ->
                doctor.getPhone();
            case 4 ->
                hospital.getName();
            default ->
                null;
        };
    }

}
