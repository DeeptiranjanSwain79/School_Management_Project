package School_Management_System;

import java.sql.*;

public class Conn {
    
    Connection conn;
    Statement stmt;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?characterEncoding=latin1", "root", "Happy");
            stmt = conn.createStatement();
        }catch (Exception e){e.printStackTrace();}
    }
}
