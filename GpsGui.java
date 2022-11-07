import nz.sodium.*;
import javax.swing.*;
import swidgets.*;
import java.awt.*;
import java.text.*;
import java.util.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.FlowLayout;
import javax.swing.table.*;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.border.*;


public class GpsGui {

    public static void main(String[] args){

        //GUI frame heading
        JFrame frame = new JFrame("GUI");
        //Frame Size
        frame.setSize(470, 450);
        //On Pressing GUI cross stop running the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
        //PART 1
        //Code to Initialise the GPS Service from Example.java
        GpsService serv = new GpsService();
        // Retrieve Event Streams
        Stream<GpsEvent>[] streams = serv.getEventStreams(); 

        //Code to Attach a handler method to each stream from Example.java
        for(Stream<GpsEvent> s : streams)
        {
            s.listen((GpsEvent ev) -> { 
            //Printing the GPS Data on the terminal
            System.out.println(ev);
             });

            //Printing Tracker with numbers
            Cell<String> tNum;
            tNum = s.map((GpsEvent ev) -> 
            {
            String []expected;
            //Using split to remove space to directly print Tracker
            expected= ev.toString().split(" ");
            String t1String;
            //Printing Tracker as it is at place 0 in the array
            t1String = (expected[0]);
            //t1String is printing Tracker with number
            return t1String;
            //hold with no space  is used to make sure there is no hold in the data and it should get printing all together in the GUI 
            }).hold("");
            //Label for printing Latitude
            SLabel lA = new SLabel(tNum);
            lA.setPreferredSize(new Dimension(80, 30));
            frame.add(lA);
            Font ft = new Font("Serif", Font.BOLD, 16);
            lA.setFont(ft);
            lA.setForeground(Color.BLUE);
            // lA.BorderLayout(5, 5);
            


            // Printing Latitude 
            Cell<String> lNum;
            lNum = s.map((GpsEvent ev) -> 
            {
            String []expected;
            //Using split to remove space after Tracker to directly print Latitude
            expected = ev.toString().split(" ");
            String t2String;
            //Printing Latitute as it is at place 2 in the array
            t2String = (expected[2]);
            //t2String is printing Latitude
            return t2String;
            //hold with no space  is used to make sure there is no hold in the data and it should get printing all together in the GUI  
            }).hold("");
            //Label for printing Latitude
            SLabel lB = new SLabel(lNum);
            frame.add(lB);
            lB.setForeground(Color.RED);
            lB.setPreferredSize(new Dimension(150, 30));
            Font fLt = new Font("Serif", Font.BOLD, 16);
            lB.setFont(fLt);

            
            // Printing Longitude 
            Cell<String> lonNum;
            lonNum = s.map((GpsEvent ev) -> 
            {
            String []expected;
            //Using split to remove space after Longitude and directly print Longitude
            expected = ev.toString().split(" ");
            String t3String;
            //Printing Longitude as it is at place 3 in the array
            t3String = (expected[3]);
            //t3String is printing Longitude
            return t3String;  
            //hold with no space  is used to make sure there is no hold in the data and it should get printing all together in the GUI
            }).hold("");
            //Label for printing Longitude
            SLabel lC = new SLabel(lonNum);
            Font fLot = new Font("Serif", Font.BOLD, 16);
            lC.setFont(fLot);
            lC.setForeground(Color.ORANGE);
            lC.setPreferredSize(new Dimension(180, 30));
            frame.add(lC);  

              
            //Layout for printing
            frame.setLayout(new FlowLayout());
            // Setting Gui as visible
            frame.setVisible(true);
        }
        //Part 2 
        String date = new SimpleDateFormat("hh:mm:ss").format(new Date());
        JButton l = new JButton(date);
        l.setForeground(Color.ORANGE);
        l.setPreferredSize(new Dimension(450, 50));
        frame.getContentPane().add(l);


           
     }
 }