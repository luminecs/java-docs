package com.mycompany.app.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(appRootPath + "/essential/io/xanadu.txt");
            out = new FileOutputStream(appRootPath + "/essential/io/outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
