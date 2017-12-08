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
public class Stade {
     private int id_stade;
    private String libelle_stade;
    private String adresse_stade;
    private String ville_stade;
    private String type_stade;
    private int capacite_stade;

    public Stade() {
    }

    public Stade(int id_stade, String libelle_stade, String adresse_stade, String ville_stade, String type_stade, int capacite_stade) {
        this.id_stade = id_stade;
        this.libelle_stade = libelle_stade;
        this.adresse_stade = adresse_stade;
        this.ville_stade = ville_stade;
        this.type_stade = type_stade;
        this.capacite_stade = capacite_stade;
    }

    public Stade(String libelle_stade, String adresse_stade, String ville_stade, String type_stade, int capacite_stade) {
        this.libelle_stade = libelle_stade;
        this.adresse_stade = adresse_stade;
        this.ville_stade = ville_stade;
        this.type_stade = type_stade;
        this.capacite_stade = capacite_stade;
    }

    public int getId_stade() {
        return id_stade;
    }

    public void setId_stade(int id_stade) {
        this.id_stade = id_stade;
    }

    public String getLibelle_stade() {
        return libelle_stade;
    }

    public void setLibelle_stade(String libelle_stade) {
        this.libelle_stade = libelle_stade;
    }

    public String getAdresse_stade() {
        return adresse_stade;
    }

    public void setAdresse_stade(String adresse_stade) {
        this.adresse_stade = adresse_stade;
    }

    public String getVille_stade() {
        return ville_stade;
    }

    public void setVille_stade(String ville_stade) {
        this.ville_stade = ville_stade;
    }

    public String getType_stade() {
        return type_stade;
    }

    public void setType_stade(String type_stade) {
        this.type_stade = type_stade;
    }

    public int getCapacite_stade() {
        return capacite_stade;
    }

    public void setCapacite_stade(int capacite_stade) {
        this.capacite_stade = capacite_stade;
    }

    @Override
    public String toString() {
        return "Stade{" + "id_stade=" + id_stade + ", libelle_stade=" + libelle_stade + ", adresse_stade=" + adresse_stade + ", ville_stade=" + ville_stade + ", type_stade=" + type_stade + ", capacite_stade=" + capacite_stade + '}';
    }

    

    
}
