package com.mycompany.app;

import org.junit.*;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class AppTest extends  AppFixture implements MyCategories {

    @Test
    @Category(MyCategories.PositiveTests.class)
    //***Positive test for Linux Ubuntu. Create file with general name.
    public void CreateGeneralFileTest(String nameFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(nameFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @Test
    @Category(MyCategories.PositiveTests.class)
    //***Positive test for Linux Ubuntu. Create file with extension mp3.
    public void CreateAudioFileTest(String nameAudioFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(nameAudioFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @Test
    @Category(MyCategories.PositiveTests.class)
    //***Positive test for Linux Ubuntu. Create file with inexistent extension.
    public void CreateFileWithoutExtension(String loadFileNamesFromFile) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(loadFileNamesFromFile));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @Test
    @Category(MyCategories.NegativeTests.class)
    //***Negative test for Linux Ubuntu. Create file with inappropriate symbol "/".
    public void CreateInappropriateFileTest(String inappropriateNameFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(inappropriateNameFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(false, file.createNewFile());
        System.out.println("File is not created!");
    }
}

