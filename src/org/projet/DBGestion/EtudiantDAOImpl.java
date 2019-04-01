package org.projet.DBGestion;

import org.tutorial.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtudiantDAOImpl implements EtudiantDAO {

    @Override
    public List<Etudiant> findByAll() {
        Connection co = DBManager.getInstance().getConnection();
        List<Etudiant> list = new ArrayList<>();

        try {
            Statement statement = co.createStatement();
            ResultSet rs = statement.executeQuery("select * from etudiant");
            BuildEtudiantFromReq(list, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Etudiant findById(String idIn) {
        Connection co = DBManager.getInstance().getConnection();
        List<Etudiant> list = new ArrayList<>();

        try {
            Statement statement = co.createStatement();
            ResultSet rs = statement.executeQuery("select * from etudiant where id="+idIn);
            BuildEtudiantFromReq(list, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list.size()>1) {
            System.out.println("Erreur retour multiple sur un appel par id");
            return null;
        }
        else {
            return list.get(0);
        }
    }

    @Override
    public void addEtudiant(Etudiant etu) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("INSERT INTO etudiant(nom,prenom,date_de_naissance,courrielPerso,courrielPro,serieBac,dateBac,mentionBac,diplome,dateDiplome) VALUES (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,etu.getNom());
            statement.setString(2,etu.getPrenom());
            statement.setString(3,etu.getDate_de_naissance());
            statement.setString(4,etu.getCourrielPerso());
            statement.setString(5,etu.getCourrielPro());
            statement.setString(6,etu.getSerieBac());
            statement.setString(7,etu.getDateBac());
            statement.setString(8,etu.getMentionBac());
            statement.setString(9,etu.getDiplome());
            statement.setString(10,etu.getDateDiplome());
            int status = statement.executeUpdate();
            System.out.println(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEtudiantById(Etudiant etu,int id) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("UPDATE etudiant SET nom=?,prenom=?,date_de_naissance=?,courrielPerso=?,courrielPro=?,serieBac=?,dateBac=?,mentionBac=?,diplome=?,dateDiplome=? WHERE id=?");
            statement.setString(1,etu.getNom());
            statement.setString(2,etu.getPrenom());
            statement.setString(3,etu.getDate_de_naissance());
            statement.setString(4,etu.getCourrielPerso());
            statement.setString(5,etu.getCourrielPro());
            statement.setString(6,etu.getSerieBac());
            statement.setString(7,etu.getDateBac());
            statement.setString(8,etu.getMentionBac());
            statement.setString(9,etu.getDiplome());
            statement.setString(10,etu.getDateDiplome());
            statement.setInt(11,id);
            int status = statement.executeUpdate();
            System.out.println(status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEtudiantById(int id) {
        Connection co = DBManager.getInstance().getConnection();
        try {
            PreparedStatement statement = co.prepareStatement("DELETE FROM etudiant WHERE id=?");
            statement.setInt(1,id);
            int status = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void BuildEtudiantFromReq(List<Etudiant> list, ResultSet rs) throws SQLException {
        while(rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date date_de_naissance = rs.getDate("date_de_naissance");
            String courrielPro= rs.getString("courrielPro");
            String courrielPerso = rs.getString("courrielPerso");
            String serieBac = rs.getString("serieBac");
            Date dateBac = rs.getDate("dateBac");
            String mentionBac = rs.getString("mentionBac");
            String diplome = rs.getString("diplome");
            Date dateDiplome = rs.getDate("dateDiplome");
            Etudiant etudiant = new Etudiant(id,nom,prenom,date_de_naissance,courrielPro,courrielPerso,serieBac,dateBac,mentionBac,diplome,dateDiplome);
            list.add(etudiant);
        }
    }

}
