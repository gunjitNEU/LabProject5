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
import model.Community;
import model.Doctor;
import model.Person;

/**
 *
 * @author imkus
 */
public class DoctorDao {

    public int count() {
        String query = "select count(*) from doctor";
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
        String query = "delete from doctor where doctorId= '" + id + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Doctor d) {
        String query = "insert into doctor (firstName,lastName,gender,email,phone,hospitalId) values(?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, d.getFirstName());
            stmt.setString(2, d.getLastName());
            stmt.setString(3, d.getGender().toString());
            stmt.setString(4, d.getEmail());
            stmt.setString(5, d.getPhone());
            stmt.setInt(6, d.getHospitalId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Doctor d) {
        String query = "update doctor set firstName= ? , lastName= ? , gender= ? , email= ? , phone= ? , hospitalId= ?  where doctorId= ?";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, d.getFirstName());
            stmt.setString(2, d.getLastName());
            stmt.setString(3, d.getGender().toString());
            stmt.setString(4, d.getEmail());
            stmt.setString(5, d.getPhone());
            stmt.setInt(6, d.getHospitalId());
            stmt.setInt(7, d.getDoctorId());

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Doctor get(int id) {
        String query = "select * from doctor where doctorId= '" + id + "'";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Doctor> getAll() {
        String query = "select * from doctor order by doctorId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Doctor> al = new ArrayList<>();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                al.add(d);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Doctor get(String email, String password) {
        String query = "select * from doctor where email=? and password=?";
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Doctor> getAllByHospital(int hospitalId) {
        String query = "select * from doctor where hospitalId='" + hospitalId + "' order by doctorId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Doctor> al = new ArrayList<>();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                al.add(d);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Doctor> getAllByCommunity(int communityId) {
        String query = "select * from doctor d  join hospital h on d.hospitalId=h.hospitalId where communityId='" + communityId + "' order by doctorId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Doctor> al = new ArrayList<>();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                al.add(d);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Doctor> getAllByCity(Community.City c) {
        String query = "select * from doctor d  join hospital h on d.hospitalId=h.hospitalId join community c on h.communityId=c.communityId  where city='" + c.toString() + "' order by doctorId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Doctor> al = new ArrayList<>();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setFirstName(rs.getString("firstName"));
                d.setLastName(rs.getString("lastName"));
                d.setGender(Person.Gender.valueOf(rs.getString("gender")));
                d.setEmail(rs.getString("email"));
                d.setPhone(rs.getString("phone"));
                d.setHospitalId(rs.getInt("hospitalId"));
                d.setDoctorId(rs.getInt("doctorId"));
                al.add(d);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
