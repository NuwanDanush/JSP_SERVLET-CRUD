/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bean.GetBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nuwan_d
 */
public class GetDao {

    Connection conn = null;

    public ArrayList<GetBean> adminGetData(String LoggedUser) throws ClassNotFoundException, SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> allUser = new ArrayList<GetBean>(); // create array list object to get all users from database
        try {
            conn = MyConnection.getConection();
            PreparedStatement st1 = conn.prepareStatement("select * from user where name!=? ");
            st1.setString(1, LoggedUser);
            ResultSet rs1 = st1.executeQuery();

            while (rs1.next()) {
                String name = rs1.getString("name");
                String phone = rs1.getString("phone");
                String email = rs1.getString("email");
                String roll = rs1.getString("roll");
                GetBean bean = new GetBean(name, phone, email, roll); // create Getbean type object and set values using constructor
                allUser.add(bean); // add GetBean type object in to the arraylist               
            }
            rs1.close();
            st1.close();

        } catch (Exception e) {
            System.out.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return allUser; // Return object arraylist to ViewServlet
    }

    public GetBean findUser(String name) throws ClassNotFoundException, SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        GetBean gb1 = null;

        try {
            conn = MyConnection.getConection();
            PreparedStatement st2 = conn.prepareStatement("select * from user where name =?");
            st2.setString(1, name);
            ResultSet rs2 = st2.executeQuery();

            if (rs2.next()) {
                String username = rs2.getString("name");
                String phonenumber = rs2.getString("phone");
                String email = rs2.getString("email");
                String roll = rs2.getString("roll");
                gb1 = new GetBean(username, phonenumber, email, roll); //Create Getbean obeject and set rs2 values them

            }
            rs2.close();
            st2.close();

        } catch (Exception e) {
            System.out.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return gb1;//return user details
    }

    public ArrayList<GetBean> adminSearchData(String LoggedUser, String name) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> searchUsers = new ArrayList<GetBean>();
        try {
            conn = MyConnection.getConection();
            GetBean gb3 = null;

            name = name
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            PreparedStatement st3 = conn.prepareStatement("select * from user where name!=? and name like? ESCAPE '!'");
            st3.setString(1, LoggedUser);
            st3.setString(2, name + "%");
            ResultSet rs3 = st3.executeQuery();

            while (rs3.next()) {
                String username = rs3.getString("name");
                String phonenumber = rs3.getString("phone");
                String email = rs3.getString("email");
                String roll = rs3.getString("roll");
                gb3 = new GetBean(username, phonenumber, email, roll); //Create Getbean obeject and set rs2 values them
                searchUsers.add(gb3);

            }
            rs3.close();
            st3.close();

        } catch (Exception e) {
            System.err.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return searchUsers; //return serch data array
    }

    public ArrayList<GetBean> managerGetData(String LoggedUser, String Roll) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> allUser = new ArrayList<GetBean>(); // create array list object to get all users from database
        try {
            conn = MyConnection.getConection();
            PreparedStatement st4 = conn.prepareStatement("select * from user where name!=? and roll!=? ");
            st4.setString(1, LoggedUser);
            st4.setString(2, "1");
            ResultSet rs4 = st4.executeQuery();

            while (rs4.next()) {
                String name = rs4.getString("name");
                String phone = rs4.getString("phone");
                String email = rs4.getString("email");
                String roll = rs4.getString("roll");
                GetBean bean = new GetBean(name, phone, email, roll); // create Getbean type object and set values using constructor
                allUser.add(bean); // add GetBean type object in to the arraylist               
            }
            rs4.close();
            st4.close();

        } catch (Exception e) {
            System.out.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return allUser; // Return object arraylist to ViewServlet
    }

    public ArrayList<GetBean> managerSearchData(String LoggedUser, String name, String Roll) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> searchUsers = new ArrayList<GetBean>();
        try {
            conn = MyConnection.getConection();
            GetBean gb5 = null;

            name = name
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            PreparedStatement st5 = conn.prepareStatement("select * from user where name!=? and roll!=?  and name like? ESCAPE '!'");
            st5.setString(1, LoggedUser);
            st5.setString(2, "1");
            st5.setString(3, name + "%");
            ResultSet rs5 = st5.executeQuery();

            while (rs5.next()) {
                String username = rs5.getString("name");
                String phonenumber = rs5.getString("phone");
                String email = rs5.getString("email");
                String roll = rs5.getString("roll");
                gb5 = new GetBean(username, phonenumber, email, roll); //Create Getbean obeject and set rs2 values them
                searchUsers.add(gb5);

            }
            rs5.close();
            st5.close();

        } catch (Exception e) {
            System.err.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return searchUsers; //return serch data array
    }

    public ArrayList<GetBean> userGetData(String LoggedUser, String Roll) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> allUser = new ArrayList<GetBean>(); // create array list object to get all users from database
        try {
            conn = MyConnection.getConection();
            PreparedStatement st6 = conn.prepareStatement("select * from user where name!=? and roll=? ");
            st6.setString(1, LoggedUser);
            st6.setString(2, "3");
            ResultSet rs6 = st6.executeQuery();

            while (rs6.next()) {
                String name = rs6.getString("name");
                String phone = rs6.getString("phone");
                String email = rs6.getString("email");
                String roll = rs6.getString("roll");
                GetBean bean = new GetBean(name, phone, email, roll); // create Getbean type object and set values using constructor
                allUser.add(bean); // add GetBean type object in to the arraylist               
            }
            rs6.close();
            st6.close();

        } catch (Exception e) {
            System.out.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return allUser; // Return object arraylist to ViewServlet

    }

    public ArrayList<GetBean> nomalUserSearchData(String LoggedUser, String name, String Roll) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<GetBean> searchUsers = new ArrayList<GetBean>();
        try {
            conn = MyConnection.getConection();
            GetBean gb7 = null;

            name = name
                    .replace("!", "!!")
                    .replace("%", "!%")
                    .replace("_", "!_")
                    .replace("[", "![");
            PreparedStatement st7 = conn.prepareStatement("select * from user where name!=? and roll=?  and name like? ESCAPE '!'");
            st7.setString(1, LoggedUser);
            st7.setString(2, "3");
            st7.setString(3, name + "%");
            ResultSet rs7 = st7.executeQuery();

            while (rs7.next()) {
                String username = rs7.getString("name");
                String phonenumber = rs7.getString("phone");
                String email = rs7.getString("email");
                String roll = rs7.getString("roll");
                gb7 = new GetBean(username, phonenumber, email, roll); //Create Getbean obeject and set rs2 values them
                searchUsers.add(gb7);

            }
            rs7.close();
            st7.close();

        } catch (Exception e) {
            System.err.println(e);
            if (conn != null) {
                conn.rollback();
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return searchUsers; //return serch data array

    }
}
