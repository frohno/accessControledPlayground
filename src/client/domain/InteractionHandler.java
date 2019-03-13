
/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.domain;

import com.google.common.hash.Hashing;
import client.data.DataInterface;
import client.data.Database;
import com.frohno.pseudossl.PseudoSSLClient;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Pinnacle F
 */
public class InteractionHandler implements InteractionInterface
{

    String ip = "192.168.43.119"; //"80.161.136.78"
    int port = 25565;

    private String hashString(String input)
    {
        return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
    }

    @Override
    public List<String[]> sendLogin(String username, String password)
    {
        List<String[]> output = null;
        try
        {
            String ip = "192.168.43.119"; //"80.161.136.78"
            int port = 25565;
            //Creating connection
            //System.out.println("Waiting for a connection on " + ip + ":" + port);
            PseudoSSLClient pseudoSSLClient = new PseudoSSLClient(new Socket(ip, port));

            //Send an object
            pseudoSSLClient.sendObject(new String[]
            {
                "Login", username, hashString(hashString(username) + hashString(password))
            });
            output = (List<String[]>) pseudoSSLClient.recieveObject();
        } catch (Exception e)
        {
        }
        return output;
    }

    public List<String[]> getUsers(String username, String password)
    {
        List<String[]> output = null;
        try
        {
            String ip = "192.168.43.119"; //"80.161.136.78"
            int port = 25565;
            //Creating connection
            //System.out.println("Waiting for a connection on " + ip + ":" + port);
            PseudoSSLClient pseudoSSLClient = new PseudoSSLClient(new Socket(ip, port));

            //Send an object
            pseudoSSLClient.sendObject(new String[]
            {
                "UserList", username, hashString(hashString(username) + hashString(password))
            });
            output = (List<String[]>) pseudoSSLClient.recieveObject();
        } catch (Exception e)
        {
        }
        return output;
    }

}
