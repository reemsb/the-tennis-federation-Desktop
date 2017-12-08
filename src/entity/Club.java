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
public class Club {
    private int id_club;
    private String libelle_club;
    private String adresse_club;
    private String ville_club;
    private String numero_telephone;
    private String numero_fax;
    private int nbr_terrain;
    private float budget_club;

    public Club(String libelle_club, String adresse_club, String ville_club, String numero_telephone, String numero_fax, int nbr_terrain, float budget_club) {
        this.libelle_club = libelle_club;
        this.adresse_club = adresse_club;
        this.ville_club = ville_club;
        this.numero_telephone = numero_telephone;
        this.numero_fax = numero_fax;
        this.nbr_terrain = nbr_terrain;
        this.budget_club = budget_club;
    }

    public Club() {
    }

    public Club(int id_club, String libelle_club, String adresse_club, String ville_club, String numero_telephone, String numero_fax, int nbr_terrain, float budget_club) {
        this.id_club = id_club;
        this.libelle_club = libelle_club;
        this.adresse_club = adresse_club;
        this.ville_club = ville_club;
        this.numero_telephone = numero_telephone;
        this.numero_fax = numero_fax;
        this.nbr_terrain = nbr_terrain;
        this.budget_club = budget_club;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public String getLibelle_club() {
        return libelle_club;
    }

    public void setLibelle_club(String libelle_club) {
        this.libelle_club = libelle_club;
    }

    public String getAdresse_club() {
        return adresse_club;
    }

    public void setAdresse_club(String adresse_club) {
        this.adresse_club = adresse_club;
    }

    public String getVille_club() {
        return ville_club;
    }

    public void setVille_club(String ville_club) {
        this.ville_club = ville_club;
    }

    public String getNumero_telephone() {
        return numero_telephone;
    }

    public void setNumero_telephone(String numero_telephone) {
        this.numero_telephone = numero_telephone;
    }

    public String getNumero_fax() {
        return numero_fax;
    }

    public void setNumero_fax(String numero_fax) {
        this.numero_fax = numero_fax;
    }

    public int getNbr_terrain() {
        return nbr_terrain;
    }

    public void setNbr_terrain(int nbr_terrain) {
        this.nbr_terrain = nbr_terrain;
    }

    public float getBudget_club() {
        return budget_club;
    }

    public void setBudget_club(float budget_club) {
        this.budget_club = budget_club;
    }

    @Override
    public String toString() {
        return "Club{" + "id_club=" + id_club + ", libelle_club=" + libelle_club + ", adresse_club=" + adresse_club + ", ville_club=" + ville_club + ", numero_telephone=" + numero_telephone + ", numero_fax=" + numero_fax + ", nbr_terrain=" + nbr_terrain + ", budget_club=" + budget_club + '}';
    }
    
    
}
