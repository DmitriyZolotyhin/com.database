package dbutil;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import model.Bookings;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBoperation {

    /*  public static boolean Create() {
          Connection connection =  DBConnection.getConnection();
          try {
              System.out.println("Creating table in given database...");
              Statement stmt = connection.createStatement();

              String sql = "CREATE TABLE bookings" +
                      "(book_ref     varchar(30) primary key," +
                      " total_amount   int," +
                      "             book_date   date);" ;

              stmt.executeUpdate(sql);
              return true;
          }
          catch(Exception e) {
          }
          return false;

      }

  */
    public static int FindMaxTotalAmount() {
        Connection connection = DBConnection.getConnection();
        int max = 0, x;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  max(total_amount) from bookings");
            while (rs.next()) {
                x = rs.getInt("max");
                rs.getInt("max");
                if (x > max) max = x;
            }
            return max;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return max;
    }

    public static int FindMinTotalAmount() {
        Connection connection = DBConnection.getConnection();
        int min = 999999999, x;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bookings");
            while (rs.next()) {
                x = rs.getInt("total_amount");
                if (x < min) min = x;
            }
            return min;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return min;
    }

    public static int FindAvgAmount() {
        Connection connection = DBConnection.getConnection();
        int sum = 0, x = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT avg(total_amount) as total_amount FROM bookings ");
            while (rs.next()) {
                sum += rs.getInt("total_amount");
                x++;
            }
            return sum / x;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sum / x;

    }


    public static int useOfLIKE() throws SQLException { // start with s
        Connection connection = DBConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM bookings WHERE book_ref LIKE 'AB%'");
        int x = 0;
        while (rs.next()) {
            x++;
        }
        return x;
    }


    public static int fastTotal() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select total()");

        int x = 0;
        while (rs.next()) {
            x = rs.getInt("total");
            ;
        }
        return x;
    }


    public static int bookingTicketJoin() throws SQLException { // start with s
        Connection connection = DBConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT bookings.book_ref,tickets.ticket_number,tickets.passenger_name FROM bookings join tickets on bookings.book_ref=tickets.book_ref WHERE bookings.book_ref LIKE 'AB%'");
        int x = 0;
        while (rs.next()) {
            x++;
        }
        return x;

    }

}