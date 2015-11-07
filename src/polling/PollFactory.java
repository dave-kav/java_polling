package polling;
import java.rmi.RemoteException;

public interface PollFactory extends java.rmi.Remote {
	public void build(String model) throws RemoteException;
	
	public boolean doneYet() throws RemoteException;
	
	public IVehicle getVehicle() throws RemoteException;
}
