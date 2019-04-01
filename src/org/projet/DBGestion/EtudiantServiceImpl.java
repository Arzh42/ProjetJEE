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

    @Override
    public void addEtudiant(Etudiant etu) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        etuDAO.addEtudiant(etu);
    }

    @Override
    public void updateEtudiantById(Etudiant etu, int id) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        etuDAO.updateEtudiantById(etu,id);
    }

    @Override
    public void deleteEtudiantById(int id) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        etuDAO.deleteEtudiantById(id);

    }
}
