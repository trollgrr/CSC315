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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
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

    public void initialize() {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Are you ready to initialize the database?");
        System.out.println("NOTE: This will wipe the database and fill it with sample data.");
        System.out.println("Type 'yes' to continue...");
        if (stdIn.hasNext("yes")){
            stdIn.nextLine();
        try {
            System.out.println("Would you like to input a file or use default intializer?");
            System.out.println("Type 'yes' to use your own file.");
            try {
                if (stdIn.hasNext("yes")) {
                    System.out.println("Please input file name and path eg: /Documents/CSC315Final.sql");
                    stdIn.nextLine();
                    initName = stdIn.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Well, if you're not sure, then let's just go with the default.");
                System.out.println("Error" + e);
            }
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
    }

    public void populate() {
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

}
