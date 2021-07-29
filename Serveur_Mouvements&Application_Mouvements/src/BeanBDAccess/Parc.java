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
public class Parc {
    private String coordonnees;
    private String idContainer;
    private int etat;
    private String dateReservation;
    private String dateArrivee;
    private int poids;
    private String destination;
    private String typeRetour;
    
    public Parc()
    {
        
    }
    
    public Parc(String tmp1, String tmp2, int tmp3, String tmp4, String tmp5, 
    int tmp6, String tmp7, String tmp8)
    {
        
        this.coordonnees = tmp1;
        this.idContainer = tmp2;
        this.etat = tmp3;
        this.dateReservation = tmp4;
        this.dateArrivee = tmp5;
        this.poids = tmp6;
        this.destination = tmp7;
        this.typeRetour = tmp8;
    }
    
    public Parc(ResultSet resultSet) throws SQLException
    {
        this.coordonnees = resultSet.getString(1);
        this.idContainer = resultSet.getString(2);
        this.etat = resultSet.getInt(3);
        this.dateReservation = resultSet.getString(4);
        this.dateArrivee = resultSet.getString(5);
        this.poids = resultSet.getInt(6);
        this.destination = resultSet.getString(7);
        this.typeRetour = resultSet.getString(8);
    }
    
    public String getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(String coordonnees) {
        this.coordonnees = coordonnees;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTypeRetour() {
        return typeRetour;
    }

    public void setTypeRetour(String typeRetour) {
        this.typeRetour = typeRetour;
    }
    
    public String display()
    {
        String log = coordonnees + "-" + idContainer + "-" + etat + 
        "-" + dateReservation + "-" + dateArrivee + poids + "-" + destination + 
        "-" + typeRetour;
        return log;
    }
}
