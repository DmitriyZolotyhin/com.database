package model;


import java.sql.Date;

public class Bookings {
    private String book_ref;
    private Date book_date;
    private Integer total_amount;



    public Bookings(String book_ref, Date book_date, Integer total_amount) {
        this.book_ref = book_ref;
        this.book_date = book_date;
        this.total_amount = total_amount;
    }

    public Bookings() {

    }


    public String getBook_ref() {
        return book_ref;
    }

    public void setBook_ref(String book_ref) {
        this.book_ref = book_ref;
    }

    public Date getBook_date() {
        return book_date;
    }

    public void setBook_date(Date book_date) {
        this.book_date = book_date;
    }

    public Integer getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }


    @Override
    public String toString() {
        return "Bookings{" +
                "book_ref=" + book_ref +
                ", book_date='" + book_date + '\'' +
                ", total_amount=" + total_amount;
    }
}

