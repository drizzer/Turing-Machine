package components.model;

import java.util.*;

public class TuringMachine {
	/** Set of names for all possible states (e.g. qo - q5) */
	protected Set<String> StateSet;
	/** Set of all existing transitions */
	protected Set<Transition> TransitionSet;

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

	protected class Transition {
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
	protected TuringMachine() {
		StateSet = new HashSet<String>();
		TransitionSet = new HashSet<Transition>();
		StartState = new String("");
		AcceptState = new String("");
		Tape = new String("");
		CurrentState = new String("");
		CurrentSymbol = 0;
	}

	protected boolean addState(String newState) {
		if (StateSet.contains(newState)) {
			return false;
		} else {
			StateSet.add(newState);
			return true;
		}
	}

	protected boolean setStartState(String newStartState) {
		if (StateSet.contains(newStartState)) {
			StartState = newStartState;
			return true;
		} else {
			return false;
		}
	}

	protected boolean setAcceptState(String newAcceptState) {
		if (StateSet.contains(newAcceptState)) {
			AcceptState = newAcceptState;
			return true;
		} else {
			return false;
		}
	}

	protected boolean addTransition(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection) {
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
