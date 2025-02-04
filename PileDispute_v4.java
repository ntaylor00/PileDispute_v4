package cis088.week8;

import java.util.Scanner;

/*
 * Name: Nathan Taylor
 * Date: 03-22-24
 * Description: Description: Description: A program that uses a while loop to create a Pile Dispute game with
 * two players (with cheat protection, dignity, fancy display)
 */

public class PileDispute4 {
	private int pileA = 3; //example value
	private int pileB = 4; //example value
	private int pileC = 5; //example value
	private String player1Name;
	private String player2Name;
	Scanner scanner = new Scanner(System.in);
	
	//starts the game and calls the other methods below
	public void start() {
		System.out.println("----- Welcome to Pile Dispute! -----");
		getPlayersName();
		
		String winner = "";
		String loser = "";
		
		displayPiles();
		while (!isGameOver()) {
			players1Turn();
			displayPiles();
			if (isGameOver()) {
				winner = player1Name; //player 1 leaves one coin
				loser = player2Name; //player 2 must remove last coin
				break; //end if player 1 wins
			}
			players2Turn();
			displayPiles();
			if (isGameOver()) {
				winner = player2Name; //player 2 leaves one coin
				loser = player1Name; //player 1 must remove last coin
			}
		}
		System.out.print(loser + ", you must take the last remaining counter, so you lose. "
				+ winner + " wins!");
	}
	
	//checks whether game is over and returns true if so, and false otherwise
	private boolean isGameOver() {
		if (pileA + pileB + pileC == 1) { //if there is only 1 coin left, game over
			return true;
		}
		else {
			return false;
		}
	}
	
	//asks player 1 to select a pile and the number of coins to take
	private void players1Turn() {
		String pileChoice = selectValidPile(player1Name);
		selectValidCoins(pileChoice);
	}
	
	//asks player 2 to select a pile and the number of coins to take
	private void players2Turn() {
		String pileChoice = selectValidPile(player2Name);
		selectValidCoins(pileChoice);
	}
	
	//prompts the user to enter the name of player 1 and player 2 and stores the names in variables
	private void getPlayersName() {
		System.out.print("Enter the name of Player 1: ");
		player1Name = scanner.nextLine();
		System.out.print("Enter the name of Player 2: ");
		player2Name = scanner.nextLine();
	}
	
	//displays the status of the piles (how many coins in each pile)
	private void displayPiles() {
		System.out.print("\nA: ");
		for (int i = 0; i < pileA; i++) {
			System.out.print("*");
		}
		System.out.print("\nB: ");
		for (int i = 0; i < pileB; i++) {
			System.out.print("*");
		}
		System.out.print("\nC: ");
		for (int i = 0; i < pileC; i++) {
			System.out.print("*");
		}
		System.out.println("\n");
	}
	
	//checks to make sure user entered a valid pile (exists, has coins)
	private String selectValidPile(String playerName) {
		System.out.print(playerName + ", choose a pile: ");
		String pileChoice = scanner.nextLine();
		
		while (true) {
			if (pileChoice.equals("A")) {
				if (pileA == 0) {
					System.out.print("\nNice try, " + playerName + ". That pile is empty. Choose again: ");
					pileChoice = scanner.nextLine();
				}
				else {
					return "A";
				}
			}
			else if (pileChoice.equals("B")) {
				if (pileB == 0) {
					System.out.print("\nNice try, " + playerName + ". That pile is empty. Choose again: ");
					pileChoice = scanner.nextLine();
				}
				else {
					return "B";
				}
			}
			else if (pileChoice.equals("C")) {
				if (pileC == 0) {
					System.out.print("\nNice try, " + playerName + ". That pile is empty. Choose again: ");
					pileChoice = scanner.nextLine();
				}
				else {
					return "C";
				}
			}
			else {
				System.out.print("\nNice try, " + playerName + ". That pile doesn't exist. Choose again: ");
				pileChoice = scanner.nextLine();
			}
		}
	}
	
	//checks to make sure user entered a valid number of coins
	private int selectValidCoins(String pileName) {
		System.out.print("How many coins to remove from pile " + pileName + ": ");
		int numCoins = scanner.nextInt();
		
		while (true) {
			if (pileName.equals("A")) {
				if (numCoins > pileA) {
					System.out.print("\nPile A doesn't have that many coins. Try again: ");
					numCoins = scanner.nextInt();
				}
				else if (numCoins < 1) {
					System.out.print("\nYou must choose at least 1 coin. How many coins? ");
					numCoins = scanner.nextInt();
				}
				else {
					scanner.nextLine();
					pileA = pileA - numCoins;
					return pileA;
				}
			}
			else if (pileName.equals("B")) {
				if (pileName.equals("B")) {
					if (numCoins > pileB) {
						System.out.print("\nPile B doesn't have that many coins. Try again: ");
						numCoins = scanner.nextInt();
					}
					else if (numCoins < 1) {
						System.out.print("\nYou must choose at least 1 coin. How many coins? ");
						numCoins = scanner.nextInt();
					}
					else {
						scanner.nextLine();
						pileB = pileB - numCoins;
						return pileB;
					}
				}
			}
			else if (pileName.equals("C")) {
				if (pileName.equals("C")) {
					if (numCoins > pileC) {
						System.out.print("\nPile C doesn't have that many coins. Try again: ");
						numCoins = scanner.nextInt();
					}
					else if (numCoins < 1) {
						System.out.print("\nYou must choose at least 1 coin. How many coins? ");
						numCoins = scanner.nextInt();
					}
					else {
						scanner.nextLine();
						pileC = pileC - numCoins;
						return pileC;
					}
				}
			}
		}
	}
}
