package org.projet.DBGestion;

import java.util.List;

public class EtudiantServiceImpl implements EtudiantService{
    @Override
    public List<Etudiant> getAllEtudiants() {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        return etuDAO.findByAll();
    }


    @Override
    public Etudiant getEtudiantsById(String id) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        return etuDAO.findById(id);
    }

}
