/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.GetBean;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import database.GetDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nuwan_d
 */
public class ViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            // take users
            HttpSession session = request.getSession();
            String LoggedUser = (String) session.getAttribute("user"); //get logged user's username
            String Roll = (String) session.getAttribute("roll"); //get logged user's user roll
            
            if(LoggedUser!=null){
                if (Roll.equals("1")) { // if user is admin
                GetDao dao = new GetDao();
                ArrayList<GetBean> users = dao.adminGetData(LoggedUser); // Create GetBean type array list to store user's details
                session.setAttribute("Allusers", users); // pass array list with all users to view.jsp
                response.sendRedirect("view.jsp");

            } else if (Roll.equals("2")) {
                GetDao dao = new GetDao();
                ArrayList<GetBean> users = dao.managerGetData(LoggedUser, Roll); // Create GetBean type array list to store user's details
                session.setAttribute("Allusers", users); // pass array list with all users to view.jsp
                response.sendRedirect("view.jsp");

            } else if (Roll.equals("3")) {
                GetDao dao = new GetDao();
                ArrayList<GetBean> users = dao.userGetData(LoggedUser, Roll); // Create GetBean type array list to store user's details
                session.setAttribute("Allusers", users); // pass array list with all users to view.jsp
                response.sendRedirect("view.jsp");
            }
            }else{
                response.sendRedirect("login.jsp");
            }
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
