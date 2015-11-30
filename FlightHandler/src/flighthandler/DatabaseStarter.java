/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * To modify Initialize or Populate output, find the .sql file in the SRC folder
 * and just add stuff directly into it.
 *
 * @author trollgrr
 */
public class DatabaseStarter {

    private Connection con;
    private Statement st;
    String initName = (System.getProperty("user.dir") + "/CSC315Final.sql");
    String insertName = (System.getProperty("user.dir") + "/CSC315FinalPop.sql");
    String line;
    int count;

    public void Initialize() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                FileReader fileReader = new FileReader(initName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()).isEmpty() == false) {
                    stmt.executeUpdate(line);
                }

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + initName + "'");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "an exception was thrown", e);
        }
    }

    public void Populate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                FileReader fileReader = new FileReader(insertName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()).isEmpty() == false) {
                    stmt.executeUpdate(line);
                    count++;
                }
                System.out.println("Added " + count + " items");
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Unable to find file '" + insertName + "'");
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", e);
            } catch (IOException ex) {
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", ex);
            }
        } catch (Exception e) {
            System.out.println("Added " + count + " items");
        }
    }

    public ArrayList<String> Query1() {
        String query1 = "I'm sorry, but the table appears to be empty.";
        ArrayList<String> queryList = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                System.out.println("selected");
                ResultSet rs = stmt.executeQuery("SELECT Carrier_ID, FlightNo, Departure_IATA, Destination_IATA FROM flight;");
                while (rs.next()) {
                    String Carrier_ID = rs.getString("Carrier_ID");
                    String FlightNo = rs.getString("FlightNo");
                    String Departure_IATA = rs.getString("Departure_IATA");
                    String Destination_IATA = rs.getString("Destination_IATA");
                    query1 = ("Flight Number: " + Carrier_ID + FlightNo
                            + "\nDeparture Port: " + Departure_IATA
                            + "\nDestination: " + Destination_IATA);
                    System.out.println(query1);
                    queryList.add(query1);
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
        return queryList;
    }
}
