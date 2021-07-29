/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.sql.*;

/**
 *
 * @author Simon
 */
public class Panier {
    
    private int idPanier;
    private int idClient;
    private String articles;
    private boolean done;
    
    public Panier()
    {
        
    }
    
    public Panier(int tmp1)
    {
        this.idClient = tmp1;
    }
    
    public Panier(ResultSet resultSet) throws SQLException
    {
        this.idPanier = resultSet.getInt(1);
        this.idClient = resultSet.getInt(2);
        this.articles = resultSet.getString(3);
        this.done = resultSet.getBoolean(4);
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
