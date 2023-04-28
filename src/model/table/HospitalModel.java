/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import dao.CommunityDao;
import javax.swing.table.AbstractTableModel;
import model.Community;
import model.Hospital;
import java.util.ArrayList;

/**
 *
 * @author imkus
 */
public class HospitalModel extends AbstractTableModel {

    ArrayList<Hospital> arrayList;
    CommunityDao cd;

    public HospitalModel(ArrayList<Hospital> arrayList) {
        this.arrayList = arrayList;
        cd = new CommunityDao();
    }

    private final String[] columnNames
            = {
                "Hospital ID",
                "Name",
                "Community ID",
                "Area",
                "District",
                "City",
                "Pin Code"
            };

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
        Hospital hospital = arrayList.get(rowIndex);
        Community community = cd.get(hospital.getCommunityId());
        return switch (columnIndex) {
            case 1 ->
                hospital.getName();
            case 2 ->
                community.getCommunityId();
            case 3 ->
                community.getArea();
            case 4 ->
                community.getDistrict();
            case 5 ->
                community.getCity();
            case 6 ->
                community.getPinCode();
            case 0 ->
                hospital.getHospitalId();
            default ->
                null;
        };
    }
}
