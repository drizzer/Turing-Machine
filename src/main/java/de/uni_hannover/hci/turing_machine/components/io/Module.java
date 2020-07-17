package de.uni_hannover.hci.turing_machine.components.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Formatter;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Module {
  public static Formatter formatter;
  public static File file;

  public static void printActions(String fileName) throws FileNotFoundException {

    try {
      PrintStream console = new PrintStream("./src/main/java/de/uni_hannover/hci/turing_machine/components/io/" + fileName + ".txt");
      System.setOut(console); // konsole inhalt in Objekt console speichern
    } catch (FileNotFoundException fx) {
      System.out.println(fx);
    }
  }

  public static void createFile(String fileName, String newText) {
    try {
      FileWriter myWriter = new FileWriter(fileName + ".txt");
      myWriter.write(newText);
      myWriter.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void addText(String fileName, String newText) throws IOException {
    try {
      FileWriter myWriter = new FileWriter(fileName + ".txt");
      myWriter.append(newText);
      myWriter.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public static void openFile(String fileName) {
    try {
      formatter = new Formatter("./" + fileName + ".txt");
    } catch (Exception e) {
      System.out.println("Formatter Error");
    }
  }

  public static void addAlphabet(String alphabet) {
    formatter.format("%s%s%s", alphabet);
  }

}
