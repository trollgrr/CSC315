/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Johnogel
 */
public class MainPanel extends JPanel{
private JPanel top, bottom;
private JButton register, initialize;
DatabaseStarter starter;
    public MainPanel(){
        register = new JButton("REGISTER FLIGHT");
        initialize = new JButton("RE-INITIALIZE DATABASE");
        
        top = new JPanel();
        bottom = new JPanel();
        starter = new DatabaseStarter();
        this.setSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        
        top.setSize(new Dimension(this.getWidth(),this.getHeight()-100));
        bottom.setSize(new Dimension(this.getWidth(), 100));
        
        bottom.add(register);
        bottom.add(initialize);
        
        register.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                FlightRegistrationForm form = new FlightRegistrationForm();
            }
        
        });
        
        initialize.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                starter.initialize();
                starter.populate();
            }
            
            
        });
        this.add(top);
        this.add(bottom);
    }
    
}
