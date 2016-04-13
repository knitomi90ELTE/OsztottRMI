package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.shared.Circle;
import rmi.shared.CircleRemote;

/*
RMI szerver azonostása:
host, port
-> ezzel csak a registryt érjük el
+ name (String): egyedi azonositó
-> igy már megtalálja

1) Interface a függvényspecifikációknak amiket majd távolról el akarunk érni
(implements Remote)
2) a Szerver ezt az interface-t fogja implementálni

UnicastRemoteObject ->  összefoglal metódust amire amúgyis szükségünk van
                        Nélküle is lehet rmi szervert irni, csak több meló

*/



public class Server 
        extends UnicastRemoteObject 
        implements CircleRemote {

    public Server() throws RemoteException {
        super();
        System.out.println("Létrejött egy szerver objektum!");
    }

    @Override
    public double getC(Circle c) throws RemoteException {
        return c.getC();
    }
    
    
    
}
