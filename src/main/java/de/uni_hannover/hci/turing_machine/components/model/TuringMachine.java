package de.uni_hannover.hci.turing_machine.components.model;

import java.util.*;

public class TuringMachine {

	/** Name of the TuringMachine */
	protected String NameTM;
	/** Set of names for all possible states (e.g. qo - q5) */
	protected Set<String> StateSet;
	/** Set of all existing transitions */
	protected Set<Transition> TransitionSet;
	/**Set of Alphabet (e.g. #, a, b) */
	protected ArrayList<String> AlphabetSet;

	/** Starting state of the program e.g. q0 */
	protected String StartState;
	/** State in which the output is accepted */
	protected String AcceptState;

	/** Tape content as String with all symbols (seperator included) */
	protected String Tape;
	/** String with current state e.g. q3 */
	protected String CurrentState;
	/** Index of current symbol */
	protected int CurrentSymbol;

	public class Transition {
		String readState;
		char readSymbol;
		String writeState;
		char writeSymbol;
		boolean moveDirection; // true is right, false is left

		boolean isConflicting(String state, char symbol) {
			if (state.equals(readState) && symbol == readSymbol) {
				return true;
			} else {
				return false;
			}
		}
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

	/**
	 *  Getter und Setter for Programm name
	 *  */

	public String getNameTM() {
		return NameTM;
	}

	public void setNameTM(String nameTM) {
		NameTM = nameTM;
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

	public void setAlphabet(String newAlphabetSet) {
		
		AlphabetSet.add(newAlphabetSet);
	}

	public boolean addTransition(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection) {
		if (!StateSet.contains(rState) || !StateSet.contains(wState)) {
			return false;
		}

		boolean conflict = false;
		Iterator<Transition> TransitionsIterator = TransitionSet.iterator();

		while (TransitionsIterator.hasNext() && conflict == false) {

			Transition nextTransition = TransitionsIterator.next();

			if (nextTransition.isConflicting(rState, rSymbol)) {
				conflict = true;
			}
		}

		if (conflict == true) {
			return false;
		} else {
			Transition newTransition = new Transition();
			newTransition.readState = rState;
			newTransition.readSymbol = rSymbol;
			newTransition.writeState = wState;
			newTransition.writeSymbol = wSymbol;
			newTransition.moveDirection = mDirection;
			TransitionSet.add(newTransition);
			return true;
		}
	}

}
