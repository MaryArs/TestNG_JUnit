package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class AppTest extends AppFixture {

    @Test(groups = "positive", dataProvider = "nameFiles")
    //***Positive test for Linux Ubuntu. Create file with general name.
    public void CreateGeneralFileTest(String nameFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(nameFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @DataProvider
    public Iterator<Object[]> nameFiles() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new Object[]{
                    generateRandomFilesName()
            });
        }
        return data.iterator();
    }

    private Object generateRandomFilesName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString + ".txt";
    }

    @Test(groups = "positive", dataProvider = "nameAudioFiles")
    //***Positive test for Linux Ubuntu. Create file with extension mp3.
    public void CreateAudioFileTest(String nameAudioFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(nameAudioFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @DataProvider
    public Iterator<Object[]> nameAudioFiles() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new Object[]{
                    generateRandomAudioFilesName()
            });
        }
        return data.iterator();
    }

    private Object generateRandomAudioFilesName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString + ".mp3";
    }

    @Test(groups = "positive", dataProviderClass = DataProviders.class, dataProvider = "loadFileNamesFromFile")
    //***Positive test for Linux Ubuntu. Create file with inexistent extension.
    public void CreateFileWithoutExtension(String loadFileNamesFromFile) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(loadFileNamesFromFile));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(true, file.createNewFile());
        System.out.println("File is created!");
        file.delete();
    }

    @Test(groups = "negative", expectedExceptions = {java.io.IOException.class}, dataProvider = "inappropriateNameFiles")
    //***Negative test for Linux Ubuntu. Create file with inappropriate symbol "/".
    public void CreateInappropriateFileTest(String inappropriateNameFiles) throws IOException {
        File file = new File(String.valueOf(path), String.valueOf(inappropriateNameFiles));
        Assert.assertFalse(file.exists());
        Assert.assertEquals(false, file.createNewFile());
        System.out.println("File is not created!");
    }

    @DataProvider
    public Iterator<Object[]> inappropriateNameFiles() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new Object[]{
                    generateRandomInappropriateFilesName()
            });
        }
        return data.iterator();
    }

    private Object generateRandomInappropriateFilesName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString + "/" + generatedString;
    }
}

