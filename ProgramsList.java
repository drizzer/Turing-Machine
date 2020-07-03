/**
 * This class contains the programms that can be executed on the Turing machine
 * 
 * @author Mohamed El Hedi Atya
 * @version 30.06.20
 * 
 */

public final class ProgramsList {
	private ProgramsList() {
	}

	/**
	 * Checks if the input is correct for TM programm A's and B's.
	 * 
	 * @author Lisanne Haase
	 * @version 01.07.20
	 */
	public static TuringMachine EqualWordSize() {
		TuringMachine newTM = new TuringMachine();

		newTM.addState("z0");
		newTM.addState("z1");
		newTM.addState("z2");
		newTM.addState("z3");
		newTM.addState("z4");
		newTM.addState("z5");
		newTM.addState("ze");
		newTM.addState("zReject");

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
		newTM.addState("zReject");

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

}
