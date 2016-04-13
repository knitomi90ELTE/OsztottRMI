package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.shared.Circle;
import rmi.shared.CircleRemote;
import rmi.shared.ProcessString;

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

1099-es port: alapértelmezett registry port

*/

public class Server 
        extends UnicastRemoteObject 
        implements CircleRemote, ProcessString {

    public Server() throws RemoteException {
        super();
        System.out.println("Létrejött egy szerver objektum!");
    }

    @Override
    public double getC(Circle c) throws RemoteException {
        return c.getC();
    }
    
    @Override
    public String process(String s) throws RemoteException {
        return new StringBuilder(s).reverse().toString();
    }
    
    public static void main(String[] args) throws RemoteException {
        Server server = new Server();
        //Registry reg = LocateRegistry.createRegistry(1099);
        Registry reg = LocateRegistry.getRegistry();//kivulröl elinditott registry
        //bejegyezzük a szerver objektumot a registrybe
        reg.rebind("myserver", server);
        /*
        bind-> ha már létezik olyan akkor AlreadyBoundEx.-t dob
        rebind-> ez felülirja a létező registryt
        */
        System.out.println("A szerver elindult.");
    }

    
    
    
}
