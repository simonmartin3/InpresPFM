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
public class Container {
    
    private String idContainer;
    private String idSociete;
    private String contenu;
    private int capacite;
    private String dangers;
    
    public Container()
    {
        
    }
    
    public Container(String tmp1, String tmp2, String tmp3, int tmp4, String tmp5)
    {
        this.idContainer = tmp1;
        this.idSociete = tmp2;
        this.contenu = tmp3;
        this.capacite = tmp4;
        this.dangers = tmp5;
    }
    
    public Container(ResultSet resultSet) throws SQLException
    {
        this.idContainer = resultSet.getString(1);
        this.idSociete = resultSet.getString(2);
        this.contenu = resultSet.getString(3);
        this.capacite = resultSet.getInt(4);
        this.dangers = resultSet.getString(5);
    }
    
    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDangers(String dangers) {
        this.dangers = dangers;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public String getContenu() {
        return contenu;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getDangers() {
        return dangers;
    }
    
    public String display()
    {
        String log = idContainer + "-" + idSociete + "-" + contenu + "-" + 
        capacite + "-" + dangers;
        return log;
    }
}
