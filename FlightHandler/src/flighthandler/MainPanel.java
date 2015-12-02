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
private JButton initialize, populate;
private QueryManager qm;
private JLabel customers, flights, reservations, aircraft;
DatabaseStarter starter;
    public MainPanel(){
        qm = new QueryManager();
        
        initialize = new JButton("RESET DATABASE");
        initialize.setAlignmentX(JButton.CENTER_ALIGNMENT);
        initialize.setAlignmentY(JButton.BOTTOM_ALIGNMENT);
        
        populate = new JButton("POPULATE DATABASE");
        populate.setAlignmentX(JButton.CENTER_ALIGNMENT);
        populate.setAlignmentY(JButton.BOTTOM_ALIGNMENT);
        
        
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
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        
        customers = new JLabel("Number of Customers: \t"+ qm.numOfCustomers().get(0));
        customers.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        customers.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        flights = new JLabel("Number of Flights: \t"+ qm.numOfFlights().get(0));
        flights.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        flights.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        reservations = new JLabel("Number of Reservations: \t"+ qm.numOfCustomers().get(0));
        reservations.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        reservations.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        aircraft = new JLabel("Number of Plane Types: \t"+ qm.numOfAircraft().get(0));
        aircraft.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        aircraft.setAlignmentY(JLabel.TOP_ALIGNMENT);
        
        top.add(customers);
        top.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        top.add(flights);
        top.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        top.add(reservations);
        top.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        top.add(aircraft);
        top.add(Box.createRigidArea(new Dimension(this.getWidth(), 400)));
        bottom.add(initialize);
        bottom.add(Box.createRigidArea(new Dimension(this.getWidth(), 20)));
        bottom.add(populate);
        
        
        
        initialize.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                starter.reset();   
                updateLabels();
            }
            
            
        });
        
        populate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                starter.populate();   
                updateLabels();
            }
            
            
        });
        this.add(top);
        this.add(bottom);
    }
    
    public void updateLabels(){
        customers.setText("Number of Customers: \t"+ qm.numOfCustomers().get(0));
        flights.setText("Number of Flights: \t"+ qm.numOfFlights().get(0));
        reservations.setText("Number of Reservations: \t"+ qm.numOfCustomers().get(0));
        aircraft.setText("Number of Plane Types: \t"+ qm.numOfAircraft().get(0));
    }
    
}
