/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class BDBeanImpln implements BDBean, Serializable {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException 
    {
        Class leDriver = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_mouvements?serverTimezone=Europe/Brussels", "root","root");
        
        return connection;
    }
    
    public List<Container> getContainers() 
    {
        List<Container> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM containers");
            
            while(resultSet.next()) {
                returnValue.add(new Container(resultSet));
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Societe> getSocietes() 
    {
        List<Societe> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM societes")) {
                    while(resultSet.next()) {
                        returnValue.add(new Societe(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Parc> getParc() 
    {
        List<Parc> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM parc")) {
                    while(resultSet.next()) {
                        returnValue.add(new Parc(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Mouvement> getMouvements() 
    {
        List<Mouvement> returnValue = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
          try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM mouvements")) {
                    while(resultSet.next()) {
                        returnValue.add(new Mouvement(resultSet));
                    }
                }
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Destination> getDestinations() 
    {
        List<Destination> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM destination");
            
            while(resultSet.next()) {
                returnValue.add(new Destination(resultSet));
            } 
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Transporteur> getTransporteurs() 
    {
        List<Transporteur> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transporteurs");
          
            while(resultSet.next()) {
                returnValue.add(new Transporteur(resultSet));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Reservation> getReservations() 
    {
        List<Reservation> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM reservations");
          
            while(resultSet.next()) {
                returnValue.add(new Reservation(resultSet));
            } 
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public boolean addContainer(Container c)
    {
        Container add = new Container();
        add = c;
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO containers VALUES(?,?,?,?,?)");
            pstmt.setString(1, add.getIdContainer());
            pstmt.setString(2, add.getIdSociete());
            pstmt.setString(3, add.getContenu());
            pstmt.setInt(4, add.getCapacite());
            pstmt.setString(5, add.getDangers());
            ret = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ret != 0)
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean addMouvement(Mouvement m)
    {
        Mouvement mouvement = new Mouvement();
        mouvement = m;
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO mouvements VALUES(null,?,?,?,?,?,?,?)");
            pstmt.setString(1, mouvement.getIdContainer());
            pstmt.setString(2, mouvement.getIdTransporteurIn());
            pstmt.setString(3, mouvement.getDateArrivee());
            pstmt.setString(4, mouvement.getIdTransporteurOut());
            pstmt.setInt(5, mouvement.getPoids());
            pstmt.setString(6, mouvement.getDateDepart());
            pstmt.setString(7, mouvement.getDestination());
            ret = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ret != 0)
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean addParc(Parc p)
    {
        Parc parc = new Parc();
        parc = p;
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO parc VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setString(1, parc.getCoordonnees());
            pstmt.setString(2, parc.getIdContainer());
            pstmt.setInt(3, parc.getEtat());
            pstmt.setString(4, parc.getDateReservation());
            pstmt.setString(5, parc.getDateArrivee());
            pstmt.setInt(6, parc.getPoids());
            pstmt.setString(7, parc.getDestination());
            pstmt.setString(8, parc.getTypeRetour());
            ret = pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ret != 0)
        {
            return true;
        }
        else
            return false;
    }
}
