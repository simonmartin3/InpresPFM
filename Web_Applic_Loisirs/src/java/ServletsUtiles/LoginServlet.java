/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsUtiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import BeanBDAccess.*;
import java.util.List;

/**
 *
 * @author Simon
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    BDBeanImpln impln = new BDBeanImpln();
    
    private static Properties hashtable = new Properties();
    public Properties getHashtable(){return hashtable;}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        boolean ret;
        String redirectURL;
        HttpSession session = null;
        
        if(request.getParameter("request").equals("nopass"))
        {
            // New location to be redirected
            redirectURL = request.getContextPath()+"/signin.jsp?username="+request.getParameter("username");
            response.sendRedirect(redirectURL);
        }
        else if(request.getParameter("request").equals("signin"))
        {
            String user = request.getParameter("username");
            String pass = request.getParameter("pass");
            String repass = request.getParameter("repass");
            
            if(pass.equals(repass)) {
                // add client
                Client newClient = new Client(user.toString(), pass.toString());
                ret = impln.addClient(newClient);
                if(ret)
                {
                    session = request.getSession(true);
                    session.setAttribute("user.session", user);
                    session.setAttribute("error.session", "0");
                    session.setAttribute("panier.session", false);
                    redirectURL = request.getContextPath()+"/shop.jsp";
                }
                else
                    redirectURL = request.getContextPath()+"/index.jsp";
            } 
            else 
            {
                redirectURL = request.getContextPath()+"/index.jsp";    
            }
            
            response.sendRedirect(redirectURL);
            
        }
        else if(request.getParameter("request").equals("cancel"))
        {
            session.invalidate();
            redirectURL = request.getContextPath()+"/index.jsp";
            response.sendRedirect(redirectURL);
        }
        else if(request.getParameter("request").equals("login"))
        {
            boolean find = false;
            
            if(!request.getParameter("pass").isEmpty())
            {
                String user = request.getParameter("username");
                String pass = request.getParameter("pass");

                System.out.println("Essai de connexion JDBC");
                List<Client> clientList = null;
        
                clientList = impln.getClients();

                if(!clientList.isEmpty())
                {
                    int i = 0;
                    while(i < clientList.size()) 
                    {
                        if(clientList.get(i).getUsername().equals(user) && clientList.get(i).getPassword().equals(pass))
                        {
                            find = true;
                            break;
                        }
                        i++;
                    }

                    if(find)
                    {
                        session = request.getSession(true);
                        session.setAttribute("user.session", user);
                        session.setAttribute("idClient.session", clientList.get(i).getIdClient());
                        session.setAttribute("error.session", "0");
                        session.setAttribute("panier.session", false);
                        
                        redirectURL = request.getContextPath()+"/shop.jsp";
                        response.sendRedirect(redirectURL);
                    }
                    else
                    {
                        redirectURL = request.getContextPath()+"/index.jsp";
                        response.sendRedirect(redirectURL);
                    }
                }
                else
                {
                    redirectURL = request.getContextPath()+"/index.jsp";
                    response.sendRedirect(redirectURL);
                }
            }
        }
        else
        {
            redirectURL = request.getContextPath()+"/index.jsp";
            response.sendRedirect(redirectURL);
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
        processRequest(request, response);
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
