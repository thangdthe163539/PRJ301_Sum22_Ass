/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author PiPi
 */
import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {        
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
        return DriverManager.getConnection(url, userID, password);
//        return DriverManager.getConnection(url);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "Hospital";
    private final String portNumber = "1143";
    private final String userID = "sa";
    private final String password = "admin";
}
class Using{
    public static void main(String[] args) {
        try {
            new DBContext().getConnection();
            System.out.println("Thanh cong!");
        } catch (Exception e) {
            System.out.println("That Bai!"+e.getMessage());
        }
    }
}
