package org.projet.DBGestion;

import java.util.Date;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private Date date_de_naissance;
    private String courrielPro;
    private String courrielPerso;
    private String serieBac;
    private Date dateBac;
    private String mentionBac;
    private String diplome;
    private Date dateDiplome;

    /**
     *
     */
    public Etudiant(int id,String nom,String prenom,Date date_de_naissance,String courrielPro,String courrielPerso,String serieBac,Date dateBac,String mentionBac,String diplome,Date dateDiplome) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.courrielPro = courrielPro;
        this.courrielPerso = courrielPerso;
        this.serieBac = serieBac;
        this.dateBac = dateBac;
        this.mentionBac = mentionBac;
        this.diplome = diplome;
        this.dateDiplome = dateDiplome;

    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getCourrielPro() {
        return courrielPro;
    }

    public String getCourrielPerso() {
        return courrielPerso;
    }

    public String getSerieBac() {
        return serieBac;
    }

    public Date getDateBac() {
        return dateBac;
    }

    public String getMentionBac() {
        return mentionBac;
    }

    public String getDiplome() {
        return diplome;
    }

    public Date getDateDiplome() {
        return dateDiplome;
    }
}
