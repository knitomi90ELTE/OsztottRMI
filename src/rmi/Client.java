package rmi;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.shared.Circle;
import rmi.shared.CircleRemote;
import rmi.shared.Point;
import rmi.shared.ProcessString;

public class Client {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();//host:localhost, port:1099
        Remote stub = reg.lookup("myserver");
        CircleRemote cr = (CircleRemote) stub;
        //ez nem a teljes szerver obj amit bejegyezhetünk, viszont rajta keresztül elérhetjük
        Circle c = new Circle(new Point(1, 2), 3);
        double cir = cr.getC(c);
        System.out.println("A " + c + " kor kerulete: " + cir);
        
        ProcessString ps = (ProcessString) stub;
        String s = "abcdefghijk";
        String rev = ps.process(s);
        System.out.println(s + " -> " + rev);
        
    }
    
}
