package com.example.rideme;

import java.util.List;

public class ProfileApi {

    private String city;
    private String country;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String rides;
    private String free_rides;
    private String value;
    private String currency;
    private String currency_symbol;

    public ProfileApi(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRides() {
        return rides;
    }

    public void setRides(String rides) {
        this.rides = rides;
    }

    public String getFree_rides() {
        return free_rides;
    }

    public void setFree_rides(String free_rides) {
        this.free_rides = free_rides;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }

    public List<Trips> getTrips() {
        return mTrips;
    }

    public void setTrips(List<Trips> trips) {
        mTrips = trips;
    }

    private List<Trips> mTrips;
    public static class Trips {
        private String from;
        private String to;
        private String from_time;
        private String to_time;
        private String value;
        private String currency;
        private String currency_symbol;
        private String trip_duration_in_mins;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getFrom_time() {
            return from_time;
        }

        public void setFrom_time(String from_time) {
            this.from_time = from_time;
        }

        public String getTo_time() {
            return to_time;
        }

        public void setTo_time(String to_time) {
            this.to_time = to_time;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCurrency_symbol() {
            return currency_symbol;
        }

        public void setCurrency_symbol(String currency_symbol) {
            this.currency_symbol = currency_symbol;
        }

        public String getTrip_duration_in_mins() {
            return trip_duration_in_mins;
        }

        public void setTrip_duration_in_mins(String trip_duration_in_mins) {
            this.trip_duration_in_mins = trip_duration_in_mins;
        }
    }


}
