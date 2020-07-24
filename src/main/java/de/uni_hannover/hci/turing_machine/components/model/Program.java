package de.uni_hannover.hci.turing_machine.components.model;

import de.uni_hannover.hci.turing_machine.components.io.Module;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This class provides the program for the TM and prints the tape.
 * @author Mohamed Atya
 * @version v0.6
 */
public class Program extends TuringMachine {
  /** Counter for calls of each cell */
  public int[][] statCells;
  /** Counter for steps in total */
  public int statSteps;
  /** Counter for change of states */
  public int statChangeOfState;

  /*
   * //Zellen (für statCells) public int eins = 0;
   * public int zwei = 0;
   * public int drei = 0;
   * public int vier = 0;
   * public int funf = 0;
   * public int sechs = 0;
   * public int sieben = 0;
   */

  /**
   * This method takes the tape and prints a new tape s
   *
   * @author Mohamed Atya
   * @version 30.06.20
   *
   * @param String input
   * @throws FileNotFoundException
   */
  public boolean launch(String input) throws FileNotFoundException { // input = input_txt
    CurrentState = StartState;
    Tape = input;
    statSteps = 0; // counts the steps
    statChangeOfState = 0;
    int operations = 0;

    /*
     * for (int i = 0; i < 6; i++) { // Nummerierung Cell ID's von 0 bis 6
     * statCells[i][0] = i + 1; }
     */

    /*
     * Module.openFile(
     * "./src/main/java/de/uni_hannover/hci/turing_machine/components/model/lib/saves/EqualWordSize.txt"
     * ); Module.readFile(); Module.closeFile();
     */

    Module.printActions("output"); // Direct console output to text file

    while (!CurrentState.equals(AcceptState) && operations < 200 && !CurrentState.equals(RejectState)) {
      boolean foundTransition = false;
      Transition CurrentTransition = null;
      operations++;

      
      if (CurrentSymbol > 0) {
        System.out.println(
          Tape.substring(0, CurrentSymbol) + "|" + Tape.charAt(CurrentSymbol) + "|" +
          Tape.substring(CurrentSymbol) +
          " Zu: " +
          CurrentState
        );
      } else {
        System.out.println(
          Tape.substring(CurrentSymbol) + " Zu: " + CurrentState
        );
      }
      // if (!nextTransition.readState.equals(CurrentState)) {}

      Iterator<Transition> TransitionsIterator = TransitionSet.iterator();
      while (TransitionsIterator.hasNext() && foundTransition == false) {
        Transition nextTransition = TransitionsIterator.next();
        if (nextTransition.readState != nextTransition.writeState) {
          statChangeOfState++; // Counter for change of states
        }

        if (
          nextTransition.readState.equals(CurrentState) &&
          nextTransition.readSymbol == Tape.charAt(CurrentSymbol)
        ) {
          foundTransition = true;
          CurrentTransition = nextTransition;
        }
      }

      if (foundTransition == false) {
        System.err.println(
          "No valid transition! (State=" +
          CurrentState +
          ", Symbol=" +
          Tape.charAt(CurrentSymbol) +
          ")"
        );
        return false;
      } else {
        CurrentState = CurrentTransition.writeState;
        char[] tempTape = Tape.toCharArray();
        tempTape[CurrentSymbol] = CurrentTransition.writeSymbol;
        Tape = new String(tempTape);
        /*
         * switch (CurrentSymbol) { //Wie oft Index aufgerufen wird (eventuell muss
         * Zeile 96-142 verschoben werden, dahin wo Currentsymbol sich verändert) case
         * 0: statCells[i][1] = eins++; break; case 1: statCells[i][1] = zwei++; break;
         * case 2: statCells[i][1] = drei++; break; case 3: statCells[i][1] = vier++;
         * break; case 4: statCells[i][1] = funf++; break; case 5: statCells[i][1] =
         * sechs++; break; case 6: statCells[i][1] = sieben++; break; }
         */

        /*
         * for(int i = 0; i < 6; i++){ //setzen der visits switch (i) { case 0:
         * statCells[i][1] = eins; break; case 1: statCells[i][1] = zwei; break; case 2:
         * statCells[i][1] = drei; break; case 3: statCells[i][1] = vier; break; case 4:
         * statCells[i][1] = funf; break; case 5: statCells[i][1] = sechs; break; case
         * 6: statCells[i][1] = sieben;
         */
      }

      if (CurrentTransition.moveDirection == 2) {
        CurrentSymbol++;
        statSteps++; // counts the steps in total
      } else if (CurrentTransition.moveDirection == 0) {
        CurrentSymbol--;
        statSteps++; // counts the steps in total
      } else {
        statSteps++;
      }
      if (CurrentSymbol < 0) CurrentSymbol = 0;

      while (Tape.length() <= CurrentSymbol) {
        Tape = Tape.concat("_");
      }
    }
    if (CurrentState.equals(AcceptState)) {
      return true;
    } else {
      return false;
    }
  }
}
