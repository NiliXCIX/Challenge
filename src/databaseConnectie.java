import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

class databaseConnectie {

    public static void main (String [] args){
        PreparedStatement pst;
        try{
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root","1234");

        Statement statement = connectionString.createStatement();

        ResultSet resultset = statement.executeQuery("select * from gebruiker");

        pst = connectionString.prepareStatement("insert into gebruiker(gebruikerscode,geslacht,emailadres,voornaam,achternaam,gebruikersnaam,wachtwoord)values(?,?,?,?,?,?,?)");
        pst.executeUpdate();



        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
