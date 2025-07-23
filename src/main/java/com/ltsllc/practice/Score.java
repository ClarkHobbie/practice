package com.ltsllc.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

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
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        Writer writer = new FileWriter(file);
        gson.toJson(this, writer);
        writer.close();
    }
}
