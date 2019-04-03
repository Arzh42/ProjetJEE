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
        System.out.println(etuDAO.toString());
        return etuDAO.findById(id);
    }

    @Override
    public void addEtudiant(Etudiant etu) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        etuDAO.addEtudiant(etu);
    }

    @Override
    public void supprEtudiant(Etudiant etu) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.supprEtudiant(etu);
    }

    @Override
    public void modifEtudiant(Etudiant etuAmodif, Etudiant etudiantModifie) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.modifEtudiant( etuAmodif, etudiantModifie);
    }

}
