package rmi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CircleRemote extends Remote {
    
    public double getC(Circle c) throws RemoteException;
    
}
