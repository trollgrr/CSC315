/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import com.sun.glass.ui.Screen;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Johnogel
 */
public class VisualsManager {
JFrame main_frame;
JTabbedPane tabbed_pane;

    public VisualsManager(){
        main_frame = new JFrame("CSC315 Project");
        tabbed_pane = new JTabbedPane();
        tabbed_pane.setPreferredSize(new Dimension(800,600));
        
    }
    
    public void initialize(){
        tabbed_pane.addTab("MAIN", new MainPanel());
        QueryPanel panel_1 = new QueryPanel();
        panel_1.addColumn("Flight Number");
        panel_1.addColumn("Departure Airport");
        panel_1.addColumn("Arrival Airport");
        panel_1.setQuery(QueryPanel.ONE);
        panel_1.initialize();
        QueryPanel panel_2 = new QueryPanel();
        panel_2.addColumn("Flight Number");
        panel_2.addColumn("Departure Time");
        panel_2.addColumn("Arrival Time");
        panel_2.addColumn("Departure Airport");
        panel_2.addColumn("Arrival Airport");
        panel_2.addColumn("Date");
        panel_2.setQuery(QueryPanel.TWO);
        panel_2.initialize();
        QueryPanel panel_3 = new QueryPanel();
        panel_3.addColumn("Airline Name");
        panel_3.addColumn("No. of Flights");
        panel_3.addColumn("Departure Airport");
        panel_3.addColumn("Date");
        panel_3.setQuery(QueryPanel.THREE);
        panel_3.initialize();
        QueryPanel panel_4 = new QueryPanel();
        panel_4.addColumn("Airline Name");
        panel_4.addColumn("Airport Name");
        panel_4.addColumn("No. of Flights");
        panel_4.addColumn("Average Cost (Economy)");
        panel_4.setQuery(QueryPanel.FOUR);
        panel_4.initialize();
        QueryPanel panel_5 = new QueryPanel();
        panel_5.addColumn("Flight Number");
        panel_5.addColumn("Departure Airport");
        panel_5.addColumn("Arrival Airport");
        //panel_5.addColumn("Available Seats");
        panel_5.addColumn("Cost (Economy)");
        panel_5.setQuery(QueryPanel.FIVE);
        panel_5.initialize();
        QueryPanel panel_6 = new QueryPanel();
        panel_6.addColumn("Flight Number");
        panel_6.addColumn("Departure Airport");
        panel_6.addColumn("Arrival Airport");
        panel_6.addColumn("Departure Date");
        panel_6.addColumn("Available Seats");
        panel_6.setQuery(QueryPanel.SIX);
        panel_6.initialize();
        
        
        tabbed_pane.addTab("Query 1", panel_1);
        tabbed_pane.addTab("Query 2", panel_2);
        tabbed_pane.addTab("Query 3", panel_3);
        tabbed_pane.addTab("Query 4", panel_4);
        tabbed_pane.addTab("Query 5", panel_5);
        tabbed_pane.addTab("Query 6", panel_6);
        main_frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        main_frame.getContentPane().add(tabbed_pane);
        main_frame.pack();
        main_frame.setVisible(true);
        
    }
    
}
