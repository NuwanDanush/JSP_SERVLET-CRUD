/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bean.GetBean;
import bean.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nuwan_d
 */
public class LoginDao {

    Connection conn = null;
    boolean status = false;

    public boolean validate(LoginBean loginBean, GetBean gb) throws ClassNotFoundException, SQLException {

        conn = MyConnection.getConection(); // get database connection
        try {
            PreparedStatement st = conn.prepareStatement("select * from user where name = ? and password = ? ");
            st.setString(1, loginBean.getUsername()); // set values to preparedstatement variable using get function 
            st.setString(2, loginBean.getPassword());

            ResultSet rs = st.executeQuery();
            status = rs.next(); // resultset value assign to "status" variable
            
            if (status == true) {
                if (!loginBean.getUsername().equals(rs.getString("name")) || !loginBean.getPassword().equals(rs.getString("password"))) {
                    status = false; //check the username and password are correct?
                } else {                   
                        gb.setUsername(rs.getString("name"));
                        gb.setPhone(rs.getString("phone"));
                        gb.setEmail(rs.getString("email"));
                        gb.setRoll(rs.getString("roll"));                  
                }
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.print(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        
        return status;
    }
}
