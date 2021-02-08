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
public class UpdateDao {

    Connection conn = null;

    public int updateUser(RegisterBean rb) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int result = 0;
        try {
            conn = MyConnection.getConection();
            PreparedStatement st = conn.prepareStatement("update user set phone=?, email=? , roll=? where name=?");
            st.setString(1, rb.getPhone());
            st.setString(2, rb.getEmail());
            st.setString(3, rb.getRoll());
            st.setString(4, rb.getUsername());

            result = st.executeUpdate();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
             if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
//            conn.commit();
        }
        return result;
    }

}
