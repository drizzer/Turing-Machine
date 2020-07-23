package de.uni_hannover.hci.turing_machine.components.view;

import de.uni_hannover.hci.turing_machine.components.Controller;
import de.uni_hannover.hci.turing_machine.components.io.Module;
import java.io.IOException;

public class Print extends Controller {

  public static void generateConfig(String name) throws IOException {
    Module.createFile(name);

    Module.addText("#, a, b, +");

    // Iterator SetTransition
    Module.addText("\n\nz0");
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
