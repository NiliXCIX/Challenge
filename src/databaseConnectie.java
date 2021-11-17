import java.sql.DriverManager;

public class databaseConnectie {
    public static void main (String [] args){
        String connectionString = jdbc:mysql://MyDatabaseServer/MyDatabase;
        DriverManager.getConnection(connectionString, username, password);

    }
}
