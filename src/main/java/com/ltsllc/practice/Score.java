package com.ltsllc.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Score {
    public String password;
    public int correct;
    public int total;

    public void printRatio() {
        System.out.print(correct + "/" + total);
        System.out.println(" (" + (double) correct / total + ")");
    }

    public void save (File file)
        throws IOException
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        Writer writer = new FileWriter(file);
        gson.toJson(this, writer);
        writer.close();
    }
}
