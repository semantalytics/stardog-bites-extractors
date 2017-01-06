package com.semantalytics.stardog.docs.extraction;

import com.complexible.common.rdf.StatementSource;
import com.complexible.stardog.db.DatabaseConnection;
import com.complexible.stardog.docs.StardocsException;
import com.complexible.stardog.docs.extraction.RDFExtractor;
import org.openrdf.model.IRI;

import java.nio.file.Path;

public class XmlDocumentExtractor implements RDFExtractor {

    @Override
    public StatementSource extract(DatabaseConnection databaseConnection, IRI iri, Path path) throws StardocsException {
        return null;
    }
}
