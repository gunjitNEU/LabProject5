/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VitalSign;

/**
 *
 * @author imkus
 */
public class EncounterModel extends AbstractTableModel {

    ArrayList<VitalSign> arrayList;
    private final String[] columnNames
            = {
                "Weight",
                "Temperature",
                "Blood Pressure",
                "Pulse",
                "Diagnostic",
                "Date",
                "Time"
            };

    public EncounterModel(ArrayList<VitalSign> arrayList) {
        this.arrayList = arrayList;
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
        VitalSign vs = arrayList.get(rowIndex);

        return switch (columnIndex) {
            case 0 ->
                vs.getWeight();
            case 1 ->
                vs.getTemperature();
            case 2 ->
                vs.getBloodPressure();
            case 3 ->
                vs.getPulse();
            case 4 ->
                vs.getDiagnostic();
            case 5 ->
                vs.getDate().toString();
            case 6 ->
                vs.getTime().toString();
            default ->
                null;
        };

    }

}
