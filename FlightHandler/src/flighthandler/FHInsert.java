/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;
import java.sql.*;
/**
 *
 * @author benupton
 * This file creates an initial load of values to fill the database with sample data.
 * For demo purposes only, so we don't have to demonstrate so much, and have a template of
 * SQL commands that we can test.
 * Except the airports, and other relatively static information that could easily be loaded from the start.
 */

public class FHInsert {

    private Connection con;
    private Statement st;
    String insertAd1; //address
    String insertAp1; //airport
    String insertCa1; //carrier
    String insertCo1; //carrieroffice
    String insertCu1; //customer
    String insertFt1, insertFt2; //flight
    String insertFl1; //flightLeg
    String insertRs1; //reservation

    public FHInsert(){
        try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/team10", "root", "ranger");
        st = con.createStatement();
        Statement stmt = null;
        try {
            stmt = con.createStatement();

            insertAd1 =  "INSERT INTO address VALUES ('', '', '', '1060 W Addison St', 'Chicago', 'IL', '', '60613', 'USA')";
            insertAp1 =  "INSERT INTO airport VALUES ('ENTO', 'TRF', 'Sandefjord Airport, Torp – Sandefjord, Vestfold','47 33 42 70 00' )";
            insertCa1 =  "INSERT INTO carrier VALUES ('Norwegian Air Norway', 'DH')";
            insertCo1 =  "INSERT INTO carrieroffice VALUES ('47815 21 815')";
            insertCu1 =  "INSERT INTO customer VALUES ('', 'Elwood', 'Blues', '867-5309', 'XXXX XXXX XXXX XXXX', 'NOPRF', 'HALAL', 'WNG', '0', '0', '0', '0')";
            insertFt1 =  "INSERT INTO flight VALUES ('1315')"; //DY still missing as foreign key
            insertFt2 =  "INSERT INTO flight VALUES ('1282')"; //Should take two values
            insertFl1 =  "INSERT INTO flightLeg VALUES ('false', 'BGO', 'ATY', '0830', '1330')";
            insertRs1 =  "INSERT INTO reservation VALUES ('', 'false')";

            }catch (SQLException e) 
            {
            System.out.println("error: " + e);
            }finally 
            {
                if (stmt != null) 
                {
                stmt.close();
                }
            }
    }catch (ClassNotFoundException | SQLException e) 
    {
            System.out.println("Error: " + e);
    }
}
}