import com.sun.deploy.security.ruleset.Rule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextFieldExample implements ActionListener {
    JTextField tf1;
    JButton b1;
    JLabel l1,l2;
    List<Person> osoby;


    TextFieldExample(){
        osoby = new ArrayList<Person>();

        l2 = new JLabel("Dodawanie nowych osób");
        l2.setBounds(50, 25, 150, 20);

        JFrame f= new JFrame();
        tf1=new JTextField();
        tf1.setBounds(50,50,150,20);

        b1=new JButton("Dodaj");
        b1.setBounds(85,75,80,20);
        b1.addActionListener(this);

        l1 = new JLabel("Baza osób jest pusta!");
        Dimension size = l1.getPreferredSize();
        l1.setBounds(50, 100, 150, 300);

        f.add(l2);f.add(tf1);f.add(b1);f.add(l1);

        f.setSize(250,450);
        f.setLayout(null);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String name=tf1.getText();

        boolean canAdd=true;

        for (Person it : osoby) {
            if(it.getName() == name) canAdd=false;
        }

        if(canAdd) osoby.add(new Person(name));

        String result = "";
        for (Person it : osoby) {
            result+=it.getName() + "<br />";
        }

        l1.setText("<html>" + result + "</html>");
    }
}