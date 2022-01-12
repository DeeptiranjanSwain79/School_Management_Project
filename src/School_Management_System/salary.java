package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class salary implements ActionListener{
    JFrame frame;
    Choice id_;
    JButton exit, pay;
    String name;
    String x[] = {"ID", "Name", "Year", "Month", "Status"};
    String y[][] = new String[100][5];
    JTable t;
    JScrollPane sp;

    salary(String name){
        this.name = name;

        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 10);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome "+name, JLabel.CENTER);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        welcome.setBounds(10, 10, 780, 50);
        welcome.setForeground(Color.RED);
        frame.add(welcome);

        int i=0, j=0;
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from salary");
            while(rs.next()){

                y[i][j++] = rs.getString(1);
                y[i][j++] = rs.getString(2);
                y[i][j++] = rs.getString(3);
                y[i][j++] = rs.getString(4);
                y[i][j++] = rs.getString(5);
                i++;
                j=0;
            }
            t = new JTable(y, x);
        }catch (Exception e){e.printStackTrace(); }

        sp = new JScrollPane(t);
        sp.setBounds(0, 100, 787, 500);
        frame.add(sp);

        pay = new JButton("Pay");
        pay.setBounds(350, 650, 100, 40);
        pay.setFont(font3);
        pay.setBackground(Color.GREEN);
        pay.setForeground(Color.BLACK);
        pay.addActionListener(this);
        frame.add(pay);

        exit = new JButton("Exit");
        exit.setBounds(300, 710, 100, 40);
        exit.setFont(font3);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == pay){
            try {
                Conn con = new Conn();
                con.stmt.executeUpdate("update salary set status='Paid' where status='Unpaid'");
                JOptionPane.showMessageDialog(null, "Amount Transferred successfully");
                frame.setVisible(true);
                new salary(name);
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == exit){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new salary("Happy");
    }
}
