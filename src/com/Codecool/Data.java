package com.Codecool;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

    public void createText() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("todo.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    public void writeIntoText(String todo) {
        try {
            FileWriter writer = new FileWriter("todo.txt", true);
            writer.write(todo);
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getToDos() {
        List<String> todos = new ArrayList<String>();
        File myObj = new File("todo.txt");
        Scanner myReader = null;

        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            counter++;
            todos.add(counter + " " + data);
        }
        return (ArrayList) todos;
    }

    public List<String> deleteTask(String number){
        List<String> todos = new ArrayList<String>();
        File myObj = new File("todo.txt");
        Scanner myReader = null;
        int num = Integer.parseInt(number);

        try {
            myReader = new Scanner(myObj);
            int counter = 0;
            while (true) {
                assert myReader != null;
                if (!myReader.hasNextLine()) break;
                String data = myReader.nextLine();
                counter++;
                if (counter != num) {
                    todos.add(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public void overrideTodos(List<String> list){
        try {
            FileWriter myWriter = new FileWriter("todo.txt");
            for (String item:list
                 ) {
                myWriter.write(item);
                myWriter.write("\r\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
