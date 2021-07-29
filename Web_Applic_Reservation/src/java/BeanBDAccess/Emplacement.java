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
public class Emplacement {
    
    private int idEmplacement;
    private String idContainer;
    private int x;
    private int y;

    public int getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(int idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    } 
    
    public Emplacement()
    {
        
    }
    
    public Emplacement(int tmp1, String tmp2, int tmp3, int tmp4)
    {
        this.idEmplacement = tmp1;
        this.idContainer = tmp2;
        this.x = tmp3;
        this.y = tmp4;
    }
    
    public Emplacement(ResultSet resultSet) throws SQLException
    {
        this.idEmplacement = resultSet.getInt(1);
        this.idContainer = resultSet.getString(2);
        this.x = resultSet.getInt(3);
        this.y = resultSet.getInt(4);
    }
    
    public String display()
    {
        String log = idEmplacement +"-" + idContainer + "-" + x + "-" + y;
        return log;
    }
}
