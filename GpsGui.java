import nz.sodium.*;
import javax.swing.*;
import swidgets.*;
import java.awt.FlowLayout;
import javax.swing.table.*;

public class GpsGui {

    public static void main(String[] args){

        //GUI frame heading
        JFrame frame = new JFrame("GUI");
        //Frame Size
        frame.setSize(282, 270);
        //On Pressing GUI cross stop running the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
            frame.add(lA);


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
            frame.add(lC);


           
            //Layout for printing
            frame.setLayout(new FlowLayout());
            // Setting Gui as visible
            frame.setVisible(true);
        }
     }
 }
 
