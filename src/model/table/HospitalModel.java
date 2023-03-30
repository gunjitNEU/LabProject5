/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import javax.swing.table.AbstractTableModel;
import model.Community;
import model.Hospital;
import data.MainDataList;

/**
 *
 * @author imkus
 */
public class HospitalModel extends AbstractTableModel {

    private final String[] columnNames
            = {
                "Name",
                "Community ID",
                "Area",
                "District",
                "City",
                "Pin Code"
            };

    @Override
    public int getRowCount() {
        return MainDataList.hospitalList.size();
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
        Hospital hospital = MainDataList.hospitalList.get(rowIndex);
        Community community = MainDataList.communityList.stream().filter((c) -> c.getCommunityId() == hospital.getCommunityId()).findAny().get();
        return switch (columnIndex) {
            case 0 ->
                hospital.getName();
            case 1 ->
                community.getCommunityId();
            case 2 ->
                community.getArea();
            case 3 ->
                community.getDistrict();
            case 4 ->
                community.getCity();
            case 5 ->
                community.getPinCode();
            default ->
                null;
        };
    }
}
