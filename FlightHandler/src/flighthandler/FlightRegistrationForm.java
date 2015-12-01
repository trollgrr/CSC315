/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Johnogel
 */
public class FlightRegistrationForm extends JFrame{
private final JPanel registration;
private JButton submit;
public final static String 
        FIRST = "First Name",
        LAST = "Last Name",
        PHONE = "Phone Number",
        ADDRESS = "Street address",
        ZIP = "Zip",
        APT = "apt no.",
        CITY = "City",
        STATE = "State",
        COUNTRY = "Country",
        PO_BOX = "P.O. Box";
                    
private ArrayList<JTextField> text_fields;
    public FlightRegistrationForm(){
        super();
        text_fields = new ArrayList();
        registration = new JPanel();
        registration.setLayout(new BoxLayout(registration, BoxLayout.Y_AXIS));
        initializePanel();
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(registration);
        pack();
        setVisible(true);
    }
    
    public void initializePanel(){
       submit = new JButton("SUBMIT");
       if(text_fields.size() > 0){
           while(text_fields.size() > 0){
               text_fields.remove(0);
           }
       } 
        
       JTextField first_name = new JTextField();
       first_name.setName(FIRST);
       
       JTextField last_name = new JTextField();
       last_name.setName(LAST);
       
       JTextField address = new JTextField();
       address.setName(ADDRESS);
       
       JTextField apt_no = new JTextField();
       apt_no.setName(APT);
       
       JTextField city = new JTextField();
       city.setName(CITY);
       
       JTextField state = new JTextField();
       state.setName(STATE);
       
       JTextField zip = new JTextField();
       zip.setName(ZIP);
       
       JTextField po_box = new JTextField();
       po_box.setName(PO_BOX);
       
       
       JTextField country= new JTextField("Enter Country");
       country.setName(COUNTRY);
       
       JTextField phone = new JTextField("Enter Phone Number");
       phone.setName(PHONE);
       
       //adds all text fields to arraylist for later processing
       text_fields.add(first_name);
       text_fields.add(last_name);
       text_fields.add(address);
       text_fields.add(apt_no);
       text_fields.add(city);
       text_fields.add(state);
       text_fields.add(zip);
       text_fields.add(po_box);
       text_fields.add(country);
       text_fields.add(phone);
       
       for(JTextField tf : text_fields){
           tf.setText(tf.getName());
           tf.addFocusListener(new FocusListener(){

               @Override
               public void focusGained(FocusEvent fe) {
                    if(tf.getName() == null ? tf.getText() == null : tf.getName().equals(tf.getText())){
                        tf.setText("");
                    }
               }

               @Override
               public void focusLost(FocusEvent fe) {
                    if("".equals(tf.getText()))
                    {
                        tf.setText(tf.getName());
                    }
               }

               
           
           });
           
           tf.setPreferredSize(new Dimension(300,30));
           registration.add(tf);
       }
       submit.setAlignmentX(Component.CENTER_ALIGNMENT);
       registration.add(submit);
       
       
       
    }
    
    
    
}
