package model.cards;

import java.util.Arrays;
import java.util.Random;

import view.Language;
import view.Out;

public class Deck {

	public static int cardCount = 0;
	public static Card[] cards;
	public Out out;
	private String[] des = Language.getCardDescriptions();

	public Deck(Out output){
		this.out = output;
	
		cards = new Card[]{
			new BalanceCard(des[0],40, out), // ret til med doCard metode, 
			new MoveCard(des[1],11,true,out),
			new BalanceCard(des[2],10,out),
			new MoveCard(des[3],3,false,out),
			new BalanceCard(des[4],50,out),
			new BalanceCard(des[5],-15,out),
			new BalanceCard(des[6],50,out),
			new BalanceCard(des[6],50,out),
			new MoveCard(des[7],0, true, out),
			new MoveCard(des[7],0, true, out),	
			new MoveCard(des[9],39,true,out),
			new MoveCard(des[10],5,true,out),
			new BalanceCard(des[11],50,out),
			new FamillyCard(des[11],25,out),
			new BalanceCard(des[12],-10,out),
			new BalanceCard(des[13],-10,out),
			new MoveFleetCard(des[14],out),
			new MoveCard(des[15],11,true,out),
			new MoveCard(des[15],11,true,out),
			new BalanceCard(des[16],40, out), // ret til med doCard metode, 
			new BalanceCard(des[17],50, out),
			new BalanceCard(des[17],50, out),
			new BalanceCard(des[18],40, out), // ret til med dobeelt leje ved næste redderi
			new MoveCard(des[19],0,false,out),
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
