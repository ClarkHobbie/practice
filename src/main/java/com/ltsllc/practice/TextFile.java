package com.ltsllc.practice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.lang.reflect.Type;

public class TextFile {
    protected File myFile;
    protected String myText;
    protected JsonObject myObject;

    public TextFile(File file)
        throws FileNotFoundException, IOException
    {
        myFile = file;
    }

    public String read()
            throws IOException {
        if (myObject == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String string;
            FileReader fileReader = new FileReader(myFile.toString());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine())
                stringBuffer.append(string);

            myText = stringBuffer.toString();
        }

        return myText;
    }

    public <T> T fromJson (Type type)
            throws IOException
    {
        read();
        if (myText != null)
        {
            Gson gson = new Gson();
            return gson.fromJson(myText, type);
        }

        return null;
    }
}
