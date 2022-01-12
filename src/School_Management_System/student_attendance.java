package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;

public class student_attendance implements ActionListener {
    String id, cl, n;
    JFrame frame;
    JButton exit, show;
    Choice c1, c2;
    JLabel l1, l2, l3, percent, year, month, no;

    student_attendance(String id, String cl, String n){
        Date dt = new Date();
        int yr = dt.getYear() + 1900;

        this.id = id;
        this.cl = cl;
        this.n = n;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("ATTENDANCE");
        frame.setBounds(200, 0, 800, 500);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel welcome = new JLabel("Welcome  "+n, JLabel.CENTER);
        welcome.setBounds(10, 10, 780, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        c1 = new Choice();
        c1.setFont(font1);
        c1.setBounds(50, 100, 200, 30);
        for (int i=2021; i<=yr; i++){
            c1.add(String.valueOf(i));
        }
        frame.add(c1);

        c2 = new Choice();
        c2.setFont(font1);
        c2.setBounds(300, 100, 300, 30);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        frame.add(c2);

        l1 = new JLabel("Year");
        l1.setBounds(50, 150, 300, 30);
        l1.setFont(font1);
        frame.add(l1);
        year = new JLabel();
        year.setBounds(400, 150, 300, 30);
        year.setFont(font2);
        l1.setVisible(false);
        year.setVisible(false);
        frame.add(year);

        l2 = new JLabel("Month");
        l2.setBounds(50, 200, 300, 30);
        l2.setFont(font1);
        frame.add(l2);
        month = new JLabel();
        month.setBounds(400, 200, 300, 30);
        month.setFont(font2);
        l2.setVisible(false);
        month.setVisible(false);
        frame.add(month);

        l3 = new JLabel("Attendance");
        l3.setBounds(50, 250, 300, 30);
        l3.setFont(font1);
        frame.add(l3);
        percent = new JLabel();
        percent.setBounds(400, 250, 300, 30);
        percent.setFont(font2);
        l3.setVisible(false);
        percent.setVisible(false);
        frame.add(percent);

        no = new JLabel("NO DATA FOUND!!!", JLabel.CENTER);
        no.setBounds(150, 350, 500, 30);
        no.setFont(font1);
        frame.add(no);
        no.setForeground(Color.RED);
        no.setVisible(false);

        show = new JButton("Show");
        show.setBackground(Color.BLUE);
        show.setForeground(Color.WHITE);
        show.setFont(font3);
        show.setBounds(650, 100, 100, 40);
        show.addActionListener(this);
        frame.add(show);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(250, 400, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);


        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == show){
            try {
                Conn con = new Conn();
                String q = "select * from class"+cl+"_attendance where id='"+id+"' and year='"+c1.getSelectedItem()+"' and month='"+c2.getSelectedItem()+"'";
//                System.out.println(q);
                ResultSet rs = con.stmt.executeQuery(q);
                if (rs.next()){
                    l1.setVisible(true);
                    l2.setVisible(true);
                    l3.setVisible(true);

                    year.setVisible(true);
                    month.setVisible(true);
                    percent.setVisible(true);

                    year.setText(rs.getString(3));
                    month.setText(rs.getString(4));
                    percent.setText(rs.getString(5));

                }else{
                    no.setVisible(true);
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == exit){
            frame.setVisible(false);
            new student_front(id, cl);
        }
    }

    public static void main(String[] args) {
        new student_attendance("", "", "");
    }
}
