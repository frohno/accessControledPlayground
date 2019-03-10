/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.domain;

import java.util.List;

/**
 *
 * @author Pinnacle F
 */
public interface InteractionInterface {
    public List<String[]> sendLogin(String username, String password);
    public List<String[]> getUsers(String username, String password);
}
