package com.example.examen_m3uf6;

import java.util.Date;

public class Evento {

    private String title;
    private String place;
    private String email;
    private String room;
    private String description;

    private int price;
    private int people;

    private Date evDate;
    private String dateAux;

    public Evento(){

    }

    public Evento(String title, String place, String email, String room, String description, int price, int people, Date evDate, String dateAux) {
        this.title = title;
        this.place = place;
        this.email = email;
        this.room = room;
        this.description = description;
        this.price = price;
        this.people = people;
        this.evDate = evDate;
        this.dateAux = dateAux;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public Date getEvDate() {
        return evDate;
    }

    public void setEvDate(Date evDate) {
        this.evDate = evDate;
    }

    public String getDateAux() {
        return dateAux;
    }

    public void setDateAux(String dateAux) {
        this.dateAux = dateAux;
    }
}
