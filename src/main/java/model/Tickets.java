package model;

import java.sql.Date;

public class Tickets {
    private String book_ref;
    private String  ticket_number;
    private  int passengers_id;
    private String passengers_name;
    private  int passport_number;
    private Date contact_date;


    public Tickets(String book_ref, String ticket_number, Integer passengers_id, String passengers_name, Integer passport_number, Date contact_date) {
        this.book_ref = book_ref;
        this.ticket_number= ticket_number;
        this.passengers_id= passengers_id;
        this.passengers_name=passengers_name;
        this.passport_number=passport_number;
        this.contact_date=contact_date;
    }

    public Tickets() {

    }


    public String getBook_ref() {
        return book_ref;
    }

    public void setBook_ref(String book_ref) {
        this.book_ref = book_ref;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_nimber(String ticket_nimber) {
        this.ticket_number = ticket_nimber;
    }

    public Integer getPassengers_id() {
        return passengers_id;
    }

    public void setPassengers_id(Integer passengers_id) {
        this.passengers_id = passengers_id;
    }


    public String getPassengers_name() {
        return passengers_name;
    }
    public void setPassengers_name(String passengers_name) {
        this.passengers_name = passengers_name;
    }

    public Date getContact_date() {
        return contact_date;
    }
    public void setContact_date(Date contact_date) {
        this.contact_date = contact_date;
    }



    @Override
    public String toString() {
        return "Bookings{" +
                "book_ref=" + book_ref +
                ", ticket_number='" + ticket_number + '\'' +
                ", passengers_id" + passengers_id+
                ", passengers_name" + passengers_name+
                ", ticket_number=" + ticket_number + '\'' +
                ", passport_number" + passport_number+
                ", contact_date" + contact_date;

    }
}

