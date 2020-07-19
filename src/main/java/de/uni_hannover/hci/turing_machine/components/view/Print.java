package de.uni_hannover.hci.turing_machine.components.view;

import java.io.IOException;

import de.uni_hannover.hci.turing_machine.components.io.Module;

public class Print {
  Module file = new Module();

  public static void generateConfig(String programName) throws IOException {

    Module.createFile(programName);

    Module.addText("z0");
    Module.addText("\nz1");
    Module.addText("\nz2");
    Module.addText("\nz3");
    Module.addText("\nz4");
    Module.addText("\nz5");
    Module.addText("\nze");

    Module.addText("\n\nz0");
    Module.addText("\nze");

    Module.addText("\n\nz0, a, z0, a, R");
    Module.addText("\nz0, #, z1, #, R");
    Module.addText("\nz0,  , z0,  , R");
    Module.addText("\nz1, b, z1, b, R");
    Module.addText("\nz1, _, z2, _, L");

    Module.addText("\nz2, b, z2, b, L");
    Module.addText("\nz2, #, z2, #, L");
    Module.addText("\nz2, a, z2, a, L");
    Module.addText("\nz2, +, z2, +, L");
    Module.addText("\nz2, _, z3, _, R");

    // ...noch nicht fertig
    Module.closeWriter();
  }

}