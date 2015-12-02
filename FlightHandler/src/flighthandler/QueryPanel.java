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
private ArrayList<JLabel> columns;
private ArrayList<JPanel> rows;
private JScrollPane scroll_pane;
private JPanel top, middle, bottom, sub_scroll;
private JButton query_button;
private String query;
private QueryManager qm;
private int query_to_run;
private ArrayList<String> result;
public static final int 
        ONE = 1,
        TWO = 2,
        THREE = 3,
        FOUR = 4,
        FIVE = 5,
        SIX = 6;
private static final int ROW_HEIGHT = 30, MAX_ROWS = 20;
    public QueryPanel(){
        
        qm = new QueryManager();
        
        rows = new ArrayList();
        
        this.setSize(new Dimension(800,600));
        this.setPreferredSize(new Dimension(800,600));
        BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(bl);
        
        sub_scroll = new JPanel();
        scroll_pane = new JScrollPane(sub_scroll);
        
        top = new JPanel();
        top.setPreferredSize(new Dimension(this.getWidth(), 50));
        top.setMaximumSize(new Dimension(this.getWidth(), 50));
        /*scroll_pane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()-200));
        sub_scroll.setPreferredSize(new Dimension(scroll_pane.getWidth(), 2000));
        sub_scroll.setSize(new Dimension(scroll_pane.getWidth(), 2000));
        */
        middle = new JPanel();
        middle.setPreferredSize(new Dimension(this.getWidth(), 700));
        middle.setSize(new Dimension(this.getWidth(), 700));
        middle.setMaximumSize(new Dimension(this.getWidth(), 700));
        
                
        bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(this.getWidth(), 100));
        //bottom.setBackground(Color.yellow);
        bottom.setMaximumSize(new Dimension(this.getWidth(), 50));
        
        columns = new ArrayList();
        query_button = new JButton("RUN QUERY");
        query_button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                //fill screen with query result
                
                ArrayList<String> result = getResult();
                //JPanel row = new JPanel();
                JLabel field;
                //row.setSize(new Dimension(middle.getWidth(), ROW_HEIGHT));
                
                /*for (int i = 1; i <= result.size(); i++){
                    
                }*/
                clearRows();
                int row = 0, i = 0;
                
                while(row < MAX_ROWS && i < result.size()){
                    
                    field = (JLabel) rows.get(row).getComponent((i%columns.size()));
                    field.setText(result.get(i));
                    if((i+1) % columns.size() == 0){
                        row++;
                    }
                    i++;
                }
                
                System.out.println("Some Query should totally run right here yo.");
                
            }
        
        });
        
        query_button.setAlignmentY(Container.BOTTOM_ALIGNMENT);
        query_button.setAlignmentX(Container.CENTER_ALIGNMENT);
        
        
    }
    
    public void addColumn(String column_name){
        columns.add(new JLabel(column_name));
    }
    
    //use this method in client class to set query to be run
    public void setQuery(int query){
        query_to_run = query;
    }
    
    public int getColumnNums(){
        return columns.size();
    }
    
    public ArrayList<String> getResult(){
        switch(query_to_run){
            case ONE:
                return qm.Query1();
            case TWO:
                return qm.Query2();
            case THREE:
                return qm.Query3();
            case FOUR:
                return qm.Query4();
            case FIVE:
                return qm.Query5();
            case SIX:
                return qm.Query6();
            default:
                return new ArrayList<>();
        }
    }
    
    private void clearRows(){
        JLabel field;
        for(int i = 0; i < MAX_ROWS; i++){
            for(int j = 0; j < columns.size(); j++){
                field = (JLabel)rows.get(i).getComponent(j);
                field.setText("");
            }
        }
            
    }
    
    public void initialize(){
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
        for (JLabel l : columns){
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setVerticalAlignment(JLabel.NORTH);
            top.add(l);
        }
        JLabel field;
        for(int i = 0; i < MAX_ROWS; i++){
            rows.add(new JPanel());
            rows.get(i).setSize(new Dimension(this.getWidth(), 25));
            rows.get(i).setMinimumSize(new Dimension(this.getWidth(), 25));
            rows.get(i).setMaximumSize(new Dimension(this.getWidth(), 25));
            rows.get(i).setLayout(new GridLayout(1,getColumnNums()));
            for(int j = 0; j < this.getColumnNums(); j++){
                field = new JLabel("");
                field.setHorizontalAlignment(JLabel.CENTER);
                field.setVerticalAlignment(JLabel.NORTH);
                rows.get(i).add(field);
            }
            
            
        }
        for(JPanel row : rows){
            middle.add(row);
        }
        
        top.setLayout(new GridLayout(0,getColumnNums()));
        bottom.add(query_button);
        
        scroll_pane.add(sub_scroll);
        this.add(top);
        this.add(middle);
        this.add(bottom);
        
    }
    
}
