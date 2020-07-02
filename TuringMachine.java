import java.util.Scanner;
import java.util.*;

/**
*This class provides a constructor and methods to create TM.
*
*
*@author Lisanne Haase
*@version 30.06.20
*/
public class TuringMachine {
    /** String with all possible states (e.g. qo - q5) */
    private Set<String> StateSet = new HashSet<String>();
    /** ??? */
    private Set<Transition> TransitionSet;
    /** String with first state e.g. q0*/
    private String BeginState;
    /** ?? */
    private String AcceptState;
    /** ?? */
    private String RejectState;
    /** string with all symbols (seperator included */
    private String Tape;
    /** String with current state e.g. q3 */
    private String CurrentState;
    /** ?? Why is currentsymbol an integer? */
    private int CurrentSymbol;

    /**
    *This constructor provides an empty TM.
    *@author Lisanne Haase
    *@version 30.06.20
    */

// Programm TuringMachine als char[][] ?? Tape als char[][]???
    public TuringMachine(Set<String> StateSet, Set<Transition> TransitionSet, String BeginState, String AcceptState, String RejectState, String Tape, String CurrentState, int CurrentSymbol)   {
        this.StateSet = StateSet;
        this.TransitionSet = TransitionSet;
        this.BeginState = BeginState;
        this.AcceptState = AcceptState;
        this.RejectState = RejectState;
        this.Tape = Tape;
        this.CurrentState = CurrentState;
        this.CurrentSymbol = CurrentSymbol;
    }
    
    /**
    *checks if the input is correct for TM programm A's and B's.
    *@author Lisanne Haase
    *@version 01.07.20
    */
    public boolean check1(String tape) {
    
        int length = tape.length();
        int firsthalf = (length-1) / 2;
        boolean accepted;
        
        if(tape == "" || length%2 == 0) { 
            return false;
        }
        for(int i = 0; i < firsthalf; i++) { 
            if (!(tape.charAt(i) == tape.charAt(+1))) {
                return false;
            }
        }
        for(int i = firsthalf+2; i < length; i++) {
            if (!(tape.charAt(i) == tape.charAt(+1))) {
                return false;
            }
        }
        if(!(tape.charAt(firsthalf+1) == '#')) {
            return false;
        }
        return true;
    }
    
    /** 
    *checks if the input is correct for TM programm Annagramme.
    *@author Lisanne Haase
    *@version 01.07.20
    */
    public boolean check2(String tape){
        int length = tape.length();
        int firsthalf = (length-1)/2;
        int secondhalf = firsthalf+2;
        int a1 = 0;
        int a2 = 0;
        int b1 = 0;
        int b2 = 0;
        
        if(tape == "" || length%2 == 0) { 
            return false;
        }
        
        for(int i = 0; i < firsthalf; i++) {
            if(tape.charAt(i) == 'a'){
                a1++;
            }
            if(tape.charAt(i) == 'b'){
                b1++;
            }
        }
        
        for(int i = firsthalf+2; secondhalf < length; i++) {
            if(tape.charAt(i) == 'a'){
                a2++;
            }
            if(tape.charAt(i) == 'b'){
                b2++;
            }
        }
        
         if(!(tape.charAt(firsthalf+1) == '#')) {
            return false;
        }
        if(!(a1 == a2 && b1 == b2)){
            return false;
        }
        
        return true;
    }

	/**
	*This method contains the programm Nr. 1 A's and B's. 
	*It changes the current state and the input of the cell acording to the current state and input.
	*@author Lisanne Haase
	*@version 02.06.20
	*/
	public String As_Bs(String CurrentState, String CurrentSymbol){	 //PDF Zustandsübergänge eintragen
		{},
		{},
		{},
		{},
		{},
		{},
		{},

	}
    
    
    


}

