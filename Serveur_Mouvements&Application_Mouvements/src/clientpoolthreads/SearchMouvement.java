/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientpoolthreads;

import BeanBDAccess.Mouvement;
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
import java.util.Properties;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Simon
 */
public class SearchMouvement extends javax.swing.JDialog {

    /**
     * Creates new form InputReservationClient
     */
    
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket cliSocket;
    private Socket tmpSocket;
    ButtonGroup G = new ButtonGroup();
    
    public SearchMouvement(java.awt.Frame parent, boolean modal, Socket s) {
        super(parent, modal);
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setLocation((width/2), (height-this.getHeight())/2);
        tmpSocket = s;
        
        
        G.add(RadioButton_Destination);
        G.add(RadioButton_Societe);
        RadioButton_Societe.setSelected(true);
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
        jLabel3 = new javax.swing.JLabel();
        TextField_DateDebut = new javax.swing.JTextField();
        TextField_DateFin = new javax.swing.JTextField();
        Button_Ok = new javax.swing.JButton();
        Button_Annuler = new javax.swing.JButton();
        RadioButton_Societe = new javax.swing.JRadioButton();
        RadioButton_Destination = new javax.swing.JRadioButton();
        TextField_Search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Liste des mouvements");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setText("Date d??but (dd/mm/yyyy) :");

        jLabel3.setText("Date fin (dd/mm/yyyy) : ");

        Button_Ok.setText("OK");
        Button_Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_OkActionPerformed(evt);
            }
        });

        Button_Annuler.setText("Annuler");
        Button_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AnnulerActionPerformed(evt);
            }
        });

        RadioButton_Societe.setText("Soci??t??");

        RadioButton_Destination.setText("Destination");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextField_Search)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TextField_DateDebut)
                    .addComponent(TextField_DateFin)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(RadioButton_Societe, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(RadioButton_Destination, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_DateDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_DateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioButton_Societe)
                    .addComponent(RadioButton_Destination))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Ok)
                    .addComponent(Button_Annuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_AnnulerActionPerformed

    private void Button_OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_OkActionPerformed
        if(TextField_DateDebut.getText().equals("") || TextField_DateFin.getText().equals(""))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Entrer des dates et/ou le nom de la soci??t?? \n ou la destiantion.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String radioButtonSelected = null;
            if(RadioButton_Destination.isSelected())
                radioButtonSelected = RadioButton_Destination.getText();
            
            if(RadioButton_Societe.isSelected())
                radioButtonSelected = RadioButton_Societe.getText();
            
            String chargeUtile = TextField_DateDebut.getText() + "," + TextField_DateFin.getText() +
            "," + radioButtonSelected + "," + TextField_Search.getText();
            System.out.println(chargeUtile);
            
            RequeteSUM req = new RequeteSUM(RequeteSUM.REQUEST_LIST_OPERATIONS, chargeUtile);

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
            Vector m = new Vector();
            try
            {
                ois = new ObjectInputStream(cliSocket.getInputStream());
                rep = (ReponseSUM)ois.readObject();
                System.out.println(" *** Code re??ue :" + rep.getCode());
                    
            }
            catch (ClassNotFoundException e)
            { 
                System.out.println("--- erreur sur la classe = " + e.getMessage()); 
            }
            catch (IOException e)
            { 
                System.out.println("--- erreur IO = " + e.getMessage()); 
            }
            
            if(rep.getCode() == ReponseSUM.LIST_OPERATIONS_OK)
            {
                if(!rep.getListMouvement().isEmpty())
                {
                    ListMouvement lm = new ListMouvement((Frame) super.getParent(), false, rep.getListMouvement());
                    lm.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(new JFrame(), "Aucune valeur trouv??.", "Erreur", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(new JFrame(), "Erreur dans l'envoie des informations !", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Button_OkActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        TextField_DateDebut.setText("01/10/2020");
        TextField_DateFin.setText("30/10/2020");
        TextField_Search.setText("Namur");
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
            java.util.logging.Logger.getLogger(SearchMouvement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchMouvement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchMouvement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchMouvement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SearchMouvement dialog = new SearchMouvement(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton Button_Ok;
    private javax.swing.JRadioButton RadioButton_Destination;
    private javax.swing.JRadioButton RadioButton_Societe;
    private javax.swing.JTextField TextField_DateDebut;
    private javax.swing.JTextField TextField_DateFin;
    private javax.swing.JTextField TextField_Search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
