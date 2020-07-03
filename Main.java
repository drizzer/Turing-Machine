
public class Main {

	public static void main(String[] args) {

		//TuringMachine TM1 = ProgramsList.EqualWordSize();
		//boolean done = TM1.Run("aaa#bbb");

		TuringMachine TM2 = ProgramsList.Anagram();
		boolean done = TM2.Run("aab#aba");

		if (done == true) {
			System.out.println("The input was accepted.");
		} else {
			System.out.println("The input was rejected.");
		}
	}

}
