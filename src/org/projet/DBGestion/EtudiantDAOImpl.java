package org.projet.DBGestion;

import org.tutorial.DBManager;

import javax.json.*;
import javax.json.stream.JsonLocation;
import javax.json.stream.JsonParser;
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


            InputStream fis = new FileInputStream(filePath);

            JsonReader reader = Json.createReader(fis);

            JsonArray jsonArray = reader.readArray();

            reader.close();

            Etudiant etuTempo ;

            String id;
            String nom;
            String prenom;
            Date date_de_naissance;
            String courrielPro;
            String courrielPerso;
            String serieBac;
            String dateBac;
            String mentionBac;
            String diplome;
            Date dateDiplome;
            JsonObject tempo;

            for(int i = 0; i<3;i++){
                //etuTempo = new Etudiant()
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
                //dateDiplome = new Date(tempo.getString("anDiplome"));

                //date_de_naissance = java.text.DateFormat.getDateInstance().parse(tempo.getString("ddn"));
                date_de_naissance = new Date(tempo.getString("ddn"));
                etuTempo = new Etudiant(id, nom, prenom,date_de_naissance,dateBac);

                System.out.println(etuTempo.toString());
                System.out.println("-----------------<<<<<<<<>>>>>>--------------------");
            }
            //System.out.println(jsonArray);

            // DB connection setup
            Connection con = DBManager.getInstance().getConnection();

            // PreparedStatements
            PreparedStatement preparedStatement = con.prepareStatement("insert into  Table_Name values (?, ?, ?, ? )");



    } catch (SQLException e) {
            e.printStackTrace();
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
            statement.setString(2,etu.getDate_de_naissance());
            statement.setString(2,etu.getCourrielPerso());
            statement.setString(2,etu.getCourrielPro());
            statement.setString(2,etu.getSerieBac());
            statement.setString(2,etu.getDateBac());
            statement.setString(2,etu.getMentionBac());
            statement.setString(2,etu.getDiplome());
            statement.setString(2,etu.getDateDiplome());
            int status = statement.executeUpdate();
            System.out.println(status);
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
            //Etudiant etudiant = new Etudiant(id,nom,prenom,date_de_naissance,courrielPro,courrielPerso,serieBac,dateBac,mentionBac,diplome,dateDiplome);
            //list.add(etudiant);
        }
    }


    public static void main(String args[]){

    }
}
