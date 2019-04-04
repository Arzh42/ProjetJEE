package org.projet.DBGestion.WebServiceLink;

import org.projet.DBGestion.EtudiantDAO;
import org.projet.DBGestion.EtudiantDAOImpl;

import java.io.*;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class URLToFile {


        public static void process(String url){
            InputStream input = null;
            try {
                input = new URL(url).openStream();
                EtudiantDAOImpl.saveDatasInDB(input);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (input != null) try { input.close(); } catch (IOException ignored) {}
            }
        }
    }

