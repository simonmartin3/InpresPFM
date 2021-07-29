/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.sql.*;

/**
 *
 * @author Simon
 */
public class Client {
    
    private int idClient;
    private String username;
    private String password;
    
    public Client()
    {
        
    }
    
    public Client(String tmp1, String tmp2)
    {
        this.username = tmp1;
        this.password = tmp2;
    }
    
    public Client(int tmp1, String tmp2, String tmp3)
    {
        this.idClient = tmp1;
        this.username = tmp2;
        this.password = tmp3;
    }
    
    public Client(ResultSet resultSet) throws SQLException
    {
        this.idClient = resultSet.getInt(1);
        this.username = resultSet.getString(2);
        this.password = resultSet.getString(3);
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String display()
    {
        String log = idClient + "-" + username + "-" + password;
        return log;
    }
}
