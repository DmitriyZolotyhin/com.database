package service;

import dao.BookingsDao;
import dbutil.DBConnection;
import model.Bookings;

import java.sql.*;

public class BookingsDAOImplement implements BookingsDao {



        @Override
        public boolean addBookings(Bookings bookings) {
            Connection connection = DBConnection.getConnection();
            try {
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO bookings (book_ref, book_date, total_amount) VALUES (?,?,?)");
                // ps.setInt(0, user.getId());
                ps.setString(1, bookings.getBook_ref());
                ps.setDate(2, (Date) bookings.getBook_date());
                ps.setInt(3, bookings.getTotal_amount());

                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean updateBookings(Bookings bookings, String book_ref ) {
            Connection connection = DBConnection.getConnection();
            try {

                PreparedStatement ps = connection
                       // .prepareStatement("UPDATE bookings SET book_ref=?, book_date=?, total_amount=? WHERE total_amount=?");
                  .prepareStatement("UPDATE bookings SET book_ref=? WHERE book_ref=?");
               ps.setString(1, bookings.getBook_ref());
             //   ps.setDate(2, (Date) bookings.getBook_date());
            //    ps.setInt(3, bookings.getTotal_amount());
              //  ps.setInt(4, bookings.getTotal_amount());
                ps.setString(2, bookings.getBook_ref());
                int i = ps.executeUpdate();
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }



    @Override
        public boolean deleteBookings(int total_amount) {
            Connection connection = DBConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                int i = stmt.executeUpdate("DELETE FROM bookings WHERE total_amount=" + total_amount);
                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }



    @Override
        public Bookings bookingsFindByAmount(int a) {
            Connection connection = DBConnection.getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM bookings WHERE total_amount=" + a);
                if (rs.next()) {
                  Bookings bookings = new Bookings();
                    bookings.setBook_ref(rs.getString( "book_ref"));
                   bookings.setBook_date(rs.getDate("book_date"));
                    bookings.setTotal_amount(rs.getInt("total_amount"));

                    return bookings;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return null;

        }



    public static boolean deleteAllTables() {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "DROP table if exists tickets_fligths,tickets,bookings");

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    }


