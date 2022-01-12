package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;

public class studentAttendance implements ActionListener {
    JFrame frame;
    String x[] = {"ID", "Name", "Percentage"};
    String y[][] = new String[100][3];
    JTable table;
    JScrollPane sp;
    String name, cl;
    Choice yr, month;
    JButton exit, show;
    JLabel y1, m;
    int i = 0, j = 0;

    studentAttendance(String name, String cl){
        Date dt = new Date();
        int year = dt.getYear() + 1900;

        this.name = name;
        this.cl = cl;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 20);
        frame.setSize(1000, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome  "+name, JLabel.CENTER);
        welcome.setBounds(10, 10, 980, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        y1 = new JLabel("Year");
        y1.setFont(font1);
        y1.setBounds(50, 100, 100, 30);
        frame.add(y1);
        yr = new Choice();
        yr.setBounds(200, 100, 200, 30);
        yr.setFont(font2);
        for (int i=2021; i<=year; i++){
            yr.add(String.valueOf(i));
        }
        frame.add(yr);

        m = new JLabel("Month");
        m.setFont(font1);
        m.setBounds(450, 100, 100, 30);
        frame.add(m);
        month = new Choice();
        month.setFont(font2);
        month.setBounds(600, 100, 200, 30);
        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");
        frame.add(month);

        show = new JButton("Show");
        show.setBackground(Color.BLUE);
        show.setForeground(Color.WHITE);
        show.setFont(font3);
        show.setBounds(850, 100, 100, 40);
        show.addActionListener(this);
        frame.add(show);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(450, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == show){
            try {
                Conn con = new Conn();
                String q = "select * from class"+cl+"_attendance where year='"+yr.getSelectedItem()+"' and month='"+month.getSelectedItem()+"'";
                ResultSet rs = con.stmt.executeQuery(q);
                System.out.println(q);

                while (rs.next()){
                    y[i][j++] = rs.getString(1);
                    y[i][j++] = rs.getString(2);
                    y[i][j++] = rs.getString(5);
                    i++;
                    j=0;
                }

                table = new JTable(y,x);

            }catch (Exception e){e.printStackTrace();}

            sp = new JScrollPane(table);
            sp.setBounds(0, 200, 987, 400);
            sp.setFont(new Font("Franklin Gothic", Font.PLAIN, 25));
            frame.add(sp);
            frame.setVisible(true);
        }else if (ae.getSource() == exit){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentAttendance("", "9");
    }
}
