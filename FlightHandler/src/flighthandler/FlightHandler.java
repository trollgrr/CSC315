/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

/**
 *
 * @author benupton
 */
public class FlightHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Initializing database...");
        DatabaseStarter dbase = new DatabaseStarter();
        dbase.initialize();
        QueryManager query = new QueryManager();
        System.out.println("Database initialized, populating...");
        dbase.populate();
        //returns arraylist of formatted strings with database query results
        query.Query1(); 
        query.Query2();
        query.Query3();
        VisualsManager manager = new VisualsManager();
        manager.initialize();
        
    }
    
}
