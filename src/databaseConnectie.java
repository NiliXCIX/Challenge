import java.sql.*;

public class databaseConnectie {
    public static void main (String [] args){

        try{
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root","1234");

        Statement statement = connectionString.createStatement();

        ResultSet resultset = statement.executeQuery("select * from gebruiker");

        while (resultset.next()) {
            System.out.println(resultset.getString("gebruikercode"));
            System.out.println(resultset.getString("geslacht"));
            System.out.println(resultset.getString("emailadres"));
            System.out.println(resultset.getString("voornaam"));
            System.out.println(resultset.getString("achternaam"));
            System.out.println(resultset.getString("gebruikersnaam"));
            System.out.println(resultset.getString("wachtwoord"));

        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
