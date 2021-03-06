package de.uni_hannover.hci.turing_machine.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;
import java.util.Formatter;
import java.util.Scanner;
import java.io.BufferedReader; //Scanner
import java.io.FileReader;

/**
 * This class provides methods for creating, reading and closing a file.
 * @author Mohamed Atya
 * @version v0.6
 */
public class Module {
  public static FileWriter myWriter;
  public static Scanner scanner;

  public static Formatter formatter;

  /**
   * Directing the console output and saves the input in a file
   *
   * @version v0.4
   * @param fileName
   * @throws FileNotFoundException
   */
  public static void printActions(String fileName)
    throws FileNotFoundException {
    try {
      PrintStream console = new PrintStream(
        "./" +
        fileName +
        ".txt"
      );
      System.setOut(console); // konsole inhalt in Objekt console speichern
    } catch (FileNotFoundException fx) {
      System.out.println(fx);
    }
  }

  /**
   * Creates a new file
   *
   * @param fileName
   * @param newText
   */
  public static void createFile(String fileName) {
    try {
      myWriter =
        new FileWriter(
          "./" +
          fileName +
          ".turm"
        );
      myWriter.write(fileName + "\n\n");
    } catch (IOException e) {
      System.out.println("Could not create file.");
      e.printStackTrace();
    }
  }

  /**
   * Appends text to a file
   *
   * @param fileName
   * @param newText
   * @throws IOException
   */
  public static void addText(String newText) throws IOException {
    try {
      myWriter.append("\n" + newText);
    } catch (IOException e) {
      System.out.println("Could not add text to file.");
      e.printStackTrace();
    }
  }

  /**
   * Closes the FileWriter object
   *
   * @throws IOException
   */
  public static void closeWriter() throws IOException {
    try {
      myWriter.append("\n\n" + "End");
      myWriter.close();
    } catch (IOException e) {
      System.out.println("Could not close file.");
      e.printStackTrace();
    }
  }


  /**
   * This method puts the Output of the console in a String
   */
  public static String buffReader(String fileName) throws FileNotFoundException, IOException {
  
    FileReader file = new FileReader(fileName); //Weg zur Datei
    BufferedReader reader = new BufferedReader(file);

    String text = "";
    String line = reader.readLine(); //liest Reihe nach Reihe
    while((line = reader.readLine()) != null){
      line = reader.readLine();

        text += line + "\n";       //erste Reihe von Datei wird in test gespeichert
    }
      return text;
    
  }
/*
  public static String buffReaderLoad(String fileName) {

    FileReader file = new FileReader(fileName); //Weg zur Datei
    BufferedReader reader = new BufferedReader(file);

    String text = "";
    String line = reader.readLine(); //liest Reihe nach Reihe
    while(line != null){

        text += line + "\n";       //erste Reihe von Datei wird in test gespeichert
        line = reader.readLine();
    }
      return text;

  } */
  /*
   *
   * public static void openFile(String fileName) { try { formatter = new
   * Formatter(fileName + ".txt"); } catch (Exception e) {
   * System.out.println("Formatter Error"); } }
   *
   * public static void addAlphabet(String alphabet) { formatter.format("%s%s%s",
   * alphabet); }
   */
}

