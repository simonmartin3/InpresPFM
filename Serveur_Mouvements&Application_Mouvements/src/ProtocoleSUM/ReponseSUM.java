/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocoleSUM;

import java.io.*;
import java.util.Vector;
import requetepoolthreads.Reponse;
/**
 *
 * @author Simon
 */
public class ReponseSUM implements Reponse, Serializable {
    
    public static int LOGIN_OK = 101;
    public static int LOGIN_FAIL = 102;
    public static int LOGOUT_OK = 201;
    public static int LOGOUT_FAIL = 202;
    public static int INPUT_LORRY_OK = 301;
    public static int INPUT_LORRY_FAIL = 302;
    public static int INPUT_LORRY_WITHOUT_RESERVATION_OK = 401;
    public static int INPUT_LORRY_WITHOUT_RESERVATION_FAIL = 402;
    public static int LIST_OPERATIONS_OK = 501;
    public static int LIST_OPERATIONS_FAIL = 502;
    public static int ADD_CONTAINER_OK = 601;
    public static int ADD_CONTAINER_FAIL = 602;
    
    private int codeRetour;
    private String chargeUtile;
    private Vector mouvements;
    
    public ReponseSUM(int c, String chu)
    {
        codeRetour = c; setChargeUtile(chu);
    }
    
    public ReponseSUM(int c, Vector m)
    {
        codeRetour = c; setListMouvement(m);
    }
    
    public int getCode() { return codeRetour; }
    
    public String getChargeUtile() { return chargeUtile; }
    
    public void setChargeUtile(String chargeUtile) { this.chargeUtile = chargeUtile; }
    
    public void setListMouvement(Vector m){this.mouvements = m;}
    
    public Vector getListMouvement(){return mouvements;}
}
