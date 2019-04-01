package org.projet.DBGestion.WebServiceLink;

import org.projet.DBGestion.EtudiantDAO;
import org.projet.DBGestion.EtudiantDAOImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class URLToFile {


        public static void process(String url, String filePath){
            InputStream input = null;
            OutputStream output = null;
            try {
                input = new URL(url).openStream();
                output = new FileOutputStream(filePath);
                byte[] buffer = new byte[1024];
                for (int length ; (length = input.read(buffer)) > 0;) {
                    output.write(buffer, 0, length);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) try { output.close(); } catch (IOException ignored) {}
                if (input != null) try { input.close(); } catch (IOException ignored) {}
            }

        }

        public static void main(String[] args){


            //URLToFile.process("https://stormy-lowlands-39083.herokuapp.com/etudiants/", "outputRead/output.json");
            EtudiantDAOImpl.saveDatasInDB("outputRead/output.json");



        }
    }

