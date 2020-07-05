package de.uni_hannover.hci.turing_machine;

import de.uni_hannover.hci.turing_machine.components.model.ProgramsList;

public class App {

	public static void main(String[] args) {

		// TuringMachine TM1 = ProgramsList.EqualWordSize();
		// boolean done = TM1.Run("aaa#bbb");

		TuringMachine TM2 = ProgramsList.Anagram();
		boolean done = TM2.Run("aab#aba");
		/*
		  String As&Bs = "As&Bs.txt"; //Programm As&Bs wird eingelesen
		  ladeDatei(As&Bs);
		  
		  String Annagramm = "Annagramm.txt"; //Programm Annagramm wird eingelesen
		  ladeDatei(Annagramm);
		 */
		if (done == true) {
			System.out.println("The input was accepted.");
		} else {
			System.out.println("The input was rejected.");
		}
	}
}
