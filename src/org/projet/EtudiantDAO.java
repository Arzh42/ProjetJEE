package org.projet;

import java.util.List;

public interface EtudiantDAO {
    List<Etudiant> findByAll();

    Etudiant findById(String id);
}
