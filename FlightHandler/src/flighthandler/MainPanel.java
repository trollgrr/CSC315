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
private JButton register;
    public MainPanel(){
        register = new JButton("REGISTER FLIGHT");
        this.setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));
        add(register);
        
        register.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                FlightRegistrationForm form = new FlightRegistrationForm();
            }
        
        });
    }
    
}
