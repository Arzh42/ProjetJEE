package org.projet.DBGestion;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantsById(String id);

    void addEtudiant(Etudiant etu);
}
