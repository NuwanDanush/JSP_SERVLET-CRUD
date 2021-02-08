/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.GetBean;
import bean.RegisterBean;
import database.GetDao;
import database.UpdateDao;
//import database.UserFindByIdDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
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
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("uname").trim();
            String phone = request.getParameter("phone").trim();
            String email = request.getParameter("email").trim();
            String roll = request.getParameter("roll");

            RegisterBean rb = new RegisterBean(); // create RegisterBean object and set values from user
            rb.setUsername(name);
            rb.setPhone(phone);
            rb.setEmail(email);
            rb.setRoll(roll);

            UpdateDao ud = new UpdateDao();
            int result = ud.updateUser(rb); // call update function in UpdateDao

            HttpSession session = request.getSession();
            String editflag = (String) session.getAttribute("editflag"); // get flag from FindByUserServlet

            if (result == 1) {
                if (editflag == "1") {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Update Successfully!');");
//                    out.println("location='ViewServlet';");
//                    out.println("</script>");
                    RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
                    request.setAttribute("update", true);// return the response to update.jsp
                    dis.forward(request, response);

                } else if (editflag == "2") {
//                    out.println("<script type=\"text/javascript\">");
//                    out.println("alert('Update Successfully!');");
//                    out.println("location='welcome.jsp';");
//                    out.println("</script>");
                    RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
                    request.setAttribute("update", true);// return the response to update.jsp
                    dis.forward(request, response);
                }

            } else {
                out.print("Update Erorr");
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
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
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
