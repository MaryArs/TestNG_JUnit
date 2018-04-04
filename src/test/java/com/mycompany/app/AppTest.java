package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

@Test
public class AppTest extends AppFixture {

    //***Positive test for Linux Ubuntu. Create file with general name.
    public void CreateGeneralFileTest() throws IOException {

        File file = new File(String.valueOf(path), "SimpleFile.txt");

        if (!file.exists()){
            Assert.assertTrue(file.createNewFile());
            System.out.println("File is created!");

        } else {

            System.out.println("File already exists!");
        }
    }

    //***Positive test for Linux Ubuntu. Create file with extension mp3.
    public void CreateAudioFileTest() throws IOException {
        File file = new File("File.mp3");
        if (!file.exists()){

            Assert.assertTrue(file.createNewFile());
            System.out.println("File is created!");

        } else {

            System.out.println("File already exists!");

        }
    }

     //***Negative test for Linux Ubuntu. Create file with inexistent extension.
    public void CreateFileWithoutExtension() throws IOException {
        File file = new File("%023Th.??");
        if (!file.exists()){

            Assert.assertTrue(file.createNewFile());
            System.out.println("File is created!");

        } else {

            System.out.println("File already exists!");

        }
    }

     //***Negative test for Linux Ubuntu. Create file with inappropriate symbol "/".
    @Test(expectedExceptions = {java.io.IOException.class})
    public void CreateInappropriateFileTest() throws IOException {
        File file = new File("</>*** **");
        if (!file.exists()){

            Assert.assertFalse(file.createNewFile());
            System.out.println("File is created!");

        } else {

            System.out.println("File already exists!");
        }
    }
}

