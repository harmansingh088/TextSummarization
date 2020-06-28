/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dell1
 */
public class DBConnection {

    public static Connection connect() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql:///textsummarization";
            conn = DriverManager.getConnection(url, "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conn;
    }

}
