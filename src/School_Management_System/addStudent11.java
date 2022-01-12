package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.util.Random;

public class addStudent11 implements ActionListener{
    JFrame frame;
    JButton save, cancel;
    Date dt = new Date();
    int yr = dt.getYear()+1900;
    JLabel id_, l1;
    JTextField  name_, father_, mother_, password_, roll_, dob_, aadhaar_, mil_, fse_, se_, te_, fe_;
    String cl;

    addStudent11(){
        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("New Student Register");
        frame.setBounds(300, 20, 800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        Random rand = new Random();
        int i = rand.nextInt((999-100)+1)+100;
        String id=yr+"11"+i;
        System.out.println(id);

        l1 = new JLabel("ID");
        l1.setBounds(500, 50, 100, 40);
        l1.setFont(font1);
//        l1.setVisible(false);
        frame.add(l1);
        id_ = new JLabel(id);
        id_.setBounds(600, 50, 200, 40);
        id_.setFont(font2);
        frame.add(id_);
//        id_.setVisible(false);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(150, 100, 100, 40);
        l2.setFont(font1);
        frame.add(l2);
        name_ = new JTextField();
        name_.setBounds(300, 100, 200, 40);
        name_.setFont(font2);
        frame.add(name_);

        JLabel l3 = new JLabel("Father");
        l3.setBounds(150, 150, 100, 40);
        l3.setFont(font1);
        frame.add(l3);
        father_ = new JTextField();
        father_.setBounds(300, 150, 200, 40);
        father_.setFont(font2);
        frame.add(father_);

        JLabel l4 = new JLabel("Mother");
        l4.setBounds(150, 200, 100, 40);
        l4.setFont(font1);
        frame.add(l4);
        mother_ = new JTextField();
        mother_.setBounds(300, 200, 200, 40);
        mother_.setFont(font2);
        frame.add(mother_);

        JLabel l5 = new JLabel("Password");
        l5.setBounds(150, 250, 100, 40);
        l5.setFont(font1);
        frame.add(l5);
        password_ = new JTextField();
        password_.setBounds(300, 250, 200, 40);
        password_.setFont(font2);
        frame.add(password_);

        JLabel l6 = new JLabel("Roll");
        l6.setBounds(150, 300, 100, 40);
        l6.setFont(font1);
        frame.add(l6);
        roll_ = new JTextField();
        roll_.setBounds(300, 300, 200, 40);
        roll_.setFont(font2);
        frame.add(roll_);

        JLabel l7 = new JLabel("DOB");
        l7.setBounds(150, 350, 100, 40);
        l7.setFont(font1);
        frame.add(l7);
        dob_ = new JTextField();
        dob_.setBounds(300, 350, 200, 40);
        dob_.setFont(font2);
        frame.add(dob_);

        JLabel l8 = new JLabel("AADHAAR");
        l8.setBounds(150, 400, 100, 40);
        l8.setFont(font1);
        frame.add(l8);
        aadhaar_ = new JTextField();
        aadhaar_.setBounds(300, 400, 200, 40);
        aadhaar_.setFont(font2);
        frame.add(aadhaar_);

        JLabel l9 = new JLabel("MIL");
        l9.setBounds(50, 450, 100, 40);
        l9.setFont(font1);
        frame.add(l9);
        mil_ = new JTextField();
        mil_.setBounds(200, 450, 200, 40);
        mil_.setFont(font2);
        frame.add(mil_);

        JLabel l10 = new JLabel("1st Elective");
        l10.setBounds(450, 500, 100, 40);
        l10.setFont(font1);
        frame.add(l10);
        fse_ = new JTextField();
        fse_.setBounds(550, 500, 200, 40);
        fse_.setFont(font2);
        frame.add(fse_);

        JLabel l11 = new JLabel("2nd Elective");
        l11.setBounds(50, 550, 100, 40);
        l11.setFont(font1);
        frame.add(l11);
        se_ = new JTextField();
        se_.setBounds(200, 550, 200, 40);
        se_.setFont(font2);
        frame.add(se_);

        JLabel l12 = new JLabel("3rd Elective");
        l12.setBounds(450, 550, 100, 40);
        l12.setFont(font1);
        frame.add(l12);
        te_ = new JTextField();
        te_.setBounds(550, 550, 200, 40);
        te_.setFont(font2);
        frame.add(te_);

        JLabel l13 = new JLabel("4th Elective");
        l13.setBounds(450, 600, 100, 40);
        l13.setFont(font1);
        frame.add(l13);
        fe_ = new JTextField();
        fe_.setBounds(550, 600, 200, 40);
        fe_.setFont(font2);
        frame.add(fe_);

        save = new JButton("Save");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);
        save.setFont(font3);
        save.setBounds(300, 650, 100, 40);
        save.addActionListener(this);
        frame.add(save);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(font3);
        cancel.setBounds(600, 650, 100, 40);
        cancel.addActionListener(this);
        frame.add(cancel);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save){
            String q = "insert into class_11 (id, name, father, mother, roll, password, dob, aadhaar) values" +
                    "('"+id_.getText()+"', '"+name_.getText()+"', '"+father_.getText()+"', '"+mother_.getText()+"', '"+roll_.getText()+"'," +
                    "'"+password_.getText()+"', '"+dob_.getText()+"', '"+aadhaar_.getText()+"')";
            System.out.println(q);
            try {
                Conn con = new Conn();
                con.stmt.executeUpdate(q);
                q = "insert into class11_subjects values ('"+id_.getText()+"', '"+name_.getText()+"', '"+mil_.getText()+"'," +
                        "'English', '"+fse_.getText()+"', '"+se_.getText()+"', '"+te_.getText()+"', '"+fe_.getText()+"')";
                con.stmt.executeUpdate(q);
                q = "insert into student (id, name, admission_year, admission_class, current_class) values ('"+id_.getText()+"'," +
                        "'"+name_.getText()+"', "+yr+", '11', '11')";
                con.stmt.executeUpdate(q);

                JOptionPane.showMessageDialog(null, "Data Stored Successfully");
            }catch (Exception e){e.printStackTrace();}
        }else if(ae.getSource() == cancel){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new addStudent11();
    }
}
