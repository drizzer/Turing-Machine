package de.uni_hannover.hci.turing_machine.components.model;

/**
 * This class contains the Programms that can be executed on the Turing machine
 *
 * @author Mohamed El Hedi Atya
 * @version 30.06.20
 *
 */

public final class ProgramsList extends Program {

  private ProgramsList() {}

  /**
   * Checks if the input is correct for TM Programm A's and B's.
   *
   * @author Lisanne Haase
   * @version 01.07.20
   */
  public static Program EqualWordSize() {
    Program newTM = new Program();

    newTM.addState("z0");
    newTM.addState("z1");
    newTM.addState("z2");
    newTM.addState("z3");
    newTM.addState("z4");
    newTM.addState("z5");
    newTM.addState("ze");

    newTM.setStartState("z0");
    newTM.setAcceptState("ze");

    newTM.addTransition("z0", 'a', "z0", 'a', 2);
    newTM.addTransition("z0", '#', "z1", '#', 2);
    newTM.addTransition("z0", ' ', "z0", ' ', 2);
    newTM.addTransition("z1", 'b', "z1", 'b', 2);
    newTM.addTransition("z1", ' ', "z2", ' ', 0); // loop here

    newTM.addTransition("z2", 'b', "z2", 'b', 0);
    newTM.addTransition("z2", '#', "z2", '#', 0);
    newTM.addTransition("z2", 'a', "z2", 'a', 0);
    newTM.addTransition("z2", '+', "z2", '+', 0);
    newTM.addTransition("z2", ' ', "z3", ' ', 2);

    newTM.addTransition("z3", '+', "z3", '+', 2);
    newTM.addTransition("z3", 'a', "z4", '+', 2);
    newTM.addTransition("z4", '+', "z4", '+', 2);
    newTM.addTransition("z4", 'a', "z4", 'a', 2);
    newTM.addTransition("z4", '#', "z4", '#', 2);
    newTM.addTransition("z4", 'b', "z2", '+', 0);

    newTM.addTransition("z3", '#', "z5", '#', 2);
    newTM.addTransition("z5", '+', "z5", '+', 2);
    newTM.addTransition("z5", ' ', "ze", ' ', 1); // nicht mehr bewegen

    return newTM;
  }

  /**
   * Checks if the input is correct for TM Programm Annagramme.
   *
   * @author Lisanne Haase
   * @version 01.07.20
   */
  public static Program Anagram() {
    Program newTM = new Program();

    newTM.addState("z0");
    newTM.addState("z1");
    newTM.addState("z2");
    newTM.addState("z11");
    newTM.addState("z22");
    newTM.addState("z3");
    newTM.addState("z33");
    newTM.addState("z4");
    newTM.addState("z5");
    newTM.addState("ze");

    newTM.setStartState("z0");
    newTM.setAcceptState("ze");

    newTM.addTransition("z0", 'a', "z1", '+', 2);
    newTM.addTransition("z0", 'b', "z2", '+', 2);
    newTM.addTransition("z0", '$', "z3", '$', 2);

    newTM.addTransition("z1", 'a', "z1", 'a', 2);
    newTM.addTransition("z1", 'b', "z1", 'b', 2);
    newTM.addTransition("z1", '+', "z1", '+', 2);
    newTM.addTransition("z1", '#', "z11", '#', 2);

    newTM.addTransition("z2", 'a', "z2", 'a', 2);
    newTM.addTransition("z2", 'b', "z2", 'b', 2);
    newTM.addTransition("z2", '+', "z2", '+', 2);
    newTM.addTransition("z2", '#', "z22", '#', 2);

    newTM.addTransition("z3", '#', "z33", '#', 2);
    newTM.addTransition("z33", '$', "ze", '$', 1);

    newTM.addTransition("z11", 'a', "z4", '+', 0);
    newTM.addTransition("z11", '+', "z11", '+', 2);
    newTM.addTransition("z11", 'b', "z11", 'b', 2);

    newTM.addTransition("z22", 'b', "z4", '+', 0);
    newTM.addTransition("z22", '+', "z22", '+', 2);
    newTM.addTransition("z22", 'a', "z22", 'a', 2);

    newTM.addTransition("z4", 'a', "z4", 'a', 0);
    newTM.addTransition("z4", 'b', "z4", 'b', 0);
    newTM.addTransition("z4", '+', "z4", '+', 0);
    newTM.addTransition("z4", '#', "z4", '#', 0);
    newTM.addTransition("z4", '$', "z0", '$', 2);

    newTM.addTransition("z0", '+', "z0", '+', 2);
    newTM.addTransition("z0", '#', "z5", '#', 2);

    newTM.addTransition("z5", '+', "z5", '+', 2);
    newTM.addTransition("z5", '$', "ze", '$', 1);

    return newTM;
  }
/*
  public static Program EqualBinaryWords() {
    Program newTM = new Program();
    newTM.addState("q1");
    newTM.addState("q2");
    newTM.addState("q3");
    newTM.addState("q4");
    newTM.addState("q5");
    newTM.addState("q6");
    newTM.addState("q7");
    newTM.addState("q8");
    newTM.addState("qa");
    newTM.addState("qr");

    newTM.setStartState("q1");
    newTM.setAcceptState("qa");

    newTM.addTransition("q1", '1', "q3", 'x', true);
    newTM.addTransition("q1", '0', "q2", 'x', true);
    newTM.addTransition("q1", '#', "q8", '#', true);
    newTM.addTransition("q2", '0', "q2", '0', true);
    newTM.addTransition("q2", '1', "q2", '1', true);
    newTM.addTransition("q2", '#', "q4", '#', true);
    newTM.addTransition("q3", '0', "q3", '0', true);
    newTM.addTransition("q3", '1', "q3", '1', true);
    newTM.addTransition("q3", '#', "q5", '#', true);
    newTM.addTransition("q4", 'x', "q4", 'x', true);
    newTM.addTransition("q4", '0', "q6", 'x', false);
    newTM.addTransition("q5", 'x', "q5", 'x', true);
    newTM.addTransition("q5", '1', "q6", 'x', false);
    newTM.addTransition("q6", '0', "q6", '0', false);
    newTM.addTransition("q6", '1', "q6", '1', false);
    newTM.addTransition("q6", 'x', "q6", 'x', false);
    newTM.addTransition("q6", '#', "q7", '#', false);
    newTM.addTransition("q7", '0', "q7", '0', false);
    newTM.addTransition("q7", '1', "q7", '1', false);
    newTM.addTransition("q7", 'x', "q1", 'x', true);
    newTM.addTransition("q8", 'x', "q8", 'x', true);
    newTM.addTransition("q8", ' ', "qa", ' ', true);
    return newTM;
  }*/
}
