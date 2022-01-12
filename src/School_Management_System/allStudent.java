package School_Management_System;

import java.sql.ResultSet;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class allStudent implements ActionListener {
    JFrame frame;
    JTable t;
    String x[] = {"ID", "Name", "Father", "Mother", "Roll", "DOB", "AADHAAR"};
    String y[][] = new String[100][8];
    int i=0, j=0;
    String name, cl, id;
    JButton exit, result, attendance;

    allStudent(String id, String name, String cl){
        this.name = name;
        this.cl = cl;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);


        frame = new JFrame("WELCOME");
        frame.setLocation(150, 20);
        frame.setSize(1200, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome  "+name, JLabel.CENTER);
        welcome.setBounds(10, 10, 1180, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);


        try {
            Conn con = new Conn();
            String q = "Select * from class_"+cl+"";
            System.out.println(q);
            ResultSet rs = con.stmt.executeQuery(q);

            while (rs.next()){
                y[i][j++] = rs.getString("ID");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("Father");
                y[i][j++] = rs.getString("Mother");
                y[i][j++] = rs.getString("Roll");
                y[i][j++] = rs.getString("DOB");
                y[i][j++] = rs.getString("AADHAAR");
                System.out.println(i);
                i++;
                j=0;
            }
            t = new JTable(y, x); //JTable table = new JTable(data, columnNames);
            t.setVisible(true);

        }catch (Exception e){e.printStackTrace();}

        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(0, 100, 1200, 550);
        sp.setFont(font1);
        frame.add(sp);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(950, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        result = new JButton("Result");
        result.setBackground(Color.green);
        result.setForeground(Color.BLACK);
        result.setFont(font3);
        result.setBounds(550, 700, 100, 40);
        result.addActionListener(this);
        frame.add(result);

        attendance = new JButton("Attendance");
        attendance.setBackground(Color.BLUE);
        attendance.setForeground(Color.WHITE);
        attendance.setFont(font3);
        attendance.setBounds(50, 700, 200, 40);
        attendance.addActionListener(this);
        frame.add(attendance);

        frame.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == attendance){
            new studentAttendance(name, cl);
        }else if(ae.getSource() == result){
            new studentResult(id, name, cl);
        }else if(ae.getSource() == exit){
            frame.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new allStudent("797", "Happy", "Nursery");
    }
}
