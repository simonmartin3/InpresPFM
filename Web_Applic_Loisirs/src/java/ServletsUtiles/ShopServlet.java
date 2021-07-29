/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsUtiles;

import BeanBDAccess.BDBeanImpln;
import BeanBDAccess.*;
import java.io.IOException;
import static java.lang.System.out;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Simon
 */
public class ShopServlet extends HttpServlet {

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
    int cmptVisite = 18;
    public static int MAXVISITOR = 20;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("request").equals("cancel"))
        {
            if(session.getAttribute("panier.session").equals(true))
            {
                
                Panier p = impln.getOnlyPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
                String tmp = p.getArticles();
                if(!tmp.equals("Visite"))
                {
                    List<Article> articleList = null;
                    articleList = impln.getArticles();
                    int q = 0;
                    StringTokenizer st1 = new StringTokenizer(tmp, "/-"); 
                    while (st1.hasMoreTokens())
                    {
                        int id = Integer.parseInt(st1.nextToken());
                        int qtmp = Integer.parseInt(st1.nextToken());
                        int i = 0;
                        while(i < articleList.size()) 
                        {
                            if(articleList.get(i).getIdArticle() == id)
                            {
                                q = articleList.get(i).getQuantite();
                                break;
                            }
                            i++;
                        }
                        synchronized(this)
                        {
                            impln.updateQuantiteArticle(articleList.get(i).getIdArticle() , q + qtmp);
                        }
                    }
                }
                else
                {
                    synchronized(this)
                    {
                        cmptVisite--;
                    }
                }
                impln.deletePanier(Integer.parseInt(session.getAttribute("idPanier.session").toString()));
            }
            session.invalidate();
            String site = new String(request.getContextPath()+"/index.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
        else if(request.getParameter("request").equals("end"))
        {
            synchronized(this)
            {
                impln.paymentDone(Integer.parseInt(session.getAttribute("idPanier.session").toString()));
            }
            
            session.invalidate();
            String site = new String(request.getContextPath()+"/index.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
        }
        else if(request.getParameter("request").equals("next"))
        {
            session.setAttribute("service.session", request.getParameter("shop"));
            
            if(request.getParameter("shop").equals("visite"))
            {
                if(cmptVisite < 20)
                {
                    synchronized(this)
                    {
                        cmptVisite++;
                    }
                    
                    if(session.getAttribute("panier.session").equals(false))
                    {
                        // Création de panier
                        impln.createPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
                        session.setAttribute("panier.session", true);
                    }

                    Panier p = impln.getOnlyPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
                    session.setAttribute("idPanier.session", p.getIdPanier());
                    String tmpArticle = "Visite";
                    
                    synchronized(this)
                    {
                        impln.addArticleToPanier(p.getIdPanier(), tmpArticle);
                    }
                    
                    String site = new String(request.getContextPath()+"/payment.jsp");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
                else
                {
                    session.setAttribute("error.session", "20");
                    String site = request.getContextPath()+"/shop.jsp";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
            }
            else if(request.getParameter("shop").equals("achats"))
            {
                List<Article> articleList = null;
                articleList = impln.getArticles();
                request.setAttribute("data", articleList);
                RequestDispatcher rd = request.getRequestDispatcher("/catalogue.jsp"); 
                rd.forward(request, response);  
            }
        }
        else
        {     
            session.invalidate();
            String site = new String(request.getContextPath()+"/index.jsp");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);
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
