package polling;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

@SuppressWarnings("serial")
public class PollFactoryImpl extends UnicastRemoteObject implements PollFactory {
	private String name;
	private int v = 0;
	private boolean done = false;
	private boolean temp;
	private IVehicle myVehicle;
	private Random random = new Random();
	
	protected PollFactoryImpl(String name) throws RemoteException {
		this.name = name;
	}
	
	@Override
	public void build(String model) throws RemoteException {
		if (model.equalsIgnoreCase("car")) {
			System.out.printf("\n\nProduction under way, please stand by...\n\n");
			try {
				Thread.sleep(random.nextInt(1000) + 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myVehicle = new Car();
			if (myVehicle != null) {
				v++;
				System.out.printf("Prodcution Completed!!\n----------------------------\nModel:\t\t" + myVehicle.getModel()  
				+ "\nRegistration:\t152 - C - %d\n----------------------------\n", v);
				done = true;
			}
		}
		else if (model.equalsIgnoreCase("van")) {
			System.out.printf("\n\nProduction under way, please stand by...\n\n");
			try {
				Thread.sleep(random.nextInt(10000) + 1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myVehicle = new Van();
			if (myVehicle != null) {
				v++;
				System.out.printf("Prodcution Completed!!\n----------------------------\nModel:\t\t" + myVehicle.getModel()  
				+ "\nRegistration:\t152 - C - %d\n----------------------------\n", v);
				done = true;
			}
		}
		else {
			System.out.printf("Invalid option.");
			done = true;
		}
	}
	@Override
	public boolean doneYet() throws RemoteException {
		temp = done;
		done = false;
		return temp == true;
	}
	@Override
	public IVehicle getVehicle() throws RemoteException {
		return myVehicle;
	}
}
