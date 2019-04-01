package org.projet.DBGestion;

import java.util.List;

public interface EtudiantDAO {
    List<Etudiant> findByAll();

    Etudiant findById(String id);

    void addEtudiant(Etudiant etu);

    void updateEtudiantById(Etudiant etu,int id);

    void deleteEtudiantById(int id);
}
