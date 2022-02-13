package com.ltsllc.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args)
            throws IOException {
        File file = new File("practice.txt");
        java.io.FileReader fileReader = new java.io.FileReader("practice.txt");
        TextFile textFile = new TextFile(file);
        Score score = textFile.fromJson(Score.class);
        System.out.print("practice> ");

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        score.total++;
        if (score.password.equals(bufferedReader.readLine())) {
            System.out.println("correct");
            score.correct++;
        } else {
            System.out.println("wrong");
        }
        score.printRatio();
        score.save(file);
    }
}
