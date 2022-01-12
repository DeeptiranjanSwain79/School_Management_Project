package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;
public class student_login implements ActionListener {
    JFrame frame;
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    Choice c;

    student_login(){
        Font font1 = new Font("FootLight MT", Font.BOLD, 25);
        Font font2 = new Font("Franklin Gothic", Font.BOLD, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("Student Login");
        frame.setBounds(300, 200, 500, 500);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/student1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);

        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 500, 500);
        frame.add(img);

        JLabel title = new JLabel("Student Login", JLabel.CENTER);
        title.setForeground(new Color(231, 84, 128));
        title.setFont(new Font("Elephant", Font.PLAIN, 25));
        title.setBounds(10, 10, 480, 35);
        img.add(title);

        JLabel l1 = new JLabel("ID");
        l1.setBounds(50, 100, 150, 30);
        l1.setFont(font1);
        img.add(l1);

        username = new JTextField();
        username.setFont(font2);
        username.setBounds(230, 100, 200, 30);
        img.add(username);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(50, 180, 150, 30);
        l2.setFont(font1);
        img.add(l2);

        password = new JPasswordField();
        password.setFont(font2);
        password.setBounds(230, 180, 200, 30);
        img.add(password);

        JLabel l3 = new JLabel("Class");
        l3.setBounds(50, 260, 150, 30);
        l3.setFont(font1);
        l3.setForeground(Color.RED);
        img.add(l3);

        c = new Choice();
        c.setBounds(230, 260, 200, 30);
        c.setFont(font2);
        c.add("Nursery");
        c.add("KG");
        for (int i=1; i<=12; i++){
            c.add(String.valueOf(i));
        }
        img.add(c);
//        System.out.println(c.getSelectedItem());

        login = new JButton("Login");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setFont(font3);
        login.setBounds(120, 350, 100, 40);
        login.addActionListener(this);
        img.add(login);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(font3);
        cancel.setBounds(120, 400, 100, 40);
        cancel.addActionListener(this);
        img.add(cancel);

        l1.setForeground(Color.RED);
        l2.setForeground(Color.RED);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            String id = username.getText();
            String password_ = password.getText();
            String class_ = c.getSelectedItem();

            try {
                Conn con = new Conn();
                String q = "Select * from class_"+class_+" where ID='"+id+"'and password='"+password_+"'";
//                System.out.println(q);
                ResultSet rs = con.stmt.executeQuery(q);
                if (rs.next()){
                    new student_front(id, class_);
                    JOptionPane.showMessageDialog(null, "Log in Successful");
                    frame.setVisible(false);
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            frame.setVisible(false);
            new user();
        }
    }

    public static void main(String[] args) {
        new student_login();
    }
}
