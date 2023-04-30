/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Encounter;
import model.VitalSign;

/**
 *
 * @author imkus
 */
public class EncounterDao {

    public ArrayList<VitalSign> getAllByPatientAndDoctor(int doctorId, int patientId) {
        String query = "select * from encounter where patientId='" + patientId + "' and doctorId='" + doctorId + "' order by doctorId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<VitalSign> al = new ArrayList<>();
            while (rs.next()) {
                VitalSign v = new VitalSign();
                v.setBloodPressure(rs.getString("bloodPressure"));
                v.setPulse(rs.getInt("pulse"));
                v.setDiagnostic(rs.getString("diagnostic"));
                v.setWeight(rs.getInt("weight"));
                v.setTemperature(rs.getInt("temperature"));
                v.setDate(rs.getDate("date").toLocalDate());
                v.setTime(rs.getTime("time").toLocalTime());
                al.add(v);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void add(Encounter e) {
        String query = "insert into encounter (doctorId,patientId,weight,temperature,bloodPressure,pulse,diagnostic,date,time) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setInt(1, e.getDoctorId());
            stmt.setInt(2, e.getPatientId());
            stmt.setInt(3, e.getVitalSign().getWeight());
            stmt.setInt(4, e.getVitalSign().getTemperature());
            stmt.setString(5, e.getVitalSign().getBloodPressure());
            stmt.setInt(6, e.getVitalSign().getPulse());
            stmt.setString(7, e.getVitalSign().getDiagnostic());

            stmt.setDate(8, Date.valueOf(e.getVitalSign().getDate()));
            stmt.setTime(9, Time.valueOf(e.getVitalSign().getTime()));

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
