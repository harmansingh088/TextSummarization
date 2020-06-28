/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.UserBean;
import db.DBConnection;
import email.SendMail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dell1
 */
public class LoginServices {

    public static UserBean authenticateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserBean objbean=new UserBean();
        try {
            conn = DBConnection.connect();
            //pstmt = conn.prepareStatement("select userstatus from usermaster where username=? and password=?");
            pstmt = conn.prepareStatement("select userid,userstatus,password,usertype from usermaster where username=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
           
            if (rs.next()) {
                if (password.equals(rs.getString("Password"))) {
         
                       objbean.setUserId(rs.getInt("userid"));
                       objbean.setUserType(rs.getString("usertype"));
                       objbean.setUserStatus(rs.getBoolean("userstatus"));
                       return objbean;
                } 

            }

        } catch (Exception e) {
            System.out.println("Exception in authentication:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of authentication:" + e);
            }
        }
        return objbean;
    }

    public static int forgotPassword(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.connect();
            pstmt = conn.prepareStatement("select email,password from usermaster where username=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("Password");
                String email = rs.getString("email");
                String result=SendMail.sendMail(email,"Your Password is:"+password,"Password Recovery");
                if(result.equalsIgnoreCase("sent")){
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in forgotPassword:" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in finally of forgotPassword:" + e);
            }
        }
        return -1;
    }

}
