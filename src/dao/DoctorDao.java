/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import data.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hospital;

/**
 *
 * @author imkus
 */
public class DoctorDao {
    public static int count() {
        String query = "select count(*) from hospital";
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

    public static void remove(int id) {
        String query = "delete from hospital where hospitalId= '" + id + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void add(Hospital h) {
        String query = "insert into hospital (name,communityId) values(?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, h.getName());
            stmt.setInt(2, h.getCommunityId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void update(Hospital h) {
        String query = "update hospital set name='" + h.getName() + "', communityId='" + h.getCommunityId() + "' where hospitalId= '" + h.getHospitalId() + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Hospital get(int id) {
        String query = "select * from hospital where hospitalId= '" + id + "'";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                Hospital h = new Hospital();
                h.setCommunityId(rs.getInt("communityId"));
                h.setHospitalId(rs.getInt("hospitalId"));
                h.setName(rs.getString("name"));
                return h;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Hospital> getAll() {
        String query = "select * from hospital order by hospitalId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Hospital> al = new ArrayList<>();
            while (rs.next()) {
                Hospital h = new Hospital();
                h.setCommunityId(rs.getInt("communityId"));
                h.setHospitalId(rs.getInt("hospitalId"));
                h.setName(rs.getString("name"));
                al.add(h);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
