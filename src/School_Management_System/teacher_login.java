package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class teacher_login implements ActionListener {
    JFrame frame;
    JTextField username;
    JPasswordField password;
    JButton login, cancel;

    teacher_login(){
        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("Teacher Login");
        frame.setBounds(300, 200, 500, 400);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/teacher_login.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);

        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 500, 400);
        frame.add(img);

        JLabel title = new JLabel("Teacher Login", JLabel.CENTER);
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

        login = new JButton("Login");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setFont(font3);
        login.setBounds(120, 250, 100, 40);
        login.addActionListener(this);
        img.add(login);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(font3);
        cancel.setBounds(120, 320, 100, 40);
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

            try {
                Conn con = new Conn();
                String q = "select * from teacher where ID='"+id+"' and password='"+password_+"'";
//                System.out.println(q);
                ResultSet rs = con.stmt.executeQuery(q);
                if (rs.next()){
                    new teachers_front(id);
                    JOptionPane.showMessageDialog(null, "Logged in Successfully");
                    frame.setVisible(false);
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            frame.setVisible(false);
            new user();
        }
    }

    public static void main(String[] args) {
        new teacher_login();
    }
}

