package polling;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class PollServer {
	public static void main( String argv[]) {

	      System.out.println("Application Started");      
	      System.setSecurityManager(new RMISecurityManager());
	      
	      try {
	         PollFactoryImpl obj = new PollFactoryImpl("Vehicle Server");
	         Naming.rebind("rmi://" +argv[0] + "/PollServer",obj);
	         System.out.println("Server in Registry");
	         }catch (Exception e)  {
	             System.out.println ("Vehicle Server error: " +
	                    e.getMessage());
	         }
	   }
}
