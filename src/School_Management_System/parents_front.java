package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class parents_front implements ActionListener {
    JFrame frame;
    JButton exit, result, attendance, complaint;
    String id, cl;

    parents_front(String id, String cl){
        this.id = id;
        this.cl = cl;

        Font font1 = new Font("FootLight MT", Font.BOLD, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("Welcome Parents");
        frame.setBounds(100, 30, 1200, 800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel welcome = new JLabel("WELCOME", JLabel.CENTER);
        welcome.setBounds(10, 10, 980, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        JLabel l1 = new JLabel("Child's ID");
        l1.setBounds(50, 100, 300, 30);
        l1.setFont(font1);
        frame.add(l1);
        JLabel id_ = new JLabel();
        id_.setBounds(400, 100, 300, 30);
        id_.setFont(font2);
        frame.add(id_);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(50, 150, 300, 30);
        l2.setFont(font1);
        frame.add(l2);
        JLabel name_ = new JLabel();
        name_.setBounds(400, 150, 300, 30);
        name_.setFont(font2);
        frame.add(name_);

        JLabel l3 = new JLabel("Father's Name");
        l3.setBounds(50, 200, 300, 30);
        l3.setFont(font1);
        frame.add(l3);
        JLabel father_ = new JLabel();
        father_.setBounds(400, 200, 500, 30);
        father_.setFont(font2);
        frame.add(father_);

        JLabel l4 = new JLabel("Father's Occupation");
        l4.setBounds(50, 250, 300, 30);
        l4.setFont(font1);
        frame.add(l4);
        JLabel father_o = new JLabel();
        father_o.setBounds(400, 250, 500, 30);
        father_o.setFont(font2);
        frame.add(father_o);

        JLabel l5 = new JLabel("Father's AADHHAAR No.");
        l5.setBounds(50, 300, 300, 30);
        l5.setFont(font1);
        frame.add(l5);
        JLabel father_a = new JLabel();
        father_a.setBounds(400, 300, 500, 30);
        father_a.setFont(font2);
        frame.add(father_a);

        JLabel l6 = new JLabel("Mother's Name");
        l6.setBounds(50, 350, 300, 30);
        l6.setFont(font1);
        frame.add(l6);
        JLabel mother_ = new JLabel();
        mother_.setBounds(400, 350, 500, 30);
        mother_.setFont(font2);
        frame.add(mother_);

        JLabel l7 = new JLabel("Mother's Occupation");
        l7.setBounds(50, 400, 300, 30);
        l7.setFont(font1);
        frame.add(l7);
        JLabel mother_o = new JLabel();
        mother_o.setBounds(400, 400, 500, 30);
        mother_o.setFont(font2);
        frame.add(mother_o);

        JLabel l8 = new JLabel("Mother's AADHHAAR No.");
        l8.setBounds(50, 450, 450, 30);
        l8.setFont(font1);
        frame.add(l8);
        JLabel mother_a = new JLabel();
        mother_a.setBounds(400, 450, 500, 30);
        mother_a.setFont(font2);
        frame.add(mother_a);

        JLabel l9 = new JLabel("Guardian's Name");
        l9.setBounds(50, 500, 500, 30);
        l9.setFont(font1);
        frame.add(l9);
        JLabel guardian_ = new JLabel();
        guardian_.setBounds(400, 500, 500, 30);
        guardian_.setFont(font2);
        frame.add(guardian_);

        JLabel l10 = new JLabel("Guardian's Occupation");
        l10.setBounds(50, 550, 300, 30);
        l10.setFont(font1);
        frame.add(l10);
        JLabel guardian_o = new JLabel();
        guardian_o.setBounds(400, 550, 500, 30);
        guardian_o.setFont(font2);
        frame.add(guardian_o);

        JLabel l11 = new JLabel("Guardian's AADHHAAR No.");
        l11.setBounds(50, 600, 300, 30);
        l11.setFont(font1);
        frame.add(l11);
        JLabel guardian_a = new JLabel();
        guardian_a.setBounds(400, 600, 500, 30);
        guardian_a.setFont(font2);
        frame.add(guardian_a);

        try {
            Conn con = new Conn();
            String q = "select * from Parents where child_id='"+id+"' and Class='"+cl+"'";
            ResultSet rs = con.stmt.executeQuery(q);

            while (rs.next()){
                id_.setText(rs.getString(1));
                name_.setText(rs.getString(2));
                father_.setText(rs.getString(3));
                father_o.setText(rs.getString(4));
                father_a.setText(rs.getString(5));
                mother_.setText(rs.getString(6));
                mother_o.setText(rs.getString(7));
                mother_a.setText(rs.getString(8));
                guardian_.setText(rs.getString(9));
                guardian_o.setText(rs.getString(10));
                guardian_a.setText(rs.getString(11));

            }

        }catch (Exception e){e.printStackTrace();}

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.BLACK);
        exit.setFont(font3);
        exit.setBounds(350, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        result = new JButton("Result");
        result.setBackground(Color.GREEN);
        result.setForeground(Color.BLACK);
        result.setFont(font3);
        result.setBounds(950, 300, 150, 40);
        result.addActionListener(this);
        frame.add(result);

        attendance = new JButton("Attendance");
        attendance.setBackground(Color.BLUE);
        attendance.setForeground(Color.WHITE);
        attendance.setFont(font3);
        attendance.setBounds(1000, 500, 150, 40);
        attendance.addActionListener(this);
        frame.add(attendance);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            frame.setVisible(false);
            new parents_login();
        }else if (ae.getSource() == result){
            frame.setVisible(false);
            new result(id, cl, "Mr./Ms.");
        }else if (ae.getSource() == attendance){
            frame.setVisible(false);
            new student_attendance(id, cl, "Mr./Ms.");
        }
    }

    public static void main(String[] args) {
        new parents_front("797", "9");
    }
}
