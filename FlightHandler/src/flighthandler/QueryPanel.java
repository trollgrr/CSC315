/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flighthandler;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Johnogel
 */
public class QueryPanel extends JPanel{
private ArrayList<JLabel> column_headers;
private JScrollPane scroll_pane;
private JPanel top, bottom;
private JButton query_button;
private String query;
    public QueryPanel(){
        
        this.setSize(new Dimension(800,600));
        this.setPreferredSize(new Dimension(800,600));
        BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(bl);
        
        scroll_pane = new JScrollPane();
        top = new JPanel();
        top.setPreferredSize(new Dimension(this.getWidth(), 50));
        top.setMaximumSize(new Dimension(this.getWidth(), 50));
        scroll_pane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-200));
        
        
        
        bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(this.getWidth(), 100));
        //bottom.setBackground(Color.yellow);
        bottom.setMaximumSize(new Dimension(this.getWidth(), 50));
        
        column_headers = new ArrayList();
        query_button = new JButton("RUN QUERY");
        query_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                //fill screen with query result
                System.out.println("Some Query should totally run right here yo.");
                
            }
        
        });
        
        query_button.setAlignmentY(Container.BOTTOM_ALIGNMENT);
        query_button.setAlignmentX(Container.CENTER_ALIGNMENT);
        
        
    }
    
    public void addColumn(String column_name){
        column_headers.add(new JLabel(column_name));
    }
    
    //use this method in client class to set query to be run
    public void setQuery(String query){
        this.query = query;
    }
    
    public int getColumnNums(){
        return column_headers.size();
    }
    
    public void initialize(){
        for (JLabel l : column_headers){
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setVerticalAlignment(JLabel.NORTH);
            top.add(l);
        }
        
        top.setLayout(new GridLayout(0,getColumnNums()));
        bottom.add(query_button);
        this.add(top);
        this.add(scroll_pane);
        this.add(bottom);
        
    }
    
}
