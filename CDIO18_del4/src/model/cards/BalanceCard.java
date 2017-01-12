package model.cards;

import model.Player;
import view.Out;

public class BalanceCard extends Card {
	
	int BalanceModifier;

	public BalanceCard(String s, int balanceModifier,Out out) {
		super(s, out);
		BalanceModifier = balanceModifier;
	}

	@Override
	public void doCard(Player p, Out out) {
		out.CardsOut(description);
		if(BalanceModifier <0){
			p.getAccount().withdraw(BalanceModifier * (-1));
		}
		else{
		p.getAccount().addSum(BalanceModifier);
		}
		out.setGUIBalance(p);
	}
	
	

}
