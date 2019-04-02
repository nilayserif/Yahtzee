/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.sun.corba.se.impl.io.OutputStreamHook;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Asus
 */
public class Client {

    public static Socket Socket;
    public static ObjectOutputStream Out;
    public static ObjectInputStream In;
    public static String Name;
    //public static Listen listen;
    public static void Start(String ip, int port) throws IOException {
        Client.Socket = new Socket(ip, port);
        Client.Out = new ObjectOutputStream(Client.Socket.getOutputStream());
        Client.In = new ObjectInputStream(Client.Socket.getInputStream());
    }

    public static void Stop() throws IOException {
        if (Client.Socket != null) {
            //Client.listen.stop();
            Client.Socket.close();
            Client.Out.flush();
            Client.In.close();

        }
    }
    public static void Send(Object msg) throws IOException{
        Client.Out.writeObject(msg);
    }
}
