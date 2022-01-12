package School_Management_System;

import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class principal implements ActionListener {
    JFrame frame;
    String id, name, cl;
    JButton exit, teacher, student, faculty;
    Choice c;

    principal(String id, String name){
        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        this.id = id;
        this.name = name;

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 20);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome "+name, JLabel.CENTER);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        welcome.setBounds(10, 10, 780, 50);
        welcome.setForeground(Color.RED);
        frame.add(welcome);


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

        try {
            Conn con = new Conn();
            String q = "Select * from faculty where id='"+id+"' and Post='Principal'";
            ResultSet rs = con.stmt.executeQuery(q);
            System.out.println(q);

            if (rs.next()){
                id_.setText(id);
                name_.setText(name);
                aadhaar_.setText(rs.getString("AADHAAR"));
                qualification_.setText(rs.getString("Qualification"));
                password_.setText(rs.getString("Password"));
            }
        }catch (Exception e){e.printStackTrace();}

        c = new Choice();
        c.setBounds(50, 400, 200, 30);
        c.setFont(new Font("Footlight MT", Font.PLAIN, 20));
        c.add("Nursery");
        c.add("KG");
        for (int i=1; i<=12; i++){
            c.add(String.valueOf(i));
        }
        frame.add(c);

        student = new JButton("Student");
        student.setBackground(Color.BLUE);
        student.setForeground(Color.WHITE);
        student.setFont(font3);
        student.setBounds(300, 400, 200, 40);
        student.addActionListener(this);
        frame.add(student);

        teacher = new JButton("Teacher");
        teacher.setBackground(Color.GREEN);
        teacher.setForeground(Color.BLACK);
        teacher.setFont(font3);
        teacher.setBounds(300, 500, 200, 40);
        teacher.addActionListener(this);
        frame.add(teacher);

        faculty = new JButton("Faculty");
        faculty.setBackground(Color.CYAN);
        faculty.setForeground(Color.BLACK);
        faculty.setFont(font3);
        faculty.setBounds(300, 600, 200, 40);
        faculty.addActionListener(this);
        frame.add(faculty);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(300, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == teacher){
             new allTeacher(name);
        }else if (ae.getSource() == student){
            cl = c.getSelectedItem();
            new allStudent(id, name, cl);
        } else if (ae.getSource() == faculty){
            new allFaculty(name);
        }else if (ae.getSource() == exit){
            new faculties_login();
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new principal("", "");
    }
}
