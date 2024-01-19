/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Community;

/**
 *
 * @author imkus
 */
public class CommunityDao {

    public int count() {
        String query = "select count(*) from community";
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
        String query = "delete from community where communityId= '" + id + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Community c) {
        String query = "insert into community (area,district,pinCode,city) values(?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, c.getArea());
            stmt.setString(2, c.getDistrict());
            stmt.setString(3, c.getPinCode());
            stmt.setString(4, c.getCity().toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Community c) {
        String query = "update community set city= ? , area= ? , pinCode= ? , district= ?  where communityId= ?";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, c.getCity().toString());
            stmt.setString(2, c.getArea());
            stmt.setString(3, c.getPinCode());
            stmt.setString(4, c.getDistrict());
            stmt.setInt(5, c.getCommunityId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Community get(int id) {
        String query = "select * from community where communityId= '" + id + "'";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                Community c = new Community();
                c.setCommunityId(rs.getInt("communityId"));
                c.setCity(Community.City.valueOf(rs.getString("city")));
                c.setDistrict(rs.getString("district"));
                c.setPinCode(rs.getString("pinCode"));
                c.setArea(rs.getString("area"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Community> getAll() {
        String query = "select * from community order by communityId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Community> al = new ArrayList<>();
            while (rs.next()) {
                Community c = new Community();
                c.setCommunityId(rs.getInt("communityId"));
                c.setCity(Community.City.valueOf(rs.getString("city")));
                c.setDistrict(rs.getString("district"));
                c.setPinCode(rs.getString("pinCode"));
                c.setArea(rs.getString("area"));
                al.add(c);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Community> getAllByCity(Community.City city) {
        String query = "select * from community where city='" + city.toString() + "' order by communityId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Community> al = new ArrayList<>();
            while (rs.next()) {
                Community c = new Community();
                c.setCommunityId(rs.getInt("communityId"));
                c.setCity(Community.City.valueOf(rs.getString("city")));
                c.setDistrict(rs.getString("district"));
                c.setPinCode(rs.getString("pinCode"));
                c.setArea(rs.getString("area"));
                al.add(c);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
