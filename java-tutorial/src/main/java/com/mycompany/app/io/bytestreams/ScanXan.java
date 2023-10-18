package com.mycompany.app.io.bytestreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {
        String appRootPath = System.getProperty("user.dir");
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader(appRootPath + "/essential/io/xanadu.txt")));
            // s.useDelimiter(",\\s*");
            while (s.hasNext()) {
                System.out.println(s.next());
                // System.out.println(s.nextLine());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
