import nz.sodium.*;
import javax.swing.*;

   class GpsGui{
      public static void main(String args[]){
        JFrame frame = new JFrame("FIRST GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JButton button1 = new JButton("BUTTON");
        frame.getContentPane().add(button1);
        frame.setVisible(true);
     }
}