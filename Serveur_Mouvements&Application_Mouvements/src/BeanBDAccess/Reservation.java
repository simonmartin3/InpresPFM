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
public class Reservation {
    private String idReservation;
    private String idContainer;
    private String idSociete;
    private String idTransporteur;
    private String dateReservation;
  
    public Reservation(ResultSet resultSet) throws SQLException
    {
        this.idReservation = resultSet.getString(1);
        this.idContainer = resultSet.getString(2);
        this.idSociete = resultSet.getString(3);
        this.idTransporteur = resultSet.getString(4);
        this.dateReservation = resultSet.getString(5);
    }    

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public String getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public String getIdTransporteur() {
        return idTransporteur;
    }

    public void setIdTransporteur(String idTransporteur) {
        this.idTransporteur = idTransporteur;
    }
    
    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
    
}
