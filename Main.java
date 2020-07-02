import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		TuringMachine TM = new TuringMachine();
		System.out.println("input tape");
		Scanner t = new Scanner(System.in); //tape wird eingelesen
		String tape = t.nextLine();
		
		System.out.println("input states");
		Scanner s = new Scanner(System.in); //Zustände werden eingelesen
		String states = s.nextLine();

		System.out.println("input TM");
		Scanner t2 = new Scanner(System.in); //Turingprogramm wird eingelesen
		String tp = t2.nextLine();
		

	}

 /*   if(check(this.tape) == true) {
        System.out.println("The input was accepted.");
    } else {
        System.out.println("The input was rejected.");
*/
}
