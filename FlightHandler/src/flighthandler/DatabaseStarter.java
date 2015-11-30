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
import java.sql.Statement;

/**
 * To modify Initialize or Populate output, find the .sql file in the 
 * SRC folder and just add stuff directly into it.
 * @author trollgrr
 */
public class DatabaseStarter {

    private Connection con;
    private Statement st;
    String initName = (System.getProperty("user.dir")+"/CSC315Final.sql");
    String insertName = (System.getProperty("user.dir")+"/CSC315FinalPop.sql");
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
                while ((line = bufferedReader.readLine()).isEmpty() == false) 
                {
                    stmt.executeUpdate(line);
                }

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + initName + "'");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void Populate()
    {
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
                System.out.println("Added "+count+" items");
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + insertName + "'");
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Added "+count+" items");
        }
    }
}
