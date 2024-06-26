package com.seleniumProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProprtiesFile {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
        //create property obj
        Properties pro = new Properties();
        //load file
        pro.load(file);
        String u = pro.getProperty("url");
        String n = pro.getProperty("name");
        String s = pro.getProperty("surname");
        System.out.println(u+" "+n+" "+s);

    }
}
