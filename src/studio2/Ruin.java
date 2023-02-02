package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("What is your start amount: ");
		double startAmount = in.nextDouble();

		System.out.println("What is your Win Change (1 to 0): ");
		double winChance = in.nextDouble();

		System.out.println("What is your win limit: ");
		double winLimit = in.nextDouble();

		// System.out.println("Maximum number of plays:");
		// int totalPlays = in.nextInt();

		System.out.println("The number of days you would like to play: ");
		int days = in.nextInt();
		int count = 0;

		int play_amnt = 0;
		
	

		while (count < days) {

			double currentMoney = startAmount;
			
			while (currentMoney < winLimit && currentMoney > 0) {
				double a = Math.random();
				if (a > winChance) {
					currentMoney--;
				} else {
					currentMoney++;
				}
			}
			count++;

			if (currentMoney == 0) {
				System.out.println("You're ruined: " + currentMoney);
			} else {
				System.out.println("You're successful: " + currentMoney);
			}
		}
		double expected_ruin;
		double b = (1-winChance)/winChance;
		if (winChance == 0.5) {
			expected_ruin = 1 - (startAmount / winLimit);
		} else {
			expected_ruin = ((Math.pow(b,startAmount))-(Math.pow(b,play_amnt)))/(1-Math.pow(b,winLimit));
			
		}
		System.out.println("your expected ruin: " + expected_ruin);
	}

}
