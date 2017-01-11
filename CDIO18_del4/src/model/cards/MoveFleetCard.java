package model.cards;

import desktop_fields.Ownable;
import model.Player;
import model.fields.Field;
import model.fields.Fieldlist;
import model.fields.Fleet;
import view.Out;




public class MoveFleetCard extends Card {

	private boolean doubleRent;

	public MoveFleetCard(String description, boolean doubleRent, Out out) {
		super(description, out);
		this.doubleRent = doubleRent;
	}

	@Override
	public void doCard(Player p, Out out) {
		int pos = 0;
		out.removeCar(p);
		for (int i = 0; i <= Fieldlist.getFields().length - 1; i++) {
			int index = (i + p.getPlayerPos()) % 40;
			Field f = Fieldlist.getFields()[index];
			if (f instanceof Fleet) {
				Fleet fleet = (Fleet)f;

				if ((i + p.getPlayerPos()) > Fieldlist.getFields().length) {
					p.getAccount().addSum(200);
				}

				pos = (i + p.getPlayerPos()) % 40;

				if(fleet.getOwner() != null && doubleRent == true){
					
				}

				break;
			}

		}
		p.setPlayerPos(pos);
		out.setcar(p);
		out.setGUIBalance(p);
	}
}
