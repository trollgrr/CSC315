/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Johnogel
 */
public class FlightRegistrationFrame extends JFrame{
private final JPanel registration;
private JButton submit;
public final static String 
        FIRST = "FIRST",
        LAST = "LAST",
        PHONE = "PHONE",
        ADDRESS = "ADDRESS",
        ZIP = "ZIP",
        APT = "APT",
        CITY = "CITY",
        STATE = "STATE",
        COUNTRY = "COUNTRY",
        PO_BOX = "PO_BOX";
                    
private ArrayList<JTextField> text_fields;
    public FlightRegistrationFrame(){
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
        
       JTextField first_name = new JTextField("Enter First Name");
       first_name.setName(FIRST);
       
       JTextField last_name = new JTextField("Enter Last Name");
       last_name.setName(LAST);
       
       JTextField address = new JTextField("Enter Address");
       address.setName(ADDRESS);
       
       JTextField apt_no = new JTextField("Enter Apt. No.");
       apt_no.setName(APT);
       
       JTextField city = new JTextField("Enter City");
       city.setName(CITY);
       
       JTextField state = new JTextField("Enter State");
       state.setName(STATE);
       
       JTextField zip = new JTextField("Enter Zip Code");
       zip.setName(ZIP);
       
       JTextField po_box = new JTextField("Enter PO BOX");
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
           registration.add(tf);
       }
       registration.add(submit);
       
       
       
    }
    
    
    
}
