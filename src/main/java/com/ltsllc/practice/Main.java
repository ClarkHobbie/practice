package com.ltsllc.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {

    public static void main (String[] args)
            throws IOException {
        Main main = new Main();
        main.main1(args);
    }

    public void main1(String[] args)
            throws IOException {
        File file = new File("practice.txt");
        if (!file.exists()) {
            createNewScoreFile(file);
        }


        FileInputStream fileInputStream = new FileInputStream(file);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();

        String json = new String(fileInputStream.readAllBytes());

        Score score = gson.fromJson(json, Score.class);
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

    public void createNewScoreFile(File file) throws IOException{
        Score score = new Score();
        score.correct = 0;
        score.total = 0;
        score.password = null;
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(score);

        fileOutputStream.write(json.getBytes());

        fileOutputStream.close();
    }
}
