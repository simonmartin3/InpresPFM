/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clientpoolthreads.*;
import java.io.*;
import java.util.Properties;
import serveurpoolthreads.FenAppServeur;

/**
 *
 * @author Simon
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String configServeur = "serveur.properties";
        String configClient = "client.properties";
        
        Properties pServeur = new Properties();
        Properties pClient = new Properties();
        
        File configS = new File(configServeur);
        if(configS.createNewFile())
        {
            System.out.println("File config server create.");
            pServeur.put("PORT_IN", "50000");
            pServeur.put("PORT_EMP", "50001");
            pServeur.put("PATH_LOGIN", "login.csv");
            pServeur.put("SEP_CSV", ",");
            FileOutputStream outS = new FileOutputStream(configServeur);
            pServeur.store(outS, null);
        }
        
        File configC = new File(configClient);
        if(configC.createNewFile())
        {
            System.out.println("File config client create.");
            pClient.put("PORT_SERVER", "50000");
            pClient.put("ADRESSE_SERVER", "0.0.0.0");
            FileOutputStream outC = new FileOutputStream(configClient);
            pClient.store(outC, null);
        }
        
        FileInputStream inC = new FileInputStream(configClient);
        FileInputStream inS = new FileInputStream(configServeur);
        
        pClient.load(inC);
        pServeur.load(inS);
        
        LoginClient lc = new LoginClient(pClient);
        lc.setVisible(true);
       
        FenAppServeur fas = new FenAppServeur(pServeur);
        fas.setVisible(true);
    }
    
}
