package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class studentFee implements ActionListener{
    JFrame frame;
    JTable t;
    JScrollPane sp;
    JButton exit;
    String cl;
    String x[] = {"ID", "Name", "Class", "Arrears", "Due", "Status", "MOP", "Tr ID"};
    String y[][] = new String[100][8];

    studentFee(String cl){
        this.cl = cl;

        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 10);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Class "+cl, JLabel.CENTER);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        welcome.setBounds(10, 10, 780, 50);
        welcome.setForeground(Color.RED);
        frame.add(welcome);


        int i=0, j=0;
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from fees where class='"+cl+"'");
            while(rs.next()){
                y[i][j++] = rs.getString(1);
                y[i][j++] = rs.getString(2);
                y[i][j++] = rs.getString(3);
                y[i][j++] = rs.getString(4);
                y[i][j++] = rs.getString(5);
                y[i][j++] = rs.getString(6);
                y[i][j++] = rs.getString(7);
                y[i][j++] = rs.getString(8);
                i++;
                j=0;
            }
            t = new JTable(y,x);
        }catch (Exception e){e.printStackTrace();}

        sp = new JScrollPane(t);
        sp.setBounds(0, 80, 787, 600);
        frame.add(sp);

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
        if (ae.getSource() == exit){
            frame.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new studentFee("Nursery");
    }
}
