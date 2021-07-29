/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanBDAccess;

import java.util.List;

/**
 *
 * @author Simon
 */
public interface BDBean {
    public List<Container> getContainers();
    public List<Societe> getSocietes();
    public List<Parc> getParc();
    public List<Mouvement> getMouvements();
    public List<Destination> getDestinations();
    public List<Transporteur> getTransporteurs();
    public List<Reservation> getReservations();
    
    public boolean addContainer(Container c);
    public boolean addMouvement(Mouvement m);
}
