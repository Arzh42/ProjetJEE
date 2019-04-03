package org.projet.DBGestion;

import java.util.List;

public interface EtudiantDAO {
    List<Etudiant> findByAll();

    Etudiant findById(String id);

    void addEtudiant(Etudiant etu);

    void supprEtudiant(Etudiant etu);

    void modifEtudiant(Etudiant etuAmodif, Etudiant etuModifie);
}
