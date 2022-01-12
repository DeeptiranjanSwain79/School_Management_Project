package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class fees implements ActionListener{
    JFrame frame;
    JTextField amt, tid;
    JLabel status_, due_, arrears_;
    JButton pay, exit;
    String name, cl, id, status;
    Choice mop;
    int due;

    fees(String name, String cl, String id){
        this.name = name;
        this.cl = cl;
        this.id = id;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("WELCOME");
        frame.setLocation(300, 100);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);

        JLabel welcome = new JLabel("Welcome "+name, JLabel.CENTER);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        welcome.setBounds(10, 10, 780, 50);
        welcome.setForeground(Color.RED);
        frame.add(welcome);

        JLabel l1 = new JLabel("ID");
        l1.setFont(font1);
        l1.setBounds(50, 100, 200, 30);
        frame.add(l1);
        JLabel i_ = new JLabel(id);
        i_.setFont(font2);
        i_.setBounds(300, 100, 300, 30);
        frame.add(i_);

        JLabel l2 = new JLabel("Name");
        l2.setFont(font1);
        l2.setBounds(50, 150, 200, 30);
        frame.add(l2);
        JLabel name_ = new JLabel();
        name_.setFont(font2);
        name_.setBounds(300, 150, 300, 30);
        frame.add(name_);

        JLabel l3 = new JLabel("Status");
        l3.setFont(font1);
        l3.setBounds(50, 200, 200, 30);
        frame.add(l3);
        status_ = new JLabel();
        status_.setFont(font2);
        status_.setBounds(300, 200, 300, 30);
        frame.add(status_);

        JLabel l4 = new JLabel("Class");
        l4.setFont(font1);
        l4.setBounds(50, 250, 200, 30);
        frame.add(l4);
        JLabel l4_ = new JLabel(cl);
        l4_.setFont(font2);
        l4_.setBounds(300, 250, 300, 30);
        frame.add(l4_);

        JLabel l5 = new JLabel("Arrears");
        l5.setFont(font1);
        l5.setBounds(50, 300, 200, 30);
        frame.add(l5);
        arrears_ = new JLabel();
        arrears_.setFont(font2);
        arrears_.setBounds(300, 300, 300, 30);
        frame.add(arrears_);

        JLabel l6 = new JLabel("Due");
        l6.setFont(font1);
        l6.setBounds(50, 350, 200, 30);
        frame.add(l6);
        due_ = new JLabel();
        due_.setFont(font2);
        due_.setBounds(300, 350, 300, 30);
        frame.add(due_);

        try {
            Conn con = new Conn();
            String q = "Select * from fees where id='"+id+"'";
            System.out.println(q);
            ResultSet rs = con.stmt.executeQuery(q);

            if (rs.next()){
                name_.setText(rs.getString("Name"));
                status_.setText(rs.getString("Status"));
                arrears_.setText(rs.getString("Arrears"));
                due = rs.getInt("Due");
                status = rs.getString("Status");
                due_.setText(rs.getString("Due"));
            }

        }catch (Exception e){e.printStackTrace();}

        amt = new JTextField();
        amt.setBounds(100, 400, 150, 30);
        amt.setFont(font1);
        frame.add(amt);

        mop = new Choice();
        mop.setFont(font2);
        mop.setBounds(300, 400, 300, 30);
        mop.add("Cash");
        mop.add("Card");
        mop.add("Net Banking");
        frame.add(mop);

        JLabel t = new JLabel("Transaction ID");
        t.setBounds(100, 450, 200, 30);
        t.setFont(font1);
        frame.add(t);
        tid = new JTextField();
        tid.setBounds(350, 450, 300, 30);
        tid.setFont(font2);
        frame.add(tid);

        pay = new JButton("Pay");
        pay.setBounds(350, 500, 100, 40);
        pay.setFont(font3);
        pay.setBackground(Color.GREEN);
        pay.setForeground(Color.BLACK);
        pay.addActionListener(this);
        frame.add(pay);

        exit = new JButton("Exit");
        exit.setBounds(300, 550, 100, 40);
        exit.setFont(font3);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        frame.add(exit);

        frame.setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == pay){
            int amt_ = Integer.parseInt(amt.getText());
            String tid_ = tid.getText();
            due -= amt_;
            if (due <= 0){
                status_.setText("CLEAR");
                status = "CLEAR";
            }

            try {
                Conn con = new Conn();
                String q = "update fees set due="+due+", status='"+status+"', tid='"+tid_+"', mop='"+mop.getSelectedItem()+"', arrears="+due+" where id='"+id+"'";
                System.out.println(q);
                con.stmt.executeUpdate(q);

                ResultSet rs = con.stmt.executeQuery("Select * from fees where id='"+id+"'");
                if (rs.next()){
                    arrears_.setText(rs.getString("Arrears"));
                    due_.setText(rs.getString("Due"));
                }
                JOptionPane.showMessageDialog(null, "Paid Successfully");

            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == exit){
            frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new fees("", "", "");
    }
}
