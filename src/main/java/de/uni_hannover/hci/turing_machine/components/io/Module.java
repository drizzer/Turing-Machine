package de.uni_hannover.hci.turing_machine.components.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;
import java.util.Formatter;
import java.util.Scanner;


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
        "./src/main/java/de/uni_hannover/hci/turing_machine/components/io/" +
        fileName +
        ".turm"
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
          "./src/main/java/de/uni_hannover/hci/turing_machine/components/model/lib/saves/" +
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
      myWriter.append(newText);
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

  public static void openFile(String fileName) {
    try {
      scanner = new Scanner(new File(fileName));
    } catch (Exception e) {
      System.out.println("Could not find file");
    }
  }

  public static void readFile() throws IOException {
    // while(scanner.hasNext()) {
    String title = scanner.next();
    String alphabet = scanner.next();

    Module.createFile(title);
    Module.addText(alphabet);
    // }
  }

  public static void closeFile() {
    scanner.close();
  }
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
