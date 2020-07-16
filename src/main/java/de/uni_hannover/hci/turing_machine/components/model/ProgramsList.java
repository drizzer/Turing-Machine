package de.uni_hannover.hci.turing_machine.components.model;

/**
 * This class contains the programms that can be executed on the Turing machine
 * 
 * @author Mohamed El Hedi Atya
 * @version 30.06.20
 * 
 */

public final class ProgramsList extends Program {
	private ProgramsList() {
	}

	/**
	 * Checks if the input is correct for TM programm A's and B's.
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

		newTM.addTransition("z0", 'a', "z0", 'a', true);
		newTM.addTransition("z0", '#', "z1", '#', true);
		newTM.addTransition("z0", '_', "z0", '_', true);
		newTM.addTransition("z1", 'b', "z1", 'b', true);
		newTM.addTransition("z1", '_', "z2", '_', false); // loop here

		newTM.addTransition("z2", 'b', "z2", 'b', false);
		newTM.addTransition("z2", '#', "z2", '#', false);
		newTM.addTransition("z2", 'a', "z3", 'a', false); // die war z2
		newTM.addTransition("z2", '+', "z2", '+', false);
		newTM.addTransition("z2", '_', "z3", '_', true);

		newTM.addTransition("z3", '+', "z3", '+', true);
		newTM.addTransition("z3", 'a', "z4", '+', true);
		newTM.addTransition("z4", '+', "z4", '+', true);
		newTM.addTransition("z4", 'a', "z4", 'a', true);
		newTM.addTransition("z4", '#', "z4", '#', true);
		newTM.addTransition("z4", 'b', "z2", '+', false);

		newTM.addTransition("z4", '#', "z5", '+', true);
		newTM.addTransition("z5", '+', "z5", '+', true);
		newTM.addTransition("z5", '_', "ze", '_', true); // muss nicht mehr bewegen, boolean nicht geeignet

		return newTM;
	}

	/**
	 * Checks if the input is correct for TM programm Annagramme.
	 * 
	 * @author Lisanne Haase
	 * @version 01.07.20
	 */
	public static TuringMachine Anagram() {
		TuringMachine newTM = new TuringMachine();

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

		newTM.addTransition("z0", 'a', "z1", '+', true);
		newTM.addTransition("z0", 'b', "z2", '+', true);
		newTM.addTransition("z0", '_', "z3", '_', true);

		newTM.addTransition("z1", 'a', "z1", 'a', true);
		newTM.addTransition("z1", 'b', "z1", 'b', true);
		newTM.addTransition("z1", '+', "z1", '+', true);
		newTM.addTransition("z1", '#', "z11", '#', true);

		newTM.addTransition("z2", 'a', "z2", 'a', true);
		newTM.addTransition("z2", 'b', "z2", 'b', true);
		newTM.addTransition("z2", '+', "z2", '+', true);
		newTM.addTransition("z2", '#', "z22", '#', true);

		newTM.addTransition("z3", '#', "z33", '#', true);
		newTM.addTransition("z33", '_', "ze", '_', true); // muss nicht bewegen

		newTM.addTransition("z11", 'a', "z4", '+', false);
		newTM.addTransition("z11", '+', "z11", '+', true);
		newTM.addTransition("z11", 'b', "z11", 'b', true);

		newTM.addTransition("z22", 'b', "z4", '+', false);
		newTM.addTransition("z22", '+', "z22", '+', true);
		newTM.addTransition("z22", 'a', "z22", 'a', true);

		newTM.addTransition("z4", 'a', "z4", 'a', false);
		newTM.addTransition("z4", 'b', "z4", 'b', false);
		newTM.addTransition("z4", '+', "z4", '+', false);
		newTM.addTransition("z4", '#', "z4", '#', false);
		newTM.addTransition("z4", '_', "z0", '_', true);

		newTM.addTransition("z0", '+', "z0", '+', true);
		newTM.addTransition("z0", '#', "z5", '#', true);

		newTM.addTransition("z5", '+', "z5", '+', true);
		newTM.addTransition("z5", '_', "ze", '_', true); // still bleiben

		return newTM;
	}

	public static TuringMachine EqualBinaryWords() {
		TuringMachine newTM = new TuringMachine();
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
		newTM.addTransition("q8", '_', "qa", '_', true);
		return newTM;
	}

}
