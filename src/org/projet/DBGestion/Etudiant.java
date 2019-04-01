package org.projet.DBGestion;

import java.util.Date;

public class Etudiant {
    private String id;
    private String nom;
    private String prenom;
    private Date date_de_naissance;
    private String courrielPro;
    private String courrielPerso;
    private String serieBac;
    private String dateBac;
    private String mentionBac;
    private String diplome;
    private String dateDiplome;

    /**
     *
     */
    public Etudiant(String id,String nom,String prenom,Date date_de_naissance, String dateBac/*,String courrielPro,String courrielPerso,String serieBac,Date dateBac,String mentionBac,String diplome,Date dateDiplome*/) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.dateBac = dateBac;
        /*this.courrielPro = courrielPro;
        this.courrielPerso = courrielPerso;
        this.serieBac = serieBac;

        this.mentionBac = mentionBac;
        this.diplome = diplome;
        this.dateDiplome = dateDiplome;*/

    }


    public String toString(){
        return "nom :" + nom +"\n" + "prenom : " + prenom+"\n"+"ddn : " + date_de_naissance+"\n"+"dateBac : "+ dateBac;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    /*public String getDate_de_naissance() {
        return date_de_naissance;
    }*/

    public String getCourrielPro() {
        return courrielPro;
    }

    public String getCourrielPerso() {
        return courrielPerso;
    }

    public String getSerieBac() {
        return serieBac;
    }

    public String getDateBac() {
        return dateBac;
    }

    public String getMentionBac() {
        return mentionBac;
    }

    public String getDiplome() {
        return diplome;
    }

    public String getDateDiplome() {
        return dateDiplome;
    }
}
