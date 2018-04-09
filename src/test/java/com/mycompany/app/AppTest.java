package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


public class AppTest extends AppFixture {

    @Test (groups = "positive")
    //***Positive test for Linux Ubuntu. Create file with general name.
    public void CreateGeneralFileTest() throws IOException {
        File file = new File(String.valueOf(path), "SimpleFile.txt");
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true,file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }
    @Test (groups = "positive")
    //***Positive test for Linux Ubuntu. Create file with extension mp3.
    public void CreateAudioFileTest() throws IOException {
        File file = new File(String.valueOf(path),"File.mp3");
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }
    @Test (groups = "positive")
     //***Positive test for Linux Ubuntu. Create file with inexistent extension.
    public void CreateFileWithoutExtension() throws IOException {
        File file = new File(String.valueOf(path),"%023Th.??");
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @Test(groups = "negative", expectedExceptions = {java.io.IOException.class})
     //***Negative test for Linux Ubuntu. Create file with inappropriate symbol "/".
    public void CreateInappropriateFileTest() throws IOException {
        File file = new File(String.valueOf(path),"</>*** **");
        Assert.assertFalse(file.exists());
        Assert.assertEquals(false, file.createNewFile());
        System.out.println("File is not created!");
    }
}

