/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbelaire
 */
public class QueryManager {
        private Connection con;
    private Statement st;
    String initName = (System.getProperty("user.dir") + "/CSC315Final.sql");
    String insertName = (System.getProperty("user.dir") + "/CSC315FinalPop.sql");
    String line;
    
    
      public ArrayList<String> Query1() {
        String query1 = "I'm sorry, but the table appears to be empty.";
        ArrayList<String> queryList1 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;

            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("SELECT Carrier_ID, FlightNo, Departure_IATA, Destination_IATA FROM flight;");
                while (rs.next()) {
                    String Carrier_ID = rs.getString("Carrier_ID");
                    String FlightNo = rs.getString("FlightNo");
                    String Departure_IATA = rs.getString("Departure_IATA");
                    String Destination_IATA = rs.getString("Destination_IATA");
                    query1 = ("Flight Number: " + Carrier_ID + FlightNo
                            + "\nDeparture Port: " + Departure_IATA
                            + "\nDestination: " + Destination_IATA);
                    //queryList1.add(query1);
                    queryList1.add(Carrier_ID+" "+FlightNo);
                    
                    queryList1.add(Departure_IATA);
                    queryList1.add(Destination_IATA);
                }
            } catch (Exception ex) {
                System.out.println("yikes");
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", ex);
            }
        } catch (Exception e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "an exception was thrown", e);
            System.out.println("double yikes");
        }
        return queryList1;
    }

      
    public ArrayList<String> Query2() {
        String query2 = "I'm sorry, but the table appears to be empty.";
        ArrayList<String> queryList2 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;

            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("SELECT Carrier_ID, FlightNo, DepartureTimeLocal, ArrivalTimeLocal, Departure_IATA, Destination_IATA, DepartureDate FROM flight WHERE Departure_IATA='DFW' AND Destination_IATA='LAX' AND DepartureDate='2006-12-31';");
                while (rs.next()) {
                    String Carrier_ID = rs.getString("Carrier_ID");
                    String FlightNo = rs.getString("FlightNo");
                    String DepartureTimeLocal = rs.getString("DepartureTimeLocal");
                    String ArrivalTimeLocal = rs.getString("ArrivalTimeLocal");
                    String DepartureAirport = rs.getString("Departure_IATA");
                    String ArrivalAirport = rs.getString("Destination_IATA");
                    String Date = rs.getString("DepartureDate");
                    query2 = ("Flight Number: " + Carrier_ID + FlightNo
                            + "\nDeparture Time: " + DepartureTimeLocal
                            + "\nArrival Time: " + ArrivalTimeLocal);
                    System.out.println(query2);
                    //queryList2.add(query2);
                    queryList2.add(Carrier_ID+FlightNo);
                    queryList2.add(DepartureTimeLocal);
                    queryList2.add(ArrivalTimeLocal);
                    queryList2.add(DepartureAirport);
                    queryList2.add(ArrivalAirport);
                    queryList2.add(Date);
                }
            } catch (Exception ex) {
                System.out.println("yikes");
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", ex);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "an exception was thrown", e);
            System.out.println("double yikes");
        }
        return queryList2;
    }

    public ArrayList<String> Query3() {//Still not working///////////
        String query3 = "I'm sorry, but the table appears to be empty.";
        ArrayList<String> queryList3 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("SELECT Carrier_ID, FlightNo, DepartureTimeLocal, ArrivalTimeLocal FROM flight WHERE Departure_IATA='DFW' AND Destination_IATA='LAX' AND DepartureDate='2006-12-31';");
                while (rs.next()) {
                    String Carrier_ID = rs.getString("Carrier_ID");
                    String FlightNo = rs.getString("FlightNo");
                    String DepartureTimeLocal = rs.getString("DepartureTimeLocal");
                    String ArrivalTimeLocal = rs.getString("ArrivalTimeLocal");
                    query3 = ("Flight Number: " + Carrier_ID + FlightNo
                            + "\nDeparture Time: " + DepartureTimeLocal
                            + "\nArrival Time: " + ArrivalTimeLocal);
                    System.out.println(query3);
                    queryList3.add(query3);
                }
            } catch (Exception ex) {
                System.out.println("yikes");
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", ex);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "an exception was thrown", e);
            System.out.println("double yikes");
        }
        return queryList3;
    }
    

    
}
