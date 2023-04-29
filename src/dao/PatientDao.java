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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Doctor;
import model.Patient;
import model.Person;

/**
 *
 * @author imkus
 */
public class PatientDao {

    public int count() {
        String query = "select count(*) from patient";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void remove(int id) {
        String query = "delete from patient where patientId= '" + id + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Patient p) {
        String query = "insert into patient (firstName,lastName,gender,email,phone,doctorId) values(?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, p.getFirstName());
            stmt.setString(2, p.getLastName());
            stmt.setString(3, p.getGender().toString());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getPhone());
            stmt.setInt(6, p.getDoctorId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Patient p) {
        String query = "update patient set firstName='?', lastName='?',gender='?',email='?',phone='?',doctorId='?' where patientId= '?'";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, p.getFirstName());
            stmt.setString(2, p.getLastName());
            stmt.setString(3, p.getGender().toString());
            stmt.setString(4, p.getEmail());
            stmt.setString(5, p.getPhone());
            stmt.setInt(6, p.getDoctorId());
            stmt.setInt(7, p.getPatientId());

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Patient get(int id) {
        String query = "select * from patient where patientId= '" + id + "'";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                Patient p = new Patient();
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setGender(Person.Gender.valueOf(rs.getString("gender")));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setDoctorId(rs.getInt("doctorId"));
                p.setPatientId(rs.getInt("patientId"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Patient> getAll() {
        String query = "select * from patient order by patientId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Patient> al = new ArrayList<>();
            while (rs.next()) {
                Patient p = new Patient();
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setGender(Person.Gender.valueOf(rs.getString("gender")));
                p.setEmail(rs.getString("email"));
                p.setPhone(rs.getString("phone"));
                p.setDoctorId(rs.getInt("doctorId"));
                p.setPatientId(rs.getInt("patientId"));
                al.add(p);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
