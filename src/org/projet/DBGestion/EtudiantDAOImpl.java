package org.projet.DBGestion;

import org.tutorial.DBManager;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class EtudiantDAOImpl implements EtudiantDAO {

   /* private static EtudiantDAOImpl instance;*/
    public static ArrayList<Etudiant> datas;



   public EtudiantDAOImpl(){}


    public static void saveDatasInDB(String filePath){
        try {

            System.out.println("<<<ENTREEE saveDatas >>>>>>>>");
            InputStream fis = new FileInputStream(filePath);
            System.out.println("<<< Juste avant JSON >>>>>>>>");
             JsonReader reader = Json.createReader(fis);

            JsonArray jsonArray = reader.readArray();

            reader.close();

            System.out.println("<<<on a lu le fichier >>>>>>>>");

            Etudiant etuTempo ;

            String id;
            String nom;
            String prenom;
            String date_de_naissance;
            String courrielPro;
            String courrielPerso;
            String serieBac;
            String dateBac;
            String mentionBac;
            String diplome;
            String dateDiplome;
            JsonObject tempo;

            EtudiantServiceImpl  etudiantDAO = new EtudiantServiceImpl();


            for(int i = 0; i<3;i++){
                //etuTempo = new Etudiant()
                System.out.println("<<<entrée Boucle >>>>>>>>");
                tempo = (JsonObject) jsonArray.get(i);
                id = tempo.getString("numetudiant");
                prenom = tempo.getString("prenom");
                nom = tempo.getString("nom");
                courrielPro = tempo.getString("emailPro");
                courrielPerso = tempo.getString("emailPerso");
                serieBac = tempo.getString("bac");
                mentionBac = tempo.getString("menBac");
                dateBac = tempo.getString("anBac");
                diplome = tempo.getString("diplome");
                dateDiplome = tempo.getString("anDiplome");

                //date_de_naissance = java.text.DateFormat.getDateInstance().parse(tempo.getString("ddn"));
                date_de_naissance = tempo.getString("ddn");
                System.out.println("<<<avant etudiant>>>>>>>>");
                etuTempo = new Etudiant(id, nom, prenom,date_de_naissance,courrielPro,courrielPerso,serieBac,dateBac,mentionBac,diplome,dateDiplome);
                etudiantDAO.addEtudiant(etuTempo);
                System.out.println(etuTempo.toString());
                System.out.println("-----------------<<<<<<<<>>>>>>--------------------");
            }
            //System.out.println(jsonArray);

            // DB connection setup
            //Connection con = DBManager.getInstance().getConnection();

            // PreparedStatements
            //PreparedStatement preparedStatement = con.prepareStatement("insert into  Table_Name values (?, ?, ?, ? )");



    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> findByAll() {
        Connection co = DBManager.getInstance().getConnection();
        List<Etudiant> list = new ArrayList<>();

        try {
            Statement statement = co.createStatement();
            System.out.println("<<<<<méthode findByAll >>>>>>");
            ResultSet rs = statement.executeQuery("select * from etudiant");
            BuildEtudiantFromReq(list, rs);
            System.out.println(list);
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

    private void BuildEtudiantFromReq(List<Etudiant> list, ResultSet rs) throws SQLException {
        while(rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String date_de_naissance = rs.getString("date_de_naissance");
            String courrielPro= rs.getString("courrielPro");
            String courrielPerso = rs.getString("courrielPerso");
            String serieBac = rs.getString("serieBac");
            String dateBac = rs.getString("dateBac");
            String mentionBac = rs.getString("mentionBac");
            String diplome = rs.getString("diplome");
            String dateDiplome = rs.getString("dateDiplome");
            Etudiant etudiant = new Etudiant(id,nom,prenom,date_de_naissance,courrielPro,courrielPerso,serieBac,dateBac,mentionBac,diplome,dateDiplome);
            list.add(etudiant);
        }
    }


    public static void main(String args[]){
            EtudiantDAOImpl.saveDatasInDB("outputRead/output.json");
    }
}
