package School_Management_System;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class result implements ActionListener {
    JFrame frame;
    String id, cl, n;
    JLabel r1, r2, r3, r4, r5, r6, r7, r8, r9, l1, l2, l3, l4, l5, l6, total, percent, r11, r21, r31, r41, r51, r61, r71, r81, r91, no;
    JButton print, exit, show;
    Choice exam;

    result(String id, String cl, String n){
        this.id = id;
        this.cl = cl;
        this.n = n;

        Font font1 = new Font("FootLight MT", Font.PLAIN, 25);
        Font font2 = new Font("Franklin Gothic", Font.PLAIN, 25);
        Font font3 = new Font("Lucida Calligraphy", Font.PLAIN, 15);

        frame = new JFrame("RESULTS ");
        frame.setBounds(200, 0, 800, 800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel welcome = new JLabel("Welcome  "+n, JLabel.CENTER);
        welcome.setBounds(10, 10, 780, 50);
        welcome.setFont(new Font("Elephant", Font.PLAIN, 30));
        frame.add(welcome);

        JLabel e = new JLabel("Exam Name");
        e.setBounds(50, 100, 200, 30);
        e.setFont(font1);
        frame.add(e);

        exam = new Choice();
        exam.setBounds(300, 100, 200, 30);
        exam.setFont(font2);
        exam.add("Monthly Test-1");
        exam.add("Monthly Test-2");
        exam.add("Half-yearly");
        exam.add("Annual");
        frame.add(exam);

        show = new JButton("Show");
        show.setBackground(Color.BLUE);
        show.setForeground(Color.WHITE);
        show.setFont(font3);
        show.setBounds(600, 100, 100, 40);
        show.addActionListener(this);
        frame.add(show);

        no = new JLabel("NO DATA FOUND!!!", JLabel.CENTER);
        no.setBounds(150, 150, 500, 30);
        no.setFont(font1);
        frame.add(no);
        no.setForeground(Color.RED);
        no.setVisible(false);

        r1 = new JLabel();
        r1.setFont(font1);
        r1.setBounds(50, 200, 300, 30);
        frame.add(r1);
        r1.setVisible(false);
        r11 = new JLabel();
        r11.setFont(font2);
        r11.setBounds(400, 200, 300, 30);
        frame.add(r11);
        r11.setVisible(false);

        r2 = new JLabel();
        r2.setFont(font1);
        r2.setBounds(50, 250, 300, 30);
        frame.add(r2);
        r1.setVisible(false);
        r21 = new JLabel();
        r21.setFont(font2);
        r21.setBounds(400, 250, 300, 30);
        frame.add(r21);
        r21.setVisible(false);

        r3 = new JLabel();
        r3.setFont(font1);
        r3.setBounds(50, 300, 300, 30);
        frame.add(r3);
        r3.setVisible(false);
        r31 = new JLabel();
        r31.setFont(font2);
        r31.setBounds(400, 300, 300, 30);
        frame.add(r31);
        r31.setVisible(false);

        r4 = new JLabel();
        r4.setFont(font1);
        r4.setBounds(50, 350, 300, 30);
        frame.add(r4);
        r4.setVisible(false);
        r41 = new JLabel();
        r41.setFont(font2);
        r41.setBounds(400, 350, 300, 30);
        frame.add(r41);
        r41.setVisible(false);

        r5 = new JLabel();
        r5.setFont(font1);
        r5.setBounds(50, 400, 300, 30);
        frame.add(r5);
        r5.setVisible(false);
        r51 = new JLabel();
        r51.setFont(font2);
        r51.setBounds(400, 400, 300, 30);
        frame.add(r51);
        r51.setVisible(false);

        r6 = new JLabel();
        r6.setFont(font1);
        r6.setBounds(50, 450, 300, 30);
        frame.add(r6);
        r6.setVisible(false);
        r61 = new JLabel();
        r61.setFont(font2);
        r61.setBounds(400, 450, 300, 30);
        frame.add(r61);
        r61.setVisible(false);

        r7 = new JLabel();
        r7.setFont(font1);
        r7.setBounds(50, 500, 300, 30);
        frame.add(r7);
        r7.setVisible(false);
        r71 = new JLabel();
        r71.setFont(font2);
        r71.setBounds(400, 500, 300, 30);
        frame.add(r71);
        r71.setVisible(false);

        r8 = new JLabel();
        r8.setFont(font1);
        r8.setBounds(50, 550, 3200, 30);
        frame.add(r8);
        r8.setVisible(false);
        r81 = new JLabel();
        r81.setFont(font2);
        r81.setBounds(400, 550, 300, 30);
        frame.add(r81);
        r81.setVisible(false);

        l1 = new JLabel("Total");
        l1.setFont(font1);
        l1.setBounds(50, 600, 200, 30);
        frame.add(l1);
        l1.setVisible(false);
        total = new JLabel();
        total.setFont(font2);
        total.setBounds(400, 600, 200, 30);
        frame.add(total);
        total.setVisible(false);

        l2 = new JLabel("Percentage");
        l2.setFont(font1);
        l2.setBounds(50, 650, 200, 30);
        frame.add(l2);
        l2.setVisible(false);
        percent = new JLabel();
        percent.setFont(font2);
        percent.setBounds(400, 650, 200, 30);
        frame.add(percent);
        percent.setVisible(false);

        print = new JButton("Print");
        print.setBackground(Color.GREEN);
        print.setForeground(Color.BLACK);
        print.setFont(font3);
        print.setBounds(200, 700, 100, 40);
        print.addActionListener(this);
        frame.add(print);
        print.setVisible(false);

        exit = new JButton("Exit");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setFont(font3);
        exit.setBounds(600, 700, 100, 40);
        exit.addActionListener(this);
        frame.add(exit);
        exit.setVisible(false);


        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == show){
            try {
                Conn con = new Conn();
                String q = "select * from class"+cl+"_results where id='"+id+"' and exam_name='"+exam.getSelectedItem()+"'";
                ResultSet rs = con.stmt.executeQuery(q);
                if (rs.next()){
                    no.setVisible(false);

                    print.setVisible(true);
                    exit.setVisible(true);

                    r1.setVisible(true);
                    r11.setVisible(true);
                    r1.setText(rs.getMetaData().getColumnName(4));
                    r11.setText(rs.getString(4));

                    r2.setVisible(true);
                    r21.setVisible(true);
                    r2.setText(rs.getMetaData().getColumnName(5));
                    r21.setText(rs.getString(5));

                    r3.setVisible(true);
                    r31.setVisible(true);
                    r3.setText(rs.getMetaData().getColumnName(6));
                    r31.setText(rs.getString(6));

                    r4.setVisible(true);
                    r41.setVisible(true);
                    r4.setText(rs.getMetaData().getColumnName(7));
                    r41.setText(rs.getString(7));

                    r5.setVisible(true);
                    r51.setVisible(true);
                    r5.setText(rs.getMetaData().getColumnName(8));
                    r51.setText(rs.getString(8));

                    r6.setVisible(true);
                    r61.setVisible(true);
                    r6.setText(rs.getMetaData().getColumnName(9));
                    r61.setText(rs.getString(9));

                    l1.setVisible(true);
                    l1.setForeground(Color.blue);
                    total.setVisible(true);
                    total.setText(rs.getString("Total"));
                    total.setForeground(Color.blue);

                    l2.setVisible(true);
                    percent.setVisible(true);
                    percent.setText(rs.getString("Percentage"));
                    l2.setForeground(Color.GREEN);
                    percent.setForeground(Color.GREEN);

                    if (cl=="2" || cl=="3" || cl=="4" || cl=="5" || cl=="6"){
                        r7.setVisible(true);
                        r71.setVisible(true);
                        r7.setText(rs.getMetaData().getColumnName(10));
                        r71.setText(rs.getString(10));
                    }else if (cl=="7" || cl=="8" || cl=="9" || cl=="10"){
                        r7.setVisible(true);
                        r71.setVisible(true);
                        r7.setText(rs.getMetaData().getColumnName(10));
                        r71.setText(rs.getString(10));
                        r8.setVisible(true);
                        r81.setVisible(true);
                        r8.setText(rs.getMetaData().getColumnName(11));
                        r81.setText(rs.getString("PE"));
                    }


                }else{
                    no.setVisible(true);
                }
            }catch (Exception ex){ex.printStackTrace();}
        }else if (ae.getSource() == print){
            try {
                //Take the screenshot
                Robot robot = new Robot();      //java.awt.Robot
                String format = "jpg";
                String fileName = "'"+id+"'_'"+exam.getSelectedItem()+"'_Result."+format;

                Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());      //java.awt.Rectangle
                BufferedImage screenFullImage = robot.createScreenCapture(screenSize);      //java.awt.image.BufferedImage
                ImageIO.write(screenFullImage, format, new File(fileName));     //javax.imageio.ImageIO

            }catch (Exception ex){
                ex.printStackTrace();
                System.err.println(ex);
            }
        }else if(ae.getSource() == exit){
            frame.setVisible(false);
            new student_front(id, cl);
        }


    }

    public static void main(String[] args) {
        new result("", "", "");
    }
}
