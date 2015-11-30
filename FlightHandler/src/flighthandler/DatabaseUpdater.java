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
 * @author trollgrr
 */
public class DatabaseUpdater {
        private Connection con;
        private Statement st;

    
            public void Update1(ArrayList<String> text_fields) {//Still not working///////////
        String update1 = "I'm sorry, but the table appears to be empty.";
        ArrayList<String> updateList1 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeQuery("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("INSERT INTO customer VALUES (NULL, 'Elwood', 'Blues', '867-5309', '5309 5309 5309 5309','1', '2', 'NOPRF', 'HALAL', 'WNG');");
                while (rs.next()) {
                    //rs.updateString(FirstName, update1);
                    String Carrier_ID = rs.getString("Carrier_ID");
                    String FlightNo = rs.getString("FlightNo");
                    String DepartureTimeLocal = rs.getString("DepartureTimeLocal");
                    String ArrivalTimeLocal = rs.getString("ArrivalTimeLocal");
                    update1 = ("Flight Number: " + Carrier_ID + FlightNo
                            + "\nDeparture Time: " + DepartureTimeLocal
                            + "\nArrival Time: " + ArrivalTimeLocal);
                    System.out.println(update1);
                    updateList1.add(update1);
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
    }
    
}
