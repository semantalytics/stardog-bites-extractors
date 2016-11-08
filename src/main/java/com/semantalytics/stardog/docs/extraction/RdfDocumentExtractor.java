package com.semantalytics.stardog.docs.extraction;

import com.complexible.common.rdf.StatementSource;
import com.complexible.common.rdf.impl.RDFFileReference;
import com.complexible.stardog.db.DatabaseConnection;
import com.complexible.stardog.docs.StardocsException;
import com.complexible.stardog.docs.extraction.RDFExtractor;
import org.openrdf.model.IRI;
import org.openrdf.query.resultio.QueryResultFormat;
import org.openrdf.query.resultio.QueryResultIO;

import java.nio.file.Path;
import java.util.Optional;

public class RdfDocumentExtractor implements RDFExtractor {

    @Override
    public StatementSource extract(DatabaseConnection databaseConnection, IRI iri, Path path) throws StardocsException {
        Optional<QueryResultFormat> queryResultFormat = QueryResultIO.getParserFormatForFileName(path.getFileName().toString());

        return null;
    }
}
