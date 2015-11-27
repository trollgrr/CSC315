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
        panel_1.addColumn("Column 1");
        panel_1.addColumn("Column 2");
        panel_1.initialize();
        tabbed_pane.addTab("Query 1", panel_1);
        main_frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        main_frame.getContentPane().add(tabbed_pane);
        main_frame.pack();
        main_frame.setVisible(true);
        
    }
    
}
