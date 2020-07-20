package de.uni_hannover.hci.turing_machine.components.model;

import java.util.*;

/**
 * This class provides Methods to store the information of the TM
 * 
 * @author Mohamed Atya
 * @version 05.07.20
 */
public class TuringMachine {

	/** Name of the TuringMachine */
	protected String NameTM;
	/** Set of names for all possible states (e.g. qo - q5) */
	public Set<String> StateSet;
	/** Set of all existing transitions */
	protected Set<Transition> TransitionSet;
	/** Set of Alphabet (e.g. #, a, b) */
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

	/**
	 * This class provides the transitions of the TM
	 * 
	 * @author Lisanne Haase
	 * @version 16.07.20
	 */
	public class Transition {
		String readState;
		char readSymbol;
		String writeState;
		char writeSymbol;
		boolean moveDirection; // true is right, false is left

		/**
		 * This method returns the current transition into a string
		 * 
		 * @version 16.07.20
		 * @author Mohamed Atya
		 */
		@Override
		public String toString() {
			return "Transition{" + "readState='" + readState + '\'' + ", readSymbol=" + readSymbol + ", writeState='"
					+ writeState + '\'' + ", writeSymbol=" + writeSymbol + ", moveDirection=" + moveDirection + '}';
		}

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
	 * Getter for Programm name
	 * 
	 * @return name of TM
	 */
	public String getNameTM() {
		return NameTM;
	}

	/**
	 * Setter for Programm name
	 * 
	 * @param string (Name of TM)
	 */
	public void setNameTM(String nameTM) {
		this.NameTM = nameTM;
	}

	/**
	 * This method adds a new state in the stateSet. If the added state if already
	 * in the stateSet it returns false
	 * 
	 * @param String newState
	 * @return boolean
	 */
	public boolean addState(String newState) {
		if (StateSet.contains(newState)) {
			return false;
		} else {
			StateSet.add(newState);
			return true;
		}
	}

	/**
	 * This method defines the StartState. If the StartState is not in the stateSet
	 * it returns false. The StartState has to be included in the stateSet.
	 * 
	 * @param newStartState
	 * @return boolean
	 */
	public boolean setStartState(String newStartState) {
		if (StateSet.contains(newStartState)) {
			StartState = newStartState;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method defines the acceptState. If the acceptState is not in the
	 * stateSet it returns false. The acceptState has to be included in the
	 * stateSet.
	 * 
	 * @param acceptState
	 * @return boolean
	 */
	public boolean setAcceptState(String newAcceptState) {
		if (StateSet.contains(newAcceptState)) {
			AcceptState = newAcceptState;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method stores the alphabet in a set.
	 * 
	 * @param String
	 */
	public void setnewAlphabet(String newAlphabetSet) {

		AlphabetSet.add(newAlphabetSet);
	}

	/**
	 * This method adds a state transition to the TransitionSet. If the state
	 * transition contains states, which don't exist, it returns false.
	 * 
	 * @param rState
	 * @param rSymbol
	 * @param wState
	 * @param wSymbol
	 * @param mDirection
	 * @return boolean
	 */
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
