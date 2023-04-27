/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import dao.HospitalDao;
import data.MainDataList;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Doctor;
import model.Hospital;

/**
 *
 * @author imkus
 */
public class DoctorModel extends AbstractTableModel {

    ArrayList<Doctor> arrayList;
    HospitalDao hd;

    private final String[] columnNames
            = {
                "Doctor ID",
                "First Name",
                "Last Name",
                "Email",
                "Phone",
                "Hospital"
            };

    public DoctorModel(ArrayList<Doctor> arrayList) {
        this.arrayList = arrayList;
        hd = new HospitalDao();
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
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
        Doctor doctor = arrayList.get(rowIndex);
        Hospital hospital = hd.get(doctor.getHospitalId());

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
