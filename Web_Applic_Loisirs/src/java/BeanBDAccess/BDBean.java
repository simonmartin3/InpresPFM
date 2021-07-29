/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.util.List;

/**
 *
 * @author Simon
 */
public interface BDBean {
    public List<Client> getClients();
    public List<Article> getArticles();
    public List<Panier> getPanier();
    
    
    public boolean addClient(Client c);
    public boolean createPanier(int idClient);
    public boolean addArticleToPanier(int idPanier, String a);
    public Panier getOnlyPanier(int idPanier);
    public boolean deletePanier(int idPanier);
    public boolean updateQuantiteArticle(int idArticle, int q);
    public boolean paymentDone(int idPanier);
}
