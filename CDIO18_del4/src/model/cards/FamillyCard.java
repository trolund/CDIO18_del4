package model.cards;

import controller.Gamecontroller;
import model.Player;
import view.Out;

public class FamillyCard extends Card  {

	public FamillyCard(String description, Out out) {
		super(description, out);
	}

	@Override
	public void doCard(Player p, Out out) {
		out.CardsOut(description);
		for (int i = 0; i < Gamecontroller.getPlayer().length; i++) {
			Gamecontroller.getPlayer()[i].getAccount().withdraw(25);
			p.getAccount().addSum(25);
			System.out.println(p.getName() + "got 25kr form " + Gamecontroller.getPlayer()[i].getName());
		}
	}
	
	

}
