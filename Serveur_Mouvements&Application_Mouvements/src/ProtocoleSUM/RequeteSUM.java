/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocoleSUM;

import BeanBDAccess.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import serveurpoolthreads.*;
import requetepoolthreads.Requete;
/**
 *
 * @author Simon
 */
public class RequeteSUM implements Requete, Serializable{
    
    public static int REQUEST_LOGIN = 1;
    public static int REQUEST_LOGOUT = 2;
    public static int REQUEST_INPUT_LORRY = 3;
    public static int REQUEST_INPUT_LORRY_WITHOUT_RESERVATION = 4;
    public static int REQUEST_LIST_OPERATIONS = 5;
    public static int REQUEST_ADD_CONTAINER = 6;
    
    private int type;
    private String chargeUtile;
    private Socket socketClient;
    private String[][] parc = new String[10][10];
    
    BDBeanImpln impln = new BDBeanImpln();
    
    public RequeteSUM(int t, String chu)
    {
        type = t; setChargeUtile(chu);
    }
    
    public RequeteSUM(int t, String chu, Socket s)
    {
        type = t; setChargeUtile(chu); socketClient = s;
    }
    
    public Runnable createRunnable (final Socket s, final ConsoleServeur cs)
    {
        if (type==REQUEST_LOGIN)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteLogin(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_LOGOUT)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteLogout(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_INPUT_LORRY)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteInputLorry(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_INPUT_LORRY_WITHOUT_RESERVATION)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteInputLorryWithoutReservation(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_LIST_OPERATIONS)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteListOperations(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    } catch (ParseException e) {
                        System.err.println("Erreur lors de la comparaison de date ? [" + e.getMessage() + "]");
                    }
                }
            };
        else if(type==REQUEST_ADD_CONTAINER)
            return new Runnable()
            {
                public void run()
                {
                    try {
                        traiteRequeteAddContainer(s, cs);
                    } catch (FileNotFoundException e) {
                        System.err.println("Erreur le fichier login n'existe pas ? [" + e.getMessage() + "]");
                        System.exit(1);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'ouverture du fichier ? [" + e.getMessage() + "]");
                    }
                }
            };
        else return null;
    }
    
    private void traiteRequeteLogin(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#Login#"+Thread.currentThread().getName());
        
        FileInputStream in = new FileInputStream("serveur.properties");
        Properties p = new Properties();
        p.load(in);
        
        String csvFile = p.getProperty("PATH_LOGIN");
        String line = "";
        String cvsSplitBy = p.getProperty("SEP_CSV");
        String[] recvLogin = getChargeUtile().split(cvsSplitBy);
        ReponseSUM rep = null;
        boolean find = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] login = line.split(cvsSplitBy);
                if(login[0].equals(recvLogin[0]) && login[1].equals(recvLogin[1]))
                {
                    find = true;
                    break;
                }
                else
                    find = false;
                
                System.out.println("Login [user=" + login[0] + " , pass=" + login[1] + "]");
            }

        } catch (IOException e) {
            System.err.println("Erreur ouverture fichier login ? [" + e.getMessage() + "]");
        }
        
        if(find)
        {
            rep = new ReponseSUM(ReponseSUM.LOGIN_OK, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Login OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.LOGIN_FAIL, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Login FAIL#"+Thread.currentThread().getName());
        }
        
        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteLogout(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#Logout#"+Thread.currentThread().getName());
        
        FileInputStream in = new FileInputStream("serveur.properties");
        Properties p = new Properties();
        p.load(in);
        
        String csvFile = p.getProperty("PATH_LOGIN");
        String line = "";
        String cvsSplitBy = p.getProperty("SEP_CSV");
        String[] recvLogin = getChargeUtile().split(cvsSplitBy);
        ReponseSUM rep = null;
        boolean find = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] login = line.split(cvsSplitBy);
                if(login[0].equals(recvLogin[0]) && login[1].equals(recvLogin[1]))
                {
                    find = true;
                    break;
                }
                else
                    find = false;
                
                System.out.println("Login [user=" + login[0] + " , pass=" + login[1] + "]");
            }

        } catch (IOException e) {
            System.err.println("Erreur ouverture fichier login ? [" + e.getMessage() + "]");
        }
        
        if(find)
        {
            rep = new ReponseSUM(ReponseSUM.LOGOUT_OK, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Logout OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.LOGOUT_FAIL, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#Logout FAIL#"+Thread.currentThread().getName());
        }
        
        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteInputLorry(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#INPUT_LORRY#"+Thread.currentThread().getName());
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(getChargeUtile(),",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
        
        
        System.out.println("Essai de connexion JDBC");
        List<Reservation> reservationList = null;
        List<Societe> societeList = null;
        
        reservationList= impln.getReservations();
        societeList = impln.getSocietes();
        
        ReponseSUM rep = null;
        int i = 0;
        boolean find = false;
        
        if(!reservationList.isEmpty())
        {
            while(i < reservationList.size()) 
            {
                if(reservationList.get(i).getIdReservation().equals(param.get(0)) && reservationList.get(i).getIdContainer().equals(param.get(1)))
                {
                    find = true;
                    break;
                }
                i++;
            }
            
            if(find)
            {
                String msg = getChargeUtile() + "," + reservationList.get(i).getIdTransporteur()+
                "," + reservationList.get(i).getIdSociete() +","+reservationList.get(i).getDateReservation();
                rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_OK, msg);
                cs.TraceEvenements(adresseDistante+"#INPUT_LORRY OK#"+Thread.currentThread().getName());
            }
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_FAIL, "fail");
            cs.TraceEvenements(adresseDistante+"#INPUT_LORRY FAIL#"+Thread.currentThread().getName());
        }
        

        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }
    
    private void traiteRequeteInputLorryWithoutReservation(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#INPUT_LORRY_WITHOUT_RESERVATION#"+Thread.currentThread().getName());
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(getChargeUtile(),",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
        
        
        System.out.println("Essai de connexion JDBC");
        List<Societe> societeList = null;
        
        societeList = impln.getSocietes();
        
        ReponseSUM rep = null;
        boolean find = false;

        if(!societeList.isEmpty())
        {
            String msg = getChargeUtile();
            msg = msg + "," + societeList.get(0).getIdSociete();
            for(int i = 1; i < societeList.size(); i++)
            {
                msg = msg + "/" + societeList.get(i).getIdSociete();
            }
            rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_WITHOUT_RESERVATION_OK, msg);
            cs.TraceEvenements(adresseDistante+"#INPUT_LORRY_WITHOUT_RESERVATION OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.INPUT_LORRY_WITHOUT_RESERVATION_FAIL, "fail");
            cs.TraceEvenements(adresseDistante+"#INPUT_LORRY_WITHOUT_RESERVATION FAIL#"+Thread.currentThread().getName()); 
        }  

        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }  
    }
    
    private void traiteRequeteListOperations(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException, ParseException
    {
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#LIST_MOUVEMENT#"+Thread.currentThread().getName());
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(getChargeUtile(),",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
                
        System.out.println("Essai de connexion JDBC");
        
        List<Mouvement> mouvementList = null; 
        mouvementList = impln.getMouvements();
        
        List<Transporteur> transporteurList = null; 
        transporteurList = impln.getTransporteurs();
               
        ReponseSUM rep = null;

        if(!mouvementList.isEmpty())
        {
            Vector mouvements = new Vector();
            
            if(param.get(2).equals("Destination"))
            {
                for(int i = 0; i < mouvementList.size(); i++)
                {
                    if(mouvementList.get(i).getDestination().equals(param.get(3)))
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                        Date firstDate = sdf.parse(param.get(0).toString());
                        Date secondDate = sdf.parse(param.get(1).toString());
                        Date thirdDate = sdf.parse(mouvementList.get(i).getDateArrivee());
                        if(thirdDate.after(firstDate) && thirdDate.before(secondDate))
                            mouvements.add(mouvementList.get(i));
                    }
                }
            }
            
            if(param.get(2).equals("Société"))
            {
                for(int i = 0; i < mouvementList.size(); i++)
                {
                    for(int j = 0; j < transporteurList.size(); j++)
                    {
                        if(transporteurList.get(j).getIdSociete().equals(param.get(3)))
                        {
                            if(mouvementList.get(i).getIdTransporteurIn().equals(transporteurList.get(j).getIdTransporteur()))
                            {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                                Date firstDate = sdf.parse(param.get(0).toString());
                                Date secondDate = sdf.parse(param.get(1).toString());
                                Date thirdDate = sdf.parse(mouvementList.get(i).getDateArrivee());
                                if(thirdDate.after(firstDate) && thirdDate.before(secondDate))
                                    mouvements.add(mouvementList.get(i));
                            }
                        }
                    }
                }
            }
            rep = new ReponseSUM(ReponseSUM.LIST_OPERATIONS_OK, mouvements);
            cs.TraceEvenements(adresseDistante+"#LIST_MOUVEMENT OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.LIST_OPERATIONS_FAIL, "fail");
            cs.TraceEvenements(adresseDistante+"#LIST_MOUVEMENT FAIL#"+Thread.currentThread().getName()); 
        }  

        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }  
    }  
    
    private void traiteRequeteAddContainer(Socket sock, ConsoleServeur cs) throws FileNotFoundException, IOException
    {
        boolean ret = false, ret1 = false, ret2 = false;
        ReponseSUM rep = null;
        Date date = new Date();
        Random rand = new Random();
        List<Parc> parcList = null; 
        parcList = impln.getParc();
        List<Destination> destinationList = null; 
        destinationList = impln.getDestinations();
        
        String adresseDistante = sock.getRemoteSocketAddress().toString();
        cs.TraceEvenements(adresseDistante+"#ADD_CONTAINER#"+Thread.currentThread().getName());
        
        Vector param = new Vector();
        StringTokenizer parser = new StringTokenizer(getChargeUtile(),",");
        while (parser.hasMoreTokens())
            param.add(parser.nextToken());
        
        int poids = rand.nextInt(100)+50;
        
        // add container
        Container newContainer = new Container(param.get(0).toString(), 
        param.get(1).toString(), param.get(2).toString(), Integer.parseInt(param.get(3).toString()), 
        param.get(4).toString());
        ret = impln.addContainer(newContainer);
        
        // add parc
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String x = Integer.toString(rand.nextInt(10));
        String y = Integer.toString(rand.nextInt(10));
        
        Vector coordParc;
        StringTokenizer parserCoordParc;
        if(!parcList.isEmpty())
        {
            for(int i = 0; i < parcList.size(); i++)
            {
                coordParc = new Vector();
                parserCoordParc = new StringTokenizer(parcList.get(i).getCoordonnees(),",");

                while (parserCoordParc.hasMoreTokens())
                    coordParc.add(parserCoordParc.nextToken());
                
                if(x.equals(coordParc.get(0)) && y.equals(coordParc.get(1)))
                {
                    x = Integer.toString(rand.nextInt(10));
                    y = Integer.toString(rand.nextInt(10));
                    i = 0;
                }
            }
        }
        
        String coordonnees = x + "," + y;
        Vector destination = new Vector();
        
        for(int i = 0; i < destinationList.size(); i++)
        {
            destination.add(destinationList.get(i).getVille());
        }
        
        int randomNum = rand.nextInt(destinationList.size());
        
        String typeRetour = null;

        if(rand.nextInt(100)%2 == 0)
            typeRetour = "Bateau";
        else
            typeRetour = "Train";
        
        Parc addParc = new Parc(coordonnees,param.get(0).toString(),2,param.get(6).toString(),formatter.format(date),
        poids,destination.get(randomNum).toString(), typeRetour);
        ret1 = impln.addParc(addParc);
        
        // add mouvement
        Mouvement newMouvement = new Mouvement(0,param.get(0).toString(), param.get(5).toString(),
        formatter.format(date), null, poids, null, destination.get(randomNum).toString());
        ret2 = impln.addMouvement(newMouvement);
        
        // delete reservation ---------------------
        
        if(ret && ret1 && ret2)
        {
            rep = new ReponseSUM(ReponseSUM.ADD_CONTAINER_OK, getChargeUtile());
            cs.TraceEvenements(adresseDistante+"#ADD_CONTAINER OK#"+Thread.currentThread().getName());
        }
        else
        {
            rep = new ReponseSUM(ReponseSUM.ADD_CONTAINER_FAIL, "FAIL");
            cs.TraceEvenements(adresseDistante+"#ADD_CONTAINER FAIL#"+Thread.currentThread().getName());
        }
        // Construction d'une réponse
        ObjectOutputStream oos;
        try
        {
            oos = new ObjectOutputStream(sock.getOutputStream());
            oos.writeObject(rep); oos.flush();
            oos.close();
        }
        catch (IOException e)
        {
            System.err.println("Erreur réseau ? [" + e.getMessage() + "]");
        }
    }

    public String getChargeUtile() { return chargeUtile; }
    
    public void setChargeUtile(String chargeUtile)
    {
        this.chargeUtile = chargeUtile;
    }
    
    private String [][] createTabParc()
    {
        String[][] tmp = new String[10][10];
        
        List<Container> containerList = null;
        containerList = impln.getContainers();
        
        if(!containerList.isEmpty())
        {
            for (int i = 0; i < tmp.length; i++) {
                System.out.println(i);
            }
        }
        
        return tmp;
    }
    
}
