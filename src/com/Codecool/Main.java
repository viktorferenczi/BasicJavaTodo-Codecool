package com.Codecool;

import java.io.File;

public class Main {

    public static void main(String[] args) {

       Data data = new Data();
       Userinterface ui = new Userinterface();
       File file = new File("todo.txt");
       boolean todoExists = file.exists();

       if (!todoExists)
        data.createText();

        while (true)
        {
            ui.HandleMenu();
            ui.Choose();
        }
    }
}
