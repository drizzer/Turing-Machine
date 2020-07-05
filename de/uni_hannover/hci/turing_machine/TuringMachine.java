package de.uni_hannover.hci.turing_machine;

import java.util.*;

public class TuringMachine {
	/** Set of names for all possible states (e.g. qo - q5) */
	private Set<String> StateSet;
	/** Set of all existing transitions */
	private Set<Transition> TransitionSet;
	/** Starting state of the program e.g. q0 */
	private String StartState;
	/** State in which the output is accepted */
	private String AcceptState;

	/** Tape content as String with all symbols (seperator included */
	private String Tape;
	/** String with current state e.g. q3 */
	private String CurrentState;
	/** Index of current symbol */
	private int CurrentSymbol;

	class Transition {
		String readState;
		char readSymbol;
		String writeState;
		char writeSymbol;
		boolean moveDirection; // true is right, false is left
	}

	/**
	 * This constructor provides an empty TM.
	 * 
	 * @author Lisanne Haase
	 * @version 30.06.20
	 */
	public TuringMachine() {
		StateSet = new HashSet<String>();
		TransitionSet = new HashSet<Transition>();
		StartState = new String("");
		AcceptState = new String("");
		Tape = new String("");
		CurrentState = new String("");
		CurrentSymbol = 0;
	}

	public boolean Run(String input) {
		CurrentState = StartState;
		Tape = input;

		while (!CurrentState.equals(AcceptState)) {
			boolean foundTransition = false;
			Transition CurrentTransition = null;

			if (CurrentSymbol > 0) {
				System.out.println(Tape.substring(0, CurrentSymbol) + " " + CurrentState + " " + Tape.substring(CurrentSymbol));
			} else {
				System.out.println(" " + CurrentState + " " + Tape.substring(CurrentSymbol));
			}

			Iterator<Transition> TransitionsIterator = TransitionSet.iterator();
			while (TransitionsIterator.hasNext() && foundTransition == false) {
				Transition nextTransition = TransitionsIterator.next();
				if (nextTransition.readState.equals(CurrentState) && nextTransition.readSymbol == Tape.charAt(CurrentSymbol)) {
					foundTransition = true;
					CurrentTransition = nextTransition;
				}
			}

			if (foundTransition == false) {
				System.err.println("Kein gültiger Zustandsübergang! (Zustand=" + CurrentState + ", Symbol="
						+ Tape.charAt(CurrentSymbol) + ")");
				return false;
			} else {
				CurrentState = CurrentTransition.writeState;
				char[] tempTape = Tape.toCharArray();
				tempTape[CurrentSymbol] = CurrentTransition.writeSymbol;
				Tape = new String(tempTape);
				if (CurrentTransition.moveDirection == true) {
					CurrentSymbol++;
				} else {
					CurrentSymbol--;
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

	public boolean addState(String newState) {
		if (StateSet.contains(newState)) {
			return false;
		} else {
			StateSet.add(newState);
			return true;
		}
	}

	public boolean setStartState(String newStartState) {
		if (StateSet.contains(newStartState)) {
			StartState = newStartState;
			return true;
		} else {
			return false;
		}
	}

	public boolean setAcceptState(String newAcceptState) {
		if (StateSet.contains(newAcceptState)) {
			AcceptState = newAcceptState;
			return true;
		} else {
			return false;
		}
	}

	public void addTransition(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection) {
		Transition newTransition = new Transition();

		newTransition.readState = rState;
		newTransition.readSymbol = rSymbol;
		newTransition.writeState = wState;
		newTransition.writeSymbol = wSymbol;
		newTransition.moveDirection = mDirection;

		TransitionSet.add(newTransition);
	}
}
