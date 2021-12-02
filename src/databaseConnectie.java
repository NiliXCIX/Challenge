import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnectie {
    public static void main (String [] args){

        try {
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://MyDatabaseServer/MyDatabase", "root","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
