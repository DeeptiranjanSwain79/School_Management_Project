package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;

public class addTeacher implements ActionListener{
    JFrame frame;
    JButton save, cancel;
    Date dt = new Date();
    int yr = dt.getYear()+1900;
    Random rand = new Random();
    int i = rand.nextInt((999-100)+101);
    String id = yr+"0T"+i;
    JLabel id_, post_;
    JTextField name_, aadhaar_, password_, salary_, cl1, cl2, cl3, cl4, cl5;
    Choice q;
    addTeacher(){
        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("New Teacher Register");
        frame.setBounds(300, 20, 800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel l1 = new JLabel("ID");
        l1.setBounds(500, 50, 100, 40);
        l1.setFont(font1);
        frame.add(l1);
        id_ = new JLabel(id);
        id_.setBounds(600, 50, 200, 40);
        id_.setFont(font2);
        frame.add(id_);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(100, 100, 200, 40);
        l2.setFont(font1);
        frame.add(l2);
        name_ = new JTextField();
        name_.setBounds(350, 100, 200, 40);
        name_.setFont(font2);
        frame.add(name_);

        JLabel l3 = new JLabel("AADHAAR");
        l3.setBounds(100, 150, 200, 40);
        l3.setFont(font1);
        frame.add(l3);
        aadhaar_ = new JTextField();
        aadhaar_.setBounds(350, 150, 200, 40);
        aadhaar_.setFont(font2);
        frame.add(aadhaar_);

        JLabel l4 = new JLabel("Qualification");
        l4.setBounds(100, 200, 200, 40);
        l4.setFont(font1);
        frame.add(l4);
        q = new Choice();
        q.setBounds(350, 200, 200, 40);
        q.setFont(font2);
        q.add("Matriculate");
        q.add("Inter-Mediate");
        q.add("Graduate");
        q.add("Post-Graduate");
        q.add("Doctorate");
        frame.add(q);

        JLabel l5 = new JLabel("Post");
        l5.setBounds(100, 250, 200, 40);
        l5.setFont(font1);
        frame.add(l5);
        post_ = new JLabel("Teacher");
        post_.setBounds(350, 250, 200, 40);
        post_.setFont(font2);
        frame.add(post_);

        JLabel l6 = new JLabel("Password");
        l6.setBounds(100, 300, 200, 40);
        l6.setFont(font1);
        frame.add(l6);
        password_ = new JTextField();
        password_.setBounds(350, 300, 200, 40);
        password_.setFont(font2);
        frame.add(password_);

        JLabel l7 = new JLabel("Salary");
        l7.setBounds(100, 350, 200, 40);
        l7.setFont(font1);
        frame.add(l7);
        salary_ = new JTextField();
        salary_.setBounds(350, 350, 200, 40);
        salary_.setFont(font2);
        frame.add(salary_);

        JLabel l8 = new JLabel("Class 1");
        l8.setBounds(100, 400, 200, 40);
        l8.setFont(font1);
        frame.add(l8);
        cl1 = new JTextField();
        cl1.setBounds(350, 400, 200, 40);
        cl1.setFont(font2);
        frame.add(cl1);

        JLabel l9 = new JLabel("Class 2");
        l9.setBounds(100, 450, 200, 40);
        l9.setFont(font1);
        frame.add(l9);
        cl2 = new JTextField();
        cl2.setBounds(350, 450, 200, 40);
        cl2.setFont(font2);
        frame.add(cl2);

        JLabel l10 = new JLabel("Class 3");
        l10.setBounds(100, 500, 200, 40);
        l10.setFont(font1);
        frame.add(l10);
        cl3 = new JTextField();
        cl3.setBounds(350, 500, 200, 40);
        cl3.setFont(font2);
        frame.add(cl3);

        JLabel l11 = new JLabel("Class 4");
        l11.setBounds(100, 550, 200, 40);
        l11.setFont(font1);
        frame.add(l11);
        cl4 = new JTextField();
        cl4.setBounds(350, 550, 200, 40);
        cl4.setFont(font2);
        frame.add(cl4);

        JLabel l12 = new JLabel("Class 5");
        l12.setBounds(100, 600, 200, 40);
        l12.setFont(font1);
        frame.add(l12);
        cl5 = new JTextField();
        cl5.setBounds(350, 600, 200, 40);
        cl5.setFont(font2);
        frame.add(cl5);

        save = new JButton("Save");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);
        save.setFont(font3);
        save.setBounds(300, 700, 100, 40);
        save.addActionListener(this);
        frame.add(save);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(font3);
        cancel.setBounds(600, 700, 100, 40);
        cancel.addActionListener(this);
        frame.add(cancel);

        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save){
            String query = "insert into faculty (id, name, aadhaar, post, Qualification, password, salary) values ('"+id_.getText()+"'," +
                    "'"+name_.getText()+"', "+aadhaar_.getText()+", 'Teacher', '"+q.getSelectedItem()+"', " +
                    "'"+password_.getText()+"', "+salary_.getText()+")";
            System.out.println(query);
            try {
                Conn con = new Conn();
                con.stmt.executeUpdate(query);

                query = "insert into Teacher values ('"+id+"', '"+name_.getText()+"', '"+aadhaar_.getText()+"', '"+q.getSelectedItem()+"', " +
                        "'"+password_.getText()+"', '"+salary_.getText()+"', '"+cl1.getText()+"', '"+cl2.getText()+"'," +
                        "'"+cl3.getText()+"', '"+cl4.getText()+"', '"+cl5.getText()+"')";
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Stored Successfully");
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addTeacher();
    }
}
