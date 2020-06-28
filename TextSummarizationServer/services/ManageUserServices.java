/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.UserBean;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell1
 */
public class ManageUserServices {

    public static boolean addRecord(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("insert into usermaster (userid,username,password,usertype,userstatus,name,contact,email,address,dob,gender) values(?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, objbean.getUserId());
            pstmt.setString(2, objbean.getUserName());
            pstmt.setString(3, objbean.getPassword());
            pstmt.setString(4, objbean.getUserType());
            pstmt.setBoolean(5, objbean.getUserStatus());
            pstmt.setString(6, objbean.getName());
            pstmt.setString(7, objbean.getContact());
            pstmt.setString(8, objbean.getEmail());
            pstmt.setString(9, objbean.getAddress());
            pstmt.setString(10, objbean.getDob());
            pstmt.setBoolean(11, objbean.getGender());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in Adding Record:" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of Adding Record:" + e);
            }
        }
        return false;
    }

    public static boolean UpdateById(UserBean objbean) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("update usermaster set username=?,password=?,usertype=?,userstatus=?,name=?,contact=?,email=?,address=?,dob=?,gender=? where userid=?");
            pstmt.setString(1, objbean.getUserName());
            pstmt.setString(2, objbean.getPassword());
            pstmt.setString(3, objbean.getUserType());
            pstmt.setBoolean(4, objbean.getUserStatus());
            pstmt.setString(5, objbean.getName());
            pstmt.setString(6, objbean.getContact());
            pstmt.setString(7, objbean.getEmail());
            pstmt.setString(8, objbean.getAddress());
            pstmt.setString(9, objbean.getDob());
            pstmt.setBoolean(10, objbean.getGender());
            pstmt.setInt(11, objbean.getUserId());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in Updating Record:" + e);
        } finally {
            try {

                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of Updating Record:" + e);
            }
        }
        return false;
    }

    public static ArrayList<UserBean> getAllRecords() {
        ArrayList<UserBean> al = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            al = new ArrayList<UserBean>();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                objbean.setUserId(rs.getInt("userid"));
                objbean.setUserName(rs.getString("username"));
                objbean.setPassword(rs.getString("password"));
                objbean.setUserType(rs.getString("usertype"));
                objbean.setUserStatus(rs.getBoolean("userstatus"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setEmail(rs.getString("email"));
                objbean.setAddress(rs.getString("address"));
                objbean.setDob(rs.getString("dob"));
                objbean.setGender(rs.getBoolean("gender"));
                al.add(objbean);

            }
            return al;
        } catch (Exception e) {
            System.out.println("Exception in get all records:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of get all records:" + e);
            }
        }
        return al;

    }

    public static ArrayList<UserBean> getRecordsByName(String name1) {
        ArrayList<UserBean> al = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            al = new ArrayList<UserBean>();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster where name=?");
            pstmt.setString(1, name1);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                objbean.setUserId(rs.getInt("userid"));
                objbean.setUserName(rs.getString("username"));
                objbean.setPassword(rs.getString("password"));
                objbean.setUserType(rs.getString("usertype"));
                objbean.setUserStatus(rs.getBoolean("userstatus"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setEmail(rs.getString("email"));
                objbean.setAddress(rs.getString("address"));
                objbean.setDob(rs.getString("dob"));
                objbean.setGender(rs.getBoolean("gender"));
                al.add(objbean);

            }
            return al;
        } catch (Exception e) {
            System.out.println("Exception in get records by name:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of get recordsby name:" + e);
            }
        }
        return al;

    }

    
    public static ArrayList<UserBean> getRecordsByUserType(String usertype) {
        ArrayList<UserBean> al = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            al = new ArrayList<UserBean>();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster where usertype=?");
            pstmt.setString(1,usertype);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                objbean.setUserId(rs.getInt("userid"));
                objbean.setUserName(rs.getString("username"));
                objbean.setPassword(rs.getString("password"));
                objbean.setUserType(rs.getString("usertype"));
                objbean.setUserStatus(rs.getBoolean("userstatus"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setEmail(rs.getString("email"));
                objbean.setAddress(rs.getString("address"));
                objbean.setDob(rs.getString("dob"));
                objbean.setGender(rs.getBoolean("gender"));
                al.add(objbean);

            }
            return al;
        } catch (Exception e) {
            System.out.println("Exception in get records by user type:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of get recordsby user type:" + e);
            }
        }
        return al;

    }

    
     public static ArrayList<UserBean> getRecordsByNameAndUserType(String usertype,String name) {
        ArrayList<UserBean> al = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            al = new ArrayList<UserBean>();
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select * from usermaster where usertype=? and name=?");
            pstmt.setString(1,usertype);
            pstmt.setString(2,name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean objbean = new UserBean();
                objbean.setUserId(rs.getInt("userid"));
                objbean.setUserName(rs.getString("username"));
                objbean.setPassword(rs.getString("password"));
                objbean.setUserType(rs.getString("usertype"));
                objbean.setUserStatus(rs.getBoolean("userstatus"));
                objbean.setName(rs.getString("name"));
                objbean.setContact(rs.getString("contact"));
                objbean.setEmail(rs.getString("email"));
                objbean.setAddress(rs.getString("address"));
                objbean.setDob(rs.getString("dob"));
                objbean.setGender(rs.getBoolean("gender"));
                al.add(objbean);

            }
            return al;
        } catch (Exception e) {
            System.out.println("Exception in get records by user type:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of get recordsby user type:" + e);
            }
        }
        return al;

    }
    
    
    
    public static int getNextId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = 0;
        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select max(userid) from usermaster");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("max(userid)") + 1;
            }
            return id;
        } catch (Exception e) {
            System.out.println("Exception in getNextId" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of getNextId:" + e);
            }

        }
        return id;
    }
}
