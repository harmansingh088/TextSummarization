package services;

import beans.UserBean;
import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManageProfileServices {

    public static UserBean getUserBean(int id)
    {
        UserBean objBean=null;
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try
        {
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("select username,password,name,dob,contact,email,address,gender from usermaster where userid=?");
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                objBean=new UserBean();
                objBean.setUserId(id);
                objBean.setUserName(rs.getString("username"));
                objBean.setPassword(rs.getString("password"));
                objBean.setName(rs.getString("name"));
                objBean.setDob(rs.getString("dob"));
                objBean.setContact(rs.getString("contact"));
                objBean.setEmail(rs.getString("email"));
                objBean.setAddress(rs.getString("address"));
                objBean.setGender(rs.getBoolean("gender"));
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in getUserBean() : "+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                conn.close();
                rs.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception in finally of getUserBean() : "+e);
            }
        }
        return objBean;
    }
    public static boolean updateById(UserBean objBean)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try
        {
            String username=objBean.getUserName();
            conn=DBConnection.connect();
            pstmt=conn.prepareStatement("update usermaster set username=?,password=?,name=?,dob=?,contact=?,email=?,address=?,gender=? where userid=?");
            pstmt.setString(1,objBean.getUserName());
            pstmt.setString(2,objBean.getPassword());
            pstmt.setString(3,objBean.getName());
            pstmt.setString(4,objBean.getDob());
            pstmt.setString(5,objBean.getContact());
            pstmt.setString(6,objBean.getEmail());
            pstmt.setString(7,objBean.getAddress());
            pstmt.setInt(9,objBean.getUserId());
            pstmt.setBoolean(8,objBean.getGender());
            int i=pstmt.executeUpdate();
            if(i>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception in updateById() : "+e);
        }
        finally
        {
            try
            {
                pstmt.close();
                conn.close();
                rs.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception in finally of updateById() : "+e);
            }
        }
        return false;
    }
}
