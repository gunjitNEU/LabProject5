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
import java.sql.Types;
import model.Admin;

/**
 *
 * @author imkus
 */
public class AdminDao {

    public int count() {
        String query = "select count(*) from admin";
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
        String query = "delete from admin where adminId= '" + id + "'";
        Statement stmt;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Admin a) {
        String query = "insert into admin (firstName,lastName,gender,email,phone,role) values(?,?,?,?,?,?)";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, a.getFirstName());
            stmt.setString(2, a.getLastName());
            if (a.getGender() != null) {
                stmt.setString(3, a.getGender().toString());
            } else {
                stmt.setNull(3, Types.VARCHAR);

            }
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getPhone());
            stmt.setString(6, a.getRole().toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Admin a) {
        String query = "update admin set firstName='?', lastName='?',gender='?',email='?',phone='?',role='?' where adminId= '?'";
        PreparedStatement stmt;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, a.getFirstName());
            stmt.setString(2, a.getLastName());
            if (a.getGender() != null) {
                stmt.setString(3, a.getGender().toString());
            } else {
                stmt.setNull(3, Types.VARCHAR);
            }
            stmt.setString(4, a.getEmail());
            stmt.setString(5, a.getPhone());
            stmt.setString(6, a.getRole().toString());
            stmt.setInt(7, a.getAdminId());

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Admin get(int id) {
        String query = "select * from admin where adminId= '" + id + "'";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                Admin a = new Admin();
                a.setFirstName(rs.getString("firstName"));
                a.setLastName(rs.getString("lastName"));
//                a.setGender(Person.Gender.valueOf(rs.getString("gender")));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setRole(Admin.Role.valueOf(rs.getString("role")));
                a.setAdminId(rs.getInt("adminId"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Admin> getAll() {
        String query = "select * from admin order by adminId";
        Statement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            ArrayList<Admin> al = new ArrayList<>();
            while (rs.next()) {
                Admin a = new Admin();
                a.setFirstName(rs.getString("firstName"));
                a.setLastName(rs.getString("lastName"));
//                a.setGender(Person.Gender.valueOf(rs.getString("gender")));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setRole(Admin.Role.valueOf(rs.getString("role")));
                a.setAdminId(rs.getInt("adminId"));
                al.add(a);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Admin get(String email, String password) {
        String query = "select * from admin where email=? and password=?";
        PreparedStatement stmt;
        ResultSet rs;
        try {
            stmt = ConnectionManager.getConnection().prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Admin a = new Admin();
                a.setFirstName(rs.getString("firstName"));
                a.setLastName(rs.getString("lastName"));
//                a.setGender(Person.Gender.valueOf(rs.getString("gender")));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setRole(Admin.Role.valueOf(rs.getString("role")));
                a.setAdminId(rs.getInt("adminId"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommunityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
