/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package test2.domain;

import com.google.common.hash.Hashing;
import test2.DataInterface;
import test2.Database;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Pinnacle F
 */
public class InteractionHandler implements InteractionInterface {

    DataInterface userDatabase = new Database("UserDB", "Oliver's personal computer #GDPR-Friendly", "jdbc:postgresql://dumbo.db.elephantsql.com:5432/iquyoclh", "iquyoclh", "0jjwWfpCjVao0Opr2HfQpd058rYqhcvy");

    private String hashString(String input) {
        return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
    }

    @Override
    public List<String[]> sendLogin(String username, String password) {
        return userDatabase.sendQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password +"'", "username", "password", "full_name", "institution", "employee_id"); //hashString(hashString(username) + hashString(password))
    }
}
