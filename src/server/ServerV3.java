/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Pinnacle F
 */
public class ServerV3 {

    public static void main(String[] args) {
        new ServerV3().start();
    }

    private void start() {
        try {
            ServerSocket ss = new ServerSocket(25565);//1028
            while (true) {
                System.out.println("Waiting for connection...");
                Socket socketToClient = ss.accept();
                System.out.println("Socket accepted");
                ClientHandler cl = new ClientHandler(socketToClient);
                cl.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
