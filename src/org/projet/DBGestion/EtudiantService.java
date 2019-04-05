package org.projet.DBGestion;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantsById(String id);

    void addEtudiant(Etudiant etu);

    List<Groupe> getAllGroupes();

    Groupe getGroupeByNom(String nom);

    void addGroupe(Groupe g);

    void supprEtudiant(Etudiant etu);

    void modifEtudiant(Etudiant etuAmodif, Etudiant etudiantModifie);

    void supprGroupe(Groupe g);

    void modifGroupe(Groupe gAmodif, Groupe groupeModifie);

    void ajoutEtuGroupe(Groupe g, Etudiant etu);

    void supprEtuGroupe(Groupe g, Etudiant etu);

    List<Etudiant> getAllEtudiantsInGroupe(String groupe);
}
