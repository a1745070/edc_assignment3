import javax.swing.*;
import java.awt.FlowLayout;
import swidgets.*;
import nz.sodium.*;

public class MergeExample2 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Merge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create inputs
        STextField input1 = new STextField("");

        Stream<String> stext2 = input1.sUserChanges.map(t -> {
            return t.replaceAll("[aeiou]", "*");
        });

        // Merge input streams
        Cell<String> text1 = input1.sUserChanges.merge(stext2, (t1, t2) -> {
            return t1+" "+t2;
        }).hold("");

        // Create output label
        SLabel label1 = new SLabel(text1);

        frame.add(input1);
        frame.add(label1);
        frame.setSize(400, 160);
        frame.setVisible(true);
    }

}

