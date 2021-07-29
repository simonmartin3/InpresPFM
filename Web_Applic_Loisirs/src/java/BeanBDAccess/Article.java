/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Simon
 */
public class Article {
    
    private int idArticle;
    private String nom;
    private int quantite;
    private float prix;
    
    public Article()
    {
        
    }
    
    public Article(ResultSet resultSet) throws SQLException
    {
        this.idArticle = resultSet.getInt(1);
        this.nom = resultSet.getString(2);
        this.quantite = resultSet.getInt(3);
        this.prix = resultSet.getFloat(4);
    }
    
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    public String display()
    {
        String log = idArticle + "-" + nom + "-" + quantite;
        return log;
    }
}

