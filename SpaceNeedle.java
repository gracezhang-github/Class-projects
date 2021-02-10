// CSE142
// Take-home Assessment #2
// 
// This program will print out the space needle in varying sizes


public class SpaceNeedle {
	public static final int SIZE = 4;

	public static void main(String[] args) {
		needle();
		topHalfCircle();
		bottomHalfCircle();
		needle();
		bottomStick();
		topHalfCircle();
}

	// prints out the needle part of the space needle
	public static void needle() {
		
		for (int line = 1; line <= SIZE; line++) {
			for (int space = 1; space <= 3*SIZE; space++) {
				System.out.print(" ");
			}
			
			System.out.println("||");
		}
	}

	// prints out the top half of the circle on the space needle
	public static void topHalfCircle() {
		
		for (int line = 1; line <= SIZE; line++) {
			for (int space = 1; space <= -3*line + 3*SIZE; space++) {
				System.out.print(" ");
			}
				System.out.print("__/");
		
			for (int colon = 1; colon <= 1 * line - 1; colon++) {
				System.out.print(":::");
			}
				System.out.print("||");
		
			for (int colon = 1; colon <= 1 * line - 1; colon++) {
				System.out.print(":::");
			}
				System.out.print("\\__");
			System.out.println();
		}
			System.out.print("|");
		
		for (int quotes = 1; quotes <= 6 * SIZE; quotes++) {
				System.out.print("\"");
			}
			System.out.print("|");
	
		System.out.println();
	}

	// prints out the bottom half of the circle on the space needle
	public static void bottomHalfCircle() {
		for (int line = 1; line <= SIZE; line++) {
			for (int space = 1; space <= 2 * line - 2; space++) {
				System.out.print(" ");
			}
				System.out.print("\\_");

			for (int backForSlash = 1; backForSlash <= -2*line + 3*SIZE+1; backForSlash++) {
				System.out.print("/\\");
			}
				System.out.print("_/");
			System.out.println();
		}
	}

	// prints out the bottom half of the space needle body
	public static void bottomStick() {
		for (int line = 1; line <= SIZE * SIZE; line++) {
			for (int space = 1; space <= 2*SIZE + 1; space++) {
				System.out.print(" ");
			}

			System.out.print("|");
			for (int percent = 1; percent <= SIZE - 2; percent++) {
				System.out.print("%");
			}
			
			System.out.print("||");
			for (int bar = 1; bar <= SIZE - 2; bar++) {
				System.out.print("%");
			}
			System.out.println("|");
		}
	} 
}
	

