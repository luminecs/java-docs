package com.mycompany.app.io.bytestreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(appRootPath + "/essential/io/xanadu.txt");
            outputStream = new FileWriter(appRootPath + "/essential/io/characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
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
