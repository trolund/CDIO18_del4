package model.fields.cards;

import model.Player;

public class BalanceCard extends Card {
	
	int BalanceModifier;

	public BalanceCard(String s, int balanceModifier) {
		super(s);
		BalanceModifier = balanceModifier;
	}

	@Override
	public void doCard(Player p) {
		if(BalanceModifier >= 0) p.getAccount().addSum(BalanceModifier);
		else p.getAccount().withdraw(BalanceModifier);
	}
	
	

}
