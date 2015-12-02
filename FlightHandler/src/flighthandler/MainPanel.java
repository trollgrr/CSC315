/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Johnogel
 */
public class MainPanel extends JPanel{
private JPanel top, bottom;
private JButton initialize;
private QueryManager qm;
DatabaseStarter starter;
    public MainPanel(){
        qm = new QueryManager();
        
        initialize = new JButton("INITIALIZE DATABASE");
        initialize.setAlignmentX(JButton.CENTER_ALIGNMENT);
        initialize.setAlignmentY(JButton.CENTER_ALIGNMENT);
        
        
        top = new JPanel();
        bottom = new JPanel();
        starter = new DatabaseStarter();
        this.setSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        top.setSize(new Dimension(this.getWidth(),this.getHeight()-100));
        top.setMinimumSize(new Dimension(this.getWidth(),this.getHeight()-100));
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
        
        bottom.setSize(new Dimension(this.getWidth(), 100));
        bottom.setPreferredSize(new Dimension(this.getWidth(), 400));
        bottom.setMaximumSize(new Dimension(this.getWidth(), 100));
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        
        JLabel customers = new JLabel("Number of Customers: \t"+ qm.numOfCustomers().get(0));
        customers.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        customers.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        JLabel flights = new JLabel("Number of Flights: \t"+ qm.numOfFlights().get(0));
        flights.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        flights.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        JLabel reservations = new JLabel("Number of Reservations: \t"+ qm.numOfCustomers().get(0));
        reservations.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        reservations.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        JLabel aircraft = new JLabel("Number of Plane Types: \t"+ qm.numOfAircraft().get(0));
        aircraft.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        aircraft.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        this.add(customers);
        this.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        this.add(flights);
        this.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        this.add(reservations);
        this.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        this.add(aircraft);
        this.add(Box.createRigidArea(new Dimension(this.getWidth(), 400)));
        this.add(initialize);
        
        
        
        initialize.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                starter.initialize();
                starter.populate();
            }
            
            
        });
       // this.add(top);
       // this.add(bottom);
    }
    
}
