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

        Assert.assertFalse(file.exists());
        Assert.assertTrue(file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    //***Positive test for Linux Ubuntu. Create file with extension mp3.
    public void CreateAudioFileTest() throws IOException {
        File file = new File(String.valueOf(path),"File.mp3");
        Assert.assertFalse(file.exists());
        Assert.assertTrue(file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

     //***Negative test for Linux Ubuntu. Create file with inexistent extension.
    public void CreateFileWithoutExtension() throws IOException {
        File file = new File(String.valueOf(path),"%023Th.??");
        Assert.assertFalse(file.exists());
        Assert.assertTrue(file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

     //***Negative test for Linux Ubuntu. Create file with inappropriate symbol "/".
    @Test(expectedExceptions = {java.io.IOException.class})
    public void CreateInappropriateFileTest() throws IOException {
        File file = new File(String.valueOf(path),"</>*** **");
        Assert.assertFalse(file.exists());
        Assert.assertFalse(file.createNewFile());
        System.out.println("File is not created!");
    }
}

