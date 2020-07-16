package de.uni_hannover.hci.turing_machine.components.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Module {
  /*
   * public static void main(String[] args) throws FileNotFoundException { 
   * Module test = new Module();
   * test.setFile("data1");
   * Module.writeOutput("data2", "eyyyyyy"); 
   * }
   */

  public void setFile(String fileName) throws FileNotFoundException {

    try {
      PrintStream console = new PrintStream("./" + fileName + ".txt");
      System.setOut(console); // konsole inhalt in Objekt console speichern
    } catch (FileNotFoundException fx) {
      System.out.println(fx);
    }
  }

  public static void writeOutput(String fileName, String newText) {
    try {
      FileWriter myWriter = new FileWriter(fileName + ".txt");
      myWriter.write(newText);
      System.out.println("Successfully wrote to the file.");
      myWriter.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
