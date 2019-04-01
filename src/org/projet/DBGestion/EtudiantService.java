package org.projet.DBGestion;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantsById(String id);

    void addEtudiant(Etudiant etu);

    void updateEtudiantById(Etudiant etu,int id);

    void deleteEtudiantById(int id);
}
