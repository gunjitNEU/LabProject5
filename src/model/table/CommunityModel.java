/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import javax.swing.table.AbstractTableModel;
import model.Community;
import data.MainDataList;

/**
 *
 * @author imkus
 */
public class CommunityModel extends AbstractTableModel {

    private final String[] columnNames
            = {
                "Community ID",
                "Area",
                "District",
                "City",
                "Pin Code"
            };

    public CommunityModel() {

    }

    @Override
    public int getRowCount() {
        return MainDataList.communityList.size();
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
        Community community = MainDataList.communityList.get(rowIndex);
        return switch (columnIndex) {
            case 0 ->
                community.getCommunityId();
            case 1 ->
                community.getArea();
            case 2 ->
                community.getDistrict();
            case 3 ->
                community.getCity();
            case 4 ->
                community.getPinCode();
            default ->
                null;
        };
    }

}
