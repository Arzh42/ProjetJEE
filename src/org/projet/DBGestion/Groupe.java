package org.projet.DBGestion;

import java.util.Date;

public class Groupe {
    private String nom;
    private String nomProprietaire;
    private String dateCreation;

    /**
     *
     */
    public Groupe(String nom, String nomProprietaire, String dateCreation) {
        this.nom = nom;
        this.nomProprietaire = nomProprietaire;
        this.dateCreation = dateCreation;

    }


    public String toString(){
        return "nom :" + nom +"\n" + "nomProprietaire : " + nomProprietaire + "\n" + "dateCreation : " + dateCreation;
    }

    public String getNom() {
        return nom;
    }

    public String getNomProprietaire(){
        return nomProprietaire;
    }

    public String getDateCreation(){
        return dateCreation;
    }
}
