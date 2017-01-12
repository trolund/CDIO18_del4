package model.cards;

import controller.MoveController;
import model.Player;
import model.fields.Fieldlist;
import view.Out;

public class MoveCard extends Card {

	private int move;
	private boolean teleport;	//teleport or move care
	
	public MoveCard(String description, int moves, boolean teleport, Out out) {
		super(description, out);
		this.move = moves;
		this.teleport = teleport;
		
	}
	
	public void doCard(Player p, Out out){
		out.CardsOut(description);
		out.removeCar(p);
		if(teleport){
			if(move == 24 && p.getPlayerPos() > 24){
				p.getAccount().addSum(200);
			}
			if(move == 30){
				Fieldlist.getFields()[30].landOn(p, out);
			}
			p.setPlayerPos(move);
		}
		else{
			new MoveController().movePlayer(move, p);
		}	
		
		out.setcar(p);
	}
}
