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

    public List<String[]> sendLogin(String username, String password)
    {
        return interactionInterface.sendLogin(username, password);

    }

}
