package org.projet.DBGestion;

import java.util.List;

public interface EtudiantDAO {
    List<Etudiant> findByAll();

    Etudiant findById(String id);

    void addEtudiant(Etudiant etu);

    List<Groupe> findGByAll();

    Groupe findGByNom(String nom);

    void addGroupe(Groupe g);

    void supprEtudiant(Etudiant etu);

    void modifEtudiant(Etudiant etuAmodif, Etudiant etuModifie);

    void supprGroupe(Groupe g);

    void modifGroupe(Groupe gAmodif, Groupe gModifie);

    void ajoutEtuGroupe(Groupe g, Etudiant etu);

    void supprEtuGroupe(Groupe g, Etudiant etu);

    List<Etudiant> getAllEtudiantsInGroupe(String groupe);
}
