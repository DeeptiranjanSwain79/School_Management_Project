package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class student_pd implements ActionListener {
    JFrame frame;
    String id, cl, n;
    JButton exit;

    student_pd(String id, String cl, String n){
        this.id = id;
        this.cl = cl;
        this.n = n;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);

        frame = new JFrame("PERSONAL DETAILS");
        frame.setLayout(null);
        frame.setSize(850, 600);
        frame.setLocation(200, 30);

        JLabel welcome = new JLabel("Welcome    "+n, JLabel.CENTER);
        welcome.setForeground(Color.GREEN);
        welcome.setBounds(10, 10, 830, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        JLabel l1 = new JLabel("ID");
        l1.setBounds(50, 70, 300, 30);
        l1.setFont(font1);
        frame.add(l1);
        JLabel id_ = new JLabel();
        id_.setBounds(400, 70, 400, 30);
        id_.setFont(font2);
        frame.add(id_);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 120, 300, 30);
        l2.setFont(font1);
        frame.add(l2);
        JLabel name_ = new JLabel();
        name_.setBounds(400, 120, 400, 30);
        name_.setFont(font2);
        frame.add(name_);

        JLabel l3 = new JLabel("Father's Name");
        l3.setBounds(50, 170, 300, 30);
        l3.setFont(font1);
        frame.add(l3);
        JLabel father_ = new JLabel();
        father_.setBounds(400, 170, 400, 30);
        father_.setFont(font2);
        frame.add(father_);

        JLabel l4 = new JLabel("Mother's Name");
        l4.setBounds(50, 220, 300, 30);
        l4.setFont(font1);
        frame.add(l4);
        JLabel m_ = new JLabel();
        m_.setBounds(400, 220, 400, 30);
        m_.setFont(font2);
        frame.add(m_);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(50, 270, 300, 30);
        l5.setFont(font1);
        frame.add(l5);
        JLabel password_ = new JLabel();
        password_.setBounds(400, 270, 400, 30);
        password_.setFont(font2);
        frame.add(password_);

        JLabel l6 = new JLabel("Roll Number");
        l6.setBounds(50, 320, 300, 30);
        l6.setFont(font1);
        frame.add(l6);
        JLabel roll_ = new JLabel();
        roll_.setBounds(400, 320, 400, 30);
        roll_.setFont(font2);
        frame.add(roll_);

        JLabel l7 = new JLabel("DOB");
        l7.setBounds(50, 370, 300, 30);
        l7.setFont(font1);
        frame.add(l7);
        JLabel dob_ = new JLabel();
        dob_.setBounds(400, 370, 400, 30);
        dob_.setFont(font2);
        frame.add(dob_);

        JLabel l8 = new JLabel("AADHAAR Number");
        l8.setBounds(50, 420, 300, 30);
        l8.setFont(font1);
        frame.add(l8);
        JLabel aadhaar_ = new JLabel();
        aadhaar_.setBounds(400, 420, 400, 30);
        aadhaar_.setFont(font2);
        frame.add(aadhaar_);

        try {
            Conn con = new Conn();
            String q = "Select * from class_"+cl+" where ID='"+id+"'";
            ResultSet rs = con.stmt.executeQuery(q);

            if (rs.next()){
                id_.setText(rs.getString(1));
                name_.setText(rs.getString(2));
                father_.setText(rs.getString(3));
                m_.setText(rs.getString(4));
                password_.setText(rs.getString(5));
                roll_.setText(rs.getString(6));
                dob_.setText(rs.getString(7));
                aadhaar_.setText(rs.getString(8));
            }

        }catch (Exception e){e.printStackTrace();}

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        exit.setBounds(350, 500, 100, 50);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            frame.setVisible(false);
            new student_front(id, cl);
        }
    }

    public static void main(String[] args) {
        new student_pd("", "", "");
    }

}
