/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Rym
 */
public class Ticket {
    private int id_ticket;
    private String libelle_ticket;
    private float prix_ticket;
    private int match_id_match;
    private int stade_id_stade;
    private int nbr_ticket_dispo;

    public Ticket(String libelle_ticket, float prix_ticket, int match_id_match, int stade_id_stade, int nbr_ticket_dispo) {
        this.libelle_ticket = libelle_ticket;
        this.prix_ticket = prix_ticket;
        this.match_id_match = match_id_match;
        this.stade_id_stade = stade_id_stade;
        this.nbr_ticket_dispo = nbr_ticket_dispo;
    }

    public Ticket(int id_ticket, String libelle_ticket, float prix_ticket, int match_id_match, int stade_id_stade, int nbr_ticket_dispo) {
        this.id_ticket = id_ticket;
        this.libelle_ticket = libelle_ticket;
        this.prix_ticket = prix_ticket;
        this.match_id_match = match_id_match;
        this.stade_id_stade = stade_id_stade;
        this.nbr_ticket_dispo = nbr_ticket_dispo;
    }

    public Ticket() {
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public String getLibelle_ticket() {
        return libelle_ticket;
    }

    public void setLibelle_ticket(String libelle_ticket) {
        this.libelle_ticket = libelle_ticket;
    }

    public float getPrix_ticket() {
        return prix_ticket;
    }

    public void setPrix_ticket(float prix_ticket) {
        this.prix_ticket = prix_ticket;
    }

    public int getMatch_id_match() {
        return match_id_match;
    }

    public void setMatch_id_match(int match_id_match) {
        this.match_id_match = match_id_match;
    }

    public int getStade_id_stade() {
        return stade_id_stade;
    }

    public void setStade_id_stade(int stade_id_stade) {
        this.stade_id_stade = stade_id_stade;
    }

    public int getNbr_ticket_dispo() {
        return nbr_ticket_dispo;
    }

    public void setNbr_ticket_dispo(int nbr_ticket_dispo) {
        this.nbr_ticket_dispo = nbr_ticket_dispo;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", libelle_ticket=" + libelle_ticket + ", prix_ticket=" + prix_ticket + ", match_id_match=" + match_id_match + ", stade_id_stade=" + stade_id_stade + ", nbr_ticket_dispo=" + nbr_ticket_dispo + '}';
    }

    

   

   

    
}