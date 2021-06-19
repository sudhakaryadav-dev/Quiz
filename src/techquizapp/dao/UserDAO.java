/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

/**
 *
 * @author hp
 */
public class UserDAO {

    public static boolean validateUser(User user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where userid = ? and password = ? and usertype = ?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        return rs.next();
        
    }
    
    public static boolean addStudent(User user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int ans = ps.executeUpdate();
        return ans == 1;
    } 
    
    public static boolean changePassword(User user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password = ? where userid = ?");
        ps.setString(1, user.getPassword());
        ps.setString(2, user.getUserId());
        int ans = ps.executeUpdate();
        return ans == 1;
    }
    
    public static boolean validate(User user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from users where userid = ? ");
        ps.setString(1, user.getUserId());
        ResultSet rs = ps.executeQuery();
        return rs.next();
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
