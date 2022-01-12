package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class accountant implements ActionListener{
    JFrame frame;
    String id, name;
    JButton fee, salary, search, sfee;
    JTextField tf;
    Choice c;

    accountant(String id, String name){
        this.id = id;
        this.name = name;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 100);
        frame.setSize(800, 700);
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
            String q = "Select * from faculty where id='"+id+"' and Post='Accountant'";
            ResultSet rs = con.stmt.executeQuery(q);
            System.out.println(q);

            if (rs.next()){
                id_.setText(id);
                name_.setText(rs.getString("Name"));
                aadhaar_.setText(rs.getString("AADHAAR"));
                qualification_.setText(rs.getString("Qualification"));
                password_.setText(rs.getString("Password"));
            }
        }catch (Exception e){e.printStackTrace();}

        fee = new JButton("Fees");
        fee.setBackground(Color.BLUE);
        fee.setForeground(Color.WHITE);
        fee.setFont(font3);
        fee.setBounds(100, 400, 200, 40);
        fee.addActionListener(this);
        frame.add(fee);

        salary = new JButton("Salary");
        salary.setBackground(Color.GREEN);
        salary.setForeground(Color.BLACK);
        salary.setFont(font3);
        salary.setBounds(500, 400, 200, 40);
        salary.addActionListener(this);
        frame.add(salary);

        tf = new JTextField();
        tf.setBounds(100, 500, 270, 40);
        tf.setFont(font2);
        frame.add(tf);
        tf.setVisible(false);

        search = new JButton("Search");
        search.setBounds(400, 500, 100, 40);
        search.setFont(font3);
        search.setBackground(Color.ORANGE);
        search.setForeground(Color.BLACK);
        search.addActionListener(this);
        frame.add(search);
        search.setVisible(false);

        c = new Choice();
        c.setBounds(200, 600, 150, 40);
        c.setFont(font1);
        c.add("Nursery");
        c.add("KG");
        for (int i=1; i<=12; i++){
            c.add(String.valueOf(i));
        }
        frame.add(c);
        c.setVisible(false);

        sfee = new JButton("Student Fee");
        sfee.setBounds(400, 600, 200, 40);
        sfee.setFont(font3);
        sfee.setBackground(Color.GRAY);
        sfee.setForeground(Color.WHITE);
        frame.add(sfee);
        sfee.addActionListener(this);
        sfee.setVisible(false);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == fee){
            tf.setVisible(true);
            search.setVisible(true);
            c.setVisible(true);
            sfee.setVisible(true);
        }else if (ae.getSource() == salary){
            new salary(name);
        }else if (ae.getSource() == search){
            try {
                Conn con = new Conn();
                String q = "Select * from student where id='"+tf.getText()+"'";
                ResultSet rs = con.stmt.executeQuery(q);
                System.out.println(q);
                if (rs.next()){
                    String cl = rs.getString("Current_Class");
                    new fees(name, cl, tf.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "No student found with ID: "+tf.getText());
                }

            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == sfee){
            new studentFee(c.getSelectedItem());
        }

    }

    public static void main(String[] args) {
        new accountant("", "");
    }
}
