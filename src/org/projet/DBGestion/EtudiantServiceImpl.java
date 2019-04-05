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
    public List<Groupe> getAllGroupes() {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        return etuDAO.findGByAll();
    }


    @Override
    public Groupe getGroupeByNom(String nom) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        System.out.println(etuDAO.toString());
        return etuDAO.findGByNom(nom);
    }

    @Override
    public void addGroupe(Groupe g) {
        EtudiantDAO etuDAO = new EtudiantDAOImpl();
        etuDAO.addGroupe(g);
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

    @Override
    public void supprGroupe(Groupe g) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.supprGroupe(g);
    }

    @Override
    public void modifGroupe(Groupe gAmodif, Groupe gModifie) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.modifGroupe( gAmodif, gModifie);
    }

    @Override
    public void ajoutEtuGroupe(Groupe g, Etudiant etu) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.ajoutEtuGroupe(g, etu);
    }

    @Override
    public void supprEtuGroupe(Groupe g, Etudiant etu) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        etudiantDAO.supprEtuGroupe(g, etu);
    }

    @Override
    public List<Etudiant> getAllEtudiantsInGroupe(String groupe) {
        EtudiantDAO etudiantDAO = new EtudiantDAOImpl();
        return etudiantDAO.getAllEtudiantsInGroupe(groupe);
    }
}
