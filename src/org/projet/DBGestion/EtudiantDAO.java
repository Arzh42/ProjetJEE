package org.projet.DBGestion;

import java.util.List;

public interface EtudiantDAO {
    List<Etudiant> findByAll();

    Etudiant findById(String id);

    void addEtudiant(Etudiant etu);
}
