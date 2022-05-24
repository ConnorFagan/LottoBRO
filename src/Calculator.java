import java.util.Scanner;
import java.util.Random;
public class Calculator {
	
	private double pot;
	private int numTickets;
	private double ticketPrice;
	
	private double winLottoChance = 1/292201388;
	private double tax = 0.24;
	
	public Calculator(double pot, int numTickets, double ticketPrice) {
		this.pot = pot;
		this.numTickets = numTickets;
		this.ticketPrice = ticketPrice;
	}
	
	public Calculator() {
		this.pot = 0.0;
		this.numTickets = 0;
		this.ticketPrice = 0.0;
	}
	
	public double chanceOfWinning() {
		// % chance of winning lotto
		return numTickets * winLottoChance * 100;
	}
	
	public double moneyLostOrWonPerTicket() {
		return (winLottoChance * (pot * (1 - tax))) - ticketPrice;
	}
	
	public double trueMoneyMade(int tktsBoughtToWin) {
		// this value is after tax
		return (pot * (1 - tax)) - (tktsBoughtToWin * ticketPrice);
	}
	
	public static int randomLoopBuy() {
		// potentially rework so that you don't re-draw (if that even matters)
		int winningNumber = 1;
		int ticketsBought = 1;
		int randomNumber = (int)(Math.random() * 292201388);
		while (randomNumber != winningNumber && ticketsBought <= 292201387) {
			randomNumber = (int)(Math.random() * 292201388);
			ticketsBought++;
			
		}
		System.out.println("You bought " + ticketsBought + " tickets before winning the lotto.");
		return ticketsBought;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What is the lotto pot at?");
		double poot = scan.nextDouble();
		
		System.out.println("How many tickets did you buy?");
		int nuumTickets = scan.nextInt();
		
		System.out.println("How much did one ticket cost you?");
		double tiicketPrice = scan.nextDouble();
		
		Calculator urChances = new Calculator(poot, nuumTickets, tiicketPrice);
		int tktsBought = randomLoopBuy();
		System.out.println("Money made or lost: " + urChances.trueMoneyMade(tktsBought));
		System.out.println("Chance of winning: " + urChances.chanceOfWinning());
		
		// why does this return a negative number but the money you really get is positive
		System.out.println("Money won or lost per ticket: " + urChances.moneyLostOrWonPerTicket());
		System.out.println();

	}

}
