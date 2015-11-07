package polling;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class PollClient {
	public static void main(String argv[]) {
		Object vehicle = null;
		PollFactory factory = null;
		IVehicle iv = null;
		boolean loop = true;
		String model = Handy.readString("\nWhich vehicle do you wish to order?\n\t-\tCar\n\t-\tVan\n\n\t\t");
		try  {
			/*get reference to server from
	                  server’s registry*/
			factory = (PollFactory) Naming.lookup("rmi://" + argv[0] + "/PollServer");
			factory.build(model);
		}catch (Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		while(loop) {
			try {
				if (factory.doneYet()) {
					iv = factory.getVehicle();
					loop = false;
//					if ((IVehicle)vehicle != null)
						System.out.printf("\nCompleted production of model: %s\n", iv.getModel());
//					else
//						System.out.println("\nInvalid choice!!\n");
				}
			}
			catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
