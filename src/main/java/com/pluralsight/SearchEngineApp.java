package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineApp {
    public static void main(String[] args) {
        Scanner cScans = new Scanner(System.in);

        while (true) {
        System.out.println("Enter a search term(X or x to exit): ");

        String sT = cScans.nextLine();

        if(sT.equalsIgnoreCase("x")) {
            logAction("Exit)");
            System.out.println("Goodbye!");
            break;
        }
       logAction("search: " + sT);
    }
        cScans.close();

}   public static void logAction(String action) {
        DateTimeFormatter cFormat = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));

        String timestamp = LocalDateTime.now().format((cFormat));

        try {
            FileWriter cWriter = new FileWriter("logs.txt", true);
            cWriter.write(timestamp + " " + action + "\n");

            cWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }


    }
}
