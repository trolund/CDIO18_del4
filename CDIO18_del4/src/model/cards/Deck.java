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
//			new BalanceCard(des[0],50, 125, out), 		// betal 50 pr. hus og 125 pr. hotel.
			new MoveCard(des[1], 11, true, out), 		// teleport til Frederiksberg Allé.
			new FamilyCard(des[2], 25, out),			// tager 25 dask fra hver spiller og giver til spilleren der trækker kortet.
			new MoveCard(des[3], -3, false, out),		// ryk 3 felter tilbage
			new BalanceCard(des[4], 50, out),			// modtag 50 dask.
			new BalanceCard(des[5], -15, out),			// modtag 25 dask.
			new BalanceCard(des[6], -10, out),			// betal 10 dask.
			new BalanceCard(des[7], 100, out),			// modtag 100 dask.
			new BalanceCard(des[8], 100, out),			// modtag 100 dask.
			new MoveCard(des[9],0, true, out),			// ryk frem til START	
			new MoveCard(des[10],0, true, out),			// ryk frem til START
			new FamilyCard(des[11], 25, out),			// modtag 25 dask fra hver spiller
			new MoveCard(des[12], 39, true, out),		// tag ind på rådhuspladsen
			new MoveCard(des[13], 5, true , out),		// ryk til øresundsredderiet
			new BalanceCard(des[14], -50, out),			// betal 50 dask
			new BalanceCard(des[15], -20, out),			// betal 20 dasko
			new BalanceCard(des[16], -10, out),			// betal 10 dask
			new MoveFleetCard(des[17], false, out),		// tag med nærmeste redderi :)
			new MoveCard(des[18], 30, true, out),		// gå i fængsel
			new MoveCard(des[19], 30, true, out),		// gå i fængsel bra
	//		new BalanceCard(des[20], 25, 100, out), 	// betal 25 pr. hus og 100 pr. hotæl
			new BalanceCard(des[21], 50, out),			// modtag 50 dask
			new BalanceCard(des[22], 50, out),			// modtag 50 dask
			new MoveFleetCard(des[23], true, out),		// ryk til nærmeste redderi og betal double husleje
			new MoveCard(des[24], 19, true, out),		// Ryk frem til Strandvejen
			new BalanceCard(des[25], 50, out),			// modtag dask 50
			new BalanceCard(des[26], 50, out),			// modtag 50 dask
			new BalanceCard(des[27], 25, out),			// modtag 25 dask
			new BalanceCard(des[28], 25, out),			// modtag 25 dask
			new MoveCard(des[29], 32, true, out),		// ryk til Vimmelskaftet 
			new MoveCard(des[30], -3, false, out),		// ryk tre felter tilbage
			new MoveCard(des[31], -3, false, out),		// ryk tre felter tilbage
			new FreeJailCard(des[32], out),				// FreeJailCard
			new FreeJailCard(des[33], out),				// FreeJailCard
			new BalanceCard(des[34], -150, out),		// betal 150 dask	
			new BalanceCard(des[35], 50, out),			// modtag 50 dask
			new BalanceCard(des[36], -10, out),			// betal 10 dask
			new MoveCard(des[37], 24, true, out),		// ryk til grønningen
			new BalanceCard(des[38], 150, out),			// modtag 150 dask
			new FamilyCard(des[39], 25, out),			// fra hver spiller, modtag 25 dask
			new BalanceCard(des[40], -50, out),			// betal 50 dask i bøde bro
			new BalanceCard(des[41], 10, out),			// betal 10 dask
			new BalanceCard(des[42], 100, out),			// modtag dask 100 af banken
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
