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
		
		for (int i = 0; i < Gamecontroller.getPlayer().length; i++) {
			Gamecontroller.getPlayer()[i].getAccount().withdraw(25);
			p.getAccount().addSum(25);
		}
		
		
	}
	
	

}
