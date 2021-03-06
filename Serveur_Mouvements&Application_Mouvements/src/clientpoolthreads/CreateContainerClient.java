/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpoolthreads;

import ProtocoleSUM.ReponseSUM;
import ProtocoleSUM.RequeteSUM;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class CreateContainerClient extends javax.swing.JDialog {

    /**
     * Creates new form CreateContainerReservationClient
     */
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket cliSocket;
    private Socket tmpSocket;
    private List<String> idSociete;
    
    public CreateContainerClient(java.awt.Frame parent, boolean modal, Socket s, String tmp) {
        super(parent, modal);
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setLocation((width/2), (height-this.getHeight())/2);
        
        tmpSocket = s;
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(tmp, ",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
        
        TextField_IdTransporteur.setEditable(false);
        TextField_IdTransporteur.setText(param.get(0).toString());
        
        TextField_IdContainer.setEditable(false);
        TextField_IdContainer.setText(param.get(1).toString());
        
        Vector societe = new Vector();
        StringTokenizer parser2 = new StringTokenizer(param.get(2).toString(), "/");
        while (parser2.hasMoreTokens())
            societe.add(parser2.nextToken());
        
        Iterator<String> itr = societe.iterator();
        while(itr.hasNext())
            ComboBox_Societe.addItem(itr.next());
        
        TextField_DateReservation.setEditable(false);
        TextField_DateReservation.setText("/");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ComboBox_Societe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TextField_Contenu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Spinner_Capacite = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        TextField_Dangers = new javax.swing.JTextField();
        Button_OK = new javax.swing.JButton();
        Button_Annuler = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TextField_IdContainer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TextField_IdTransporteur = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TextField_DateReservation = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Soci??t?? :");

        jLabel3.setText("Nature du contenu :");

        jLabel4.setText("Capacit?? :");

        jLabel5.setText("Dangers particuliers :");

        Button_OK.setText("Ok");
        Button_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_OKActionPerformed(evt);
            }
        });

        Button_Annuler.setText("Annuler");
        Button_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AnnulerActionPerformed(evt);
            }
        });

        jLabel6.setText("Identifiant container :");

        jLabel7.setText("identifiant transporteur :");

        jLabel8.setText("Date r??servation :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ComboBox_Societe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_Contenu)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Spinner_Capacite)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_Dangers)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_IdContainer)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_IdTransporteur)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_DateReservation)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(Button_Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_IdContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_IdTransporteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_Societe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_Contenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Spinner_Capacite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_Dangers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_DateReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_OK)
                    .addComponent(Button_Annuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_AnnulerActionPerformed

    private void Button_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_OKActionPerformed
        if(TextField_Contenu.getText().equals("") || TextField_Dangers.getText().equals("") || 
        TextField_IdContainer.getText().equals("") || TextField_IdTransporteur.getText().equals("") ||
        Spinner_Capacite.getValue().equals("0") || ComboBox_Societe.getSelectedItem().equals("") ||
        TextField_DateReservation.getText().equals(""))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Entrer les informations n??cessaire pour \n la cr??ation du container.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String chargeUtile = TextField_IdContainer.getText() + "," + 
            ComboBox_Societe.getSelectedItem().toString() + "," +
            TextField_Contenu.getText() + "," + Spinner_Capacite.getValue().toString() + "," +
            TextField_Dangers.getText() + "," + TextField_IdTransporteur.getText() + "," + 
            TextField_DateReservation.getText();
            RequeteSUM req = new RequeteSUM(RequeteSUM.REQUEST_ADD_CONTAINER, chargeUtile);

            // Connexion au serveur
            ois=null; 
            oos=null; 
            cliSocket = null;
            try
            {
                cliSocket = new Socket(tmpSocket.getInetAddress(), tmpSocket.getPort());
            }
            catch (UnknownHostException e)
            { 
                System.err.println("Erreur ! Host non trouv?? [" + e + "]"); 
            }
            catch (IOException e)
            { 
                System.err.println("Erreur ! Pas de connexion ? [" + e + "]"); 
            }

            // Envoie de la requ??te
            try
            {
                oos = new ObjectOutputStream(cliSocket.getOutputStream());
                oos.writeObject(req); 
                oos.flush();
            }
            catch (IOException e)
            { 
                System.err.println("Erreur r??seau ? [" + e.getMessage() + "]"); 
            }

            // Lecture de la r??ponse
            ReponseSUM rep = null;
            try
            {
                ois = new ObjectInputStream(cliSocket.getInputStream());
                rep = (ReponseSUM)ois.readObject();
                System.out.println(" *** Reponse re??ue : " + rep.getChargeUtile() + "," + rep.getCode());
            }
            catch (ClassNotFoundException e)
            { 
                System.out.println("--- erreur sur la classe = " + e.getMessage()); 
            }
            catch (IOException e)
            { 
                System.out.println("--- erreur IO = " + e.getMessage()); 
            }
            
            if(rep.getCode() == ReponseSUM.ADD_CONTAINER_OK)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Le container a bien ??t?? ajout??.", "Message", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Erreur dans la cr??ation du container !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Button_OKActionPerformed

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
            java.util.logging.Logger.getLogger(CreateContainerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateContainerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateContainerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateContainerClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateContainerClient dialog = new CreateContainerClient(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Annuler;
    private javax.swing.JButton Button_OK;
    private javax.swing.JComboBox<String> ComboBox_Societe;
    private javax.swing.JSpinner Spinner_Capacite;
    private javax.swing.JTextField TextField_Contenu;
    private javax.swing.JTextField TextField_Dangers;
    private javax.swing.JTextField TextField_DateReservation;
    private javax.swing.JTextField TextField_IdContainer;
    private javax.swing.JTextField TextField_IdTransporteur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
