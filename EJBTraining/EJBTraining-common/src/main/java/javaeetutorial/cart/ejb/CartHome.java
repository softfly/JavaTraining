package javaeetutorial.cart.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

public interface CartHome extends EJBHome {

    CartObject create() throws CreateException, RemoteException;

}
