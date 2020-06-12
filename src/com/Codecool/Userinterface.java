package com.Codecool;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Userinterface {

    Data data = new Data();

    public void printTodos(ArrayList datas){
        for (Object todo: datas
        ) {
            System.out.println(todo.toString());
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void PrintMenu(String title, String[] list, String exitmessage)
    {
        System.out.println(title + ": \n");
        int counter = 0;

        for (String option: list
             ) {
            counter++;
            System.out.println(" (" + counter + ") " + option);
        }
        System.out.println(" (0) " + exitmessage);
    }

    /// <summary>
    /// Handling menu options nad print it out
    /// </summary>
    public void HandleMenu()
    {
        String[] options = new String[]
                {
                        "Add Task",
                        "Read Tasks",
                        "Delete Task",
                };
        PrintMenu("Main menu", options, "Exit program");
    }

    /// <summary>
    /// Helps us get input from user and choose a menu option depends on the input
    /// </summary>
    public void Choose()
    {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nPlease enter a number: ");
        String option = input.nextLine();

        if (option.equals("1"))
        {
            clearScreen();
            System.out.println("Please enter a task you want to add: ");
            String task = input.nextLine();
            data.writeIntoText(task);
            System.out.println("Task successfully added.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
        }
        else if (option.equals("2"))
        {
            clearScreen();
            printTodos(data.getToDos());
            System.out.println("\nPress enter to continue...\n");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (option.equals("3"))
        {
            clearScreen();
            System.out.println("Your Todos: ");
            printTodos(data.getToDos());
            clearScreen();
            System.out.println("Please enter the number of the task you want to delete:  ");
            String number = input.nextLine();
            data.overrideTodos(data.deleteTask(number));
            System.out.println("Task successfully deleted.");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
        }
        else if (option.equals("0"))
        {
            clearScreen();
            System.out.println("Closing the program, please wait...");
            // Terminate JVM
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        else
        {
            System.out.println("Wrong input! Try again.");
            try {
                TimeUnit.SECONDS.sleep(2);
                clearScreen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
