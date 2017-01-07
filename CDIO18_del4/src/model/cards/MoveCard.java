package model.cards;

import controller.Gamecontroller;
import controller.MoveController;
import model.Player;
import model.fields.Fieldlist;
import view.Out;

public class MoveCard extends Card {

	private int move;
	private boolean teleport;	//teleport or move care
	private Out out;
	
	public MoveCard(String description, int moves, boolean teleport, Out out) {
		super(description);
		this.move = moves;
		this.teleport = teleport;
		this.out = out;
		
	}
	
	public void doCard(Player p){
		out.CardsOut(description);
		if(teleport){
			if(move == 24 && p.getPlayerPos() > 24){
				p.getAccount().addSum(200);
			}
			p.setPlayerPos(move);
		}
		else{
			new MoveController().moveCarPos(move, p);
		}	
		out.removeCar(p);
		out.setcar(p);
	}
}
