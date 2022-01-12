package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class dataEntry implements ActionListener{
    JFrame frame;
    String id, name;
    JButton student, faculty, teacher, student11;

    dataEntry(String id, String name){
        this.id = id;
        this.name = name;

        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("DATA ENTRY OPERATOR");
        frame.setBounds(300, 200, 500, 350);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        student = new JButton("Student");
        student.setBackground(Color.BLUE);
        student.setForeground(Color.WHITE);
        student.setFont(font3);
        student.setBounds(200, 70, 100, 40);
        student.addActionListener(this);
        frame.add(student);

        student11 = new JButton("11th Student");
        student11.setBackground(Color.BLUE);
        student11.setForeground(Color.WHITE);
        student11.setFont(font3);
        student11.setBounds(400, 70, 100, 40);
        student11.addActionListener(this);
        frame.add(student11);


        faculty = new JButton("Faculty");
        faculty.setBackground(Color.GREEN);
        faculty.setForeground(Color.BLACK);
        faculty.setFont(font3);
        faculty.setBounds(200, 150, 100, 40);
        faculty.addActionListener(this);
        frame.add(faculty);

        teacher = new JButton("Teacher");
        teacher.setBackground(Color.BLACK);
        teacher.setForeground(Color.WHITE);
        teacher.setFont(font3);
        teacher.setBounds(200, 225, 100, 40);
        teacher.addActionListener(this);
        frame.add(teacher);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == student){
            new addStudent();
        }if (ae.getSource() == student11){
            new addStudent11();
        }else if (ae.getSource() == faculty){
            new addFaculty();
        }else if(ae.getSource() == teacher){
//            new addTeacher();
        }
    }

    public static void main(String[] args) {
        new dataEntry("", "");
    }
}
