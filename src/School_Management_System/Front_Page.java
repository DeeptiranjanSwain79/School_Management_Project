package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Thread;

public class Front_Page implements ActionListener{
    JFrame frame;
    JButton enter;
    JLabel title;

    Front_Page(){
        frame = new JFrame("LORDS INTERNATIONAL SCHOOL");
        frame.setSize(1000, 700);
        frame.setLocation(200, 50);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/school.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);

        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0,0, 1000, 700);
        frame.add(img);

        title = new JLabel("LORDS INTERNATIONAL SCHOOL", JLabel.CENTER);
        title.setBounds(10, 10, 980, 50);
        title.setFont(new Font("Elephant", Font.PLAIN, 40));
        title.setForeground(new Color(231, 84, 128));
        img.add(title);

        enter = new JButton("CLICK HERE TO CONTINUE");
        enter.setBackground(new Color(0, 128, 128));
        enter.setForeground(Color.GREEN);
        enter.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 30));
        enter.setBounds(200, 550, 600, 70);
        enter.addActionListener(this);
        img.add(enter);

        frame.setVisible(true);

        while (true){
            title.setVisible(false);
            try {
                Thread.sleep(500);
            }catch (Exception e){e.printStackTrace();}
            title.setVisible(true);
            try {
                Thread.sleep(1000);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == enter){
            new user();
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Front_Page();
    }
}
