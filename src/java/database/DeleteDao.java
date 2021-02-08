/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author nuwan_d
 */
import bean.GetBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDao {

    Connection conn = null;

    public int delete(String name) throws ClassNotFoundException, SQLException {
        int result = 0;
        try {
            conn = MyConnection.getConection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM user where name = ?");
            st.setString(1, name);

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
