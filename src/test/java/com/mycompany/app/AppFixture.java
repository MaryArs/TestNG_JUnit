package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.*;

@Test
public class AppFixture {

   public Path path;

    @BeforeClass
    public void CreateTempDirectory() throws IOException {
        Path basepath = Paths.get("./");
        System.out.println(basepath);
        path = Files.createTempDirectory(basepath,"myFile");
        System.out.println("Temporary directory was created in :  " + path);
    }

    @AfterClass
    public void  DeleteTempDirectory() throws IOException {
      path.toFile().deleteOnExit();
      System.out.println("Temporary directory is deleted!");
    }
}
