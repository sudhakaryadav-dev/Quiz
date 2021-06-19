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
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author hp
 */
public class PerformanceDAO {

    public static ArrayList<String> getAllExamId(String studentId)throws SQLException
    {
        String qry="select examid from performance where userid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ArrayList<String> examIdList=new ArrayList<>();
        ps.setString(1, studentId);
        ResultSet rs=ps.executeQuery();    
        while(rs.next()){
            String id=rs.getString(1);
            examIdList.add(id);
        }
               
    return examIdList;                      
   }
    
    public static void addPerformance(Performance performance)throws SQLException{
        String qry="Insert into performance values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, performance.getUserId());
        ps.setString(2, performance.getExamId());
        ps.setInt(3,performance.getRight());
        ps.setInt(4,performance.getWrong());
        ps.setInt(5,performance.getUnattempted());
        ps.setDouble(6,performance.getPer());
        ps.setString(7,performance.getLanguage());
        ps.executeUpdate();
        
    }
    
    public static ArrayList<String> getAllStudentId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ArrayList<String> studentIdList = new ArrayList<>();
        ResultSet rs = st.executeQuery("Select distinct userid from performance");
        while(rs.next()){
            String id =rs.getString(1);
            studentIdList.add(id);
        }
        return studentIdList;
        
    }
    
    
    
    public static ArrayList<Performance> getAllData() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ArrayList<Performance> performanceList = new ArrayList<>();
        ResultSet rs = st.executeQuery("Select * from performance");
        while(rs.next()){
            String userid = rs.getString(1);
            String examid = rs.getString(2);
            int right = rs.getInt(3);
            int wrong = rs.getInt(4);
            int unatt = rs.getInt(5);
            double per = rs.getDouble(6);
            String lang = rs.getString(7);
            Performance p = new Performance(examid, lang, userid, right, wrong, unatt, per);
            performanceList.add(p);
                    
        }
        return performanceList;
        
        
    }
    
    public static StudentScore getScore(String studentId, String examId) throws SQLException{
       
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select language, per from performance where userid=? and examid=?");
       ArrayList<String> examIdList=new ArrayList<>();
       ps.setString(1, studentId);
       ps.setString(2, examId);
       ResultSet rs=ps.executeQuery(); 
       rs.next();
       StudentScore obj = new StudentScore();
       obj.setLanguage(rs.getString(1));
       obj.setPercentage(rs.getDouble(2));
       return obj;     
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
