/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package presentation;

import domain.InteractionHandler;
import domain.InteractionInterface;
import java.util.List;

/**
 *
 * @author Pinnacle F
 */
public class InteractionCommunicatior
{

    private final InteractionInterface interactionInterface = new InteractionHandler();
    
    private static InteractionCommunicatior interactionCommunicatior;

    public List<String[]> sendLogin(String username, String password)
    {
        return interactionInterface.sendLogin(username, password);

    }
    
    public List<String[]> getUsers(String username, String password)
    {
        return interactionInterface.getUsers(username, password);

    }
    
    private InteractionCommunicatior()
    {
       //nothing 
    }
    
    
    public static InteractionCommunicatior getInstance()
    {
        if (interactionCommunicatior == null)
        {
            interactionCommunicatior = new InteractionCommunicatior();
        }
        return interactionCommunicatior;
    }

}
