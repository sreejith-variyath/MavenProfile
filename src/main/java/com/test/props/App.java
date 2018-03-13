package com.test.props;

import javax.xml.crypto.Data;

/**
 * Created by sreejith on 3/13/2018.
 */
public class App {

    public static void main(String[] args){
        System.out.println("Testing");
        DatabaseConfiguration dbConig = DatabaseConfiguration.getInstance();
        System.out.println(dbConig.getUsername());
    }
}
