package isa;
import java.util.*;
public class cst4lab2 {


	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);


	        int numStates = 3;


	        ArrayList<Integer>[][] transitions = new ArrayList[numStates][2];
	        
	        for (int i = 0; i < numStates; i++) {
	            for (int j = 0; j < 2; j++) {
	                transitions[i][j] = new ArrayList<>();
	            }
	        }


	        transitions[0][0].add(0);
	        transitions[0][0].add(1);

	        transitions[0][1].add(0);

	        transitions[1][1].add(2);

	        transitions[2][0].add(2);
	        transitions[2][1].add(2);

	        System.out.println("Type binary strings (a/b). Type 'STOP' to quit.\n");

	        while (true) {
	            System.out.print("Input: ");
	            String input = sc.nextLine();


	            if (input.equalsIgnoreCase("STOP")) {
	                System.out.println("Program ended.");
	                break;
	            }

	            Set<Integer> currentStates = new HashSet<>();
	            currentStates.add(0); 


	            for (char ch : input.toCharArray()) {
	                int symbol = (ch == 'a') ? 0 : 1;
	                Set<Integer> nextStates = new HashSet<>();

	                for (int state : currentStates) {
	                    nextStates.addAll(transitions[state][symbol]);
	                }

	                currentStates = nextStates;
	            }


	            if (currentStates.contains(2)) {
	                System.out.println("Output: Accepted\n");
	            } else {
	                System.out.println("Output: Rejected\n");
	            }
	        }

	        sc.close();
	    }
	}
