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
public class Societe {

    private String idSociete;
    private String nomContact;
    private String emailContact;
    private String telContact;
    private String adresse;
    
    public Societe(ResultSet resultSet) throws SQLException
    {
        this.idSociete = resultSet.getString(1);
        this.nomContact = resultSet.getString(2);
        this.emailContact = resultSet.getString(3);
        this.telContact = resultSet.getString(4);
        this.adresse = resultSet.getString(5);
    }
    
    public String getIdSociete() {
        return idSociete;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public String getTelContact() {
        return telContact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setIdSociete(String idSociete) {
        this.idSociete = idSociete;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String display()
    {
        String log = idSociete + "-" + nomContact + "-" + emailContact + "-" + 
        telContact + "-" + adresse;
        return log;
    }
}
