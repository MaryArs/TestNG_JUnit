package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.*;
import org.junit.rules.ExternalResource;

public class AppFixture {

    protected static Path path;

    @ClassRule
    public static ExternalResource fileRule = new ExternalResource() {

        @Override
        protected void before() throws IOException {
            Path basepath = Paths.get("./");
            path = Files.createTempDirectory(basepath, "myFile");
            System.out.println("Temporary directory was created in :  " + path);
        }

        @Override
        protected void after() {
            path.toFile().deleteOnExit();
            System.out.println("Temporary directory is deleted!");
        }
    };
}
