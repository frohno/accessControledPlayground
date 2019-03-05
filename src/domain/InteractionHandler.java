
/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package domain;

import com.google.common.hash.Hashing;
import data.DataInterface;
import data.Database;
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
        return userDatabase.sendQuery("SELECT username, full_name, institution, employee_id FROM users WHERE username = '" + username + "' AND password = '" + hashString(hashString(username) + hashString(password)) +"'", "username", "full_name", "institution", "employee_id");
    }
}

