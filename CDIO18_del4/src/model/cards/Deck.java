package model.cards;

import java.util.Arrays;
import java.util.Random;

import view.Language;
import view.Out;

public class Deck {

	private static int cardCount = 0;
	public static Card[] cards;
	public Out out;
	private String[] des = Language.getCardDescriptions();

	public Deck(Out output){
		this.out = output;
	
		cards = new Card[]{
			new BalanceCard(des[0],50, out), 		// betal 50 pr. hus og 125 pr. hotel.
			new MoveCard(des[1], 11, true, out), 		// teleport til Frederiksberg Allé.
			new FamilyCard(des[2], 25, out),			// tager 25 dask fra hver spiller og giver til spilleren der trækker kortet.
			new MoveCard(des[3], -3, false, out),		// ryk 3 felter tilbage
			new BalanceCard(des[4], 50, out),			// modtag 50 dask.
			new BalanceCard(des[5], -15, out),			// modtag 25 dask.
			new BalanceCard(des[6], -10, out),			// betal 10 dask.
			new BalanceCard(des[7], 100, out),			// modtag 100 dask.
			new BalanceCard(des[7], 100, out),			// modtag 100 dask.
			new MoveCard(des[8],0, true, out),			// ryk frem til START	
			new MoveCard(des[8],0, true, out),			// ryk frem til START
			new FamilyCard(des[9], 25, out),			// modtag 25 dask fra hver spiller
			new MoveCard(des[10], 39, true, out),		// tag ind på rådhuspladsen
			new MoveCard(des[11], 5, true , out),		// ryk til øresundsredderiet
			new BalanceCard(des[12], -50, out),			// betal 50 dask
			new BalanceCard(des[13], -20, out),			// betal 20 dasko
			new MoveFleetCard(des[14], false, out),			// tag med nærmeste redderi :)
			new MoveCard(des[15],11, true, out),		// gå i fængsel
			new MoveCard(des[16],11, true, out),		// gå i fængsel bra
			new BalanceCard(des[16], 25, out), 	// betal 25 pr. hus og 100 pr. hotæl
			new BalanceCard(des[17], 50, out),			// modtag 50 dask
			new BalanceCard(des[18], 50, out),			// modtag 50 dask
			new MoveFleetCard(des[18], true, out),		// ryk til nærmeste redderi og betal double husleje
			new MoveCard(des[19],0, false, out),
			new BalanceCard(des[20], 40, out), 
			new MoveCard(des[21],11, true, out),
			new BalanceCard(des[22], 10, out),
			new MoveCard(des[23], 3, false, out),
			new BalanceCard(des[23], 50, out),
			new BalanceCard(des[24], -15, out),
			new BalanceCard(des[25], 50, out),
			new BalanceCard(des[25], 50, out),
			new MoveCard(des[26],0, true, out),
			new MoveCard(des[26],0, true, out),	
			new MoveCard(des[27], 39, true, out),
			new MoveCard(des[28], 5, true, out),
			new BalanceCard(des[29], 50, out),
			new FamilyCard(des[30], 25, out),
			new BalanceCard(des[31], -10, out),
			new BalanceCard(des[32], -10, out),
			new MoveFleetCard(des[33], true, out),
			new MoveCard(des[34], 11, true, out),
			new MoveCard(des[35], 11, true, out),
		};
		shuffleArray();
	}

	public static void shuffleArray(){		
		Random rnd = new Random();
		for (int i = cards.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Card a = cards[index];
			cards[index] = cards[i];
			cards[i] = a;
		}

	}
	
	
	
	public static int getCardCount() {
		return cardCount;
	}

	public static void setCardCount(int cardCount) {
		Deck.cardCount = cardCount;
	}

	public static Card[] getCards() {
		return cards;
	}

	public static void printCards(){
		System.out.println(Arrays.toString(Deck.cards));
	}

}
