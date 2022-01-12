package School_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class studentResult implements ActionListener {
    JFrame frame;
    JButton exit;
    String id, name, cl;
    JTable t;
    String x[];
    String y[][];

    studentResult(String id, String name, String cl){
        this.id = id;
        this.name = name;
        this.cl = cl;

        if (cl.equalsIgnoreCase("Nursery")){
            x = new String[]{"ID", "Name", "Exam Name", "Nursery English", "Nursery Mathematics", "Arts & Crafts", "Nursery EVS", "Rhymes & Stories", "General Activity", "Total", "Percentage"};
            y = new String[100][11];
        }else if (cl.equalsIgnoreCase("KG")){
            x = new String[]{"ID", "Name", "Exam Name", "ODIA", "English", "Mathematics", "Arts", "EVS", "General Awareness", "Total", "Percentage"};
            y = new String[100][11];
        }
        switch (cl){
            case "1":x = new String[]{"ID", "Name", "Exam Name", "ODIA", "English", "Mathematics", "Arts", "EVS", "General Knowledge", "Total", "Percentage"};
                    y = new String[100][11];break;

            case "2":
            case "3":
            case "4":
            case "5":
            case "6":x = new String[]{"ID", "Name", "Exam Name", "ODIA", "English", "Mathematics", "Arts", "EVS", "General Knowledge", "Physical Education", "Total", "Percentage"};
                    y = new String[100][12];break;

            case "7":
            case "8":
            case "9":
            case "10": x = new String[]{"ID", "Name", "Exam Name", "ODIA", "English", "Sanskrit/Hindi", "Mathematics", "Science","Social Science", "Programming", "Physical Education", "Total", "Percentage"};
                       y = new String[100][13];break;
            case "11":
            case "12":x = new String[]{"ID", "Name", "Exam Name", "MIL", "English", "First Elective", "Second Elective", "Third Elective","Fourth Elective", "Total", "Percentage"};
                      y = new String[100][11];  break;

        }

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(10, 20);
        frame.setSize(1500, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome  "+name, JLabel.CENTER);
        welcome.setBounds(10, 10, 1480, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);


        try {
            Conn con = new Conn();
            String q = "Select * from class"+cl+"_Results";
            System.out.println(q);
            ResultSet rs = con.stmt.executeQuery(q);
            int i=0, j=0;

            while (rs.next()){
                y[i][j++] = rs.getString("ID");
                y[i][j++] = rs.getString("Name");
                y[i][j++] = rs.getString("Exam_name");
                y[i][j++] = rs.getString(4);
                y[i][j++] = rs.getString(5);
                y[i][j++] = rs.getString(6);
                y[i][j++] = rs.getString(7);
                y[i][j++] = rs.getString(8);
                y[i][j++] = rs.getString(9);
                y[i][j++] = rs.getString(10);
                y[i][j++] = rs.getString(11);
                if ((cl == "2") || (cl == "3") || (cl == "4") || (cl == "5") || (cl == "6") || (cl=="7") || (cl=="8") || (cl=="9") || (cl=="10")){
                    y[i][j++] = rs.getString(12);
                    if ((cl=="7") || (cl=="8") || (cl=="9") || (cl=="10")){
                        y[i][j++] = rs.getString(13);
                    }
                }
                i++;
                j=0;
            }

            t = new JTable(y, x); //JTable table = new JTable(data, columnNames);

        }catch (Exception e){e.printStackTrace();}

        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(0, 100, 1487, 550);
        sp.setFont(font1);
        frame.add(sp);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(700, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new studentResult("", "", "");
    }
}
