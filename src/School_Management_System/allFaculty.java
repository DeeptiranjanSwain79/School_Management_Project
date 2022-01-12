package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class allFaculty implements ActionListener{
    JFrame frame;
    JTable table;
    JButton exit;
    String name;
    String x[] = {"ID", "Name", "AADHAAR", "Qualification", "Post"};
    String y[][] = new String[100][5];

    allFaculty(String name){
        this.name = name;

        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 20);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome  "+name, JLabel.CENTER);
        welcome.setBounds(10, 10, 1480, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        int i=0, j=0;
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from Faculty");
            while (rs.next()){
                y[i][j++] = rs.getString("ID");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("AADHAAR");
                y[i][j++] = rs.getString("Qualification");
                y[i][j++] = rs.getString("Post");
                i++;
                j = 0;
            }
            table = new JTable(y, x);
        }catch (Exception e){e.printStackTrace();}

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 80, 787, 620);
        frame.add(sp);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(350, 720, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new allFaculty("Happy");
    }
}
