package com.mycompany.app.io.bytestreams;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(appRootPath + "/essential/io/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter(appRootPath + "/essential/io/characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
