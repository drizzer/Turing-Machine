package de.uni_hannover.hci.turing_machine.components.model;

import de.uni_hannover.hci.turing_machine.components.io.Module;

import java.util.*;

import java.io.FileNotFoundException;

public class Program extends TuringMachine {
	/** Counter for calls of each cell */
	protected int[] statCells;
	/** Counter for steps in total */
	protected int statSteps;
	/** Counter for change of states */
	protected int statChangeofstates;

	Module output = new Module();

	/**
	 * This method takes the tape and prints a new tape s
	 * 
	 * @author Mohamed Atya
	 * @version 30.06.20
	 */
	public boolean launch(String input) throws FileNotFoundException {
		CurrentState = StartState;
		Tape = input;
		statSteps = 0; // counts the steps
		int operations = 0;

		// Direct console output to text file
		Module.printActions("output");

		while (!CurrentState.equals(AcceptState) && operations < 80) {
			boolean foundTransition = false;
			Transition CurrentTransition = null;
			operations++;

			if (CurrentSymbol > 0) {
				System.out.println(Tape.substring(0, CurrentSymbol) + Tape.substring(CurrentSymbol) + " Zu: " + CurrentState);
			} else {
				System.out.println(Tape.substring(CurrentSymbol) + " Zu: " + CurrentState);
			}
			// if (!nextTransition.readState.equals(CurrentState)) {}

			Iterator<Transition> TransitionsIterator = TransitionSet.iterator();
			while (TransitionsIterator.hasNext() && foundTransition == false) {
				Transition nextTransition = TransitionsIterator.next();

				if (nextTransition.readState.equals(CurrentState) && nextTransition.readSymbol == Tape.charAt(CurrentSymbol)) {
					foundTransition = true;
					CurrentTransition = nextTransition;
				}
			}

			if (foundTransition == false) {
				System.err
						.println("No valid transition! (State=" + CurrentState + ", Symbol=" + Tape.charAt(CurrentSymbol) + ")");
				return false;

			} else {
				CurrentState = CurrentTransition.writeState;
				char[] tempTape = Tape.toCharArray();
				tempTape[CurrentSymbol] = CurrentTransition.writeSymbol;
				Tape = new String(tempTape);

				if (CurrentTransition.moveDirection == true) {
					CurrentSymbol++;
					statSteps++; // counts the steps in total
				} else {
					CurrentSymbol--;
					statSteps++; // counts the steps in total
				}

				if (CurrentSymbol < 0)
					CurrentSymbol = 0;

				while (Tape.length() <= CurrentSymbol) {
					Tape = Tape.concat("_");
				}
			}
		}

		if (CurrentState.equals(AcceptState)) {
			return true;
		} else {
			return false;
		}

	}
}
