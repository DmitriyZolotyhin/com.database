import dbutil.DBConnection;
import dbutil.DBoperation;
import model.Bookings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import service.BookingsDAOImplement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class DataBaseTest {

    BookingsDAOImplement uDAOi = new BookingsDAOImplement();


    Connection connection = DBConnection.getConnection();

/*

    @AfterClass
    public static void afterAll() throws SQLException {

           BookingsDAOImplement.deleteAllTables() ;


    }
*/
    @Test
    public void Connectiontest() throws SQLException {
        String str = "bd_for_test";
        assertEquals(str, connection.getCatalog());
    }

    @Test
    public void testAddBookings() {
        Bookings bookings1 = new Bookings("test6", Date.valueOf("2019-09-23"), 300000); // existing user
        assertTrue(uDAOi.addBookings(bookings1));
    }

    @Test
    public void testUpdateBookings() {
        Bookings bookings1 = new Bookings("test6", Date.valueOf("2019-09-23"), 300000);
        assertTrue(uDAOi.updateBookings(bookings1, "test8"));
    }


    @Test
    public void testDeleteBookings() {
        assertTrue(uDAOi.deleteBookings(300000));
    }

    @Test
    public void testUserFindByAmount() {
        assertNotNull(uDAOi.bookingsFindByAmount(9000));
        assertNull(uDAOi.bookingsFindByAmount(70000));
    }


    @Test
    public void testFindMaxTotalAmount() {
        int x = DBoperation.FindMaxTotalAmount();
        assertEquals(125000, x);
    }

    @Test
    public void testFindMinAmount() {
        int x = DBoperation.FindMinTotalAmount();
        assertEquals(3000, x);
    }

    @Test
    public void testFindAvgAmount() {
        int x = DBoperation.FindAvgAmount();
        assertEquals(64062, x);
    }


    @Test
    public void testUseOfLIKE() throws SQLException {
        int x = DBoperation.useOfLIKE();
        assertEquals(1, x);
    }

    @Test
    public void testFastTotal() throws SQLException {
        int x = DBoperation.fastTotal();
        assertEquals(512500, x);
    }

    @Test
    public void testDeleteBookingsWithMyTriggers() {
        assertFalse(uDAOi.deleteBookings(455000));

    }

    @Test
    public void testUseOfJoinANDLike() throws SQLException {
        int x = DBoperation.bookingTicketJoin();
        assertEquals(1, x);
    }

}