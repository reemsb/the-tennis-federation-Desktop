/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
/**
 *
 * @author Rym
 */
public class Reservation {
private int id_reservation;
private Date date_recuperation_ticket;
private int ticket_id_ticket;
private String block;
private String seat;

    public Reservation(Date date_recuperation_ticket, int ticket_id_ticket, String block, String seat) {
        this.date_recuperation_ticket = date_recuperation_ticket;
        this.ticket_id_ticket = ticket_id_ticket;
        this.block = block;
        this.seat = seat;
    }

    public Reservation(int id_reservation, Date date_recuperation_ticket, int ticket_id_ticket, String block, String seat) {
        this.id_reservation = id_reservation;
        this.date_recuperation_ticket = date_recuperation_ticket;
        this.ticket_id_ticket = ticket_id_ticket;
        this.block = block;
        this.seat = seat;
    }

    public Reservation() {
    }

    

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Date getDate_recuperation_ticket() {
        return date_recuperation_ticket;
    }

    public void setDate_recuperation_ticket(Date date_recuperation_ticket) {
        this.date_recuperation_ticket = date_recuperation_ticket;
    }

    public int getTicket_id_ticket() {
        return ticket_id_ticket;
    }

    public void setTicket_id_ticket(int ticket_id_ticket) {
        this.ticket_id_ticket = ticket_id_ticket;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", date_recuperation_ticket=" + date_recuperation_ticket + ", ticket_id_ticket=" + ticket_id_ticket + ", block=" + block + ", seat=" + seat + '}';
    }

  

}