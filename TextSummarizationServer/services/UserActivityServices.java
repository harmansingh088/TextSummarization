/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dell1
 */
public class UserActivityServices {
    
    public static int insertLoginTime(int id)
    {
       Connection conn=null;
       PreparedStatement pstmt=null; 
       ResultSet rs=null;
       int aid=0;
       try
       {
           SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
           Date d1=new Date();
           String str=sdf.format(d1);
           conn = DBConnection.connect();
           pstmt = conn.prepareStatement("insert into useractivitymaster (userid,logintime) values(?,?)");
           pstmt.setInt(1,id);
           pstmt.setString(2,str);
           pstmt.executeUpdate();
           pstmt=conn.prepareStatement("select max(activityid) from useractivitymaster ");
           
           rs=pstmt.executeQuery();
           if(rs.next())
           {
             aid=rs.getInt("max(activityid)");
           }
           return aid;
           
       }
       catch(Exception e)
       {
           System.out.println("Exception in InsertLoginTime:"+e);
       }
       return aid;
    }
    
    public static void insertLogoutTime(int aid)
    {
       Connection conn=null;
       PreparedStatement pstmt=null; 
       try
       {
           SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
           Date d1=new Date();
           String str=sdf.format(d1);
           conn = DBConnection.connect();
           pstmt = conn.prepareStatement("update useractivitymaster set logouttime=? where activityid=?");
           pstmt.setString(1,str);
           pstmt.setInt(2,aid);
           int i=pstmt.executeUpdate();
       }
       catch(Exception e)
       {
           System.out.println("Exception in InsertLogoutTime:"+e);
       }
    }
    
}
