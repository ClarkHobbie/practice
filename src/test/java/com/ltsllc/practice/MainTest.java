package com.ltsllc.practice;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @Test
    void createNewScoreFile() throws Exception {
        File file = new File("practice.txt");

        Main main = new Main();
        main.createNewScoreFile(file);

        FileInputStream fileInputStream = new FileInputStream(file);
        String contents = new String(fileInputStream.readAllBytes());
        String expected = "{\n" +
                "  \"password\": null,\n";

        assert (contents.startsWith(expected));
    }
}