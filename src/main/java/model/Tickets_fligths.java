package model;

import java.sql.Date;

public class Tickets_fligths {

        private String  ticket_number;
        private  int flight_id;
        private String fare_conditions;
        private  int amount;



        public Tickets_fligths(String ticket_number, Integer flight_id, String fare_conditions, Integer amount) {

            this.ticket_number= ticket_number;
            this.flight_id= flight_id;
            this.fare_conditions=fare_conditions;
            this.amount=amount;

        }

        public Tickets_fligths() {

        }


        public String getTicket_number() {
            return ticket_number;
        }

        public void setTicket_nimber(String ticket_nimber) {
            this.ticket_number = ticket_nimber;
        }

        public Integer getFligth_id() {
            return flight_id;
        }

        public void setFlight_id_id(Integer passengers_id) {
            this.flight_id = flight_id;
        }


        public String getFare_conditinos() {
            return fare_conditions;
        }
        public void setFare_conditions(String fare_conditions) {
            this.fare_conditions = fare_conditions;
        }





        @Override
        public String toString() {
            return "Bookings{" +
                    ", ticket_number='" + ticket_number + '\'' +
                    ", fligth_id" + flight_id+
                    ", fare_conditions" + fare_conditions+
                    ", amount" + amount;

        }
    }



