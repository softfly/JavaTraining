/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * <p>
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/tutorial-examples/LICENSE.txt
 */
package javaeetutorial.cart.ejb;


import java.rmi.RemoteException;
import java.util.List;


public interface Cart {

    void initialize(String person) throws RemoteException;

    void initialize(String person, String id) throws RemoteException;

    void addBook(String title) throws RemoteException;

    void removeBook(String title) throws RemoteException;

    List<String> getContents() throws RemoteException;

    void clear() throws RemoteException;

}
