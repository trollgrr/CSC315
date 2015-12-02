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
                    queryList1.add(rs.getString("Carrier_ID")+rs.getString("FlightNo"));
                    queryList1.add(rs.getString("Departure_IATA"));
                    queryList1.add(rs.getString("Destination_IATA"));
                }
            } catch (Exception ex) {
                Logger logger = Logger.getAnonymousLogger();
                logger.log(Level.SEVERE, "an exception was thrown", ex);
            }
        } catch (Exception e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.log(Level.SEVERE, "an exception was thrown", e);
        }
        return queryList1;
    }

      
    public ArrayList<String> Query2() {
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
                    queryList2.add(rs.getString("Carrier_ID")+rs.getString("FlightNo"));
                    queryList2.add(rs.getString("DepartureTimeLocal"));
                    queryList2.add(rs.getString("ArrivalTimeLocal"));
                    queryList2.add(rs.getString("Departure_IATA"));
                    queryList2.add(rs.getString("Destination_IATA"));
                    queryList2.add(rs.getString("DepartureDate"));
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

    public ArrayList<String> Query3() {
        ArrayList<String> queryList3 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("select CarrierName, t.count, t.Departure_IATA, t.DepartureDate  from carrier natural join (select flight.Carrier_ID as id, flight.DepartureDate, flight.Departure_IATA, count(flight.Carrier_ID) as count from flight where(Departure_IATA='DFW' and DepartureDate='2006-12-31')) as t where t.id=CarrierID ;");
                while (rs.next()) {
                    
                    queryList3.add(rs.getString("CarrierName"));
                    queryList3.add(rs.getString("count"));
                    queryList3.add(rs.getString("Departure_IATA"));
                    queryList3.add(rs.getString("DepartureDate"));
                    
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



    public ArrayList<String> Query4() {

        ArrayList<String> queryList4 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("select CarrierName, t.Departure_IATA, t.Count, t.Average from carrier natural join (select distinct Departure_IATA, Carrier_ID, count(Carrier_ID) as Count, avg(CostThirdClass) as Average from flight group by Carrier_ID, Departure_IATA) as t where carrier.CarrierID=t.Carrier_ID;");
                while (rs.next()) {
                    
                    queryList4.add(rs.getString("CarrierName"));
                    queryList4.add(rs.getString("Departure_IATA"));
                    queryList4.add(rs.getString("Count"));
                    queryList4.add(rs.getString("Average"));
                    
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
        return queryList4;
    }
    
    public ArrayList<String> Query5() {
        ArrayList<String> queryList5 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("SELECT flight.Carrier_ID, flight.FlightNo, flight.Departure_IATA, flight.Destination_IATA, flight.CostThirdClass FROM flight WHERE Departure_IATA='DFW' AND Destination_IATA='LAX' AND CostThirdClass<'500';");
                while (rs.next()) {
                    queryList5.add(rs.getString("Carrier_ID")+rs.getString("FlightNo"));
                    queryList5.add(rs.getString("Departure_IATA"));
                    queryList5.add(rs.getString("Destination_IATA"));
                    queryList5.add(rs.getString("CostThirdClass"));
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
        return queryList5;
    }
    public ArrayList<String> Query6() {
        ArrayList<String> queryList6 = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "AccessMeHere");
            st = con.createStatement();
            Statement stmt = null;
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("USE FlightHandler;");
                ResultSet rs = stmt.executeQuery("select * from\n" +
                                                "	(select t.Carrier_ID, t.FlightNo, t.Departure_IATA, t.Destination_IATA, t.DepartureDate, (aircraft.classCapFirst+aircraft.classCapSecond+aircraft.classCapThird-t.Count) as AvailableSeats \n" +
                                                "	from aircraft natural join \n" +
                                                "		(select distinct count(*) as Count, flight.Departure_IATA, flight._Tail, flight.Destination_IATA, flight.DepartureDate, flight.Carrier_ID, flight.FlightNo\n" +
                                                "		from reservation natural join flight 	\n" +
                                                "		where  flight.FlightNo=reservation.Flight_No \n" +
                                                "		and flight.Carrier_ID=reservation.Carrier_ID \n" +
                                                "		and flight.DepartureDate=reservation.Departure_Date\n" +
                                                "		and flight.Departure_IATA='DFW' \n" +
                                                "		and flight.Destination_IATA='LAX' \n" +
                                                "		group by FlightNo, Carrier_ID,DepartureDate) as t \n" +
                                                "	where t._Tail=Tail\n" +
                                                "	) as other_t\n" +
                                                "where other_t.AvailableSeats>0;");//IT'S A BEAST!
                while (rs.next()) {
                    queryList6.add(rs.getString("Carrier_ID")+rs.getString("FlightNo"));
                    queryList6.add(rs.getString("Departure_IATA"));
                    queryList6.add(rs.getString("Destination_IATA"));
                    queryList6.add(rs.getString("DepartureDate"));
                    queryList6.add(rs.getString("AvailableSeats"));
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
        return queryList6;
    }

}
