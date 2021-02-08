/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bean.RegisterBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nuwan_d
 */
public class RegisterDao {

    Connection conn = null;

    public int validate(String name) throws ClassNotFoundException, SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        conn = MyConnection.getConection();
        int result;
//        this method check wether user is alredy exist or not
        try {
            PreparedStatement st1 = conn.prepareStatement("select * from user where name =?");
            st1.setString(1, name);// set values to preparedstatement variable           
            ResultSet rs1 = st1.executeQuery();

            //alredy have username then return 1
            if (rs1.next()) {
                result = 1;
            } else {
                result = 0;
            }
            rs1.close();
            st1.close();

        } catch (SQLException ex) {
            result = 0;
            if (conn != null) {
                conn.rollback();
            }
            System.out.println(ex);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public int register(RegisterBean reg) throws ClassNotFoundException, SQLException {
        int result = 0;
        // this is user register method
        conn = MyConnection.getConection();
        PreparedStatement st2 = null;
        try {
            st2 = conn.prepareStatement("insert into user values(?,?,?,?,?)");
            st2.setString(1, reg.getUsername());// set values to preparedstatement variable
            st2.setString(2, reg.getPhone());
            st2.setString(3, reg.getEmail());
            st2.setString(4, reg.getRoll());
            st2.setString(5, reg.getPassword());
            System.out.println(st2);
            result = st2.executeUpdate();

//            conn.commit();
            
        } catch (Exception ex) {
            System.out.println(ex);
            if (conn != null) {
                conn.rollback();
            }

        } finally {
            if (st2 != null) {
                st2.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
