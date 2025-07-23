package com.ltsllc.practice;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void save() throws Exception {
        Score score = new Score();
        score.correct = 0;
        score.total = 0;
        score.password = null;

        File file = new File("practice.txt");

        if (file.exists()) {
            file.delete();
        }

        score.save(file);

        FileInputStream fileInputStream = new FileInputStream(file);
        String json = new String(fileInputStream.readAllBytes());
        String expected = "{\n" +
                "  \"password\": null,\n" +
                "  \"correct\": 0,\n" +
                "  \"total\": 0\n" +
                "}";

        assert (file.exists());
        assert (json.equalsIgnoreCase(expected));
    }
}