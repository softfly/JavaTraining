/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * <p>
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/tutorial-examples/LICENSE.txt
 */
package javaeetutorial.cart.client;

import javaeetutorial.cart.ejb.Cart;
import javaeetutorial.cart.ejb.CartHome;
import javaeetutorial.cart.util.BookException;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

/**
 * The client class for the CartBean example. Client adds books to the cart,
 * prints the contents of the cart, and then removes a book which hasn't been
 * added yet, causing a BookException.
 *
 * @author ian
 */
public class CartClient {

    private static Cart cart;

    public CartClient(String[] args) {
    }

    /**
     * @param args the command line arguments
     * @throws CreateException
     * @throws RemoteException
     */
    public static void main(String[] args) throws RemoteException, CreateException, NamingException {
        CartClient client = new CartClient(args);
        client.doTest();
    }

    public void doTest() throws CreateException, NamingException, RemoteException {
        try {
            getCart().initialize("Duke d'Url", "123");
            getCart().addBook("Infinite Jest");
            getCart().addBook("Bel Canto");
            getCart().addBook("Kafka on the Shore");

            List<String> bookList = getCart().getContents();

            Iterator<String> iterator = bookList.iterator();

            while (iterator.hasNext()) {
                String title = iterator.next();
                System.out.println("Retrieving book title from cart: " + title);
            }

            System.out.println("Removing \"Gravity's Rainbow\" from cart.");
            getCart().removeBook("Gravity's Rainbow");
            getCart().clear();

            System.exit(0);
        } catch (BookException ex) {
            System.err.println("Caught a BookException: " + ex.getMessage());
            System.exit(0);
        }
    }

    protected Cart getCart() throws NamingException, RemoteException, CreateException {
        if (cart == null) {
            Context context = new InitialContext();
            Object homeObject = context.lookup("javaeetutorial.cart.ejb.CartHome");
            CartHome cartHome = (CartHome) PortableRemoteObject.narrow(homeObject, CartHome.class);
            cart = cartHome.create();
        }
        return cart;
    }

}
