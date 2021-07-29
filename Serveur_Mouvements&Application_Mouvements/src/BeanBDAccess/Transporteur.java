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
public class Transporteur {
    private String idTransporteur;
    private String idSociete;
    private int capacite;
    private String caracteristique;
    
    public Transporteur(ResultSet resultSet) throws SQLException
    {
        this.idTransporteur = resultSet.getString(1);
        this.idSociete = resultSet.getString(2);
        this.capacite = resultSet.getInt(3);
        this.caracteristique = resultSet.getString(4);
    }
    
    public String getIdTransporteur() {
        return idTransporteur;
    }

    public void setIdTransporteur(String idTransporteur) {
        this.idTransporteur = idTransporteur;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }
    
    public String display()
    {
        String log = idTransporteur + "-" + idSociete + "-" + capacite + 
        "-" + caracteristique;
        return log;
    }
}
