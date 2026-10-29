package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineApp {
    public static void main(String[] args) {

        ///Created my scanner
        Scanner cScans = new Scanner(System.in);

        //... Display application header
        System.out.println("==================================");
        System.out.println(">>    SEARCH ENGINE LOGGER  <<");
        System.out.println("==================================");
        System.out.println("Enter your search terms below");
        System.out.println("Type X to exit");
        System.out.println("==================================");
        System.out.println();


        /// A Loop for a search
        while (true) {
        System.out.println("Enter a search term(X or x to exit): ");

        String sT = cScans.nextLine();

        ///Check if the user want to exist
        if(sT.equalsIgnoreCase("x")) {
            logAction("Exit)");
            System.out.println("\nThank you for asking using Search Engine Logger");
            break;
        }

        /// Log the search term entered by the user
       logAction("search: " + sT);
    }
        /// Close Scanner to free resources
        cScans.close();

        /// Created a method to log the entries to the log.txt
}       public static void logAction(String action) {

        /// Format date and time
        DateTimeFormatter cFormat = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));

        /// Get the current logTime
        String logTime = LocalDateTime.now().format((cFormat));

        try {
            FileWriter cWriter = new FileWriter("logs.txt", true);

            /// Write the logTime and action to the file
            cWriter.write(logTime + " " + action + "\n");

            /// Close the file
            cWriter.close();
        } catch (IOException e) {

            /// Display error if file cannot be written
            System.out.println("Error writing to log file.");
        }


    }
}
