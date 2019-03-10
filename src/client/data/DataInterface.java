/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.data;

import java.util.List;

/**
 *
 * @author Pinnacle F
 */
public interface DataInterface {
    public List<String[]> sendQuery(String query, String... collums);
}
