package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class teachers_front implements ActionListener {
    JFrame frame;
    String id;
    JButton exit, studentp;
    teachers_front(String id){
        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        this.id = id;

        frame = new JFrame("WELCOME TEACHER");
        frame.setLocation(300, 20);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel l1 = new JLabel("ID");
        l1.setFont(font1);
        l1.setBounds(50, 100, 300, 30);
        frame.add(l1);
        JLabel id_ = new JLabel();
        id_.setFont(font2);
        id_.setBounds(400, 100, 300, 30);
        frame.add(id_);

        JLabel l2 = new JLabel("Name");
        l2.setFont(font1);
        l2.setBounds(50, 150, 300, 30);
        frame.add(l2);
        JLabel name_ = new JLabel();
        name_.setFont(font2);
        name_.setBounds(400, 150, 300, 30);
        frame.add(name_);

        JLabel l3 = new JLabel("AADHAAR No.");
        l3.setFont(font1);
        l3.setBounds(50, 200, 300, 30);
        frame.add(l3);
        JLabel aadhaar_ = new JLabel();
        aadhaar_.setFont(font2);
        aadhaar_.setBounds(400, 200, 300, 30);
        frame.add(aadhaar_);

        JLabel l4 = new JLabel("Qualification");
        l4.setFont(font1);
        l4.setBounds(50, 250, 300, 30);
        frame.add(l4);
        JLabel qualification_ = new JLabel();
        qualification_.setFont(font2);
        qualification_.setBounds(400, 250, 300, 30);
        frame.add(qualification_);

        JLabel l5 = new JLabel("Password");
        l5.setFont(font1);
        l5.setBounds(50, 300, 300, 30);
        frame.add(l5);
        JLabel password_ = new JLabel();
        password_.setFont(font2);
        password_.setBounds(400, 300, 300, 30);
        frame.add(password_);

        JLabel l6 = new JLabel("Salary");
        l6.setFont(font1);
        l6.setBounds(50, 350, 300, 30);
        frame.add(l6);
        JLabel salary_ = new JLabel();
        salary_.setFont(font2);
        salary_.setBounds(400, 350, 300, 30);
        frame.add(salary_);

        JLabel l7 = new JLabel("Subject 1");
        l7.setFont(font1);
        l7.setBounds(50, 400, 300, 30);
        frame.add(l7);
        JLabel sub1 = new JLabel();
        sub1.setFont(font2);
        sub1.setBounds(400, 400, 300, 30);
        frame.add(sub1);

        JLabel l8 = new JLabel("Subject 2");
        l8.setFont(font1);
        l8.setBounds(50, 450, 300, 30);
        frame.add(l8);
        JLabel sub2 = new JLabel();
        sub2.setFont(font2);
        sub2.setBounds(400, 450, 300, 30);
        frame.add(sub2);

        JLabel l9 = new JLabel("Subject 3");
        l9.setFont(font1);
        l9.setBounds(50, 500, 300, 30);
        frame.add(l9);
        JLabel sub3 = new JLabel();
        sub3.setFont(font2);
        sub3.setBounds(400, 500, 300, 30);
        frame.add(sub3);

        JLabel l10 = new JLabel("Subject 4");
        l10.setFont(font1);
        l10.setBounds(50, 550, 300, 30);
        frame.add(l10);
        JLabel sub4 = new JLabel();
        sub4.setFont(font2);
        sub4.setBounds(400, 550, 300, 30);
        frame.add(sub4);

        JLabel l11 = new JLabel("Subject 5");
        l11.setFont(font1);
        l11.setBounds(50, 600, 300, 30);
        frame.add(l11);
        JLabel sub5 = new JLabel();
        sub5.setFont(font2);
        sub5.setBounds(400, 600, 300, 30);
        frame.add(sub5);

        studentp = new JButton("Student Information");
        studentp.setBackground(Color.BLUE);
        studentp.setForeground(Color.WHITE);
        studentp.setFont(font3);
        studentp.setBounds(100, 700, 300, 40);
        studentp.addActionListener(this);
        frame.add(studentp);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(600, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        String name = null;
        try {
            Conn con = new Conn();
            String q = "Select * from teacher where id='"+id+"'";
            ResultSet rs = con.stmt.executeQuery(q);

            if (rs.next()){
                String n = rs.getString("Name");
                name = "Welcome "+n.toUpperCase();
                id_.setText(rs.getString("ID"));
                name_.setText(rs.getString("Name"));
                aadhaar_.setText(rs.getString("aadhaar"));
                qualification_.setText(rs.getString("qualification"));
                password_.setText(rs.getString("password"));
                salary_.setText(rs.getString("Salary"));
                sub1.setText(rs.getString("class_1"));
                sub2.setText(rs.getString("class_2"));
                sub3.setText(rs.getString("class_3"));
                sub4.setText(rs.getString("class_4"));
                sub5.setText(rs.getString("class_5"));


            }else{
                name = "NO DATA FOUND!!!";
            }

        }catch (Exception e){e.printStackTrace();}

        JLabel welcome = new JLabel(name, JLabel.CENTER);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        welcome.setBounds(10, 10, 780, 50);
        welcome.setForeground(Color.RED);
        frame.add(welcome);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            frame.setVisible(false);
            new user();
        }else if (ae.getSource() == studentp){

        }
    }

    public static void main(String[] args) {
        new teachers_front("797");
    }
}
