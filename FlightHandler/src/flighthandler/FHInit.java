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
 * This file does the initial load of all the tables, that would not be available to a user.
 * It should only really run during installation, but we'll probably need to run it for demo.
 */

public class FHInit {

    private Connection con;
    private Statement st;
    // Variables named to keep them separate for primary functions
    String drop1i, create1i, grant1i, grant2i, flush1i, use1i, drop2i, create2i, drop3i, create3i;
    String drop4i, create4i, drop5i, create5i, drop6i, create6i, drop7i, create7i, drop8i, create8i, drop9i, create9i, 
           drop10i, create10i, drop11i, create11i;
    public FHInit(){
        try {
            
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
        st = con.createStatement();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            drop1i =  "DROP DATABASE if exists FlightHandler";
            stmt.executeUpdate(drop1i);
            create1i =  "CREATE DATABASE FlightHandler";
            stmt.executeUpdate(create1i);
            System.out.println("create");
            flush1i =  "FLUSH PRIVILEGES";
            stmt.executeUpdate(flush1i);
            System.out.println("flush");
            use1i =  "USE FlightHandler";
            stmt.executeUpdate(use1i);
            System.out.println("use");
            drop2i =  "DROP TABLE IF EXISTS reservation";
            stmt.executeUpdate(drop2i);
            System.out.println("drop");
            create2i =  "CREATE TABLE reservation(\n" +
            "ReservationID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "PRIMARY KEY(ReservationID),\n" +
            "ReservationHold BOOL NOT NULL,\n" +
            "INDEX (ReservationID)\n" +
            ")";
            stmt.executeUpdate(create2i);
            drop3i =  "DROP TABLE IF EXISTS customer";
            stmt.executeUpdate(drop3i);
            create3i =  "CREATE TABLE customer(\n" +
            "CustomerID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "PRIMARY KEY(CustomerID),\n" +
            "FirstName VARCHAR(45) NOT NULL,\n" +
            "LastName VARCHAR(45) NOT NULL,\n" +
            "HomePhone VARCHAR(17),\n" +
            "PrimaryCardNo VARCHAR(45),\n" +
            "SeatPref VARCHAR(5), #AISLE CNTR DOOR WSHC\n" +
            "MealPref VARCHAR(5), #VEGGI HALAL KOSHR PASTA NOPRF\n" +
            "AcftPosPref VARCHAR(3), #FRT WNG TAL\n" +
            "FrequentFlierProgA INT(12) UNSIGNED,\n" +
            "FrequentFlierProgB INT(12) UNSIGNED,\n" +
            "FrequentFlierProgC INT(12) UNSIGNED,\n" +
            "FrequentFlierProgD INT(12) UNSIGNED\n" +
            ")";
            stmt.executeUpdate(create3i);
            drop4i =  "DROP TABLE IF EXISTS address";
            stmt.executeUpdate(drop4i);
            create4i =  "CREATE TABLE address(\n" +
            "AddressID INT(12) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "PRIMARY KEY(AddressID),\n" +
            "Box INT(5) UNSIGNED,\n" +
            "ApartmentNo VARCHAR(9),\n" +
            "Street VARCHAR(45) NOT NULL,\n" +
            "City VARCHAR(45)NOT NULL,\n" +
            "State VARCHAR(2),\n" +
            "Province VARCHAR(22),\n" +
            "Zip INT (5),\n" +
            "Country VARCHAR(3)\n" +
            ")";
            stmt.executeUpdate(create4i);
            drop5i =  "DROP TABLE IF EXISTS flightleg";
            stmt.executeUpdate(drop5i);            
            create5i =   "CREATE TABLE flightleg(\n" +
            "LegStatus BOOL,\n" +
            "DepartureICAO VARCHAR(4),\n" +
            "DestinationICAO VARCHAR(4),\n" +
            "DepartureTimeLocal TIME,\n" +
            "ArrivalTimeLocal TIME\n" +
            ")";
            stmt.executeUpdate(create5i);
            drop6i =  "DROP TABLE IF EXISTS airport";
            stmt.executeUpdate(drop6i);
            create6i =  "CREATE TABLE airport(\n" +
            "ICAO VARCHAR(4),\n" +
            "PRIMARY KEY(ICAO),\n" +
            "IATA VARCHAR(3),\n" +
            "FullName VARCHAR(60),\n" +
            "Phone VARCHAR(17)\n" +
            ")";
            stmt.executeUpdate(create6i);
            drop7i =  "DROP TABLE IF EXISTS flight";
            stmt.executeUpdate(drop7i);
            create7i =  "CREATE TABLE flight(\n" +
            "#CarrierName VARCHAR(2),\n" +
            "FlightNumber INT(4) UNSIGNED\n" +
            ")";
            stmt.executeUpdate(create7i);
            drop8i =  "DROP TABLE IF EXISTS carrier";
            stmt.executeUpdate(drop8i);
            create8i =  "CREATE TABLE carrier(\n" +
            "CarrierName VARCHAR(45),\n" +
            "CarrierID VARCHAR(2),\n" +
            "PRIMARY KEY(CarrierID)\n" +
            ")";
            stmt.executeUpdate(create8i);
            drop9i =  "DROP TABLE IF EXISTS carrierOffice";
            stmt.executeUpdate(drop9i);
            create9i =  "CREATE TABLE carrierOffice(\n" +
            "OfficePhone VARCHAR(17)\n" +
            ")";
            stmt.executeUpdate(create9i);
            
            drop10i = "DROP TABLE IF EXISTS frequentFlierGroup;";
            stmt.executeUpdate(drop10i);
            
            create10i = "CREATE TABLE frequentFlierGroup("+
            "CustomerID INT(12) UNSIGNED NOT NULL,\n"+
            "FFGroupID INT(12) UNSIGNED NOT NULL,\n"+
            "MembershipName VARCHAR(50) NOT NULL,\n"+
            "PRIMARY KEY (FFGroupID));";
            
            stmt.executeUpdate(create10i);
            
            drop11i = "DROP TABLE IF EXISTS frequentFlierMembership;";
            stmt.executeUpdate(drop11i);
            
            create11i = "CREATE TABLE frequentFlierMemberShip(\n"+
            "FFGroupID INT(12) UNSIGNED NOT NULL,\n"+ 
            "MembershipName VARCHAR(50) NOT NULL,\n"+
            "FFPoints INT(12) UNSIGNED,\n"+
            "PRIMARY KEY(FFGroupID, MembershipName),\n"+
            "FOREIGN KEY (FFGroupID) REFERENCES frequentFlierGroup(FFGroupID));"      ;
            
            stmt.executeUpdate(create11i);
            
            System.out.println("I think this means it's working.");

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
        }catch (Exception e) 
        {
                System.out.println("Error: " + e);
        }
    }
}