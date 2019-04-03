package org.projet.DBGestion;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantsById(String id);

    void addEtudiant(Etudiant etu);

    List<Groupe> getAllGroupes();

    Groupe getGroupeByNom(String nom);

    void addGroupe(Groupe g);
}
