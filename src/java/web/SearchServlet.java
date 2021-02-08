/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.GetBean;
import database.GetDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nuwan_d
 */
public class SearchServlet extends HttpServlet {

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

            String name = request.getParameter("name").trim();
            HttpSession session = request.getSession();
            String LoggedUser = (String) session.getAttribute("user");
            String Roll = (String) session.getAttribute("roll");

            if (Roll.equals("1")) {
                GetDao gd = new GetDao();
                ArrayList<GetBean> result = gd.adminSearchData(LoggedUser, name);

                if (!(result.isEmpty())) {
                    session.setAttribute("Allusers", result); // pass array list with all users to view.jsp
                    response.sendRedirect("searchView.jsp");
                } else {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Not found');");
//                    out.println("location='ViewServlet';");
//                    out.println("</script>");
                    RequestDispatcher dis = request.getRequestDispatcher("view.jsp");
                    request.setAttribute("search", false);
                    dis.forward(request, response);

                }
            } else if (Roll.equals("2")) {
                GetDao gd = new GetDao();
                ArrayList<GetBean> result = gd.managerSearchData(LoggedUser, name, Roll);

                if (!(result.isEmpty())) {
                    session.setAttribute("Allusers", result); // pass array list with all users to view.jsp
                    response.sendRedirect("searchView.jsp");
                } else {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Not found');");
//                    out.println("location='ViewServlet';");
//                    out.println("</script>");
                    RequestDispatcher dis = request.getRequestDispatcher("view.jsp");
                    request.setAttribute("search", false);
                    dis.forward(request, response);
                }

            } else if (Roll.equals("3")) {
                GetDao gd = new GetDao();
                ArrayList<GetBean> result = gd.nomalUserSearchData(LoggedUser, name, Roll);

                if (!(result.isEmpty())) {
                    session.setAttribute("Allusers", result); // pass array list with all users to view.jsp
                    response.sendRedirect("searchView.jsp");
                } else {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Not found');");
//                    out.println("location='ViewServlet';");
//                    out.println("</script>");
                    RequestDispatcher dis = request.getRequestDispatcher("view.jsp");
                    request.setAttribute("search", false);
                    dis.forward(request, response);
                }
            }

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
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
