import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class databaseConnectie {
    public static void main (String [] args){
        try {
            Connection connectionString = DriverManager.getConnection("jbdc:mysql://localhost::3306/babbelbeestje", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
