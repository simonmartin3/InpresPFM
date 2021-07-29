/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletsUtiles;

import BeanBDAccess.Article;
import BeanBDAccess.BDBeanImpln;
import BeanBDAccess.Panier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class CaddieServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        boolean ret = false;
        Panier p = null;
        
        if(request.getParameterMap().containsKey("request"))
        {
            if(request.getParameter("request").equals("cancel"))
            {
                if(session.getAttribute("panier.session").equals(true))
                {
                    List<Article> articleList = null;
                    articleList = impln.getArticles();
                    int q = 0;
                    p = impln.getOnlyPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
                    String tmp = p.getArticles();
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
                    
                    impln.deletePanier(Integer.parseInt(session.getAttribute("idPanier.session").toString()));
                }
                session.setAttribute("panier.session", false);
                String site = new String(request.getContextPath()+"/shop.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            }
            else
            {
                String site = new String(request.getContextPath()+"/payment.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            }
        }
        else if(request.getParameterMap().containsKey("add"))
        {
            if(session.getAttribute("panier.session").equals(false))
            {
                // Création de panier
                ret = impln.createPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
                session.setAttribute("panier.session", true);
            }
           
            p = impln.getOnlyPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
            session.setAttribute("idPanier.session", p.getIdPanier());
            String tmpArticle = p.getArticles();
            tmpArticle = tmpArticle + "/" + request.getParameter("add") + "-" + 
            request.getParameter(request.getParameter("add"));
            
            List<Article> articleList = null;
            articleList = impln.getArticles();
            int q = 0;
            for(int i = 0; i < articleList.size(); i++) 
            {
                if(articleList.get(i).getIdArticle()== Integer.parseInt(request.getParameter("add")))
                {
                    q = articleList.get(i).getQuantite();
                    break;
                }
            }
            
            synchronized(this)
            {
                impln.updateQuantiteArticle(Integer.parseInt(request.getParameter("add")), 
                q - Integer.parseInt(request.getParameter(request.getParameter("add"))));
                impln.addArticleToPanier(p.getIdPanier(), tmpArticle);
            }
            
            List<Article> panier = new ArrayList();
            p = impln.getOnlyPanier(Integer.parseInt(session.getAttribute("idClient.session").toString()));
            String tmp = p.getArticles();
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
                        Article tmpA = new Article();
                        tmpA.setIdArticle(articleList.get(i).getIdArticle());
                        tmpA.setNom(articleList.get(i).getNom());
                        tmpA.setPrix(articleList.get(i).getPrix());
                        tmpA.setQuantite(qtmp);
                        panier.add(tmpA);
                        break;
                    }
                    i++;
                }
            }
            
            
            articleList = impln.getArticles();
            request.setAttribute("data", articleList);
            request.setAttribute("panier", panier);
            RequestDispatcher rd = request.getRequestDispatcher("/catalogue.jsp"); 
            rd.forward(request, response);
            
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
