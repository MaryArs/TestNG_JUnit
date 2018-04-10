package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class AppTest extends AppFixture {

    @Test (groups = "positive", dataProvider = "nameFiles")
    //***Positive test for Linux Ubuntu. Create file with general name.
    public void CreateGeneralFileTest(String nameFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(nameFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true,file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @DataProvider
    public Iterator<Object[]> nameFiles(){
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i<3; i++){
            data.add(new  Object[]{
            generateRandomFilesName()
            });
        }

        return data.iterator();
    }

    private Object generateRandomFilesName(){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString + ".txt";
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

