/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.EmployeeDBContext;
import Helper.ControllerHelper;
import Helper.DateTimeHelper;
import Model.Employee;
import Model.Holiday;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SalaryController extends HttpServlet {

    ControllerHelper conHelp = new ControllerHelper();
    DateTimeHelper dtHelp = new DateTimeHelper();
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalaryController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SalaryController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        int[] ym = conHelp.year_month(request.getQueryString());
        String year_month = String.valueOf(ym[1])+"-"+(ym[0]>9?String.valueOf(ym[0]):"0"+String.valueOf(ym[0]));
        EmployeeDBContext db = new EmployeeDBContext();
        ArrayList<Employee> eList = db.loadEmployees();
        ArrayList<String> listDay = dtHelp.getListDayOfMonth(ym[0]-1, ym[1]);
        request.setAttribute("ym", year_month);
        request.setAttribute("month", ym[0]);
        request.setAttribute("year", ym[1]);
        request.setAttribute("listDay", listDay);
        request.setAttribute("employees", eList);
        request.getRequestDispatcher("View/SalaryReport.jsp").forward(request, response);
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
        processRequest(request, response);
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
