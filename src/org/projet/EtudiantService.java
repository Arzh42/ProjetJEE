package org.projet;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiants();

    Etudiant getEtudiantsById(String id);
}
