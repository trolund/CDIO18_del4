package model.cards;

import controller.Gamecontroller;
import model.Player;
import view.Out;

public class FamilyCard extends Card  {
	
	int gift;

	public FamilyCard(String description,int gift, Out out) {
		super(description, out);
		this.gift = gift;
	}

	@Override
	public void doCard(Player p, Out out) {
		out.CardsOut(description);
		for (int i = 0; i < Gamecontroller.getPlayer().length; i++) {
			Gamecontroller.getPlayer()[i].getAccount().withdraw(gift);
			p.getAccount().addSum(gift);
			System.out.println(p.getName() + "got " + gift + " kr form " + Gamecontroller.getPlayer()[i].getName());
			out.setGUIBalance(Gamecontroller.getPlayer()[i]);
		}
		out.setGUIBalance(p);
	}
	
	
	

}
