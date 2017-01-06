package model.fields;

import java.util.Arrays;
import java.util.Random;

import model.Player;
import model.fields.cards.BalanceCard;
import model.fields.cards.Card;
import model.fields.cards.FreeJailCard;
import model.fields.cards.MoveCard;
import view.Out;
import view.Output;

public class Chance extends Field
{
	private static int cardCont = 0;
	private static Card[] cards = {
			new MoveCard("Ryk to felter", 2),
			new BalanceCard("du får 100kr", 100),
			new FreeJailCard("du kan komme ud fra fægsel eller gemme kortet."),
	};
	

	public static Card[] getCards() {
		return cards;
	}

	public Chance(String name, String description, Out out)
	{
		super(name, description, out);
	}
	
	public void landOn(Player p, Out o)
	{
		cards[cardCont].doCard(p); // tag kort i bunken.
		if(cardCont >= cards.length){ // søger for vi ikke kommer ud over array grænser. 
			cardCont = 0;
		}
		else {
		cardCont++; // gør næste kort klar.
		}
	}
	
	public static void printCards(){
		System.out.println(Arrays.toString(cards));
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
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


	
	
	
}
