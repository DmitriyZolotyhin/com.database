package dao;

import model.Bookings;

public interface BookingsDao {


    boolean addBookings(Bookings bookings);
    boolean deleteBookings(int a);
    boolean updateBookings(Bookings bookings,String book_ref );
    Bookings bookingsFindByAmount(int a);////
}

