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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_shopping?serverTimezone=Europe/Brussels", "root","root");
        
        return connection;
    }
    
    public List<Client> getClients() 
    {
        List<Client> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            
            while(resultSet.next()) {
                returnValue.add(new Client(resultSet));
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Article> getArticles() 
    {
        List<Article> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM articles");
            
            while(resultSet.next()) {
                returnValue.add(new Article(resultSet));
            } 
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public List<Panier> getPanier() 
    {
        List<Panier> returnValue = new ArrayList<>();
        
        try 
        {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM panier");
            
            while(resultSet.next()) {
                returnValue.add(new Panier(resultSet));
            }  
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnValue;
    }
    
    public boolean addClient(Client c)
    {
        Client add = new Client();
        add = c;
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO clients VALUES(null,?,?)");
            pstmt.setString(1, add.getUsername());
            pstmt.setString(2, add.getPassword());
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
    
    public boolean createPanier(int idClient)
    {
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO panier VALUES(null,?,?,?)");
            pstmt.setInt(1, idClient);
            pstmt.setString(2, "");
            pstmt.setBoolean(3, false);
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
    
    public boolean deletePanier(int idPanier)
    {
        int ret = 0;

        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM panier WHERE idPanier = ?");
            pstmt.setInt(1, idPanier);
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
    
    public boolean addArticleToPanier(int idPanier, String a)
    {
        int ret = 0;
        
        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE panier SET articles = ? WHERE idPanier = ?");
            pstmt.setString(1, a);
            pstmt.setInt(2, idPanier);
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
    
    public boolean paymentDone(int idPanier)
    {
        int ret = 0;
        
        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE panier SET done = ? WHERE idPanier = ?");
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, idPanier);
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
    
    public Panier getOnlyPanier(int idClient)
    {
        Panier p = null;
        
        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM panier WHERE idClient = ?");
            pstmt.setInt(1, idClient);
            ResultSet rs = pstmt.executeQuery();
            while ( rs.next() )
            {
              p = new Panier();
              p.setIdPanier(rs.getInt("idPanier"));
              p.setIdClient(rs.getInt("idClient"));
              p.setArticles(rs.getString("articles") );
              p.setDone(rs.getBoolean("done"));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDBeanImpln.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    
    public boolean updateQuantiteArticle(int idArticle, int q)
    {
        int ret = 0;
        
        try 
        {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("UPDATE articles SET quantite = ? WHERE idArticle = ?");
            pstmt.setInt(1, q);
            pstmt.setInt(2, idArticle);
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
