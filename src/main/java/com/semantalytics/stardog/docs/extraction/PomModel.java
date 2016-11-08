package com.semantalytics.stardog.docs.extraction;

import com.complexible.common.rdf.StatementSource;
import com.complexible.stardog.db.DatabaseConnection;
import com.complexible.stardog.docs.StardocsException;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.openrdf.model.IRI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by zwhitley on 11/28/2016.
 */
public class PomModel {

    private Model pomToModel(File pathToPom) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(pathToPom));
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(in);
        return model;
    }

    public static void main(final String... args) {
        try {
            final Model model = new PomModel().pomToModel(Paths.get(args[0]).toFile());
            System.out.println("Developer : " + model.getDevelopers().get(0).getName());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
