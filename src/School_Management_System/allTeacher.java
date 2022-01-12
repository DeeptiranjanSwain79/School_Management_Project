package School_Management_System;

import javax.swing.*;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;

public class allTeacher implements ActionListener{
    JFrame frame;
    String name;
    JButton exit;
    String x[] = {"ID", "Name", "AADHAAR", "Qualification", "Class 1", "Class 2", "Class 3", "Class 4", "Class 5"};
    String y[][] = new String[100][9];
    JTable table;


    allTeacher(String name){
        this.name = name;

        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 20);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome  "+name, JLabel.CENTER);
        welcome.setBounds(10, 10, 780, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        int i = 0, j = 0;
        try {
            Conn con = new Conn();
            String q = "select * from teacher";
            ResultSet rs = con.stmt.executeQuery(q);
            while (rs.next()) {
                y[i][j++] = rs.getString("ID");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("AADHAAR");
                y[i][j++] = rs.getString("Qualification");
                y[i][j++] = rs.getString("Class_1");
                y[i][j++] = rs.getString("Class_2");
                y[i][j++] = rs.getString("Class_3");
                y[i][j++] = rs.getString("Class_4");
                y[i][j++] = rs.getString("Class_5");
                i++;
                j=0;

            }
            table = new JTable(y,x);
        } catch (Exception ex) {ex.printStackTrace();}

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,80, 787, 600);
        frame.add(sp);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(300, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);


        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new allTeacher("");
    }
}
