/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpoolthreads;

import ProtocoleSUM.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class LoginClient extends javax.swing.JFrame {

    /**
     * Creates new form LoginClient
     */
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket cliSocket;
    private String adresse;
    private int port;
    private Properties config;
    
    public LoginClient(Properties tmp) {
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setLocation((width/2), (height-this.getHeight())/2);
        this.setResizable(false);
        
        config = tmp;
        adresse = config.getProperty("ADRESSE_SERVEUR");
        port = Integer.parseInt(config.getProperty("PORT_SERVEUR"));
        System.err.println(adresse + ":" + port);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextField_User = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextField_Pass = new javax.swing.JPasswordField();
        Button_Connexion = new javax.swing.JButton();
        Button_Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Username :");

        jLabel3.setText("Password :");

        Button_Connexion.setText("Connexion");
        Button_Connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ConnexionActionPerformed(evt);
            }
        });

        Button_Annuler.setText("Annuler");
        Button_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_Pass))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextField_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextField_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Connexion)
                    .addComponent(Button_Annuler))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_ConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ConnexionActionPerformed
        if(TextField_User.getText().equals("") || TextField_Pass.getPassword().equals(""))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Entrer un user et/ou un password", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String chargeUtile = TextField_User.getText() + "," + String.valueOf(TextField_Pass.getPassword());
            RequeteSUM req = new RequeteSUM(RequeteSUM.REQUEST_LOGIN, chargeUtile);

            // Connexion au serveur
            ois=null; 
            oos=null; 
            cliSocket = null;
            try
            {
                cliSocket = new Socket(adresse, port);
                System.out.println(cliSocket.getInetAddress().toString());
            }
            catch (UnknownHostException e)
            { 
                System.err.println("Erreur ! Host non trouvé [" + e + "]"); 
            }
            catch (IOException e)
            { 
                System.err.println("Erreur ! Pas de connexion ? [" + e + "]"); 
            }

            // Envoie de la requête
            try
            {
                oos = new ObjectOutputStream(cliSocket.getOutputStream());
                oos.writeObject(req); 
                oos.flush();
            }
            catch (IOException e)
            { 
                System.err.println("Erreur réseau ? [" + e.getMessage() + "]"); 
            }

            // Lecture de la réponse
            ReponseSUM rep = null;
            try
            {
                ois = new ObjectInputStream(cliSocket.getInputStream());
                rep = (ReponseSUM)ois.readObject();
                System.out.println(" *** Reponse reçue : " + rep.getChargeUtile() + "-" + rep.getCode());
            }
            catch (ClassNotFoundException e)
            { 
                System.out.println("--- erreur sur la classe = " + e.getMessage()); 
            }
            catch (IOException e)
            { 
                System.out.println("--- erreur IO = " + e.getMessage()); 
            }
            
            if(rep.getCode() == ReponseSUM.LOGIN_OK)
            {
                FenAppClient fac = new FenAppClient(cliSocket);
                fac.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Erreur dans la connexion réessayer !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Button_ConnexionActionPerformed

    private void Button_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_AnnulerActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        TextField_User.setText("root");
        TextField_Pass.setText("root");
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginClient(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Annuler;
    private javax.swing.JButton Button_Connexion;
    private javax.swing.JPasswordField TextField_Pass;
    private javax.swing.JTextField TextField_User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
