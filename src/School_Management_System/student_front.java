package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;


public class student_front implements ActionListener {
    JFrame frame;
    JButton attendance, result, pd;
    String id, cl;
    String n = null;
    student_front(String id, String cl){
        this.id = id;
        this.cl = cl;

        frame = new JFrame("Welcome");
        frame.setSize(600, 500);
        frame.setLocation(450, 250);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/student.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);

        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 600, 500);
        frame.add(img);

        String text = "Welcome";

        try {
            Conn con = new Conn();
            String q = "select * from class_"+cl+" where ID='"+id+"'";
//            System.out.println(q);
            ResultSet rs = con.stmt.executeQuery(q);
            if (rs.next()){
                String s = rs.getString("Name");
                n = s.toUpperCase();
                text = "Welcome "+n;
            }
        }catch (Exception e){e.printStackTrace();}

        JLabel title = new JLabel(text, JLabel.CENTER);
        title.setBounds(10, 10, 580, 70);
        title.setFont(new Font("Elephant", Font.BOLD, 25));
        title.setForeground(Color.RED);
        img.add(title);

        attendance = new JButton("Attendance");
        attendance.setBackground(Color.BLUE);
        attendance.setForeground(Color.WHITE);
        attendance.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        attendance.setBounds(200, 100, 200, 50);
        attendance.addActionListener(this);
        img.add(attendance);

        result = new JButton("Result");
        result.setBackground(Color.GREEN);
        result.setForeground(Color.BLACK);
        result.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        result.setBounds(200, 215, 200, 50);
        result.addActionListener(this);
        img.add(result);

        pd = new JButton("Personal Details");
        pd.setBackground(Color.BLACK);
        pd.setForeground(Color.WHITE);
        pd.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        pd.setBounds(150, 350, 300, 50);
        pd.addActionListener(this);
        img.add(pd);


        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == pd){
            new student_pd(id, cl, n);
            frame.setVisible(false);
        }else if (ae.getSource() == result){
            new result(id, cl, n);
            frame.setVisible(false);
        }else if (ae.getSource() == attendance){
            new student_attendance(id, cl, n);
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new student_front("", "");
    }

}
