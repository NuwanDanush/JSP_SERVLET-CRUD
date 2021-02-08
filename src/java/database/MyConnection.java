/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nuwan_d
 */
public class MyConnection {

    public static Connection getConection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/profile2";

            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected to MySQL database");

            if (con != null) {
                System.out.println("Successfully connected to MySQL database test");
            } else {
                System.out.println("Connection error");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }
}
