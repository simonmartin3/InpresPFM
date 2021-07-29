/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletUtil;

import BeanBDAccess.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Simon
 */
@WebServlet(name = "reservationServlet", urlPatterns = {"/reservationServlet"})
public class reservationServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String redirectURL;
        boolean ret = false;
        if(request.getParameter("request").equals("login"))
        {
            String user = request.getParameter("username");
            String pass = request.getParameter("pass");
            List<Client> listClient = null;
            listClient = impln.getClients();
            
            if(request.getParameter("new") != null)
            {
                synchronized(this)
                {
                    impln.addClient(user, pass);
                }
            }
            
            
            System.out.println("Essai de connexion JDBC");
            System.out.println(user +"-"+ pass);
            
            if(!listClient.isEmpty())
            {
                int i = 0;
                boolean find = false;
                while(i < listClient.size()) 
                {
                    if(listClient.get(i).getUsername().equals(user) && listClient.get(i).getPassword().equals(pass))
                    {
                        find = true;
                        break;
                    }
                    i++;
                }

                if(find)
                {
                    List<Destination> listDest = impln.getDestinations();
                    request.setAttribute("dest", listDest);
                    RequestDispatcher rd = request.getRequestDispatcher("/reservation.jsp"); 
                    rd.forward(request, response);  
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
        else if(request.getParameter("request").equals("reserve"))
        {
            String idTransporteur = request.getParameter("idTransporteur");
            String idContainer = request.getParameter("idContainer");
            Reservation r = new Reservation();
            
            List<Transporteur> listTransporteur = impln.getTransporteurs();
            List<Reservation> listReservation = impln.getReservations();
            
            int i = 0;
            boolean find = false;
            while(i < listTransporteur.size()) 
            {
                if(listTransporteur.get(i).getIdTransporteur().equals(idTransporteur))
                {
                    find = true;
                    break;
                }
                i++;
            }
            
            if(find)
            {
                int capacity = Integer.parseInt(request.getParameter("capacity"));
                String danger = request.getParameter("danger");
                String contenu = request.getParameter("contenu");
                int count = listReservation.size();
                LocalDate localDate = LocalDate.now();
                count++;
                r.setIdReservation("R-00000"+count);
                r.setIdContainer(idContainer);
                r.setIdSociete(listTransporteur.get(i).getIdSociete());
                r.setIdTransporteur(idTransporteur);
                r.setDateReservation(DateTimeFormatter.ofPattern("dd/MM/yyy").format(localDate));
                
                // create container
                Container c = new Container();
                c.setIdContainer(idContainer);
                c.setCapacite(capacity);
                c.setContenu(contenu);
                c.setDangers(danger);
                c.setIdSociete(listTransporteur.get(i).getIdSociete());
                
                //Search emplacement
                List<Emplacement> listEmplacement = impln.getEmplacements();
                i = 0;
                find = false;
                while(i < listEmplacement.size()) 
                {
                    if(listEmplacement.get(i).getIdContainer().equals("/"))
                    {
                        find = true;
                        break;
                    }
                    i++;
                }
                if(find)
                {
                    synchronized(this)
                    {
                        impln.addEmplacement(listEmplacement.get(i).getIdEmplacement(), idContainer);
                        ret = impln.addContainer(c);
                    }
                    if(ret)
                    {
                        impln.addReservation(r);
                        
                        String msg = "Voici votre numéro de réservation :\n" + r.getIdReservation();
                        String empl = "Votre container " + r.getIdContainer() + " aura  comme empalcement :\n" +
                        listEmplacement.get(i).getX() + " - " + listEmplacement.get(i).getY();
                        request.setAttribute("msg", msg);
                        request.setAttribute("empl", empl);
                        RequestDispatcher rd = request.getRequestDispatcher("/done.jsp"); 
                        rd.forward(request, response);
                    }
                    else
                    {
                        String msg = "Votre réservation n'a pas pu être terminé car le container existe déjà.";
                        request.setAttribute("msg", msg);
                        RequestDispatcher rd = request.getRequestDispatcher("/done.jsp"); 
                        rd.forward(request, response);
                    }
                }
                else
                {
                    String msg = "Votre réservation n'a pas pu être terminé car il n'y a plus de place";
                    request.setAttribute("msg", msg);
                    RequestDispatcher rd = request.getRequestDispatcher("/done.jsp"); 
                    rd.forward(request, response);
                }
            }
            else
            {
                String msg = "Erreur le transporteur n'existe pas !";
                request.setAttribute("msg", msg);
                RequestDispatcher rd = request.getRequestDispatcher("/done.jsp"); 
                rd.forward(request, response);
            }
            
        }
        else if(request.getParameter("request").equals("end"))
        {
            List<Destination> listDest = impln.getDestinations();
            request.setAttribute("dest", listDest);
            RequestDispatcher rd = request.getRequestDispatcher("/reservation.jsp"); 
            rd.forward(request, response);
        }
        else
        {
            redirectURL = request.getContextPath()+"/index.jsp";
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
