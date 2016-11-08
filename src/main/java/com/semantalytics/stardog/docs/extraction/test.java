package com.semantalytics.stardog.docs.extraction;

import com.complexible.common.rdf.StatementSource;
import com.complexible.stardog.db.DatabaseConnection;
import com.complexible.stardog.docs.StardocsException;
import com.google.common.io.Files;
import org.openrdf.model.IRI;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.joor.Reflect.*;

public class test {

    public static void main(String... args) throws IOException {
        Path path = Paths.get(args[0]);
        String binaryName = Files.getNameWithoutExtension(path.getFileName().toString());
        List<String> binaryNames = new ArrayList<>();
        binaryNames.add(binaryName);
        List<URL> urls = new ArrayList<>();
        for(path = path.getParent(); path != null; path = path.getParent()) {
            binaryName = path.getFileName() + "." + binaryName;
            binaryNames.add(binaryName);
            urls.add(path.toFile().toURI().toURL());
        }
        ClassLoader classLoader = URLClassLoader.newInstance(urls.toArray(new URL[0]));
        Class clazz = null;
        for(String bn : binaryNames) {
            try {
                System.out.println("Attempting to load class " + bn);
                clazz = classLoader.loadClass(bn);
            } catch(ClassNotFoundException | NoClassDefFoundError e) {
                System.out.println("Class not found for " + bn);
                continue;
            }
            System.out.println("Successfully loaded " + bn);
            for(Constructor constructor : clazz.getConstructors()) {
                System.out.println("Constructor " + constructor.getName());
            }

            break;
        }
    }
}
