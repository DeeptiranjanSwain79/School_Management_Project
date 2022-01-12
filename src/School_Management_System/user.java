package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class user implements ActionListener{
    JFrame frame;
    JButton student, parents, teacher, faculties;

    user(){
        frame = new JFrame("USER LOGIN");
        frame.setBounds(300, 200, 800, 500);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/enter.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);

        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 800, 500);
        frame.add(img);

        student = new JButton("Student Login");
        student.setBackground(Color.BLUE);
        student.setForeground(Color.WHITE);
        student.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        student.setBounds(50, 100, 200, 50);
        student.addActionListener(this);
        img.add(student);

        parents = new JButton("Parents Login");
        parents.setBackground(Color.GREEN);
        parents.setForeground(Color.BLACK);
        parents.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        parents.setBounds(50, 300, 200, 50);
        parents.addActionListener(this);
        img.add(parents);

        teacher = new JButton("Teachers Login");
        teacher.setBackground(Color.BLACK);
        teacher.setForeground(Color.WHITE);
        teacher.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        teacher.setBounds(500, 100, 200, 50);
        teacher.addActionListener(this);
        img.add(teacher);

        faculties = new JButton("Faculties Login");
        faculties.setBackground(Color.RED);
        faculties.setForeground(Color.WHITE);
        faculties.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        faculties.setBounds(500, 300, 200, 50);
        faculties.addActionListener(this);
        img.add(faculties);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == student){
            new student_login();
            frame.setVisible(false);
        }else if (ae.getSource() == teacher){
            new teacher_login();
            frame.setVisible(false);
        }else if (ae.getSource() == parents){
            new parents_login();
            frame.setVisible(false);
        }else if (ae.getSource() == faculties){
            new faculties_login();
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new user();
    }
}
