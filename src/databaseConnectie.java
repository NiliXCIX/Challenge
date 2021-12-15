import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

class databaseConnectie {

    public static void main (String [] args){
        try{
            Connection connectionString = DriverManager.getConnection("jdbc:mysql://localhost:3306/babbelbeestjedb", "root","1234");

            Statement statement = connectionString.createStatement();

            ResultSet resultset = statement.executeQuery("select * from gebruiker");


            String naam = "Nilesh";
            String naamdb;
            while (resultset.next()){
                naamdb = resultset.getString("voornaam");
                if (naam.equals(naamdb)){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }

            }



        } catch (Exception e){
            e.printStackTrace();
        }


    }
}