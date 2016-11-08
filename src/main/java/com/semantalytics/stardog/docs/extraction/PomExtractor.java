package com.semantalytics.stardog.docs.extraction;

import com.complexible.common.rdf.StatementSource;
import com.complexible.stardog.db.DatabaseConnection;
import com.complexible.stardog.docs.StardocsException;
import com.complexible.stardog.docs.extraction.RDFExtractor;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.openrdf.model.IRI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PomExtractor implements RDFExtractor {

    private Model pomToModel(File pathToPom) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(pathToPom));
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(in);
        return model;
    }

    public static void main(final String... args) {
        new PomExtractor().extract(null, null, Paths.get(args[0]));
    }

    @Override
    public StatementSource extract(final DatabaseConnection databaseConnection, final IRI iri, final Path path) throws StardocsException {
        try {
            final Model model = pomToModel(path.toFile());
            System.out.println("Description : " + model.getDescription());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
