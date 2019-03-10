package client.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;
import org.postgresql.ssl.NonValidatingFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Oliver
 */
public class Database implements DataInterface {

    Connection conn = null;
    final String JDBC_DRIVER = "org.postgresql.Driver";

    String name;
    String physicalLocation;
    String dbURL;
    String dbUser;
    String dbPassword;

    public Database(String name, String physicalLocation, String dbURL, String dbUser, String dbPassword) {
        this.name = name;
        this.physicalLocation = physicalLocation;
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    @Override
    public List<String[]> sendQuery(String query, String... collums) {
        ResultSet sqlReturnValues;
        List<String[]> output = null;
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            Statement stmt = conn.createStatement();
            sqlReturnValues = stmt.executeQuery(query);
            output = new ArrayList<>();
            while (sqlReturnValues.next()) {
                String[] temp = new String[collums.length];
                for (int i = 0; i < collums.length; i++) {
                    temp[i] = sqlReturnValues.getString(collums[i]);
                }
                output.add(temp);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return output;
    }
}
