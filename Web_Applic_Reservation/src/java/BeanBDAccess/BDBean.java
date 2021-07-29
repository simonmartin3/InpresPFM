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
    public List<Client> getClients();
    public List<Emplacement> getEmplacements();
    
    public boolean addContainer(Container c);
    public boolean addMouvement(Mouvement m);
    public boolean addReservation(Reservation r);
    public boolean addEmplacement(int idEmplacement, String idContainer);
    public boolean addClient(String user, String pass);
}
