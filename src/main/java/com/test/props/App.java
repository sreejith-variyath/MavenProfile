package com.test.props;

import javax.xml.crypto.Data;

/**
 * Created by sreejith on 3/13/2018.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Config using class attributes");
        DatabaseConfiguration dbConig = DatabaseConfiguration.getInstance();
        System.out.println(dbConig.getUsername());
        System.out.println("Config using java util Properties");
        Configuration config = Configuration.getInstance();
        System.out.println("hostname : " + config.getSystemValue("hostname"));
    }
}
