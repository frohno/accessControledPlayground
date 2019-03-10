/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package server;

import java.net.Socket;
import com.frohno.pseudossl.PseudoSSLServer;
import java.util.List;
import 

/**
 *
 * @author Pinnacle F
 */
public class ClientHandler extends Thread {

    Socket clientSocket;
    Database db;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.db = new Database("UserDB", "Oliver's personal computer #GDPR-Friendly", "jdbc:postgresql://dumbo.db.elephantsql.com:5432/iquyoclh", "iquyoclh", "0jjwWfpCjVao0Opr2HfQpd058rYqhcvy");
    }

    @Override
    public void run() {
        try {
            System.out.println("Client private key recieved");
            PseudoSSLServer com = new PseudoSSLServer(this.clientSocket);
            String[] command = (String[]) com.recieveObject();
            List<String[]> result = executeCommand(command);
            com.sendObject(result);
            System.out.println("Send");
            System.out.println((String)com.recieveObject());
            com.sendObject("Connetion Terminated from server");
            System.out.println("CL: Terminated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> executeCommand(String[] input) {
        switch (input[0]) {
            case "Login":
                return sendLogin(input[1], input[2]);
            case "UserList":
                return getUserList(input[1], input[2]);
            default:
                throw new AssertionError();
        }
    }

    public List<String[]> sendLogin(String username, String password) {
        return db.sendQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'", "username", "full_name", "institution", "employee_id");
    }
    public List<String[]> getUserList(String username, String password){
        return db.sendQuery("SELECT * FROM users WHERE (SELECT password FROM users WHERE username = '" + username + "' limit 1) = '" + password + "' LIMIT 100", "username", "full_name", "institution", "employee_id");
    }
    

}
