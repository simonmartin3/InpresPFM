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
public class Destination {
    
    private String ville;
    private float distanceBateau;
    private float distanceTrain;
    private float distanceRoute;
    
    public Destination(ResultSet resultSet) throws SQLException
    {
        this.ville = resultSet.getString(1);
        this.distanceBateau = resultSet.getFloat(2);
        this.distanceTrain = resultSet.getFloat(3);
        this.distanceRoute = resultSet.getFloat(4);
    }
    
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getDistanceBateau() {
        return distanceBateau;
    }

    public void setDistanceBateau(float distanceBateau) {
        this.distanceBateau = distanceBateau;
    }

    public float getDistanceTrain() {
        return distanceTrain;
    }

    public void setDistanceTrain(float distanceTrain) {
        this.distanceTrain = distanceTrain;
    }

    public float getDistanceRoute() {
        return distanceRoute;
    }

    public void setDistanceRoute(float distanceRoute) {
        this.distanceRoute = distanceRoute;
    }
    
    public String display()
    {
        String log = ville + "-" + distanceBateau + "-" + distanceRoute + "-" + distanceTrain;
        return log;
    }
}

